package be.uantwerpen.fti.ei.invaders;

import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;

import java.util.List;

/**
 * This is our base abstract factory, based on this structure we can implement
 * a Java2D engine or a Text Engine.
 */
public abstract class AFact {
    public List<Entity> entities;
    protected Input input;

    public abstract void update();
    public abstract void render();
}
