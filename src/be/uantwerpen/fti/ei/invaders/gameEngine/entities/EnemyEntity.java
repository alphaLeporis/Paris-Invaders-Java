package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.EnemyShootsBullet;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

public class EnemyEntity extends Entity {
    private final Controller controller;

    public EnemyEntity(Controller controller, int x, int y) {
        super();
        //int x = ((150 * (enemyID - Math.floorDiv(enemyID, GameSettings.ENEMIES_PER_ROW) * GameSettings.ENEMIES_PER_ROW )) - GameSettings.ENTITY_WIDTH/2);
        //int y = ((Math.floorDiv(enemyID, GameSettings.ENEMIES_PER_ROW) + 1) * 50 - GameSettings.ENTITY_HEIGHT/2);
        System.out.println(x+":"+y+" ");
        position = new Position(x,y);
        this.controller = controller;
    }

    @Override
    public void update(State state) {
        super.update(state);
        handleCollisions(state);
    }

    @Override
    public void updateMovement() {
        int deltaX = 0;
        int deltaY = 0;

        if (controller.isRequestingLeft()) {
            deltaX-=2;
        }
        if (controller.isRequestingRight()) {
            deltaX+=2;
        }
        if (controller.isRequestingUp()) {
            deltaY-=1;
        }
        if (controller.isRequestingDown()) {
            deltaY+=20;
        }

        if (controller.isRequestingShoot()) {
            perform(new EnemyShootsBullet(this));
        }
        position = new Position(position.getX() + deltaX, position.getY() + deltaY);
    }

    private void handleCollisions(State state) {
        state.getCollidingGameObjects(this).forEach(this::handleCollision);

    }
    private void handleCollision(Entity other) {
        if (other instanceof PlayerBulletEntity) {
            isEntityAlive = false;
            other.killEntity();
            audioPlayer.playSound("hit.wav");
        }
    }

    @Override
    public Image visualize() {
        return null;
    }

    @Override
    public boolean collidesWith(Entity other) {
        return getCollisionBox().collidesWith(other.getCollisionBox());
    }
}
