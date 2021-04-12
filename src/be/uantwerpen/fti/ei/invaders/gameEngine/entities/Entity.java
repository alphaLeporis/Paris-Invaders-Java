package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.CollisionHandling.CollisionBox;
import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects.Effect;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;
import java.util.List;
import java.util.Optional;

/**
 * This is the abstract class for all movable objects.
 */
public abstract class Entity {
    protected Position position;
    protected Size size;
    protected boolean isEntityAlive;
    protected List<Effect> effects;

    /**
     * The constructor provides a default position and size.
     */
    public Entity() {
        isEntityAlive = true;
        position = new Position((int) (GameSettings.WINDOW_DIMENSION.getWidth()/2 - GameSettings.ENTITY_WIDTH/2),
                                (int) (GameSettings.WINDOW_DIMENSION.getHeight() -  GameSettings.ENTITY_HEIGHT*1.3));
        size = new Size(GameSettings.ENTITY_WIDTH, GameSettings.ENTITY_HEIGHT);
    }

    public abstract void updateMovement();
    public abstract CollisionBox getCollisionBox();
    public abstract boolean collidesWith(Entity other);
    public abstract Image visualize();

    public void update(State state) {
        updateMovement();

        try {
            effects.forEach(effect -> effect.update(state));
            cleanup();

        } catch (Exception e) {

        }
    };

    private void cleanup() {
        List.copyOf(effects).stream()
                .filter(Effect::shouldDelete)
                .forEach(effects::remove);

    }

    public Position getPosition() {
        return position;
    }
    public Size getSize() {
        return size;
    }
    public boolean isEntityAlive() {
        return isEntityAlive;
    }
    public void killEntity() {
        isEntityAlive = false;
    }
    public void setEffect(Effect effect) {
        effects.clear();
        effects.add(effect);
    }
}
