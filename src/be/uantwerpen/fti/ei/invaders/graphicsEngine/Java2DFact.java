package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.controlEngine.PlayerController;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DBulletEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DPlayerEntity;

import java.util.ArrayList;

/**
 * This class extends the parent abstract factory.
 */
public class Java2DFact extends AFact {
    private final static int width = 800;
    private final static int height = 600;
    private final Display display;

    public Java2DFact() {
        input = new Input();
        entities = new ArrayList<>();
        display = new Display(width, height, input);
    }

    @Override
    public void render(Game game) {
        display.render(game);
    }

    @Override
    public Entity getPlayerEntity(Action action) {
        return new Java2DPlayerEntity(new PlayerController(input), action);
    }

    @Override
    public Entity getEnemyEntity() {
        return null;
    }

    @Override
    public Entity getBulletEntity(Entity entity) {
        return new Java2DBulletEntity(entity.getPosition().getX(), entity.getPosition().getY());
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
