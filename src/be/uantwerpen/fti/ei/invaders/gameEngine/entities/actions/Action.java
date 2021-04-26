package be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions;

import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

/**
 * A movable entity is able to do an action. This is the abstract class providing an action.
 */
public abstract class Action {
    protected AudioPlayer audioPlayer;

    /**
     * The constructor provides an AudioPlayer, this will enable the action to play soundeffects.
     */
    public Action() {
        audioPlayer = new AudioPlayer();
    }

    /**
     * Will be run on every update
     * @param state is needed to know what state we are in and spawn new entities (if needed).
     */
    public abstract void update(State state);

    /**
     * @return a boolean to know when an action is done.
     */
    public abstract boolean isDone();


}
