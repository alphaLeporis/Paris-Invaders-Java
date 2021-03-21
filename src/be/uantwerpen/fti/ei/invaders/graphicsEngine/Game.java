package be.uantwerpen.fti.ei.invaders.graphicsEngine;
import java.util.ArrayList;
import java.util.List;

import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.controlEngine.PlayerController;
import be.uantwerpen.fti.ei.invaders.gameEngine.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.PlayerEntity;

public class Game {
    private Display display;
    private List<Entity> entities;
    private Input input;

    public Game(int width, int height) {
        input = new Input();
        display = new Display(width, height, input);
        entities = new ArrayList<>();
        entities.add(new PlayerEntity(new PlayerController(input)));
    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void render() {
        display.render(this);
    }

    public List<Entity> getEntities() {
        return entities;
    }
}
