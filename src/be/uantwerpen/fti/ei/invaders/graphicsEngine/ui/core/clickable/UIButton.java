package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIText;

import java.awt.*;

/**
 * Implements the UIClickable method.
 */
public class UIButton extends UIClickable {

    private final UIText label;

    private final ClickAction clickAction;

    /**
     * UIButton holds a UIText element as a label.
     * @param label is the text that the button will show.
     * @param position is the position of the button in game-units.
     * @param clickAction is the action to button takes when clicked.
     */
    public UIButton(String label, Position position, ClickAction clickAction) {
        this.position = position;
        this.label = new UIText(label, position);
        this.clickAction = clickAction;
    }

    /**
     * Updates the label and does the resizing.
     * @param state is needed to know where the update takes place.
     */
    @Override
    public void update(State state) {
        super.update(state);
        label.update(state);
        label.resize(xFactor,yFactor);
        setSize(label.getSize());

        if(hasFocus) {
            label.color = Color.LIGHT_GRAY;
            return;
        }

        if(isPressed) {
            label.color = Color.DARK_GRAY;
            return;
        }
        label.color = Color.WHITE;

    }

    /**
     * @param state is needed to execute the click action.
     */
    @Override
    protected void onClick(State state) {
        clickAction.execute(state);
    }

    /**
     * @return an image that represents the button.
     */
    @Override
    public Image visualize() {
        return label.visualize();
    }
}

