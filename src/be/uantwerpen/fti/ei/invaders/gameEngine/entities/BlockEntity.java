package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

/**
 * This is a block within the game. This object has no movement but has health.
 * If it has been hit more than n times the block will disappear.
 */
public class BlockEntity extends Entity {
    protected int currentHealth = 7;

    /**
     * Constructor with the spawn location
     * @param x passes the x value in game units.
     * @param y passes the y value in game units.
     */
    public BlockEntity(int x, int y) {
        super();
        position = new Position(x,y);
    }

    /**
     * Passes the update to super (entity).
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        super.update(state);
    }

    /**
     * The collision handling.
     * We want the health to decrement on each impact of a bullet.
     * @param other is needed to know what entity did it impact with.
     */
    @Override
    public void handleCollision(Entity other) {
        if (other instanceof EnemyBulletEntity | other instanceof PlayerBulletEntity) {
            audioPlayer.playSound("block-hit.wav");
            if (currentHealth <= 1) {
                isEntityAlive = false;
            } else {
                currentHealth--;
            }
            other.killEntity();
        }
    }

    /**
     * Does nothing because a block does not move.
     */
    @Override
    public void updateMovement() {}

    /**
     * @return null: no visualisation inside here.
     */
    @Override
    public Image visualize() {
        return null;
    }
}
