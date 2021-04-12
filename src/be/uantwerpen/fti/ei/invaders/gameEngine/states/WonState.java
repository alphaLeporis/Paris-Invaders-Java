package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;

public class WonState extends State {
    public WonState(Game game) {
        super(game);
        audioPlayer.playSound("won.wav");
    }
}
