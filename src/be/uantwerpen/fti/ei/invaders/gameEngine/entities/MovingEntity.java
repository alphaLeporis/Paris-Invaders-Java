package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.CollisionHandling.CollisionBox;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

public class MovingEntity extends Entity {
    @Override
    public void updateMovement() {

    }

    @Override
    public void update(State state) {

    }

    @Override
    public CollisionBox getCollisionBox() {
        return null;
    }

    @Override
    public boolean collidesWith(Entity other) {
        return false;
    }

    @Override
    public Image visualize() {
        return null;
    }
}
