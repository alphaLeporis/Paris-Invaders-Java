package be.uantwerpen.fti.ei.invaders;

import be.uantwerpen.fti.ei.invaders.gameEngine.GameLoop;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DFact;

public class Main {

    public static void main(String[] args) {
        new GameLoop(new Java2DFact()).run();
    }
}
