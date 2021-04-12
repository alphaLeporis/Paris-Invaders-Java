package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.CollisionHandling.CollisionBox;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.EnemyShootsBullet;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class EnemyEntity extends Entity {
    private final Controller controller;

    private static final ArrayList<Integer> x = new ArrayList<>((Arrays.asList(100,200,300,400,500,100,200,300,400,500)));
    private static final ArrayList<Integer> y = new ArrayList<>((Arrays.asList(50,50,50,50,50,150,150,150,150,150)));

    public EnemyEntity(Controller controller, Integer enemyCount) {
        super();
        position = new Position(x.get(enemyCount),y.get(enemyCount));
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
            System.out.println("DOWN");
            deltaY+=20;
        }

        if (controller.isRequestingShoot()) {
            System.out.println("SHOOT");
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
