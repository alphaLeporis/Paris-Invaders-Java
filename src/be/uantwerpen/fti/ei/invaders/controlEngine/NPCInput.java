package be.uantwerpen.fti.ei.invaders.controlEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.util.List;
import java.util.stream.Collectors;

/**
 * In this NPCinput class we implement the logic behind the controlls of the NPC.
 */
public class NPCInput {
    private final State state;

    public final boolean callingUp = false;
    public boolean callingDown = false;
    private boolean goingRight;

    /**
     * Constructor allows us to change the behaviour based on th state.
     * @param state is needed to change the access the NPC's.
     */
    public NPCInput(State state) {
        this.state = state;
        goingRight = true;
    }

    /**
     * At each update this method will be called.
     * It determines if the NPC's are at the border and changes the direction.
     * At the border of the screen the NPC's also go down.
     */
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

    /**
     * @return a boolean that will state if the NPC shoots or not.
     */
    public boolean callingShoot() {
        update();
        return Math.random()*1000 < AFact.gameConfig.getConfigInt("CHANCE_ENEMY_SHOOTS");
    }

    /**
     * @return a boolean that states if the NPC has to go to the left.
     */
    public boolean callingLeft() {
        return !goingRight;
    }

    /**
     * @return a boolean that states if the NPC has to go to the right.
     */
    public boolean callingRight() {
        return goingRight;
    }
}
