package be.uantwerpen.fti.ei.invaders;

import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;

import java.util.List;
import java.util.Map;

/**
 * This is our base abstract factory, based on this structure we can implement
 * a Java2D engine or a Text Engine.
 */
public abstract class AFact {
    public List<Entity> entities;
    protected Input input;

    public abstract void render(Game game);

    public abstract Entity getPlayerEntity(Action action);
    public abstract Entity getEnemyEntity();
    public abstract Entity getBulletEntity(Entity entity);
    public abstract Integer getGameSizeHeight();
    public abstract Integer getGameSizeWidth();
}
