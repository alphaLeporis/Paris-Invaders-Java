package be.uantwerpen.fti.ei.invaders;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.GameLoop;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Java2DFact;

public class Main {

    public static void main(String[] args) {
        new GameLoop(new Game(new Java2DFact()));
    }
}
