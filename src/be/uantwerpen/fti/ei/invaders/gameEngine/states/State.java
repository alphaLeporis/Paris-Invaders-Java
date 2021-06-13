package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.Score;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Our game is based on different states. Each state has a different goal.
 */
public abstract class State {
    protected final AudioPlayer audioPlayer;
    protected List<Entity> entities;
    protected final AFact afact;
    protected final Game game;
    protected Score score;
    protected int currentGameLevel;

    protected final Input input;

    private State nextState;
    protected State previousState;

    /**
     * The constructor makes a new state ands sets all the parameters to the begin values.
     * @param game is needed to get the input and the abstract factory for graphics.
     */
    public State(Game game) {
        this.game = game;
        input = game.getInput();
        afact = game.getAfact();
        audioPlayer = new AudioPlayer();
        entities = new ArrayList<>();
        score = game.getScore();
    }

    /**
     * Updates the audioplayer, entities and removes old entities.
     * @param game is needed to change between states.
     */
    public void update(Game game) {
        audioPlayer.update();
        updateEntities();
        removeDeadEntities();
        if(nextState != null) {
            game.enterState(nextState);
            nextState = null;
        }
    }

    /**
     * Checks for entities that can be deleted and will delete them.
     */
    private void removeDeadEntities() {
        entities.removeIf(entity -> !entity.isEntityAlive());
    }

    /**
     * Updates all the entities in the entity list.
     */
    @SuppressWarnings("ForLoopReplaceableByForEach")
    private void updateEntities() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update(this);
        }
    }

    /**
     * Gets the colliding game objects.
     * @param entity is the entity to check collidings with.
     * @return a list with all the entities that are colliding with the given entity.
     */
    public List<Entity> getCollidingGameObjects(Entity entity) {
        return entities.stream()
                .filter(other -> other.collidesWith(entity))
                .collect(Collectors.toList());
    }

    /**
     * Spawns a new entity.
     * @param entity is added to the entity list.
     */
    public void spawn(Entity entity) {
        entities.add(entity);
    }

    /**
     * Gets the remaining lives of the player.
     * @return an integer value of the remaining lives of the player.
     */
    public int getPlayerLives() {
        if (!(entities.get(0) instanceof PlayerEntity)) {
            return 0;
        }
        return ((PlayerEntity) entities.get(0)).getCurrentHealth();
    }

    /**
     * @return the player input
     */
    public Input getInput() {
        return input;
    }

    /**
     * Sets the next state to the given state.
     * @param nextState the state that will be the next state.
     */
    public void setNextState(State nextState) {
        if (nextState instanceof PauseState) {
            previousState = this;
        }
        audioPlayer.removeMusic();
        this.nextState = nextState;
    }

    /**
     * @return a list of all the entities.
     */
    public List<Entity> getEntities() {
        return entities;
    }

    /**
     * @return the score.
     */
    public Score getScore() {
        return score;
    }

    /**
     * @return the game.
     */
    public Game getGame() {
        return game;
    }

    /**
     * @return the current game level.
     */
    public int getCurrentGameLevel() {
        return currentGameLevel;
    }

    /**
     * @return the previous state, before the state switch. (Is needed for pause)
     */
    public State getPreviousState() {
        return previousState;
    }
}
