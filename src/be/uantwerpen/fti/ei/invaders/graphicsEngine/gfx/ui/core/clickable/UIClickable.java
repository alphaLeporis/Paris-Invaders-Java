package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ui.core.clickable;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ui.core.UIComponent;

import java.awt.*;

/**
 * This is a clickable UI component.
 */
public abstract class UIClickable extends UIComponent {
    protected boolean hasFocus;
    protected boolean isPressed;

    /**
     * Checks for a click on the location of the UI component.
     * @param state is needed to know where the update takes place.
     */
    @Override
    public void update(State state) {
        Position mousePosition = state.getInput().getMousePosition();
        hasFocus = getBounds().contains(mousePosition.getX(), mousePosition.getY());
        isPressed = hasFocus && state.getInput().isMousePressed();
        if(isPressed) {
            onClick(state);
        }
    }

    /**
     * The action it has to take on click.
     * @param state is needed to execute the click action.
     */
    protected abstract void onClick(State state);

    /**
     * @return a rectangle with the bounds of the UI component to check if the mouse is hovering above.
     */
    private Rectangle getBounds() {
        return new Rectangle(
                (int) (position.getX()*xFactor),
                (int) (position.getY()*yFactor),
                size.getWidth(),
                size.getHeight()
        );
    }
}
