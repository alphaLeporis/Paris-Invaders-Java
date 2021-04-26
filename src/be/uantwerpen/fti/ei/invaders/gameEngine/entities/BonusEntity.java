package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.CollisionHandling.CollisionBox;
import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

public class BonusEntity extends Entity {
    private final int maxAliveTimeInSeconds = GameSettings.UPDATES_PER_SECOND * 15;
    private int aliveTimeInSeconds = 0;
    protected boolean isGoodBonus;

    public BonusEntity() {
        isGoodBonus = Math.random() < GameSettings.CHANCE_GOOD_BONUS;
        position = new Position((int) (Math.random()*GameSettings.GAME_SIZE.getWidth()), 0);
        size = new Size(GameSettings.BONUS_WIDTH, GameSettings.BONUS_HEIGHT);
    }

    @Override
    public void updateMovement() {
        int deltaY = +1;
        position = new Position(position.getX(), position.getY() + deltaY);
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

    @Override
    public Image visualize() {
        return null;
    }

    public boolean isGoodBonus() {
        return isGoodBonus;
    }
}
