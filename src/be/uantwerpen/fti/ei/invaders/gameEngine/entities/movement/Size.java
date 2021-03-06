package be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement;

/**
 * To easily access the size we use this helper class.
 */
public class Size {
    private final int width;
    private final int height;

    /**
     * Constructor with width and height values.
     * @param width passes the width.
     * @param height passes the height.
     */
    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * @return the stored width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the stored height.
     */
    public int getHeight() {
        return height;
    }
}
