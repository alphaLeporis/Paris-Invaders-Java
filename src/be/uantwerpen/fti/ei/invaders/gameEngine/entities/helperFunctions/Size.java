package be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions;

/**
 * To easily access the size we use this helper class
 */
public class Size {
    private int width;
    private int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
