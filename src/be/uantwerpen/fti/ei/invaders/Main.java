package be.uantwerpen.fti.ei.invaders;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.GameLoop;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Java2DFact;

/**
 * The main class of our game.
 * The start of the universe.
 * The beginning of something beautiful.
 * All in this main class.
 */
public class Main {

    public static void main(String[] args) {
        new GameLoop(new Game(new Java2DFact()));
    }
}
