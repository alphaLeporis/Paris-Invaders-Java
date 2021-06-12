package be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

/**
 * This class will be used if an enemy shoots a bullet.
 */
public class EnemyShootsBullet extends Action {
    private final EnemyEntity enemy;
    private Entity EnemyBullet;

    /**
     * @param enemy is needed to know from where the bullet is coming from.
     */
    public EnemyShootsBullet(EnemyEntity enemy) {
        super();
        this.enemy = enemy;
        audioPlayer.playSound("enemy-shoots.wav");
    }

    /**
     * @param state is needed to know what state we are in and spawn a new bullet (if needed).
     */
    @Override
    public void update(State state) {
        if(EnemyBullet == null) {
            EnemyBullet = state.getGame().getAfact().getEnemyBulletEntity(enemy);
            state.spawn(EnemyBullet);
        }

        if(isDone()) {
            EnemyBullet.killEntity();
        }
    }

    /**
     * @return a boolean to know when an action is done, in this case when the EnemyBullet is not alive.
     */
    public boolean isDone() {
        return !EnemyBullet.isEntityAlive();
    }
}
