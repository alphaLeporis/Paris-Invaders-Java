package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions.PlayerShootsBullet;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects.Effect;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects.Fast;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.effects.Slow;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.VisualisationObjects;

import java.awt.*;
import java.util.Optional;

/**
 *  The game needs a player, else the game would not be playable!
 */
public class PlayerEntity extends Entity {
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<Effect> effect;
    private int currentHealth = 3;
    private final Controller controller;
    private long lastSpaceEntry = System.currentTimeMillis();

    /**
     * The enemy spawns
     * @param controller is needed to control the enemy.
     */
    public PlayerEntity(Controller controller) {
        super();
        position = new Position(AFact.gameConfig.getConfigInt("WIDTH")/2 - AFact.gameConfig.getConfigInt("ENTITY_WIDTH")/2,
                AFact.gameConfig.getConfigInt("HEIGHT") -  AFact.gameConfig.getConfigInt("ENTITY_HEIGHT")*2);
        this.controller = controller;
        effect = Optional.empty();
    }

    /**
     * Passes the update to super (entity) and applies effects.
     * @param state is needed to know where the updates happens.
     */
    @Override
    public void update(State state) {
        super.update(state);
        effect.ifPresent(Effect::update);
        cleanupEffects();
    }

    /**
     * The speed can be affected by effects. Here we predefine the speed in case of an effect.
     * @return the speed.
     */
    private int getSpeed() {
        if (effect.isEmpty()) return 5;
        if (effect.get() instanceof Fast) return 7;
        if (effect.get() instanceof Slow) return 3;
        return 5;
    }

    /**
     * In here we update the movement, based on the controller.
     */
    @Override
    public void updateMovement() {
        int deltaX = 0;
        if (controller.isRequestingLeft()) {
            if ((this.size.getWidth()*0.5) < position.getX())
                deltaX -= getSpeed();
        }

        if (controller.isRequestingRight()) {
            if (position.getX() < AFact.gameConfig.getConfigInt("WIDTH")-(this.size.getWidth()*1.5)) {
                deltaX += getSpeed();
            } else {
                deltaX = 0;
            }
        }

        if (controller.isRequestingShoot()) {
            if (lastSpaceEntry + 750 < System.currentTimeMillis()) {
                perform(new PlayerShootsBullet(this));
                lastSpaceEntry = System.currentTimeMillis();
            }
        }
        position.set(position.getX() + deltaX, position.getY());
    }

    /**
     * Here we handle the collisions, if the player collides with the enemy bullet the enemy dies.
     * If the player collides with a bonus, an effect is added.
     * @param other is the other entity that collides with this enemy.
     */
    @Override
    public void handleCollision(Entity other) {
        if (other instanceof EnemyBulletEntity) {
            audioPlayer.playSound("player-hit.wav");
            other.killEntity();
            score.enemyHitsPlayer();
            if (currentHealth <= 1) {
                isEntityAlive = false;
                return;
            }
            currentHealth--;
        }

        if (other instanceof BonusEntity) {
            if (((BonusEntity) other).isGoodBonus()) {
                setEffect(new Fast());
                score.playerGoodBonus();
            } else {
                setEffect(new Slow());
                score.playerBadBonus();
            }
            other.killEntity();
            audioPlayer.playSound("bonus.wav");
        }
    }

    /**
     * Cleans up old effects that should be deleted.
     */
    private void cleanupEffects() {
        if (effect.isEmpty()) return;
        if (effect.get().shouldDelete()) effect = Optional.empty();
    }

    /**
     * Applies a new effect.
     * @param effect is the new effect to be applied.
     */
    public void setEffect(Effect effect) {
        this.effect = Optional.of(effect);
    }

    /**
     * @return the current health of the player.
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * @return null: no visualisation inside here.
     */
    @Override
    public Image visualize() {
        return null;
    }
}
