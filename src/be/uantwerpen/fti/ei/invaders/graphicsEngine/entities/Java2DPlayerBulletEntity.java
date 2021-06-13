package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerBulletEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.SpriteVisualization;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

/**
 * This is  the visualization method of the Player bullet entity.
 */
public class Java2DPlayerBulletEntity extends PlayerBulletEntity {
    private final AnimationManager animationManager;
    private final SpriteVisualization spriteVisualization;

    /**
     * This is the constructor to spawn a new Player Bullet entity.
     * @param spriteLibrary is needed to create a new animationmanager with preloaded sprites.
     */
    public Java2DPlayerBulletEntity(int x, int y, SpriteLibrary spriteLibrary) {
        super(x, y);
        spriteVisualization = new SpriteVisualization();
        animationManager = new AnimationManager(spriteLibrary.getUnit("baguette"));
    }

    /**
     * Updates super (PlayerBulletEntity).
     * Updates the animationmanager for the animations.
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        super.update(state);
        animationManager.update();
    }

    /**
     * Visualizes the Player Bullet entity.
     * @return an image of the sprite animation frame.
     */
    public SpriteVisualization visualize() {
        spriteVisualization.set(animationManager.getSprite());
        return spriteVisualization;
    }
}
