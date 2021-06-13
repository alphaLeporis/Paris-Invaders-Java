package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.BlockEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

import java.awt.*;

/**
 * This is  the visualization method of the Block entity.
 */
public class Java2DBlockEntity extends BlockEntity {
    private final AnimationManager animationManager;

    /**
     * This is the constructor to spawn a new Block entity.
     * @param spriteLibrary is needed to create a new animationmanager with preloaded sprites.
     * @param x is the x location in game units.
     * @param y is the y location in game units.
     */
    public Java2DBlockEntity(SpriteLibrary spriteLibrary, int x, int y) {
        super(x, y);
        animationManager = new AnimationManager(spriteLibrary.getUnit("block"));
    }

    /**
     * Updates super (BlockEntity).
     * Updates the animationmanager for the animations.
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        super.update(state);
        animationManager.update();
        if (currentHealth !=  7) {
            animationManager.playAnimation("broken_"+currentHealth);
        }
    }

    /**
     * Visualizes the block entity.
     * @return an image of the sprite animation frame.
     */
    public Image visualize() {
        return animationManager.getSprite();
    }
}
