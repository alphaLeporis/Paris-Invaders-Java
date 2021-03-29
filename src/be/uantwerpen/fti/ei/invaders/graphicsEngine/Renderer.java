package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;

import java.awt.*;

public class Renderer {
    public void render(Game game, Graphics graphics) {
        game.getEntities().forEach(entity -> graphics.drawImage(
                entity.visualize(),
                entity.getPosition().getX(),
                entity.getPosition().getY(),
        null
                ));
    }
}
