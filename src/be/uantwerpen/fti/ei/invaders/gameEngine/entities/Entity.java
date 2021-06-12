package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.gameEngine.collisionHandling.CollisionBox;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;
import java.util.Optional;

/**
 * This is the abstract class for all movable objects.
 */
public abstract class Entity {
    protected Position position;
    protected Size size;
    protected boolean isEntityAlive;
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
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
        action = Optional.empty();
        audioPlayer = new AudioPlayer();
    }

    /**
     * Updates the movement, handles the actions and handles the collisions.
     * @param state is needed to know where the updates happens.
     */
    public void update(State state) {
        updateMovement();
        handleAction(state);
        handleCollisions(state);
    }

    /**
     * The movement updater.
     * Abstract method that each entity has to implement.
     */
    public abstract void updateMovement();

    /**
     * Visualization will be needed for the GraphicsEngine.
     * Abstract method that each entity has to implement.
     */
    public abstract Image visualize();

    /**
     * Collision handling based on the colliding object.
     * Abstract method that each entity has to implement.
     */
    public abstract void handleCollision(Entity other);

    /**
     *
     * @return a collisionbox which holds the bounds of the entity.
     */
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

    /**
     * Is used to check collision between two entities.
     * @param other the colliding entity.
     * @return a true boolean value if they collide.
     */
    public boolean collidesWith(Entity other) {
        return getCollisionBox().collidesWith(other.getCollisionBox());
    }

    /**
     * Handles an action.
     * @param state is needed to execute the action and spawn the new entity in the entitylist.
     */
    private void handleAction(State state) {
        action.ifPresent(action -> action.update(state));
    }

    /**
     * Handles the actual collision if 2 collisionboxes intersect.
     * @param state is needed to iterate over all the collidingGameObjects.
     */
    private void handleCollisions(State state) {
        state.getCollidingGameObjects(this).forEach(this::handleCollision);
    }

    /**
     * @return the position of the entity.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @return a true boolean value if the entity is still alive.
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isEntityAlive() {
        return isEntityAlive;
    }

    /**
     * Kills the entity.
     */
    public void killEntity() {
        isEntityAlive = false;
    }

    /**
     * Performs a new action.
     * @param action the action to be performed.
     */
    public void perform(Action action) {
        this.action = Optional.of(action);
    }

}
