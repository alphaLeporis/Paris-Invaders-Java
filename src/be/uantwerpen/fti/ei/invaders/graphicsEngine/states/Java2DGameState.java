package be.uantwerpen.fti.ei.invaders.graphicsEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.*;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Display;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UILevel;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UILives;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIScore;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

public class Java2DGameState extends GameState {
    Display display;
    VisualisationObjects visualisationObjects;

    public Java2DGameState(Game game, Display display) {
        super(game);
        this.display = display;
        visualisationObjects = new VisualisationObjects(display);
        createVisual();
    }

    public Java2DGameState(Game game, State state, Display display) {
        super(game, state);
        this.display = display;
        visualisationObjects = new VisualisationObjects(display);
        createVisual();
    }

    private void createVisual() {
        visualisationObjects.setBackground("game-background");
        visualisationObjects.addUiComponent(new UILevel(new Position(20,10)));
        visualisationObjects.addUiComponent(new UILives(new Position(200,10)));
        visualisationObjects.addUiComponent(new UIScore(new Position(530,10)));
        visualisationObjects.addUiComponent(new UIButton("PAUSE",new Position(1100,10), (uiState) -> uiState.setNextState(new Java2DPauseState(game, uiState, display))));
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
