package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.Timer;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Our game is based on different states. Each state can have different elements.
 */
public abstract class State {
    protected final AudioPlayer audioPlayer;
    protected List<Entity> entities;
    protected final AFact afact;
    protected final Game game;
    protected Timer timer;
    protected int currentGameLevel;

    protected final Input input;

    private State nextState;
    protected State previousState;

    public State(Game game) {
        this.input = game.getInput();
        this.afact = game.getAfact();
        this.game = game;
        audioPlayer = new AudioPlayer();
        entities = new ArrayList<>();
        timer = new Timer();
    }

    public void update(Game game) {
        audioPlayer.update();
        updateEntities();
        removeDeadEntities();
        handleMouseInput();
        if(nextState != null) {
            game.enterState(nextState);
            nextState = null;
        }
    }


    private void handleMouseInput() {
        input.clearMouseClick();
    }

    private void removeDeadEntities() {
        entities.removeIf(entity -> !entity.isEntityAlive());
    }

    @SuppressWarnings("ForLoopReplaceableByForEach")
    private void updateEntities() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update(this);
        }
    }

    public List<Entity> getCollidingGameObjects(Entity entity) {
        return entities.stream()
                .filter(other -> other.collidesWith(entity))
                .collect(Collectors.toList());
    }

    public void spawn(Entity entity) {
        entities.add(entity);
    }

    public int getPlayerLives() {
        if (!(entities.get(0) instanceof PlayerEntity)) {
            return 0;
        }
        return ((PlayerEntity) entities.get(0)).getCurrentHealth();
    }

    public Input getInput() {
        return input;
    }

    public void setNextState(State nextState) {
        if (nextState instanceof PauseState) {
            previousState = this;
        }
        audioPlayer.removeMusic();
        timer.stop();
        this.nextState = nextState;
    }

    public List<Entity> getEntities() {
        return entities;
    }


    public Game getGame() {
        return game;
    }

    public Timer getTimer() {
        return timer;
    }

    public String getFormattedTimer() {return timer.getFormattedTime();}

    public int getCurrentGameLevel() {
        return currentGameLevel;
    }

    public State getPreviousState() {
        return previousState;
    }
}
