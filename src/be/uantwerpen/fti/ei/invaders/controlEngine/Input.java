package be.uantwerpen.fti.ei.invaders.controlEngine;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;

import java.awt.event.*;

/**
 * In this input class we implement keyboard and mouse input from the user. This is done with the Java KeyListener, MouseListener and MouseMotionListener.
 */
public class Input implements KeyListener, MouseListener, MouseMotionListener {
    private final boolean[] pressed;

    private Position mousePosition;
    private boolean mousePressed;


    /**
     * The constructor allows us to capture mouse en keyboard input.
     */
    public Input() {
        pressed = new boolean[1000];
        mousePosition = new Position(0, 0);
    }

    /**
     * To know if a key code is pressed
     * @param keyCode is passed to know if it is pressed
     * @return a boolean value for the state of that keyCode.
     */
    public boolean isPressed(int keyCode) {
        return pressed[keyCode];
    }

    /**
     * @return the position of the mouse in pixels.
     */
    public Position getMousePosition() {
        return mousePosition;
    }

    /**
     * @return a boolean value of the state of the mouse button.
     */
    public boolean isMousePressed() {
        return mousePressed;
    }

    /**
     * Invoked when a key has been pressed.
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }

    /**
     * Invoked when a key has been released.
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
    }

    /**
     * Invoked when the mouse key has been pressed.
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        mousePressed = true;
    }

    /**
     * Invoked when the mouse key has been released.
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
    }

    /**
     * Invoked when the mouse has been moved.
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosition = new Position((int) e.getPoint().getX(), (int) e.getPoint().getY());
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}
}
