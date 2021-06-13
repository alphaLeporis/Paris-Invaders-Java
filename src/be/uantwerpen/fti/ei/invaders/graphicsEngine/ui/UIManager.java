package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.*;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Display;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIComponent;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UILevel;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UILives;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UITimer;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

import java.util.ArrayList;
import java.util.List;

/**
 * To make our game easy to navigate, we add different UI elements.
 * To easily handle multiple UI's based on the state we use this manager.
 */
public class UIManager {
    protected List<UIComponent> uiComponents;
    private State currentState;
    private final Display display;

    /**
     * The constructor loads the uiComponents array.
     * @param display is needed to know the xFactor and the yFactor.
     */
    public UIManager(Display display) {
        this.display = display;
        uiComponents = new ArrayList<>();
    }

    /**
     * Updates the current UI components to match their effective value.
     * @param state is needed to load the correct UI based on the state.
     */
    public void update(State state) {
        uiComponents.forEach(component -> component.resize(display.xFactor, display.yFactor));
        if (state == currentState) {
            uiComponents.forEach(component -> component.update(state));
            return;
        }
        loadComponents(state);
    }

    /**
     * Loads new components if the state has changed
     * @param state is needed to load the correct UI based on the state.
     */
    public void loadComponents(State state) {
        this.currentState = state;
        uiComponents = new ArrayList<>();

        if (state instanceof GameState) {
            uiComponents.add(new UILevel(new Position(20,10)));
            uiComponents.add(new UILives(new Position(200,10)));
            uiComponents.add(new UITimer(new Position(570,10)));
            uiComponents.add(new UIButton("PAUSE",new Position(1100,10), (uiState) -> uiState.setNextState(new PauseState(state.getGame(), uiState))));
        }

        if (state instanceof MenuState) {
            uiComponents.add(new UIButton("PLAY",new Position(600,400), (uiState) -> uiState.setNextState(new GameState(state.getGame()))));
            uiComponents.add(new UIButton("HELP",new Position(600,440), (uiState) -> uiState.setNextState(new HelpState(state.getGame()))));
            uiComponents.add(new UIButton("EXIT",new Position(600,480), (uiState) -> System.exit(0)));
        }

        if (state instanceof HelpState) {
            uiComponents.add(new UIButton("RETURN",new Position(1050,720), (uiState) -> uiState.setNextState(new MenuState(state.getGame()))));
        }

        if (state instanceof PauseState) {
            uiComponents.add(new UIButton("RETURN", new Position(600,400), (uiState) -> uiState.setNextState(new GameState(state.getGame(), uiState.getPreviousState()))));
            uiComponents.add(new UIButton("EXIT TO MENU",new Position(600,440), (uiState) -> uiState.setNextState(new MenuState(state.getGame()))));
        }

        if (state instanceof LostState) {
            uiComponents.add(new UIButton("MENU",new Position(400,400), (uiState) -> uiState.setNextState(new MenuState(state.getGame()))));
            uiComponents.add(new UIButton("EXIT",new Position(400,440), (uiState) -> System.exit(0)));
        }

        if (state instanceof WonState) {
            uiComponents.add(new UIButton("MENU",new Position(200,400), (uiState) -> uiState.setNextState(new MenuState(state.getGame()))));
            uiComponents.add(new UIButton("EXIT",new Position(200,440), (uiState) -> System.exit(0)));
        }
    }

    /**
     * @return a list of UI components.
     */
    public List<UIComponent> getUiComponents() {
        return uiComponents;
    }
}
