package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyBulletEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.SpriteVisualization;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

/**
 * This is  the visualization method of the Enemy bullet entity.
 */
public class Java2DEnemyBulletEntity extends EnemyBulletEntity {
    private final AnimationManager animationManager;
    private final SpriteVisualization spriteVisualization;

    /**
     * This is the constructor to spawn a new Enemy Bullet entity.
     * Based on the entity that fired te bullet, the bullet will visualize differently.
     * @param entity is needed to know where the bullet has been fired and by whom.
     * @param spriteLibrary is needed to create a new animationmanager with preloaded sprites.
     */
    public Java2DEnemyBulletEntity(Entity entity, SpriteLibrary spriteLibrary) {
        super(entity.getPosition().getX(), entity.getPosition().getY());
        spriteVisualization = new SpriteVisualization();
        String bulletSprite = "baguette";
        if (entity instanceof Java2DEnemyEntity) {
            switch (((Java2DEnemyEntity) entity).getUsedSprite()) {
                case "cowboy":  bulletSprite = "cactus";
                    break;
                case "greek":  bulletSprite = "trident";
                    break;
                case "german":  bulletSprite = "beer";
                    break;
                case "mexican":  bulletSprite = "taco";
                    break;
                default: bulletSprite = "baguette";
                    break;
            }
        }
        animationManager = new AnimationManager(spriteLibrary.getUnit(bulletSprite));
    }

    /**
     * Updates super (EnemyBulletEntity).
     * Updates the animationmanager for the animations.
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        super.update(state);
        animationManager.update();
    }

    /**
     * Visualizes the Enemy Bullet entity.
     * @return an image of the sprite animation frame.
     */
    public SpriteVisualization visualize() {
        spriteVisualization.set(animationManager.getSprite());
        return spriteVisualization;
    }
}
