package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.gameEngine.VisualizationObject;

/**
 *  During the game bonuses slowly drop from above.
 *  The bonus can be a good bonus or a bad bonus.
 */
public class BonusEntity extends Entity {
    private final int maxAliveTimeInSeconds = 15* AFact.gameConfig.getConfigInt("UPDATES_PER_SECOND");
    private int aliveTimeInSeconds = 0;
    protected final boolean isGoodBonus;

    /**
     * Constructor. The spawn location is random.
     */
    public BonusEntity() {
        isGoodBonus = Math.random()*10 < AFact.gameConfig.getConfigInt("CHANCE_GOOD_BONUS");
        position = new Position((int) (Math.random()*AFact.gameConfig.getConfigInt("WIDTH")), 0);
        size = new Size(AFact.gameConfig.getConfigInt("BONUS_WIDTH"), AFact.gameConfig.getConfigInt("BONUS_HEIGHT"));
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
     * Updates the movement. In this case it slowly goes down.
     */
    @Override
    public void updateMovement() {
        int deltaY = +1;
        position.set(position.getX(), position.getY() + deltaY);
    }

    /**
     * @return a boolean stating if the bonus is good or not.
     */
    public boolean isGoodBonus() {
        return isGoodBonus;
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
    public VisualizationObject visualize() {
        return null;
    }
}
