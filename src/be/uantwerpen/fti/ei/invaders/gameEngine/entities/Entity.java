package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.gameEngine.collisionHandling.CollisionBox;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects.Effect;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This is the abstract class for all movable objects.
 */
public abstract class Entity {
    protected Position position;
    protected Size size;
    protected boolean isEntityAlive;
    protected final List<Effect> effects;
    protected Optional<Action> action;
    protected final AudioPlayer audioPlayer;

    /**
     * The constructor provides a default position and size.
     */
    public Entity() {
        isEntityAlive = true;
        position = new Position(0,0);
        size = new Size(AFact.gameConfig.getConfigInt("ENTITY_WIDTH"),
                        AFact.gameConfig.getConfigInt("ENTITY_HEIGHT"));
        effects = new ArrayList<>();
        action = Optional.empty();
        audioPlayer = new AudioPlayer();
    }

    public abstract void updateMovement();
    public abstract Image visualize();

    public CollisionBox getCollisionBox() {
        return new CollisionBox(
                new Rectangle(
                        position.getX(),
                        position.getY(),
                        size.getWidth(),
                        size.getHeight()
                )
        );
    }

    public boolean collidesWith(Entity other) {
        return getCollisionBox().collidesWith(other.getCollisionBox());
    }

    public void update(State state) {
        updateMovement();
        handleAction(state);
        effects.forEach(effect -> effect.update(state));
        cleanup();
    }

    private void handleAction(State state) {
        action.ifPresent(action -> action.update(state));
    }

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

    public void perform(Action action) {
        this.action = Optional.of(action);
    }

}
