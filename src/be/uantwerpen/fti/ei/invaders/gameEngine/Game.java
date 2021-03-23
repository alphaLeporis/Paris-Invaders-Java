package be.uantwerpen.fti.ei.invaders.gameEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final AFact afact;
    private final Action action;
    public List<Entity> entities;

    public Game(AFact afact) {
        this.afact = afact;
        action = new Action(this);
        entities = new ArrayList<>();
        entities.add(afact.getPlayerEntity(action));
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
        for (Entity entity : entities) {
            entity.update();
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


}
