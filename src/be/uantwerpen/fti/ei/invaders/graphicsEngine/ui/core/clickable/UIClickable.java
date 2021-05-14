package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable;



import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIComponent;

import java.awt.*;

public abstract class UIClickable extends UIComponent {

    protected boolean hasFocus;
    protected boolean isPressed;

    @Override
    public void update(State state) {
        Position mousePosition = state.getInput().getMousePosition();

        hasFocus = getBounds().contains(mousePosition.getX(), mousePosition.getY());
        isPressed = hasFocus && state.getInput().isMousePressed();

        if(hasFocus && state.getInput().isMouseClicked()) {
            onClick(state);
        }
    }

    protected abstract void onClick(State state);

    private Rectangle getBounds() {
        return new Rectangle(
                absolutePosition.getX(),
                absolutePosition.getY(),
                size.getWidth(),
                size.getHeight()
        );
    }
}
