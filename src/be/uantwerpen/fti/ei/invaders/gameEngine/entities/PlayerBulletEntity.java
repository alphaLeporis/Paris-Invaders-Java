package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;

import java.awt.*;

/**
 *  During the game the player can shoot bullets.
 */
public class PlayerBulletEntity extends Entity {
    private final int maxAliveTimeInSeconds = 10*AFact.gameConfig.getConfigInt("UPDATES_PER_SECOND");
    private int aliveTimeInSeconds = 0;

    /**
     * The bullet spawns.
     * @param x is the x value of where the bullet starts in game units.
     * @param y is the y value of where the bullet starts in game units.
     */
    public PlayerBulletEntity(int x, int y) {
        position = new Position(x,y);
        size = new Size(64, 64);
    }

    /**
     * Updates the alive counter and movement.
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        shouldBeAlive();
        updateMovement();
    }

    /**
     * The bonus will be killed after a certain amount of time.
     */
    public void shouldBeAlive() {
        aliveTimeInSeconds ++;
        if (maxAliveTimeInSeconds <= aliveTimeInSeconds)
            this.killEntity();
    }

    /**
     * Updates the movement. In this case it goes up, to the enemies.
     */
    @Override
    public void updateMovement() {
        int deltaY = -10;
        position.set(position.getX(), position.getY()+deltaY);
    }

    /**
     * Not used, does not handle collisions itself.
     * @param other unused.
     */
    @Override
    public void handleCollision(Entity other) {}

    /**
     * @return null: no visualisation inside here.
     */
    @Override
    public Image visualize() {
        return null;
    }
}
