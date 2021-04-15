package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.menu.UIMainMenu;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.pause.UIPause;

public class PauseState extends State {
    public PauseState(Game game, State oldState) {
        super(game);
        audioPlayer.playMusic("pause.wav");
        uiContainers.add(new UIPause(windowSize, oldState));
    }
}
