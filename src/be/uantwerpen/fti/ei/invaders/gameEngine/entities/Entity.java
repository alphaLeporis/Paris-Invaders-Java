package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;

import java.awt.*;

/**
 * This is the abstract class for all movable objects.
 */
public abstract class Entity {
    protected Position position;
    protected Size size;

    /**
     * The constructor provides a default position and size.
     */
    public Entity() {
        position = new Position(50,350);
        size = new Size(50, 50);
    }

    public abstract void update();

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }

    public abstract Image visualize();
}
