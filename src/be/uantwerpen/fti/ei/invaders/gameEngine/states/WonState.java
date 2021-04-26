package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.endScreen.UIEndScreen;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.game.UIGameStats;

/**
 * Hoorah! The player won. The state will show the endscreen and will play a won sound.
 */
public class WonState extends State {
    public WonState(Game game) {
        super(game);
        //uiContainers.add(new UIEndScreen(windowSize));
        audioPlayer.playSound("won.wav");
    }
}
