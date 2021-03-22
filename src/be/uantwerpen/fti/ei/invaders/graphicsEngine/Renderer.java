package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.AFact;

import java.awt.*;
import java.util.ArrayList;

public class Renderer {
    public void render(AFact game, Graphics graphics) {
        game.getEntities().forEach(entity -> graphics.drawImage(
                entity.visualize(),
                entity.getPosition().getX(),
                entity.getPosition().getY(),
                null
        ));
    }
}
