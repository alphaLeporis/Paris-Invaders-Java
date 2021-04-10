package be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions;

import be.uantwerpen.fti.ei.invaders.gameEngine.movement.Movement;
import be.uantwerpen.fti.ei.invaders.gameEngine.movement.Vector2D;

/**
 * To easily access the position we use this helper class
 */
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void apply(Movement movement) {
        Vector2D vector  = movement.getVector();
        x += vector.getX();
        y += vector.getY();
    }
}
