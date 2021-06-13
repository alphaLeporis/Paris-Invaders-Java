package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx;

import be.uantwerpen.fti.ei.invaders.gameEngine.VisualizationObject;

import java.awt.*;

/**
 * Sprite (image) implementation of VisualizationObject.
 */
public class SpriteVisualization extends VisualizationObject<Image> {
    private Image image;

    /**
     * Empty constructor.
     */
    public SpriteVisualization() {
        image = null;
    }

    /**
     * @return the sprite (image).
     */
    @Override
    public Image get() {
        return image;
    }

    /**
     * @param object is needed to set a sprite (image).
     */
    @Override
    public void set(Image object) {
        image = object;
    }
}
