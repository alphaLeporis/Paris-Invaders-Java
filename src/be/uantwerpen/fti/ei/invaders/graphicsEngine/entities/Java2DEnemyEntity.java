package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites.SpriteLibrary;

import java.awt.*;

public class Java2DEnemyEntity extends EnemyEntity {

    private final AnimationManager animationManager;

    public Java2DEnemyEntity(Game game, Controller controller, SpriteLibrary spriteLibrary,Integer enemyCount) {
        super(game, controller, enemyCount);
        animationManager = new AnimationManager(spriteLibrary.getUnit("remy"));
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
