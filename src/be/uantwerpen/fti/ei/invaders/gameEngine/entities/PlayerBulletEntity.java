package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
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
    public void update(State state) {
        shouldBeAlive();
        updateMovement();
    }

    public void shouldBeAlive() {
        aliveTimeInSeconds ++;
        if (maxAliveTimeInSeconds <= aliveTimeInSeconds)
            this.killEntity();
    }

    @Override
    public void updateMovement() {
        int deltaY = -10;
        position.set(position.getX(), position.getY()+deltaY);
    }

    @Override
    public Image visualize() {
        return null;
    }
}
