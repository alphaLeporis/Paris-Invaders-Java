package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Java2DEnemyEntity extends EnemyEntity {

    private final AnimationManager animationManager;
    private final ArrayList<String> spriteList = new ArrayList<String>(Arrays.asList("cowboy", "german", "greek", "spanish"));

    public Java2DEnemyEntity(Controller controller, SpriteLibrary spriteLibrary,Integer enemyCount) {
        super(controller, enemyCount);
        animationManager = new AnimationManager(spriteLibrary.getUnit(spriteList.get((int) (Math.random()*4))));
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
