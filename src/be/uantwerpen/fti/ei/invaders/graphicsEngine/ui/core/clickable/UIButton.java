package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable;



import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIText;

import java.awt.*;

public class UIButton extends UIClickable {

    private final UIText label;

    private final ClickAction clickAction;

    public UIButton(String label, Position position, ClickAction clickAction) {
        this.position = position;
        this.label = new UIText(label, position);
        this.clickAction = clickAction;
    }

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

    @Override
    protected void onClick(State state) {
        clickAction.execute(state);
    }

    @Override
    public Image visualize() {
        return label.visualize();
    }
}

