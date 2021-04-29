package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.game;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.PauseState;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.Alignment;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.HorizontalContainer;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIText;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

public class UIGameStats extends HorizontalContainer {
    public UIGameStats(Size windowSize, State currentState) {
        super(windowSize);

        alignment = new Alignment(Alignment.Position.CENTER, Alignment.Position.START);
        addUIComponent(new UIText(String.valueOf(currentState.getPlayerLives())));
        addUIComponent(new UIButton("PAUSE", (state) -> state.setNextState(new PauseState(state.getGame(), currentState))));
    }
}
