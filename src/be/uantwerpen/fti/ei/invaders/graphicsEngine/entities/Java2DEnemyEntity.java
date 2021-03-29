package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.Action;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.SpriteLibrary;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Java2DEnemyEntity extends EnemyEntity {

    private AnimationManager animationManager;

    public Java2DEnemyEntity(Game game, Controller controller, SpriteLibrary spriteLibrary,Integer enemyCount) {
        super(game, controller, enemyCount);
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
