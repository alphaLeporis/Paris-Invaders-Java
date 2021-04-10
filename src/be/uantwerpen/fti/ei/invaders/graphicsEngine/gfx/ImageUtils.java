package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;

import javax.imageio.ImageIO;
import java.awt.*;

public class ImageUtils {
    public static final int ALPHA_OPAQUE = 1;
    public static final int ALPHA_BIT_MASKED = 2;
    public static final int ALPHA_BLEND = 3;

    public static Image loadImage(String filePath) {
        try {
           return ImageIO.read(ImageUtils.class.getResource(filePath));
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Could not load images from path: " + filePath);
        }
        return null;
    }

    public static Image createCompatibleImage(Size size, int transparency) {
        GraphicsConfiguration graphicsConfiguration = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        return graphicsConfiguration.createCompatibleImage(size.getWidth(), size.getHeight(), transparency);
    }
}
