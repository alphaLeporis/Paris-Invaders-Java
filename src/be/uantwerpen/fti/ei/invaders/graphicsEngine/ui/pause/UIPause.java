package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.pause;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.MenuState;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.Alignment;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.VerticalContainer;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

public class UIPause extends VerticalContainer {
    public UIPause(Size windowSize, State returnState) {
        super(windowSize);
        alignment = new Alignment(Alignment.Position.CENTER, Alignment.Position.CENTER);

        addUIComponent(new UIButton("RETURN", (state) -> state.setNextState(returnState)));
        addUIComponent(new UIButton("EXIT", (state) -> System.exit(0)));
    }
}
