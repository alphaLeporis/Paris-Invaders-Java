package be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions;

import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;

public class Action {
    private final Game game;

    public Action(Game game) {
        this.game = game;
    }

    public void shootBullet(Entity entity) {
        game.spawnBulletEntity(entity);
    }
    public void shootEnemyBullet(Entity entity) {
        game.spawnEnemyBulletEntity(entity);
    }
}
