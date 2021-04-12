package be.uantwerpen.fti.ei.invaders.gameEngine.entities.actions;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.Entity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerBulletEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

public class PlayerShootsBullet extends Action {
    private Entity player;
    private Entity playerBullet;

    public PlayerShootsBullet(Entity player) {
        this.player = player;
        audioPlayer.playSound("player-shoots.wav");
    }

    @Override
    public void update(State state) {
        if(playerBullet == null) {
            playerBullet = state.getGame().getAfact().getBulletEntity(player);
            state.spawn(playerBullet);
        }

        if(isDone()) {
            playerBullet.killEntity();
        }
    }

    @Override
    public boolean isDone() {
        return !playerBullet.isEntityAlive();
    }
}
