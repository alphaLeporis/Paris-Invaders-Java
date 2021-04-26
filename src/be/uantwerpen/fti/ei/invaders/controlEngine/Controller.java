package be.uantwerpen.fti.ei.invaders.controlEngine;

/**
 * The universal interface to control movable entities.
 */
public interface Controller {
    boolean isRequestingLeft();
    boolean isRequestingRight();
    boolean isRequestingUp();
    boolean isRequestingDown();
    boolean isRequestingShoot();
}
