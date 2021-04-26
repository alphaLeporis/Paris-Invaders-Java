package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.menu;


import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.GameState;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.Alignment;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIText;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.VerticalContainer;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

import java.awt.*;

public class UIMainMenu extends VerticalContainer {
    public UIMainMenu(Size windowSize) {
        super(windowSize);
        alignment = new Alignment(Alignment.Position.CENTER, Alignment.Position.CENTER);

        addUIComponent(new UIButton("PLAY", (state) -> state.setNextState(new GameState(state.getGame()))));
        addUIComponent(new UIButton("EXIT", (state) -> System.exit(0)));
    }
}
