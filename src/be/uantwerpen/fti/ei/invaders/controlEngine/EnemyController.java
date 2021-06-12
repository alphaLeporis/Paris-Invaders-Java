package be.uantwerpen.fti.ei.invaders.controlEngine;

/**
 * This is the controller for the enemies (NPC's). This class implements the Controller interface.
 */
public class EnemyController implements Controller {
    private final NPCInput npcInput;

    /**
     * To actually move around we pass a controller. In this case this has to be NPC controller.
     * @param npcInput is needed to translate input in movement.
     */
    public EnemyController(NPCInput npcInput) {
        this.npcInput = npcInput;
    }

    /**
     * @return a boolean value of the state of the npcInput 'left' call.
     */
    @Override
    public boolean isRequestingLeft() {
        return npcInput.callingLeft() ;
    }

    /**
     * @return a boolean value of the state of the npcInput 'right' call.
     */
    @Override
    public boolean isRequestingRight() {
        return npcInput.callingRight();
    }

    /**
     * @return a boolean value of the state of the npcInput 'up' call.
     */
    @Override
    public boolean isRequestingUp() {
        return npcInput.callingUp;
    }

    /**
     * @return a boolean value of the state of the npcInput 'down' call.
     */
    @Override
    public boolean isRequestingDown() {
        return npcInput.callingDown;
    }

    /**
     * @return a boolean value of the state of the npcInput 'shoot' call.
     */
    @Override
    public boolean isRequestingShoot() {
        return npcInput.callingShoot();
    }
}
