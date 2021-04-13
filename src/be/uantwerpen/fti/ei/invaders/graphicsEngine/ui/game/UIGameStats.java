package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.game;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.GameState;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.Alignment;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.HorizontalContainer;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIText;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

public class UIGameStats extends HorizontalContainer {
    public UIGameStats(Size windowSize) {
        super(windowSize);

        alignment = new Alignment(Alignment.Position.CENTER, Alignment.Position.START);
        addUIComponent(new UIText("Im alive"));
        addUIComponent(new UIButton("PLAY", (state) -> state.setNextState(new GameState(state.getGame()))));
    }
}
