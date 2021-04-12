package be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects;

import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

public abstract class Effect {
    private int lifeSpanInUpdates;

    public Effect(int lifeSpanInUpdates) {
        this.lifeSpanInUpdates = lifeSpanInUpdates;
    }

    public void update(State state) {
        lifeSpanInUpdates--;
    }

    public boolean shouldDelete() {
        return lifeSpanInUpdates <= 0;
    }
}
