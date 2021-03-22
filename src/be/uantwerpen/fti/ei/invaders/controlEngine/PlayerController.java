package be.uantwerpen.fti.ei.invaders.controlEngine;

import java.awt.event.KeyEvent;

public class PlayerController implements Controller {
    private Input input;

    public PlayerController(Input input) {
        this.input = input;
    }

    @Override
    public boolean isRequestingLeft() {
        return input.isPressed(KeyEvent.VK_LEFT);
    }

    @Override
    public boolean isRequestingRight() {
        return input.isPressed(KeyEvent.VK_RIGHT);
    }

    @Override
    public boolean isRequestingUp() {
        return false;
    }

    @Override
    public boolean isRequestingDown() {
        return false;
    }

    @Override
    public boolean isRequestingSpace() {
        return input.isPressed(KeyEvent.VK_SPACE);
    }
}
