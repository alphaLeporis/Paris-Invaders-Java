package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

public class BonusEntity extends Entity {
    private final int maxAliveTimeInSeconds = 15* AFact.gameConfig.getConfigInt("UPDATES_PER_SECOND");
    private int aliveTimeInSeconds = 0;
    protected final boolean isGoodBonus;

    public BonusEntity() {
        isGoodBonus = Math.random()*10 < AFact.gameConfig.getConfigInt("CHANCE_GOOD_BONUS");
        position = new Position((int) (Math.random()*AFact.gameConfig.getConfigInt("WIDTH")), 0);
        size = new Size(AFact.gameConfig.getConfigInt("BONUS_WIDTH"), AFact.gameConfig.getConfigInt("BONUS_HEIGHT"));
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
        int deltaY = +1;
        position.set(position.getX(), position.getY() + deltaY);
    }

    @Override
    public Image visualize() {
        return null;
    }

    public boolean isGoodBonus() {
        return isGoodBonus;
    }
}
