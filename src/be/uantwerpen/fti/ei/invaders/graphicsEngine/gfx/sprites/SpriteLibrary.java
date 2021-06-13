package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * This library holds different SpriteSets.
 */
public class SpriteLibrary {
    private final static String PATH_TO_SPRITES = "/sprites";
    private final Map<String, SpriteSet> spriteSetMap;

    /**
     * Constructor that loads SpriteSets
     */
    public SpriteLibrary() {
        spriteSetMap = new HashMap<>();
        loadSpritesFromDisk();
    }

    /**
     * Loads all the sprites that can be found inside the sprite directory.
     */
    private void loadSpritesFromDisk() {
        String[] folderNames = getFolderNames();

        for(String folderName: folderNames) {
            SpriteSet spriteSet = new SpriteSet();
            String pathToFolder = PATH_TO_SPRITES + "/" + folderName;
            String[] sheetsInFolder = getSheetsInFolder(pathToFolder);
            
            for (String sheetName: sheetsInFolder) {
                    spriteSet.addSheet(
                            sheetName.substring(0,sheetName.length() - 4),
                            ImageUtils.loadImage(pathToFolder + "/"+ sheetName));
            }

            spriteSetMap.put(folderName, spriteSet);
        }
    }

    /**
     * Returns a list of all sprite sheets in a folder.
     * @param baseDir is the directory there will be looked in.
     * @return a list of all the backgrounds in that folder.
     *
     */
    private String[] getSheetsInFolder(String baseDir) {
        URL resource = SpriteLibrary.class.getResource(baseDir);
        assert resource != null;
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isFile());
    }

    /**
     * The function will iterate over all the files (and folders) in the given baseDir.
     * @return A list of all the folders in the given baseDir
     */
    private String[] getFolderNames() {
        URL resource = SpriteLibrary.class.getResource(SpriteLibrary.PATH_TO_SPRITES);
        assert resource != null;
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isDirectory());
    }

    /**
     * returns a specific sprite unit.
     * @param name is needed to know what unit you want.
     * @return the specified sprite unit (if it exists).
     */
    public SpriteSet getUnit(String name) {
        return spriteSetMap.get(name);
    }

    /**
     * Resizes the SpriteSets.
     * @param xFactor is multiplied with the original image width.
     * @param yFactor is multiplied with the original image height.
     */
    public void resize(double xFactor, double yFactor) {
        for (Map.Entry<String, SpriteSet> spriteSet : spriteSetMap.entrySet()) {
            spriteSet.getValue().resize(xFactor, yFactor);
        }
    }
}
