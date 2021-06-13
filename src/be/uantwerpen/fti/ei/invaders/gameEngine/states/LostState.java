package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;

/**
 * Sadly the player has lost. The state will show the endscreen and will play a lost sound.
 */
public class LostState extends State {
    public LostState(Game game) {
        super(game);
        audioPlayer.playSound("lost.wav");
    }

    /**
     * @return a visualisation of the state. Unused here.
     */
    @Override
    public VisualisationObjects visualize() {
        return null;
    }
}
