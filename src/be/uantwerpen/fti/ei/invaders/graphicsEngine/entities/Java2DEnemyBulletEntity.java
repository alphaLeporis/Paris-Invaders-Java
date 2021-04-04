package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyBulletEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.SpriteLibrary;

import java.awt.*;

public class Java2DEnemyBulletEntity extends EnemyBulletEntity {
    private final AnimationManager animationManager;

    public Java2DEnemyBulletEntity(int x, int y, SpriteLibrary spriteLibrary) {
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
