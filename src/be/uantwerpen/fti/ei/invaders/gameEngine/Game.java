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

public class Game {
    private final AFact afact;
    private Input input;
    private State state;

    public Game(AFact afact) {
        this.input = afact.getInput();
        this.afact = afact;
        this.state = new MenuState(this);
    }

    public void update() {
        state.update(this);
    }

    public void render() {
        afact.render(state);
    }

    public AFact getAfact() {
        return afact;
    }

    public void enterState(State nextState) {
        state = nextState;
    }

    public Input getInput() {
        return input;
    }
}
