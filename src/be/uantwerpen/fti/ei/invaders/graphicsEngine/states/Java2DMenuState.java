package be.uantwerpen.fti.ei.invaders.graphicsEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.MenuState;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Display;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

public class Java2DMenuState extends MenuState {
    Display display;
    VisualisationObjects visualisationObjects;

    public Java2DMenuState(Game game, Display display) {
        super(game);
        this.display = display;
        visualisationObjects = new VisualisationObjects(display);
        createVisual();
    }

    private void createVisual() {
        visualisationObjects.setBackground("menu-background");
        visualisationObjects.addUiComponent(new UIButton("PLAY",new Position(600,400), (uiState) -> uiState.setNextState(new Java2DGameState(game, display))));
        visualisationObjects.addUiComponent(new UIButton("HELP",new Position(600,440), (uiState) -> uiState.setNextState(new Java2DHelpState(game, display))));
        visualisationObjects.addUiComponent(new UIButton("EXIT",new Position(600,480), (uiState) -> System.exit(0)));
    }


    @Override
    public void update(Game game) {
        super.update(game);
        visualisationObjects.update(this);
    }

    @Override
    public VisualisationObjects visualize() {
        return visualisationObjects;
    }
}
