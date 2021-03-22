package be.uantwerpen.fti.ei.invaders.graphicsEngine.state;

import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class State {

    protected List<Entity> entities;
    //protected SpriteLibrary spriteLibrary;
    protected Input input;

    public State(Input input) {
        this.input = input;
        entities = new ArrayList<>();
        //spriteLibrary = new SpriteLibrary();
    }

    public void update() {
        entities.forEach(entity -> entity.update());
    }


    public List<Entity> getEntities() {
        return entities;
    }

    public void spawn(Entity entity) {
        entities.add(entity);
    }
}