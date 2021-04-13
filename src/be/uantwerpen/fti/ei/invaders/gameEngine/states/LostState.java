package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.endScreen.UIEndScreen;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.game.UIGameStats;

public class LostState extends State {
    public LostState(Game game) {
        super(game);
        uiContainers.add(new UIEndScreen(windowSize));
        audioPlayer.playSound("lost.wav");
    }
}
