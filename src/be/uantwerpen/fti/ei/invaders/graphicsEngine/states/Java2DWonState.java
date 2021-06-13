package be.uantwerpen.fti.ei.invaders.graphicsEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.GameState;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.HelpState;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.MenuState;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.WonState;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Display;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIScore;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

public class Java2DWonState extends WonState {
    Display display;
    VisualisationObjects visualisationObjects;

    public Java2DWonState(Game game, Display display) {
        super(game);
        this.display = display;
        visualisationObjects = new VisualisationObjects(display);
        createVisual();
    }

    private void createVisual() {
        visualisationObjects.setBackground("won-background");
        visualisationObjects.addUiComponent(new UIScore(new Position(200,340)));
        visualisationObjects.addUiComponent(new UIButton("MENU",new Position(200,400), (uiState) -> uiState.setNextState(new Java2DMenuState(game,display))));
        visualisationObjects.addUiComponent(new UIButton("EXIT",new Position(200,440), (uiState) -> System.exit(0)));

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
