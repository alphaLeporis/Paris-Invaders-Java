package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIContainer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class State {
    protected AudioPlayer audioPlayer;
    protected List<Entity> entities;
    protected AFact afact;
    protected Game game;

    protected List<UIContainer> uiContainers;
    protected Input input;
    //protected Time time;

    protected Size windowSize;

    private State nextState;

    public State(Game game) {
        this.windowSize = GameSettings.WINDOW_SIZE;
        this.input = game.getInput();
        this.afact = game.getAfact();
        this.game = game;
        audioPlayer = new AudioPlayer();
        entities = new ArrayList<>();
        uiContainers = new ArrayList<>();
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
        for(int i = 0; i < entities.size(); i++) {
            if(!entities.get(i).isEntityAlive())
                entities.remove(i);
        }
    }

    private void updateEntities() {
        for(int i = 0; i < entities.size(); i++) {
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

    public Input getInput() {
        return input;
    }

    public void setNextState(State nextState) {
        audioPlayer.removeMusic();
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


}
