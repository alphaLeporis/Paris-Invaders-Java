package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

/**
 * Shows the current in-game time. Based on UIText.
 */
public class UIScore extends UIText {
    public UIScore(Position position) {
        super("Score:", position);
        this.color = Color.white;
    }

    /**
     * At each update it checks for a new live state.
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        createFont();
        calculateSize();
        setText("Score: "+state.getScore().getFormattedScore());
    }
}
