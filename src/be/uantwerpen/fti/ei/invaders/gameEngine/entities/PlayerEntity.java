package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.CollisionHandling.CollisionBox;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;

import java.awt.*;

public class PlayerEntity extends Entity {

    private final Controller controller;
    private final Game game;
    private final Action action;
    private long lastSpaceEntry = System.currentTimeMillis();

    public PlayerEntity(Game game, Controller controller) {
        super();
        this.game = game;
        this.action = new Action(game);
        this.controller = controller;
    }

    @Override
    public void updateMovement() {
        int deltaX = 0;
        if (controller.isRequestingLeft()) {
            if ((this.size.getWidth()*0.5) < position.getX())
                deltaX -= 5;
        }

        if (controller.isRequestingRight()) {
            if (position.getX() < game.getGameSizeWidth()-(this.size.getWidth()*1.5)) {
                deltaX += 5;
            } else {
                deltaX = 0;
            }
        }

        if (controller.isRequestingShoot()) {
            if (lastSpaceEntry + 750 < System.currentTimeMillis()) {
                action.shootBullet(this);
                lastSpaceEntry = System.currentTimeMillis();
            }
        }
        position = new Position(position.getX() + deltaX, position.getY());
        handleCollisions(game);
    }

    private void handleCollisions(Game game) {
        game.getCollidingGameObjects(this).forEach(this::handleCollision);

    }

    private void handleCollision(Entity other) {
        if (other instanceof EnemyBulletEntity) {
            isEntityAlive = false;
            other.killEntity();
        }
    }

    @Override
    public Image visualize() {
        return null;
    }

    @Override
    public void update() {
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
