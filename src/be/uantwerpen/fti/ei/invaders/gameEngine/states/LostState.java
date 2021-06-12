package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;

/**
 * Sadly the player has lost. The state will show the endscreen and will play a lost sound.
 */
public class LostState extends State {
    public LostState(Game game) {
        super(game);
        audioPlayer.playSound("lost.wav");
    }
}
