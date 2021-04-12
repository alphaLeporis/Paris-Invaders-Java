package be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects;

import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;

public class Fast extends Effect {
    public Fast() {
        super(GameSettings.UPDATES_PER_SECOND*5);
    }
}
