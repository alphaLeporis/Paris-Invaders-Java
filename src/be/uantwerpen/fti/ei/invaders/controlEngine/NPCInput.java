package be.uantwerpen.fti.ei.invaders.controlEngine;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;

import java.util.List;
import java.util.stream.Collectors;

public class NPCInput {
    private final Game game;

    public boolean callingLeft = false;
    public boolean callingRight = false;
    public boolean callingUp = false;
    public boolean callingDown = false;

    private boolean goingRight;

    public NPCInput(Game game) {
        this.game = game;
        goingRight = true;
    }

    public void update() {
/*        List<Entity> enemies = game.entities.stream()
                .filter(other -> other instanceof EnemyEntity)
                .collect(Collectors.toList());

        for (Entity enemy : enemies) {
            if (enemy.getPosition().getX() + 64 > GameSettings.WIDTH) {
                callingDown = true;
                goingRight = false;
                break;
            } else {
                callingDown = false;
            }

            if (enemy.getPosition().getX() - 10 < 0) {
                callingDown = true;
                goingRight = true;
                break;
            } else {
                callingDown = false;
            }
        }*/


    }

    public boolean callingShoot() {
        update();
        return Math.random()*1000 < 2;
    }

    public boolean callingLeft() {
        return !goingRight;
    }

    public boolean callingRight() {
        return goingRight;
    }
}
