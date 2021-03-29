package be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites;

import javax.imageio.ImageIO;
import java.awt.*;

public class ImageUtils {
    public static Image loadImage(String filePath) {
        try {
           return ImageIO.read(ImageUtils.class.getResource(filePath));
        } catch (Exception e) {
            System.out.println("Could not load images from path: " + filePath);
        }
        return null;
    }
}
