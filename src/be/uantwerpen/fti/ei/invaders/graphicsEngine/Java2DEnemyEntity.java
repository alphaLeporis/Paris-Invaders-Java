package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Java2DEnemyEntity extends EnemyEntity {
    public Java2DEnemyEntity(AFact afact, Controller controller, Integer enemyCount) {
        super(afact, controller, enemyCount);
    }

    public Image visualize() {
        BufferedImage image = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.RED);
        graphics.fillRect(0,0,size.getWidth(), size.getHeight());
        graphics.dispose();
        return image;
    }
}
