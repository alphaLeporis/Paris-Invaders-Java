package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable;


import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIContainer;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIText;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.VerticalContainer;

import java.awt.*;

public class UIButton extends UIClickable {

    private final UIContainer container;
    private final UIText label;

    private final ClickAction clickAction;

    public UIButton(String label, ClickAction clickAction) {
        this.label = new UIText(label);
        this.clickAction = clickAction;

        container = new VerticalContainer(new Size(0, 0));
        container.addUIComponent(this.label);
        container.setFixedSize(new Size(150, 30));
    }

    @Override
    public void update(State state) {
        super.update(state);
        container.update(state);
        size = container.getSize();

        Color color = Color.GRAY;

        if(hasFocus) {
            color = Color.LIGHT_GRAY;
        }

        if(isPressed) {
            color = Color.DARK_GRAY;
        }

        container.setBackgroundColor(color);
    }

    @Override
    protected void onClick(State state) {
        clickAction.execute(state);
    }

    @Override
    public Image visualize() {
        return container.visualize();
    }
}
