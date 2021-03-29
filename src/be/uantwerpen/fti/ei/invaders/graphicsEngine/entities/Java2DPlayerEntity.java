package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.SpriteLibrary;

import java.awt.*;

public class Java2DPlayerEntity extends PlayerEntity {

    private AnimationManager animationManager;

    public Java2DPlayerEntity(Game game, Controller controller, SpriteLibrary spriteLibrary) {
        super(game, controller);
        animationManager = new AnimationManager(spriteLibrary.getUnit("remy"));
    }

    public void update() {
        this.updateMovement();
        animationManager.update();
    }

    public Image visualize() {
        return animationManager.getSprite();
    }
}
