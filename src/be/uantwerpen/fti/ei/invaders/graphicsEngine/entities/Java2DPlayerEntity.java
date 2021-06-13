package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

import java.awt.*;

/**
 * This is  the visualization method of the Player entity.
 */
public class Java2DPlayerEntity extends PlayerEntity {

    private final AnimationManager animationManager;

    /**
     * This is the constructor to spawn a new Player entity.
     * This sprite is randomly chosen.
     * @param controller is needed to move the enemy.
     * @param spriteLibrary is needed to create a new animationmanager with preloaded sprites.
     */
    public Java2DPlayerEntity(Controller controller, SpriteLibrary spriteLibrary) {
        super(controller);
        animationManager = new AnimationManager(spriteLibrary.getUnit("remy"));
    }

    /**
     * Updates super (PlayerEntity).
     * Updates the animationmanager for the animations.
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        super.update(state);
        animationManager.update();
    }

    /**
     * Visualizes the Player entity.
     * @return an image of the sprite animation frame.
     */
    public Image visualize() {
        return animationManager.getSprite();
    }
}
