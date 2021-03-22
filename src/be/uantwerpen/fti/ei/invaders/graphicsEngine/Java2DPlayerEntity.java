package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerEntity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Java2DPlayerEntity extends PlayerEntity {

    public Java2DPlayerEntity(AFact afact, Controller controller) {
        super(afact, controller);
    }

    public Image visualize() {
        BufferedImage image = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.BLUE);
        graphics.fillRect(0,0,size.getWidth(), size.getHeight());
        graphics.dispose();
        return image;
    }
}
