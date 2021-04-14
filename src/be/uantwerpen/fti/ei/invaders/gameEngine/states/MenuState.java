package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIContainer;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.menu.UIMainMenu;

public class MenuState extends State {
    public MenuState(Game game) {
        super(game);

        uiContainers.add(new UIMainMenu(windowSize));
        audioPlayer.playMusic("menu.wav");
    }

}
