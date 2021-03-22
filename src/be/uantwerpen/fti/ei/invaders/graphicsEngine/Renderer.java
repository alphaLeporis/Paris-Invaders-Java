package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.state.State;

import java.awt.*;

public class Renderer {
    public void render(State state, Graphics graphics) {
        state.getEntities().forEach(gameObject -> graphics.drawImage(
                gameObject.visualize(),
                gameObject.getPosition().getX(),
                gameObject.getPosition().getY(),
                null
        ));
    }
}
