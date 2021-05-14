package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.Java2DFact;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
    private final static String PATH_TO_SPRITES = "/sprites";

    private final Map<String, SpriteSet> spriteSetMap;

    public int spriteWidth = Java2DFact.displayConfig.getConfigInt("SPRITE_SIZE");
    public int spriteHeight = Java2DFact.displayConfig.getConfigInt("SPRITE_SIZE");

    public SpriteLibrary() {
        spriteSetMap = new HashMap<>();
        loadSpritesFromDisk();
    }

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

    public SpriteSet getUnit(String name) {
        return spriteSetMap.get(name);
    }

    public void resize(double xFactor, double yFactor) {
        spriteWidth *= xFactor;
        spriteHeight *= yFactor;

        for (Map.Entry<String, SpriteSet> spriteSet : spriteSetMap.entrySet()) {
            spriteSet.getValue().resize(xFactor, yFactor);
        }

    }
}
