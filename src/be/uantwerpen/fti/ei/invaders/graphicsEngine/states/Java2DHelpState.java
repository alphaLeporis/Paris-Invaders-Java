package be.uantwerpen.fti.ei.invaders.graphicsEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.GameState;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.HelpState;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.MenuState;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Display;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.clickable.UIButton;

public class Java2DHelpState extends HelpState {
    Display display;
    VisualisationObjects visualisationObjects;

    public Java2DHelpState(Game game, Display display) {
        super(game);
        this.display = display;
        visualisationObjects = new VisualisationObjects(display);
        createVisual();
    }

    private void createVisual() {
        visualisationObjects.setBackground("help-background");
        visualisationObjects.addUiComponent((new UIButton("RETURN",new Position(1050,720), (uiState) -> uiState.setNextState(new Java2DMenuState(game,display)))));
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
