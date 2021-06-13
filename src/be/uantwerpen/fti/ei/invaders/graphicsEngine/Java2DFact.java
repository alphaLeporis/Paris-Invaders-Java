package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.ConfigReader;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.controlEngine.PlayerController;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.*;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.backgrounds.BackgroundLibrary;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

/**
 * This class extends the parent abstract factory.
 * We use a Java2D graphics engine.
 */
public class Java2DFact extends AFact {
    public static ConfigReader displayConfig;

    private final Display display;
    protected final SpriteLibrary spriteLibrary;
    protected final BackgroundLibrary backgroundLibrary;

    /**
     * The constructor loads the display, background an sprites.
     * It also takes care of the display properties.
     */
    public Java2DFact() {
        super();
        displayConfig = new ConfigReader("display.properties");
        spriteLibrary = new SpriteLibrary();
        backgroundLibrary = new BackgroundLibrary();
        display = new Display(input, spriteLibrary, backgroundLibrary);
    }

    /**
     * Sends to the display to render.
     * @param state is needed to know what to render (what state).
     */
    @Override
    public void render(State state) {
        display.render(state);
    }

    /**
     * Spawns a new Java2D player.
     * @param input is the controller
     * @return a Java2D player.
     */
    @Override
    public Entity getPlayerEntity(Input input) {
        return new Java2DPlayerEntity(new PlayerController(input), spriteLibrary);
    }

    /**
     * Spawns a new Java2D enemy.
     * @param enemyController is the enemy controller
     * @param x is the x location of where the enemy spawns in game units.
     * @param y is the y location of where the enemy spawns in game units.
     * @return a Java2D enemy.
     */
    @Override
    public Entity getEnemyEntity(Controller enemyController, int x, int y) {
        return new Java2DEnemyEntity(enemyController, spriteLibrary, x, y);
    }

    /**
     * Spawns a Java2D player bullet.
     * @param entity is the entity shooting.
     * @return a Java2D player bullet.
     */
    @Override
    public Entity getPlayerBulletEntity(Entity entity) {
        return new Java2DPlayerBulletEntity(entity.getPosition().getX(), entity.getPosition().getY(), spriteLibrary);
    }

    /**
     * Spawns a Java2D enemy bullet.
     * @param entity is the entity shooting.
     * @return a Java2D enemy bullet.
     */
    @Override
    public Entity getEnemyBulletEntity(Entity entity) {
        return new Java2DEnemyBulletEntity(entity, spriteLibrary);
    }

    /**
     * Spawns a Java2D bonus.
     * @return a Java2D bonus.
     */
    @Override
    public Entity getBonusEntity() {
        return new Java2DBonusEntity(spriteLibrary);
    }

    /**
     * Spawns a Java2D block.
     * @param x is the x location of where the block spawns in game units.
     * @param y is the y location of where the block spawns in game units.
     * @return a Java2D block.
     */
    @Override
    public Entity getBlockEntity(int x, int y) {
        return new Java2DBlockEntity(spriteLibrary, x, y);
    }

}
