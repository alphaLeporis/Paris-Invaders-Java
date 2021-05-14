package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.endScreen;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.MenuState;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.Alignment;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.VerticalContainer;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

public class UIEndScreen extends VerticalContainer {
    public UIEndScreen(Size windowSize) {
        super(windowSize);
        alignment = new Alignment(Alignment.Position.CENTER, Alignment.Position.CENTER);

        addUIComponent(new UIButton("MENU", (state) -> state.setNextState(new MenuState(state.getGame()))));
        addUIComponent(new UIButton("EXIT", (state) -> System.exit(0)));
    }
}
