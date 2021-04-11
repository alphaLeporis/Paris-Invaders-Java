package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.BonusEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

import java.awt.*;

public class Java2DBonusEntity extends BonusEntity {
    private final AnimationManager animationManager;

    public Java2DBonusEntity(SpriteLibrary spriteLibrary) {
        super();
        if (isGoodBonus)
            animationManager = new AnimationManager(spriteLibrary.getUnit("good-bonus"));
        else
            animationManager = new AnimationManager(spriteLibrary.getUnit("bad-bonus"));
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
