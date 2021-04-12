package be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects;

import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

public class Slow extends Effect {
    public Slow() {
        super(GameSettings.UPDATES_PER_SECOND*5);
    }

}
