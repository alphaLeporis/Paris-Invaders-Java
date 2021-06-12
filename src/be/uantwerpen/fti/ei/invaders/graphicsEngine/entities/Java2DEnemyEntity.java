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
    @SuppressWarnings("FieldCanBeLocal")
    private final ArrayList<String> spriteList = new ArrayList<>(Arrays.asList("cowboy", "german", "greek", "mexican"));
    private final String usedSprite;

    public Java2DEnemyEntity(Controller controller, SpriteLibrary spriteLibrary, int x, int y) {
        super(controller, x, y);
        usedSprite = spriteList.get((int) (Math.random()*4));
        animationManager = new AnimationManager(spriteLibrary.getUnit(usedSprite));
    }

    @Override
    public void update(State state) {
        super.update(state);
        animationManager.update();
    }

    public Image visualize() {
        return animationManager.getSprite();
    }

    public String getUsedSprite() {
        return usedSprite;
    }
}
