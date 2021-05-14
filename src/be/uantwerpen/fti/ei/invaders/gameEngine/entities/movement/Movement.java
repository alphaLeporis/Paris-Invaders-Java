package be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement;

import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;

public class Movement {
    private Position position;
    private Vector2D vector;
    private double speed;

    public Movement(double speed) {
        this.speed = speed;
        //this.position = new position();
        this.vector = new Vector2D(0,0);
    }

    public void update(Controller controller) {
        int deltaX = 0;
        int deltaY = 0;
        if (controller.isRequestingUp()) {
            deltaY --;
        }

        if (controller.isRequestingDown()) {
            deltaY ++;
        }

        if (controller.isRequestingLeft()) {
            deltaX --;
        }

        if (controller.isRequestingRight()) {
            deltaX ++;
        }

        vector = new Vector2D(deltaX, deltaY);
        vector.multiply(speed);

    }

    public Vector2D getVector() {
        return vector;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
