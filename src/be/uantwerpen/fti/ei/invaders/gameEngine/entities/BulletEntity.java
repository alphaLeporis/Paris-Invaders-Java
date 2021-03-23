package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;

import java.awt.*;

public class BulletEntity extends Entity {
    public BulletEntity(int x, int y) {
        position = new Position(x+25,y);
        size = new Size(5, 20);
    }

    @Override
    public void update() {
        int deltaY = -10;
        position = new Position(position.getX(), position.getY() + deltaY);
    }

    @Override
    public Image visualize() {
        return null;
    }
}
