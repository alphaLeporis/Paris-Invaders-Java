package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.GameState;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIComponent;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIText;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

import java.util.ArrayList;
import java.util.List;

public class UIManager {
    protected List<UIComponent> uiComponents;
    private State currentState;

    public UIManager() {
        uiComponents = new ArrayList<>();
    }

    public void update(State state) {
        if (state == currentState) {
            uiComponents.forEach(component -> component.update(state));
            return;
        }
        this.currentState = state;
        uiComponents = new ArrayList<>();
        uiComponents.add(new UIText("Test", new Position(200,200)));
        uiComponents.add(new UIButton("Click",new Position(400,400), (uiState) -> uiState.setNextState(new GameState(state.getGame())) ));
    }

    public List<UIComponent> getUiComponents() {
        return uiComponents;
    }
}
