package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ui.core;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

/**
 * Shows the current level. Based on UIText.
 */
public class UILevel extends UIText {
    public UILevel(Position position) {
        super("Level:", position);
        this.color = Color.black;
    }

    /**
     * At each update it checks for a different gamelevel.
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        createFont();
        calculateSize();
        setText("Level: "+ state.getCurrentGameLevel());
    }
}
