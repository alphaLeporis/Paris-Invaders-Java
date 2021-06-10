package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable;



import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
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
        setSize(label.getSize());
/*        size = container.getSize();

        Color color = Color.GRAY;

        if(hasFocus) {
            color = Color.LIGHT_GRAY;
        }

        if(isPressed) {
            color = Color.DARK_GRAY;
        }

        container.setBackgroundColor(color);*/
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

