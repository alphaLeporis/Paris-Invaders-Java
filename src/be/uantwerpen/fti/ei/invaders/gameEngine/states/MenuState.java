package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIContainer;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.menu.UIMainMenu;

/**
 * This is the begin state of our game. It will show the menu and will be playing th menu music.
 */
public class MenuState extends State {
    public MenuState(Game game) {
        super(game);

        uiContainers.add(new UIMainMenu(GameSettings.GAME_SIZE));
        audioPlayer.playMusic("menu.wav");
    }

}
