package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.ConfigReader;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.controlEngine.PlayerController;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.*;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

/**
 * This class extends the parent abstract factory.
 */
public class Java2DFact extends AFact {
    public static ConfigReader displayConfig;

    private final Display display;
    protected SpriteLibrary spriteLibrary;

    public Java2DFact() {
        super();
        displayConfig = new ConfigReader("display.properties");
        spriteLibrary = new SpriteLibrary();
        display = new Display(input);
    }

    @Override
    public void render(State state) {
        display.render(state);
    }

    @Override
    public Entity getPlayerEntity(Input input) {
        return new Java2DPlayerEntity(new PlayerController(input), spriteLibrary);
    }

    @Override
    public Entity getEnemyEntity(Controller enemyController, int x, int y) {
        return new Java2DEnemyEntity(enemyController, spriteLibrary, x, y);
    }

    @Override
    public Entity getBulletEntity(Entity entity) {
        return new Java2DPlayerBulletEntity(entity.getPosition().getX(), entity.getPosition().getY(), spriteLibrary);
    }

    @Override
    public Entity getEnemyBulletEntity(Entity entity) {
        return new Java2DEnemyBulletEntity(entity, spriteLibrary);
    }

    @Override
    public Entity getBonusEntity() {
        return new Java2DBonusEntity(spriteLibrary);
    }

    @Override
    public Entity getBlockEntity(int x, int y) {
        return new Java2DBlockEntity(spriteLibrary, x, y);
    }
}
