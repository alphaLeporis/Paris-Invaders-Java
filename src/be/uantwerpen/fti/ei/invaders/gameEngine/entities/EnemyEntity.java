package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.EnemyShootsBullet;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

/**
 *  The game needs enemies, else the game would be too easy!
 */
public class EnemyEntity extends Entity {
    private final Controller controller;

    /**
     * The enemy spawns
     * @param controller is needed to control the enemy.
     * @param x is the x value of where the enemy spawns in game units.
     * @param y is the yy value of where the enemy spawns in game units.
     */
    public EnemyEntity(Controller controller, int x, int y) {
        super();
        position = new Position(x,y);
        this.controller = controller;
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
     * In here we update the movement, based on the controller.
     */
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
        position.set(position.getX() + deltaX, position.getY()+deltaY);
    }

    /**
     * Here we handle the collisions, if the enemy collides with the player bullet the enemy dies.
     * @param other is the other entity that collides with this enemy.
     */
    @Override
    public void handleCollision(Entity other) {
        if (other instanceof PlayerBulletEntity) {
            isEntityAlive = false;
            other.killEntity();
            audioPlayer.playSound("hit.wav");
        }
    }

    /**
     * @return null: no visualisation inside here.
     */
    @Override
    public Image visualize() {
        return null;
    }
}
