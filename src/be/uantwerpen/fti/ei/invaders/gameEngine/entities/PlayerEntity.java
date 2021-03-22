package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;

import java.awt.*;

public class PlayerEntity extends Entity {

    private Controller controller;
    private long lastSpaceEntry = System.currentTimeMillis();

    public PlayerEntity(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void update() {
        int deltaX = 0;
        if (controller.isRequestingLeft()) {
            deltaX-=5;
        }
        if (controller.isRequestingRight()) {
            deltaX+=5;
        }
        if (controller.isRequestingSpace()) {
            if (lastSpaceEntry + 1000 < System.currentTimeMillis()) {
                System.out.println("Fired!");
                lastSpaceEntry = System.currentTimeMillis();
            }
        }
        position = new Position(position.getX() + deltaX, position.getY());
    }

    @Override
    public Image visualize() {
        return null;
    }
}
