package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.CollisionHandling.CollisionBox;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

public class PlayerBulletEntity extends Entity {
    private final int maxAliveTimeInSeconds = 10*AFact.gameConfig.getConfigInt("UPDATES_PER_SECOND");
    private int aliveTimeInSeconds = 0;

    public PlayerBulletEntity(int x, int y) {
        position = new Position(x,y);
        size = new Size(64, 64);
    }

    @Override
    public void updateMovement() {
        int deltaY = -10;
        position = new Position(position.getX(), position.getY() + deltaY);
    }

    @Override
    public Image visualize() {
        return null;
    }

    @Override
    public void update(State state) {
        aliveTimeInSeconds ++;
        if (maxAliveTimeInSeconds <= aliveTimeInSeconds)
            this.killEntity();

        updateMovement();
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox(
                new Rectangle(
                        position.getX(),
                        position.getY(),
                        size.getWidth(),
                        size.getHeight()
                )
        );
    }

    @Override
    public boolean collidesWith(Entity other) {
        return getCollisionBox().collidesWith(other.getCollisionBox());
    }
}
