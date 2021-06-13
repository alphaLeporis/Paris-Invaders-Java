package be.uantwerpen.fti.ei.invaders.graphicsEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.LostState;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.MenuState;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Display;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIScore;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

public class Java2DLostState extends LostState {
    Display display;
    VisualisationObjects visualisationObjects;

    public Java2DLostState(Game game, Display display) {
        super(game);
        this.display = display;
        visualisationObjects = new VisualisationObjects(display);
        createVisual();
    }

    private void createVisual() {
        visualisationObjects.setBackground("lost-background");
        visualisationObjects.addUiComponent(new UIScore(new Position(400,340)));
        visualisationObjects.addUiComponent(new UIButton("MENU",new Position(400,400), (uiState) -> uiState.setNextState(new Java2DMenuState(game,display))));
        visualisationObjects.addUiComponent(new UIButton("EXIT",new Position(400,440), (uiState) -> System.exit(0)));
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
