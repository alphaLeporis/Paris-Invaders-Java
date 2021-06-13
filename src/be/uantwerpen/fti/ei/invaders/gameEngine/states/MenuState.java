package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;

/**
 * This is the begin state of our game. It will show the menu and will be playing the menu music.
 */
public class MenuState extends State {
    public MenuState(Game game) {
        super(game);
        audioPlayer.playMusic("menu.wav");
    }

    /**
     * @return a visualisation of the state. Unused here.
     */
    @Override
    public VisualisationObjects visualize() {
        return null;
    }
}
