package be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

public class EnemyShootsBullet extends Action {
    private final Entity enemy;
    private Entity EnemyBullet;

    public EnemyShootsBullet(Entity enemy) {
        this.enemy = enemy;
        audioPlayer.playSound("enemy-shoots.wav");
    }

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

    @Override
    public boolean isDone() {
        return !EnemyBullet.isEntityAlive();
    }
}
