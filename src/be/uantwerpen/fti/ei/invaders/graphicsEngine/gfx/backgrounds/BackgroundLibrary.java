package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.backgrounds;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BackgroundLibrary {
    private final static String PATH_TO_BACKGROUNDS = "/backgrounds";

    private final Map<String, Image> backgrounds;

    public BackgroundLibrary() {
        backgrounds = new HashMap<>();
        loadBackgroundsFromDisk();
    }

    private void loadBackgroundsFromDisk() {
        String[] backgroundsInFolder = getBackgroundsInFolder(PATH_TO_BACKGROUNDS);
        BackgroundSet backgroundSet = new BackgroundSet();

        for (String background: backgroundsInFolder) {
            backgrounds.put(background.substring(0,background.length() - 4),
                            ImageUtils.loadImage(PATH_TO_BACKGROUNDS + "/"+ background));
        }


    }

    private String[] getBackgroundsInFolder(String baseDir) {
        URL resource = BackgroundLibrary.class.getResource(baseDir);
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isFile());
    }


    public Image getBackground(String name) {
        return backgrounds.get(name);
    }
}
