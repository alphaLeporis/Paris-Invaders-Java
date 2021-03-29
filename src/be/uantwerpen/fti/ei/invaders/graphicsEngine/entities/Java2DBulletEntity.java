package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.BulletEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.SpriteLibrary;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Java2DBulletEntity extends BulletEntity {
    private AnimationManager animationManager;

    public Java2DBulletEntity(int x, int y, SpriteLibrary spriteLibrary) {
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
