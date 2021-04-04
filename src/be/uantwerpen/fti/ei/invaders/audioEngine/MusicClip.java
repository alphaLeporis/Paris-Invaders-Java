package be.uantwerpen.fti.ei.invaders.audioEngine;


import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;

import javax.sound.sampled.Clip;

public class MusicClip extends AudioClip {
    public MusicClip(Clip clip) {
        super(clip);
    }

    @Override
    protected float getVolume(GameSettings gameSettings) {
        return gameSettings.getMusicVolume();
    }
}
