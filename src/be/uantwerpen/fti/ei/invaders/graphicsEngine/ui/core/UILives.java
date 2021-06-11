package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

public class UILives extends UIText {
    public UILives(Position position) {
        super("", position);
        this.color = Color.black;
    }

    @Override
    public void update(State state) {
        createFont();
        calculateSize();
        setText("Lives: "+ state.getPlayerLives());
    }
}
