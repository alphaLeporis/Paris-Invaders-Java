package be.uantwerpen.fti.ei.invaders.gameEngine.collisionHandling;

import java.awt.*;

/**
 * Our collision handler uses a collision box to decide when 2 entities have collided.
 * We will be using the Rectangle class to know when 2 rectangles have collided.
 */
public class CollisionBox {
    private final Rectangle bounds;

    /**
     * @param bounds is saved inside the class.
     */
    public CollisionBox(Rectangle bounds) {
        this.bounds = bounds;
    }

    /**
     * To check if 2 collisionboxes (this box and the "other" box) have collided.
     * @param other is needed to check if there is a collision.
     * @return a boolean based on the fact if they have collided or not.
     */
    public boolean collidesWith(CollisionBox other) {
        return bounds.intersects(other.getBounds());
    }

    /**
     * @return the bounds of this object, is needed in the collidesWith method.
     */
    public Rectangle getBounds() {
        return bounds;
    }
}
