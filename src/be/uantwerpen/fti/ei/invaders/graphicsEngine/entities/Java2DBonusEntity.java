package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.BonusEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

import java.awt.*;

/**
 * This is  the visualization method of the Bonus entity.
 */
public class Java2DBonusEntity extends BonusEntity {
    private final AnimationManager animationManager;

    /**
     * This is the constructor to spawn a new Bonus entity.
     * @param spriteLibrary is needed to create a new animationmanager with preloaded sprites.
     */
    public Java2DBonusEntity(SpriteLibrary spriteLibrary) {
        super();
        if (isGoodBonus)
            animationManager = new AnimationManager(spriteLibrary.getUnit("good-bonus"));
        else
            animationManager = new AnimationManager(spriteLibrary.getUnit("bad-bonus"));
    }

    /**
     * Updates super (BonusEntity).
     * Updates the animationmanager for the animations.
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        super.update(state);
        animationManager.update();
    }

    /**
     * Visualizes the Bonus entity.
     * @return an image of the sprite animation frame.
     */
    public Image visualize() {
        return animationManager.getSprite();
    }
}
