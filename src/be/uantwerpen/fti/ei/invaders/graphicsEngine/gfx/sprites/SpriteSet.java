package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.Java2DFact;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SpriteSet {
    private final Map<String, Image> original_animationSheets;
    private final Map<String, Image> animationSheets;

    public int spriteWidth = Java2DFact.displayConfig.getConfigInt("SPRITE_SIZE");
    public int spriteHeight = Java2DFact.displayConfig.getConfigInt("SPRITE_SIZE");

    public SpriteSet() {
        this.original_animationSheets = new HashMap<>();
        this.animationSheets = new HashMap<>();
    }

    public void addSheet(String name, Image animationSheet) {
        original_animationSheets.put(name, animationSheet);
        animationSheets.put(name, animationSheet);
    }

    public Image get(String name) {
        return animationSheets.get(name);
    }

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
