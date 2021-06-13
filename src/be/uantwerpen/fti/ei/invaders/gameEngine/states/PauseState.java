package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;

/**
 * The player has pushed the pause button and entered this PauseState. It will show return screen and plays pause music.
 */
public class PauseState extends State {
    public PauseState(Game game, State state) {
        super(game);
        this.previousState = state;
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
