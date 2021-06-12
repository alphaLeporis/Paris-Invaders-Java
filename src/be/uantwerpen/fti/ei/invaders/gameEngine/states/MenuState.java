package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;

/**
 * This is the begin state of our game. It will show the menu and will be playing th menu music.
 */
public class MenuState extends State {
    public MenuState(Game game) {
        super(game);
        audioPlayer.playMusic("menu.wav");
    }
}
