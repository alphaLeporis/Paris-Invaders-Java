package be.uantwerpen.fti.ei.invaders;

import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.SpriteLibrary;

import java.util.List;
import java.util.Map;

/**
 * This is our base abstract factory, based on this structure we can implement
 * a Java2D engine or a Text Engine.
 */
public abstract class AFact {
    protected Input input;
    protected SpriteLibrary spriteLibrary;

    public abstract void render(Game game);

    public abstract Entity getPlayerEntity(Game game);
    public abstract Entity getEnemyEntity(Game game, Integer enemyCount);
    public abstract Entity getBulletEntity(Entity entity);
    public abstract Integer getGameSizeHeight();
    public abstract Integer getGameSizeWidth();

    public abstract Entity getEnemyBulletEntity(Entity entity);
}
