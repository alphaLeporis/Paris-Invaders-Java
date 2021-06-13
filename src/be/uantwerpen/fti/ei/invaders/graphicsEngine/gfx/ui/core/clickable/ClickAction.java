package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ui.core.clickable;

import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

/**
 * Small helper function to execute an action in the state.
 */
public interface ClickAction {
    void execute(State state);
}
