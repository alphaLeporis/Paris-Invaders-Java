package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.BlockEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

import java.awt.*;

public class Java2DBlockEntity extends BlockEntity {
    private final AnimationManager animationManager;

    public Java2DBlockEntity(SpriteLibrary spriteLibrary, int x, int y) {
        super(x, y);
        animationManager = new AnimationManager(spriteLibrary.getUnit("block"));
    }

    @Override
    public void update(State state) {
        super.update(state);
        animationManager.update();
        if (currentHealth !=  7) {
            animationManager.playAnimation("broken_"+currentHealth);
        }
    }

    public Image visualize() {
        return animationManager.getSprite();
    }
}
