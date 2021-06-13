package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.backgrounds;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * The background library loads all the backgrounds at the beginning of the game.
 * It also takes care of resizing. Backgrounds are saved as their original and a resized version.
 * At each resizement the original backgrounds will be use.
 */
public class BackgroundLibrary {
    private final static String PATH_TO_BACKGROUNDS = "/backgrounds";

    private final Map<String, Image> original_backgrounds;
    private final Map<String, Image> backgrounds;

    /**
     * Constructor that loads images.
     */
    public BackgroundLibrary() {
        original_backgrounds = new HashMap<>();
        backgrounds = new HashMap<>();
        loadBackgroundsFromDisk();
    }

    /**
     * Method for loading backgrounds from disk.
     */
    private void loadBackgroundsFromDisk() {
        String[] backgroundsInFolder = getBackgroundsInFolder();

        for (String background: backgroundsInFolder) {
            original_backgrounds.put(background.substring(0,background.length() - 4),
                                    ImageUtils.loadImage(PATH_TO_BACKGROUNDS + "/"+ background)
            );

        }
    }

    /**
     * @return a list of all the backgrounds in the folder.
     */
    private String[] getBackgroundsInFolder() {
        URL resource = BackgroundLibrary.class.getResource(BackgroundLibrary.PATH_TO_BACKGROUNDS);
        assert resource != null;
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isFile());
    }


    /**
     * @param name is needed to know what background you want.
     * @return the specified background (if it exists).
     */
    public Image getBackground(String name) {
        return backgrounds.get(name);
    }

    /**
     * resizes the original backgrounds and saves them again.
     * @param width is the new width.
     * @param height is the new height.
     */
    public void resize(int width, int height) {
        for (Map.Entry<String, Image> background : original_backgrounds.entrySet()) {

            backgrounds.put(background.getKey(),
                            background.getValue().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        }
    }

}
