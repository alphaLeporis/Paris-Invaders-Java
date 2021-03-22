package be.uantwerpen.fti.ei.invaders.gameEngine.entities;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;

import java.awt.*;

public class BulletEntity extends Entity {
    public BulletEntity(AFact afact, int x, int y) {
        super(afact);
        position = new Position(x,y);
        size = new Size(5, 20);
    }

    @Override
    public void update() {
        int deltaY = 0;
        position = new Position(position.getX(), position.getY() + deltaY);
    }

    @Override
    public Image visualize() {
        return null;
    }
}
