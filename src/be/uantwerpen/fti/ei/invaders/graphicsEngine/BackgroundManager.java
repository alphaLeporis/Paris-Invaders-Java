package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.gameEngine.states.*;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.backgrounds.BackgroundLibrary;

import java.awt.*;

/**
 * To make our game look less boring, we add different backgrounds. To easily handle multiple backgrounds based on the state.
 */
public class BackgroundManager {
    private final BackgroundLibrary backgroundLibrary;

    /**
     * The constructor loads the BackgroundLibrary.
     */
    public BackgroundManager() {
        backgroundLibrary = new BackgroundLibrary();
    }


    /**
     * Our renderer needs the visualize method to render the background on our window.
     * @param state is needed to know what background to render
     * @return an Image, in this case a BufferedImage
     */
    public Image visualize(State state) {
        //Todo: Change this into a switch
        if (state instanceof MenuState)
            return backgroundLibrary.getBackground("menu-background");
        else if (state instanceof GameState)
            return backgroundLibrary.getBackground("game-background");
        else if (state instanceof WonState)
            return backgroundLibrary.getBackground("won-background");
        else if (state instanceof LostState)
            return backgroundLibrary.getBackground("lost-background");
        else if (state instanceof PauseState)
            return backgroundLibrary.getBackground("pause-background");
        else
            return null;
    }
}
