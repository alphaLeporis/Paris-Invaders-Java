package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.backgrounds;

import be.uantwerpen.fti.ei.invaders.gameEngine.states.*;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.StatesEnum;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.backgrounds.BackgroundLibrary;

import java.awt.*;

/**
 * To make our game look less boring, we add different backgrounds.
 * To easily handle multiple backgrounds based on the state we use this manager.
 */
public class BackgroundManager {
    private final BackgroundLibrary backgroundLibrary;

    /**
     * The constructor loads the BackgroundLibrary.
     */
    public BackgroundManager(BackgroundLibrary backgroundLibrary) {
        this.backgroundLibrary = backgroundLibrary;
    }


    /**
     * Our renderer needs the visualize method to render the correct background on our window.
     * @param state is needed to know what background to render.
     * @return an Image, the correct background.
     */
    public Image visualize(State state) {
        StatesEnum currentState = StatesEnum.valueOf(state.getClass().getSimpleName());
        switch (currentState) {
            case MenuState:
                return backgroundLibrary.getBackground("menu-background");
            case HelpState:
                return backgroundLibrary.getBackground("help-background");
            case GameState:
                return backgroundLibrary.getBackground("game-background");
            case WonState:
                return backgroundLibrary.getBackground("won-background");
            case LostState:
                return backgroundLibrary.getBackground("lost-background");
            case PauseState:
                return backgroundLibrary.getBackground("pause-background");
            default:
                return null;
        }
    }
}
