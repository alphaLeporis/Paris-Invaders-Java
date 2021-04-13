package be.uantwerpen.fti.ei.invaders.audioEngine;


import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;

import javax.sound.sampled.Clip;

public class MusicClip extends AudioClip {
    public MusicClip(Clip clip) {
        super(clip);
        clip.loop(10);
    }

    @Override
    protected float getVolume(GameSettings gameSettings) {
        return gameSettings.getMusicVolume();
    }
}
