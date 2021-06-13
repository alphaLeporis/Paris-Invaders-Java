package be.uantwerpen.fti.ei.invaders;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

/**
 * This is our base abstract factory, based on this structure we can implement
 * a Java2D engine or a Text Engine.
 */
public abstract class AFact {
    public static ConfigReader gameConfig;
    protected final Input input;

    /**
     * Constructor that makes a new user input and reads the game properties.
     */
    public AFact() {
        gameConfig = new ConfigReader("game.properties");
        this.input = new Input();
    }

    /**
     * Renders a frame.
     * @param state is needed to know what state to render.
     */
    public abstract void render(State state);

    public abstract State getGameState(Game game);
    public abstract State getGameState(Game game, State state);
    public abstract State getHelpState(Game game);
    public abstract State getLostState(Game game);
    public abstract State getWonState(Game game);
    public abstract State getMenuState(Game game);
    public abstract State getPauseState(Game game);

    /**
     * @param input is the controller.
     * @return a player.
     */
    public abstract Entity getPlayerEntity(Input input);

    /**
     * @param entityController is the enemy controller.
     * @param x is the x location of where the enemy spawns in game units.
     * @param y is the y location of where the enemy spawns in game units.
     * @return an enemy.
     */
    public abstract Entity getEnemyEntity(Controller entityController, int x, int y);

    /**
     * @param entity is the entity shooting.
     * @return a player bullet.
     */
    public abstract Entity getPlayerBulletEntity(Entity entity);

    /**
     * @param entity is the entity shooting.
     * @return an enemy bullet.
     */
    public abstract Entity getEnemyBulletEntity(Entity entity);

    /**
     * @return a bonus.
     */
    public abstract Entity getBonusEntity();

    /**
     * @param x is the x location of where the enemy spawns in game units.
     * @param y is the y location of where the enemy spawns in game units.
     * @return a block.
     */
    public abstract Entity getBlockEntity(int x, int y);

    /**
     * @return the user input class.
     */
    public Input getInput() {
        return input;
    }
}
