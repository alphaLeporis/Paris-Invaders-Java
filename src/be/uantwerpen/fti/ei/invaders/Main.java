package be.uantwerpen.fti.ei.invaders;

import be.uantwerpen.fti.ei.invaders.gameEngine.GameLoop;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Display;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Game;

public class Main {

    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(800, 600))).start();
    }
}
