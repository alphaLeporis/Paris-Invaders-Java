package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyBulletEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.SpriteLibrary;

import java.awt.*;

public class Java2DEnemyBulletEntity extends EnemyBulletEntity {
    private AnimationManager animationManager;

    public Java2DEnemyBulletEntity(int x, int y, SpriteLibrary spriteLibrary) {
        super(x, y);
        animationManager = new AnimationManager(spriteLibrary.getUnit("baguette"));
    }

    public Image visualize() {
        return animationManager.getSprite();
    }

    public void update() {
        this.updateMovement();
        animationManager.update();
    }
}
