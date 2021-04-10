package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.CollisionHandling.CollisionBox;
import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

/**
 * This is the abstract class for all movable objects.
 */
public abstract class Entity {
    protected Position position;
    protected Size size;
    protected boolean isEntityAlive;

    /**
     * The constructor provides a default position and size.
     */
    public Entity() {
        isEntityAlive = true;
        position = new Position((int) (GameSettings.WINDOW_DIMENSION.getWidth()/2 - GameSettings.ENTITY_WIDTH/2),
                                (int) (GameSettings.WINDOW_DIMENSION.getHeight() -  GameSettings.ENTITY_HEIGHT*1.3));
        size = new Size(GameSettings.ENTITY_WIDTH, GameSettings.ENTITY_HEIGHT);
    }

    public abstract void updateMovement();
    public abstract void update(State state);
    public abstract CollisionBox getCollisionBox();
    public abstract boolean collidesWith(Entity other);
    public abstract Image visualize();

    public Position getPosition() {
        return position;
    }
    public Size getSize() {
        return size;
    }
    public boolean isEntityAlive() {
        return isEntityAlive;
    }
    public void killEntity() {
        isEntityAlive = false;
    }
}
