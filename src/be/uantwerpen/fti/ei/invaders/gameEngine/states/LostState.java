package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;

public class LostState extends State {
    public LostState(Game game) {
        super(game);
        audioPlayer.playSound("lost.wav");
    }
}
