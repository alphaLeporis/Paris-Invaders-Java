package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
    private final static String PATH_TO_UNITS = "/sprites/units";

    private Map<String, SpriteSet> units;

    public SpriteLibrary() {
        units = new HashMap<>();
        loadSpritesFromDisk();
    }

    private void loadSpritesFromDisk() {
        String[] folderNames = getFolderNames(PATH_TO_UNITS);

        for(String folderName: folderNames) {
            SpriteSet spriteSet = new SpriteSet();
            String pathToFolder = PATH_TO_UNITS + "/" + folderName;
            String[] sheetsInFolder = getSheetsInFolder(pathToFolder);
            
            for (String sheetName: sheetsInFolder) {
                    spriteSet.addSheet(
                            sheetName.substring(0,sheetName.length() - 4),
                            ImageUtils.loadImage(pathToFolder + "/"+ sheetName));
            }

            units.put(folderName, spriteSet);
        }
    }

    private String[] getSheetsInFolder(String baseDir) {
        URL resource = SpriteLibrary.class.getResource(baseDir);
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isFile());
    }

    /**
     * The function will iterate over all the files (and folders) in the given baseDir.
     * @param baseDir A string to tell us what folder the sprites will be located
     * @return A list of all the folders in the given baseDir
     */
    private String[] getFolderNames(String baseDir) {
        URL resource = SpriteLibrary.class.getResource(baseDir);
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isDirectory());
    }

    public SpriteSet getUnit(String name) {
        return units.get(name);
    }
}
