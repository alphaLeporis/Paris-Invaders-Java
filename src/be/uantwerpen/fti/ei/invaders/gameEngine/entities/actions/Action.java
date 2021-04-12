package be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions;

import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

public abstract class Action {
    protected AudioPlayer audioPlayer = new AudioPlayer();
    public Action() {}

    public abstract void update(State state);
    public abstract boolean isDone();


}
