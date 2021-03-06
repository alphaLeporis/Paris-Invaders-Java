package be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects;

import be.uantwerpen.fti.ei.invaders.AFact;

/**
 * An effect is a temporary change in movement for the player.
 */
public abstract class Effect {
    private int lifeSpanInUpdates;

    /**
     * @param lifeSpanInSeconds is needed to know how long our effect will take.
     */
    public Effect(int lifeSpanInSeconds) {
        this.lifeSpanInUpdates = lifeSpanInSeconds * AFact.gameConfig.getConfigInt("UPDATES_PER_SECOND");
    }

    /**
     * At each update we decrement the counter
     */
    public void update() {
        lifeSpanInUpdates--;
    }

    /**
     * @return a boolean based on the fact if the effect is done and should be deleted.
     */
    public boolean shouldDelete() {
        return lifeSpanInUpdates <= 0;
    }
}
