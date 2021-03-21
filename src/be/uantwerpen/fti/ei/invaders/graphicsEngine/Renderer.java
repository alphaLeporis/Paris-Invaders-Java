package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import java.awt.*;

public class Renderer {
    public void render(Game game, Graphics graphics) {
        game.getEntities().forEach(entity -> graphics.drawImage(
                entity.getSprite(),
                entity.getPosition().getX(),
                entity.getPosition().getY(),
                null
        ));
    }
}
