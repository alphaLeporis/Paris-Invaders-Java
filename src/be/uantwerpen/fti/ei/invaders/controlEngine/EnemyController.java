package be.uantwerpen.fti.ei.invaders.controlEngine;

public class EnemyController implements Controller {
    @Override
    public boolean isRequestingLeft() {
        return false;
    }

    @Override
    public boolean isRequestingRight() {
        return false;
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
        return false;
    }
}
