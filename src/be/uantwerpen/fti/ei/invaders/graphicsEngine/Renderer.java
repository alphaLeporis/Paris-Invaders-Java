package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Renderer {
    public void render(Game game, Graphics graphics) {
        game.getEntities().forEach(gameObject -> graphics.drawImage(
                        gameObject.visualize(),
                        gameObject.getPosition().getX(),
                        gameObject.getPosition().getY(),
                        null
                ));
    }
}
