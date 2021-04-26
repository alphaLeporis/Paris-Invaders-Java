package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.CollisionHandling.CollisionBox;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.PlayerShootsBullet;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects.Fast;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects.Slow;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

public class PlayerEntity extends Entity {

    private int currentHealth = 3;
    private final Controller controller;
    private long lastSpaceEntry = System.currentTimeMillis();

    public PlayerEntity(Controller controller) {
        super();
        position = new Position(AFact.gameConfig.getConfigInt("WIDTH")/2 - AFact.gameConfig.getConfigInt("ENTITY_WIDTH")/2,
                AFact.gameConfig.getConfigInt("HEIGHT") -  AFact.gameConfig.getConfigInt("ENTITY_HEIGHT")*2);
        this.controller = controller;
    }

    @Override
    public void update(State state) {
        super.update(state);
        handleCollisions(state);
        setSpeed();
    }

    private int setSpeed() {
        try {
            if (effects.get(0) instanceof Slow) {
                return 3;
            } else if (effects.get(0) instanceof Fast) {
                return 7;
            } else {
                return 5;
            }
        } catch (Exception e) {
            return 5;
        }

    }

    @Override
    public void updateMovement() {
        int deltaX = 0;
        if (controller.isRequestingLeft()) {
            if ((this.size.getWidth()*0.5) < position.getX())
                deltaX -= setSpeed();
        }

        if (controller.isRequestingRight()) {
            if (position.getX() < AFact.gameConfig.getConfigInt("WIDTH")-(this.size.getWidth()*1.5)) {
                deltaX += setSpeed();
            } else {
                deltaX = 0;
            }
        }

        if (controller.isRequestingShoot()) {
            if (lastSpaceEntry + 750 < System.currentTimeMillis()) {
                perform(new PlayerShootsBullet(this));
                lastSpaceEntry = System.currentTimeMillis();
            }
        }
        position = new Position(position.getX() + deltaX, position.getY());
    }

    private void handleCollisions(State state) {
        state.getCollidingGameObjects(this).forEach(this::handleCollision);

    }

    private void handleCollision(Entity other) {
        if (other instanceof EnemyBulletEntity) {
            audioPlayer.playSound("player-hit.wav");
            if (currentHealth <= 1) {
                isEntityAlive = false;
            } else {
                currentHealth--;
            }
            other.killEntity();
        }

        if (other instanceof BonusEntity) {
            if (((BonusEntity) other).isGoodBonus()) {
                setEffect(new Fast());
            } else {
                setEffect(new Slow());
            }
            other.killEntity();
            audioPlayer.playSound("bonus.wav");
        }
    }

    @Override
    public Image visualize() {
        return null;
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

    public int getCurrentHealth() {
        return currentHealth;
    }
}
