package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.EnemyController;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.controlEngine.PlayerController;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class extends the parent abstract factory.
 */
public class Java2DFact extends AFact {
    private static int width = 800;
    private static int height = 600;
    private Display display;

    public Java2DFact() {
        input = new Input();
        display = new Display(width, height, input);
        entities = new ArrayList<>();
        entities.add(new Java2DPlayerEntity(this, new PlayerController(input)));
        for(int i = 0; i < 10; i++) {
            entities.add(new Java2DEnemyEntity(this, new EnemyController(),i));
        }
    }
    @Override
    public void createPlayer() {
        entities.add(new Java2DPlayerEntity(this, new PlayerController(input)));
    }

    @Override
    public void createEnemy() {

    }

    @Override
    public void createBullet(Entity entity) {
        entities.add(new Java2DBulletEntity(this, entity.getPosition().getX(), entity.getPosition().getY()));
    }

    @Override
    public void update() {
        entities.forEach(Entity::update);
    }

    @Override
    public void render() {
        display.render(this);
    }

    @Override
    public List<Entity> getEntities() {
        return entities;
    }
}
