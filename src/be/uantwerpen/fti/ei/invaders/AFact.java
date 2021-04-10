package be.uantwerpen.fti.ei.invaders;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.backgrounds.BackgroundLibrary;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

/**
 * This is our base abstract factory, based on this structure we can implement
 * a Java2D engine or a Text Engine.
 */
public abstract class AFact {
    protected Input input;

    public abstract void render(State state);

    public abstract Entity getPlayerEntity(Input input);
    public abstract Entity getEnemyEntity(Controller entityController, Integer enemyCount);
    public abstract Entity getBulletEntity(Entity entity);
    public abstract Entity getEnemyBulletEntity(Entity entity);

    public AFact() {
        this.input = new Input();
    }

    public Input getInput() {
        return input;
    }
}
