package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;

/**
 * The player has pushed the pause button and entered this PauseState. It will show return screen and plays pause music.
 */
public class PauseState extends State {
    public PauseState(Game game, State state) {
        super(game);
        audioPlayer.playMusic("pause.wav");
        this.previousState = state;
    }
}
