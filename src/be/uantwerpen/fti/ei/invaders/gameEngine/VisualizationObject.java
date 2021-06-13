package be.uantwerpen.fti.ei.invaders.gameEngine;

import java.awt.*;

/**
 * Is the abstract visualization object. This has to be implemented by the graphics side.
 * @param <T> is the visualization type.
 */
public abstract class VisualizationObject<T> {
    public VisualizationObject() {}

    /**
     * @return a visualization.
     */
    public abstract T get();

    /**
     * @param object is needed to set a visualization.
     */
    public abstract void set(T object);
}
