package be.uantwerpen.fti.ei.invaders.controlEngine;

public interface Controller {
    boolean isRequestingLeft();
    boolean isRequestingRight();
    boolean isRequestingUp();
    boolean isRequestingDown();
    boolean isRequestingShoot();
}
