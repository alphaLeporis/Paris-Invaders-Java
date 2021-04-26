package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyBulletEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

import java.awt.*;

public class Java2DEnemyBulletEntity extends EnemyBulletEntity {
    private final AnimationManager animationManager;

    public Java2DEnemyBulletEntity(Entity entity, SpriteLibrary spriteLibrary) {
        super(entity.getPosition().getX(), entity.getPosition().getY());
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

    @Override
    public void update(State state) {
        super.update(state);
        animationManager.update();
    }

    public Image visualize() {
        return animationManager.getSprite();
    }
}
