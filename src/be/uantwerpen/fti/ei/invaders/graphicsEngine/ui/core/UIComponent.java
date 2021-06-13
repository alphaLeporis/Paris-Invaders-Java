package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core;


import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

/**
 * This is an abstract UIComponent that can de implemented to different UI systems.
 */
public abstract class UIComponent {

    protected Position position;
    protected Size size;
    protected double xFactor;
    protected double yFactor;

    /**
     * Constructor with a default size and position.
     */
    public UIComponent() {
        position = new Position(0, 0);
        size = new Size(1, 1);
    }

    /**
     * Has to be implemented by the method.
     * @return an image of rendered UI.
     */
    public abstract Image visualize();

    /**
     * Has to be implemented by the method.
     * @param state is needed to know where the update takes place.
     */
    public abstract void update(State state);

    /**
     * @return the position of the UI component
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @return the size of the UO component
     */
    public Size getSize() {
        return size;
    }

    /**
     * @param size is needed to set the size.
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Resizes with x and y factors.
     * @param xFactor is the width multiplication factor that is stored for later
     * @param yFactor is the height multiplication factor that is stored for later
     */
    public void resize(double xFactor, double yFactor) {
        this.xFactor = xFactor;
        this.yFactor = yFactor;
    }

}
