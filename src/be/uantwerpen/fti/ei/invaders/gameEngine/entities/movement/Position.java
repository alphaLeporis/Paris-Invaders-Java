package be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement;

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