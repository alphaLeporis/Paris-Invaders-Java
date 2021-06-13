package be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement;

/**
 * To easily save and read the position we use this helper class
 */
public class Position {
    private int x;
    private int y;

    /**
     * Constructor with initial x and y values.
     * @param x passes the x value.
     * @param y passes the y value.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the stored x value.
     */
    public int getX() {
        return x;
    }

    /**
     * @return the stored y value.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the values to a new value
     * @param x replaces old x with a new value
     * @param y replaces old y with a new value
     */
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
