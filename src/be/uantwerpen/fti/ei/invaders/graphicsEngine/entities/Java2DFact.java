package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Display;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.state.GameState;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.state.State;

/**
 * This class extends the parent abstract factory.
 */
public class Java2DFact extends AFact {
    private static int width = 800;
    private static int height = 600;
    private Display display;
    private State state;

    public Java2DFact() {
        input = new Input();
        display = new Display(width, height, input);
        state = new GameState(input);
    }

    @Override
    public void update() {
        state.update();
    }

    @Override
    public void render() {
        display.render(state);
    }
}
