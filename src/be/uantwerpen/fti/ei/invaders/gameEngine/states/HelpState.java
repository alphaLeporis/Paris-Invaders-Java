package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;

/**
 * This is the help state of our game. It will show the help page.
 */
public class HelpState extends State {
    public HelpState(Game game) {
        super(game);
        audioPlayer.playMusic("pause.wav");
    }

    /**
     * @return a visualisation of the state. Unused here.
     */
    @Override
    public VisualisationObjects visualize() {
        return null;
    }
}
