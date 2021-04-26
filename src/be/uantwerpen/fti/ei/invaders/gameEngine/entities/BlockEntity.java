package be.uantwerpen.fti.ei.invaders.gameEngine.entities;


import be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects.Fast;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects.Slow;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BlockEntity extends Entity {
    protected int currentHealth = 7;

    public BlockEntity(int x, int y) {
        super();
        position = new Position(x,y);
    }

    @Override
    public void update(State state) {
        super.update(state);
        handleCollisions(state);
    }

    private void handleCollisions(State state) {
        state.getCollidingGameObjects(this).forEach(this::handleCollision);

    }

    private void handleCollision(Entity other) {
        if (other instanceof EnemyBulletEntity | other instanceof PlayerBulletEntity) {
            audioPlayer.playSound("player-hit.wav");
            if (currentHealth <= 1) {
                isEntityAlive = false;
            } else {
                currentHealth--;
            }
            other.killEntity();
        }
    }

    @Override
    public void updateMovement() {}


    @Override
    public boolean collidesWith(Entity other) {
        return getCollisionBox().collidesWith(other.getCollisionBox());
    }

    @Override
    public Image visualize() {
        return null;
    }
}
