package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.BulletEntity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Java2DBulletEntity extends BulletEntity {
    public Java2DBulletEntity(int x, int y) {
        super(x, y);
    }

    public Image visualize() {
        BufferedImage image = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.ORANGE);
        graphics.fillRect(0,0,size.getWidth(), size.getHeight());
        graphics.dispose();
        return image;
    }
}
