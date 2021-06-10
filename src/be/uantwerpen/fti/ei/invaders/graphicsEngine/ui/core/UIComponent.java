package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core;


import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import java.awt.*;

public abstract class UIComponent {

    protected Position position;
    protected Size size;

    public UIComponent() {
        position = new Position(0, 0);
        size = new Size(1, 1);
    }

    public abstract Image visualize();
    public abstract void update(State state);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

}
