package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.Timer;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIContainer;

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

    protected List<UIContainer> uiContainers;
    protected final Input input;

    private State nextState;

    public State(Game game) {
        this.input = game.getInput();
        this.afact = game.getAfact();
        this.game = game;
        audioPlayer = new AudioPlayer();
        entities = new ArrayList<>();
        uiContainers = new ArrayList<>();
        timer = new Timer();
    }

    public void update(Game game) {
        updateEntities();
        removeDeadEntities();
        List.copyOf(uiContainers).forEach(uiContainer -> uiContainer.update(this));
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
        System.out.println(((PlayerEntity) entities.get(0)).getCurrentHealth());
        return ((PlayerEntity) entities.get(0)).getCurrentHealth();
    }

    public Input getInput() {
        return input;
    }

    public void setNextState(State nextState) {
        audioPlayer.removeMusic();
        timer.stop();
        this.nextState = nextState;
    }


    public List<Entity> getEntities() {
        return entities;
    }

    public List<UIContainer> getUiContainers() {
        return uiContainers;
    }

    public Game getGame() {
        return game;
    }

    public Timer getTimer() {
        return timer;
    }
}
