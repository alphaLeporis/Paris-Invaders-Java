package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerBulletEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

import java.awt.*;

public class Java2DPlayerBulletEntity extends PlayerBulletEntity {
    private final AnimationManager animationManager;

    public Java2DPlayerBulletEntity(int x, int y, SpriteLibrary spriteLibrary) {
        super(x, y);
        animationManager = new AnimationManager(spriteLibrary.getUnit("baguette"));
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
