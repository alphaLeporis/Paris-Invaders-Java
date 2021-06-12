package be.uantwerpen.fti.ei.invaders.controlEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.util.List;
import java.util.stream.Collectors;

public class NPCInput {
    private final State state;
    public final boolean callingUp = false;
    public boolean callingDown = false;

    private boolean goingRight;

    public NPCInput(State state) {
        this.state = state;
        goingRight = true;
    }

    public void update() {
        List<Entity> enemies = state.getEntities().stream()
                .filter(other -> other instanceof EnemyEntity)
                .collect(Collectors.toList());

        for (Entity enemy : enemies) {
            if (enemy.getPosition().getX() + 64 > AFact.gameConfig.getConfigInt("WIDTH")) {
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
        }
    }

    public boolean callingShoot() {
        update();
        return Math.random()*1000 < AFact.gameConfig.getConfigInt("CHANCE_ENEMY_SHOOTS");
    }

    public boolean callingLeft() {
        return !goingRight;
    }

    public boolean callingRight() {
        return goingRight;
    }
}
