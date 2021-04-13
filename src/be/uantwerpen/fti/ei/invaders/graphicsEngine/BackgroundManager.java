package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.gameEngine.states.*;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.backgrounds.BackgroundLibrary;

import java.awt.*;

public class BackgroundManager {
    private BackgroundLibrary backgroundLibrary;
    private State state;

    public BackgroundManager() {
        backgroundLibrary = new BackgroundLibrary();
    }

    public Image visualize(State state) {
        this.state = state;
        if (state instanceof MenuState)
            return backgroundLibrary.getBackground("menu-background");
        else if (state instanceof GameState)
            return backgroundLibrary.getBackground("game-background");
        else if (state instanceof WonState)
            return backgroundLibrary.getBackground("won-background");
        else if (state instanceof LostState)
            return backgroundLibrary.getBackground("lost-background");
        else
            return null;
    }
}
