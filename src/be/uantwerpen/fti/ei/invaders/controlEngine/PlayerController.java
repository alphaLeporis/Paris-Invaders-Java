package be.uantwerpen.fti.ei.invaders.controlEngine;

import java.awt.event.KeyEvent;

/**
 * This is the controller for the player. This class implements the Controller interface.
 */
public class PlayerController implements Controller {
    private final Input input;

    /**
     * To actually move around we pass a controller. In this case this has to be user input.
     * @param input is needed to translate input in movement.
     */
    public PlayerController(Input input) {
        this.input = input;
    }

    /**
     * @return a boolean value of the state of the 'VK_LEFT' key.
     */
    @Override
    public boolean isRequestingLeft() {
        return input.isPressed(KeyEvent.VK_LEFT);
    }

    /**
     * @return a boolean value of the state of the 'VK_RIGHT' key.
     */
    @Override
    public boolean isRequestingRight() {
        return input.isPressed(KeyEvent.VK_RIGHT);
    }


    /**
     * @return an always false boolean because the player never goes up.
     */
    @Override
    public boolean isRequestingUp() {
        return false;
    }

    /**
     * @return an always false boolean because the player never goes down.
     */
    @Override
    public boolean isRequestingDown() {
        return false;
    }

    /**
     * @return a boolean value of the state of the 'VK_SPACE' key.
     */
    @Override
    public boolean isRequestingShoot() {
        return input.isPressed(KeyEvent.VK_SPACE);
    }
}
