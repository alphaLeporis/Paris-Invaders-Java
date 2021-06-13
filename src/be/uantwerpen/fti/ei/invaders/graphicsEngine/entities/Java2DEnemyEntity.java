package be.uantwerpen.fti.ei.invaders.graphicsEngine.entities;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.AnimationManager;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is  the visualization method of the Enemy entity.
 */
public class Java2DEnemyEntity extends EnemyEntity {
    private final AnimationManager animationManager;
    @SuppressWarnings("FieldCanBeLocal")
    private final ArrayList<String> spriteList = new ArrayList<>(Arrays.asList("cowboy", "german", "greek", "mexican"));
    private final String usedSprite;

    /**
     * This is the constructor to spawn a new Enemy entity.
     * This sprite is randomly chosen.
     * @param controller is needed to move the enemy.
     * @param spriteLibrary is needed to create a new animationmanager with preloaded sprites.
     * @param x is the x location in game units.
     * @param y is the y location in game units.
     */
    public Java2DEnemyEntity(Controller controller, SpriteLibrary spriteLibrary, int x, int y) {
        super(controller, x, y);
        usedSprite = spriteList.get((int) (Math.random()*4));
        animationManager = new AnimationManager(spriteLibrary.getUnit(usedSprite));
    }

    /**
     * Updates super (EnemyEntity).
     * Updates the animationmanager for the animations.
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        super.update(state);
        animationManager.update();
    }

    /**
     * Because the sprite is randomly chosen we can access it.
     * @return the used sprite.
     */
    public String getUsedSprite() {
        return usedSprite;
    }

    /**
     * Visualizes the Enemy entity.
     * @return an image of the sprite animation frame.
     */
    public Image visualize() {
        return animationManager.getSprite();
    }
}
