package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.backgrounds;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BackgroundSet {
    private final Map<String, Image> background;

    public BackgroundSet() {
        this.background = new HashMap<>();
    }

    public void addBackground(String name, Image animationSheet) {
        background.put(name, animationSheet);
    }

    public Image get(String name) {
        return background.get(name);
    }
}
