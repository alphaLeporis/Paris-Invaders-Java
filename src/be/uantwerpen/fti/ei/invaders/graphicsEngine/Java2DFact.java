package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.EnemyController;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.controlEngine.PlayerController;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DBulletEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DEnemyBulletEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DEnemyEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DPlayerEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.SpriteLibrary;

import java.util.ArrayList;

/**
 * This class extends the parent abstract factory.
 */
public class Java2DFact extends AFact {
    public static int SPRITE_SIZE = 64;
    private final static int width = 800;
    private final static int height = 600;
    private final Display display;

    public Java2DFact() {
        input = new Input();
        spriteLibrary = new SpriteLibrary();
        display = new Display(width, height, input);
    }

    @Override
    public void render(Game game) {
        display.render(game);
    }

    @Override
    public Entity getPlayerEntity(Game game) {
        return new Java2DPlayerEntity(game, new PlayerController(input), spriteLibrary);
    }

    @Override
    public Entity getEnemyEntity(Game game, Integer enemyCount) {
        return new Java2DEnemyEntity(game, new EnemyController(), spriteLibrary, enemyCount);
    }

    @Override
    public Entity getBulletEntity(Entity entity) {
        return new Java2DBulletEntity(entity.getPosition().getX(), entity.getPosition().getY(), spriteLibrary);
    }

    @Override
    public Entity getEnemyBulletEntity(Entity entity) {
        return new Java2DEnemyBulletEntity(entity.getPosition().getX(), entity.getPosition().getY(), spriteLibrary);
    }

    @Override
    public Integer getGameSizeWidth() {
        return width;
    }

    @Override
    public Integer getGameSizeHeight() {
        return height;
    }


}
