package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.Java2DFact;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds a SpriteSet, that can hold multiple sheets.
 */
public class SpriteSet {
    private final Map<String, Image> original_animationSheets;
    private final Map<String, Image> animationSheets;

    public int spriteWidth = Java2DFact.displayConfig.getConfigInt("SPRITE_SIZE");
    public int spriteHeight = Java2DFact.displayConfig.getConfigInt("SPRITE_SIZE");

    /**
     * Constructor that initiates the sheets.
     */
    public SpriteSet() {
        this.original_animationSheets = new HashMap<>();
        this.animationSheets = new HashMap<>();
    }

    /**
     * Adds an image (sheet) to the SpriteSet.
     * @param name the name of the sheet.
     * @param animationSheet the image that has to be loaded.
     */
    public void addSheet(String name, Image animationSheet) {
        original_animationSheets.put(name, animationSheet);
        animationSheets.put(name, animationSheet);
    }

    /**
     * @param name is needed to know what animationsheet you want.
     * @return the specified animationsheet (if it exists).
     */
    public Image get(String name) {
        return animationSheets.get(name);
    }

    /**
     * Resizes the animationsheet.
     * @param xFactor is multiplied with the original image width.
     * @param yFactor is multiplied with the original image height.
     */
    public void resize(double xFactor, double yFactor) {
        spriteWidth = (int) Math.round(Java2DFact.displayConfig.getConfigInt("SPRITE_SIZE")* xFactor);
        spriteHeight = (int) Math.round(Java2DFact.displayConfig.getConfigInt("SPRITE_SIZE")* yFactor);
        for (Map.Entry<String, Image> animationSheet : original_animationSheets.entrySet()) {

            try {
                animationSheets.put(animationSheet.getKey(),
                                    animationSheet.getValue().getScaledInstance((int) Math.round(animationSheet.getValue().getWidth(null)*xFactor),
                                                                            (int) Math.round(animationSheet.getValue().getHeight(null)*yFactor),
                                                                            Image.SCALE_DEFAULT));
            } catch (Exception e) {
                System.out.println("Error in resizing: "+animationSheet.getKey());
            }
        }
    }
}
