package be.uantwerpen.fti.ei.invaders;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * With this configreader we can read any config file in a directory.
 */
public class ConfigReader {
    private final static String PATH_TO_CONFIGS = "/configs/";
    private final Properties prop = new Properties();

    /**
     * Read a config file with a given name.
     * @param propFileName the name of the config file (.properties)
     */
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

    /**
     * Returns an int value of a config line in the config file.
     * @param propFieldName the name of the config line.
     * @return the value that is at the given line.
     */
    public Integer getConfigInt(String propFieldName) {
        return Integer.parseInt(prop.getProperty(propFieldName));
    }
}
