package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;

/**
 * This is the help state of our game. It will show the help page.
 */
public class HelpState extends State {
    public HelpState(Game game) {
        super(game);
        audioPlayer.playMusic("pause.wav");
    }
}
