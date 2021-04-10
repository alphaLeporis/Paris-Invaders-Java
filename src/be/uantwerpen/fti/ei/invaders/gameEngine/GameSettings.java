package be.uantwerpen.fti.ei.invaders.gameEngine;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.helperFunctions.Size;

import java.awt.*;

public class GameSettings {
    public static final int UPDATES_PER_SECOND = 60;

    public static final Dimension WINDOW_DIMENSION = new Dimension(1280,720);
    public static final Size WINDOW_SIZE = new Size(1280,720);
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    public static final int ENTITY_WIDTH = 64;
    public static final int ENTITY_HEIGHT = 64;

    public static final int SPRITE_SIZE = 64;

    private float musicVolume = 1;
    private float soundVolume = 1;

    public float getSoundVolume() {
        return soundVolume;
    }

    public float getMusicVolume() {
        return musicVolume;
    }
}