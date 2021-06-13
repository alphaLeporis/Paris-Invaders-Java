package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

/**
 * Shows the current player lives. Based on UIText.
 */
public class UILives extends UIText {
    public UILives(Position position) {
        super("", position);
        this.color = Color.black;
    }

    /**
     * At each update it checks for a new live state.
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        createFont();
        calculateSize();
        setText("Lives: "+ state.getPlayerLives());
    }
}
