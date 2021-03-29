package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.CollisionHandling.CollisionBox;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class EnemyEntity extends Entity {

    private final Action action;
    private Controller controller;
    private final Game game;

    private static ArrayList<Integer> x = new ArrayList<>((Arrays.asList(100,200,300,400,500,100,200,300,400,500)));
    private static ArrayList<Integer> y = new ArrayList<>((Arrays.asList(50,50,50,50,50,150,150,150,150,150)));

    public EnemyEntity(Game game, Controller controller, Integer enemyCount) {
        super();
        this.game = game;
        this.action = new Action(game);
        position = new Position(x.get(enemyCount),y.get(enemyCount));
        this.controller = controller;
    }

    @Override
    public void updateMovement() {
        int deltaX = 0;
        int deltaY = 0;
        if (controller.isRequestingLeft()) {
            deltaX-=1;
        }
        if (controller.isRequestingRight()) {
            deltaX+=1;
        }
        if (controller.isRequestingUp()) {
            deltaY-=1;
        }
        if (controller.isRequestingDown()) {
            deltaY+=1;
        }
        if (controller.isRequestingShoot()) {
            System.out.println("SHOOT");
            action.shootEnemyBullet(this);
        }
        position = new Position(position.getX() + deltaX, position.getY() + deltaY);
        handleCollisions(game);
    }
    private void handleCollisions(Game game) {
        game.getCollidingGameObjects(this).forEach(this::handleCollision);

    }

    private void handleCollision(Entity other) {
        if (other instanceof BulletEntity) {
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
