package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.controlEngine.PlayerController;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DPlayerBulletEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DEnemyBulletEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DEnemyEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DPlayerEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.backgrounds.BackgroundLibrary;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

/**
 * This class extends the parent abstract factory.
 */
public class Java2DFact extends AFact {
    private final Display display;
    protected SpriteLibrary spriteLibrary;

    public Java2DFact() {
        super();
        spriteLibrary = new SpriteLibrary();
        display = new Display(GameSettings.WINDOW_DIMENSION, input);
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
    public Entity getEnemyEntity(Controller enemyController, Integer enemyCount) {
        return new Java2DEnemyEntity(enemyController, spriteLibrary, enemyCount);
    }

    @Override
    public Entity getBulletEntity(Entity entity) {
        return new Java2DPlayerBulletEntity(entity.getPosition().getX(), entity.getPosition().getY(), spriteLibrary);
    }

    @Override
    public Entity getEnemyBulletEntity(Entity entity) {
        return new Java2DEnemyBulletEntity(entity.getPosition().getX(), entity.getPosition().getY(), spriteLibrary);
    }
}
