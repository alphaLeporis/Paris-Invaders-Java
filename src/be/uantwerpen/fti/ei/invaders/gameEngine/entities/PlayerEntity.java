package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;

import java.awt.*;

public class PlayerEntity extends Entity {

    private final Controller controller;
    private final Action action;
    private long lastSpaceEntry = System.currentTimeMillis();

    public PlayerEntity(Controller controller, Action action) {
        this.action = action;
        this.controller = controller;
    }

    @Override
    public void update() {
        int deltaX = 0;
        if (controller.isRequestingLeft()) {
            if (25 < position.getX()) {
                deltaX -= 5;
            } else {
                deltaX = 0;
            }

        }
        if (controller.isRequestingRight()) {
            if (position.getX() < action.getMaxWidth()-75) {
                deltaX += 5;
            } else {
                deltaX = 0;
            }
        }
        if (controller.isRequestingSpace()) {
            if (lastSpaceEntry + 750 < System.currentTimeMillis()) {
                action.shootBullet(this);
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
