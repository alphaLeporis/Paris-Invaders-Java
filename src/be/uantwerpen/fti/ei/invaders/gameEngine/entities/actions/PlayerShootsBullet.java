package be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

/**
 * This class will be called if the player shoots a bullet.
 */
public class PlayerShootsBullet extends Action {
    private final Entity player;
    private Entity playerBullet;

    /**
     * @param player is needed to know from where the bullet is coming from.
     */
    public PlayerShootsBullet(Entity player) {
        this.player = player;
        audioPlayer.playSound("player-shoots.wav");
    }

    /**
     * @param state is needed to know what state we are in and spawn a new bullet (if needed).
     */
    @Override
    public void update(State state) {
        if(playerBullet == null) {
            playerBullet = state.getGame().getAfact().getPlayerBulletEntity(player);
            state.spawn(playerBullet);
        }

        if(isDone()) {
            playerBullet.killEntity();
        }
    }

    /**
     * @return a boolean to know when an action is done, in this case when the PlayerBullet is not alive.
     */
    public boolean isDone() {
        return !playerBullet.isEntityAlive();
    }
}
