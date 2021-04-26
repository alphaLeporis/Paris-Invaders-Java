package be.uantwerpen.fti.ei.invaders;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private final static String PATH_TO_CONFIGS = "/configs/";
    private final Properties prop = new Properties();

    public ConfigReader(String propFileName) {
        try (InputStream inputStream = ConfigReader.class.getResourceAsStream(PATH_TO_CONFIGS+propFileName)) {

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the path");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public Integer getConfigInt(String propFieldName) {
        return Integer.parseInt(prop.getProperty(propFieldName));
    }
}
