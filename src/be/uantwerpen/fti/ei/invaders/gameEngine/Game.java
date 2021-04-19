package be.uantwerpen.fti.ei.invaders.gameEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.controlEngine.EnemyController;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.controlEngine.NPCInput;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.GameState;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.MenuState;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Game class will bond our Abstract Factory and the Game engine together.
 */
public class Game {
    private final AFact afact;
    private Input input;
    private State currentState;

    /**
     * The game constructor will start the game. In this case we want our menu state to start.
     * @param afact is needed to know what graphics engine we will be using.
     */
    public Game(AFact afact) {
        this.input = afact.getInput();
        this.afact = afact;
        this.currentState = new MenuState(this);
    }

    /**
     * Because each state needs different objects to be updated we let the currentState decide.
     */
    public void update() {
        currentState.update(this);
    }

    /**
     * Because each state needs different objects to be rendered we let the currentState decide.
     */
    public void render() {
        afact.render(currentState);
    }

    /**
     * @return the used abstract factory (the used graphics engine)
     */
    public AFact getAfact() {
        return afact;
    }

    /**
     * Will be used to change the state we are updating/rendering
     * @param nextState is needed to define our next state
     */
    public void enterState(State nextState) {
        currentState = nextState;
    }

    /**
     * @return the input defined in the abstract factory.
     */
    public Input getInput() {
        return input;
    }
}
