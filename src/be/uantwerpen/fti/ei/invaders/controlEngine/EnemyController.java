package be.uantwerpen.fti.ei.invaders.controlEngine;

public class EnemyController implements Controller {
    private NPCInput npcInput;

    public EnemyController(NPCInput npcInput) {
        this.npcInput = npcInput;
    }

    @Override
    public boolean isRequestingLeft() {
        return npcInput.callingLeft() ;
    }

    @Override
    public boolean isRequestingRight() {
        return npcInput.callingRight();
    }

    @Override
    public boolean isRequestingUp() {
        return npcInput.callingUp;
    }

    @Override
    public boolean isRequestingDown() {
        return npcInput.callingDown;
    }

    @Override
    public boolean isRequestingShoot() {
        return npcInput.callingShoot();
    }
}
