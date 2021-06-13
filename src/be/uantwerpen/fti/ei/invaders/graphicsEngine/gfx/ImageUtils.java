package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * Holds different small methods to work more easily with images.
 */
public class ImageUtils {
    /**
     * Loads an image from a folder relative to the resource folder.
     * @param filePath a file relative to the resource folder.
     * @return the loaded image.
     */
    public static Image loadImage(String filePath) {
        try {
           return ImageIO.read(Objects.requireNonNull(ImageUtils.class.getResource(filePath)));
        } catch (Exception e) {
            System.out.println("Could not load images from path: " + filePath);
        }
        return null;
    }

    /**
     * Creates an empty (transparent) image in a specific size.
     * @param size the size you want the image.
     * @return the transparent image.
     */
    public static Image createCompatibleImage(Size size) {
        GraphicsConfiguration graphicsConfiguration = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        return graphicsConfiguration.createCompatibleImage(size.getWidth(), size.getHeight(), 2);
    }

    /**
     * Converts an image in a BufferedImage.
     * @param image the original image that has to be converted
     * @return the buffered version of the given image.
     */
    public static BufferedImage convertToBufferedImage(Image image)
    {
        BufferedImage newImage = new BufferedImage(
                image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }
}
