package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class EnemyEntity extends Entity {

    private Controller controller;

    private static ArrayList<Integer> x = new ArrayList<>((Arrays.asList(100,200,300,400,500,100,200,300,400,500)));
    private static ArrayList<Integer> y = new ArrayList<>((Arrays.asList(50,50,50,50,50,150,150,150,150,150)));

    public EnemyEntity(AFact afact, Controller controller, Integer enemyCount) {
        super(afact);
        position = new Position(x.get(enemyCount),y.get(enemyCount));
        this.controller = controller;
    }

    @Override
    public void update() {
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
        position = new Position(position.getX() + deltaX, position.getY() + deltaY);
    }

    @Override
    public Image visualize() {
        return null;
    }
}
