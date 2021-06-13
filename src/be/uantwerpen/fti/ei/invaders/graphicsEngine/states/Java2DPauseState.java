package be.uantwerpen.fti.ei.invaders.graphicsEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.*;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Display;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

public class Java2DPauseState extends PauseState {
    Display display;
    VisualisationObjects visualisationObjects;

    public Java2DPauseState(Game game, State state, Display display) {
        super(game, state);
        this.display = display;
        visualisationObjects = new VisualisationObjects(display);
        createVisual();
        audioPlayer.playMusic("pause.wav");
    }

    private void createVisual() {
        visualisationObjects.setBackground("pause-background");
        visualisationObjects.addUiComponent(new UIButton("RETURN", new Position(600,400), (uiState) -> uiState.setNextState(new Java2DGameState(game, uiState.getPreviousState(), display))));
        visualisationObjects.addUiComponent(new UIButton("EXIT TO MENU",new Position(600,440), (uiState) -> uiState.setNextState(new Java2DMenuState(game, display))));
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
