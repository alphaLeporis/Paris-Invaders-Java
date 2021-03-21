package be.uantwerpen.fti.ei.invaders.gameEngine;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerEntity extends Entity {

    private Controller controller;

    public PlayerEntity(Controller controller) {
        super();
        this.controller = controller;
    }

    @Override
    public void update() {
        int deltaX = 0;
        if (controller.isRequestingLeft()) {
            deltaX--;
        }
        if (controller.isRequestingRight()) {
            deltaX++;
        }
        position = new Position(position.getX() + deltaX, position.getY());
    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.BLUE);
        graphics.fillRect(0,0,size.getWidth(), size.getHeight());
        graphics.dispose();
        return image;
    }
}
