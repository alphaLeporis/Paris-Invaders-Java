package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;

/**
 * Hoorah! The player won. The state will show the endscreen and will play a won sound.
 */
public class WonState extends State {
    public WonState(Game game) {
        super(game);
        audioPlayer.playSound("won.wav");
    }

    /**
     * @return a visualisation of the state. Unused here.
     */
    @Override
    public VisualisationObjects visualize() {
        return null;
    }
}
