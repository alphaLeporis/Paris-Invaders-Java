package be.uantwerpen.fti.ei.invaders.gameEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final AFact afact;
    private final Action action;
    public List<Entity> entities;

    public Game(AFact afact) {
        this.afact = afact;
        action = new Action(this);
        entities = new ArrayList<>();
        entities.add(afact.getPlayerEntity(this));
        for (int i=0; i<10; i++) {
            entities.add(afact.getEnemyEntity(this,i));
        }
    }

    public Integer getGameSizeWidth() {
        return afact.getGameSizeWidth();
    }

    public Integer getGameSizeHeight() {
        return afact.getGameSizeHeight();
    }


    public void update() {
        killDeadGameObjects();
        updateGameObjects();

    }

    private void killDeadGameObjects() {
        for(int i = 0; i < entities.size(); i++) {
            if(!entities.get(i).isEntityAlive()) {
                entities.remove(i);
            }
        }
    }

    private void updateGameObjects() {
        for(int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
        }
    }

    public void render() {
        afact.render(this);
    }

    public List<Entity> getEntities() {
        return entities;
    }



    public void spawnBulletEntity(Entity entity) {
        entities.add(afact.getBulletEntity(entity));
    }


    public List<Entity> getCollidingGameObjects(Entity entity) {
        return entities.stream()
                .filter(other -> other.collidesWith(entity))
                .collect(Collectors.toList());
    }

    public void spawnEnemyBulletEntity(Entity entity) {
        entities.add(afact.getEnemyBulletEntity(entity));
    }
}
