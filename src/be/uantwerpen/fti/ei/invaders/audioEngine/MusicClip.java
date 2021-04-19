package be.uantwerpen.fti.ei.invaders.audioEngine;


import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;

import javax.sound.sampled.Clip;

/**
 * This class will store a music clip.
 */
public class MusicClip extends AudioClip {
    /**
     * The constructor calls super to initialise our music clip.
     * @param clip is needed to know what clip we want store.
     */
    public MusicClip(Clip clip) {
        super(clip);
    }

    /**
     * Gets the music volume inside the GameSettings.
     * @return the desired volume.
     */
    @Override
    protected float getVolume() {
        return GameSettings.MUSIC_VOLUME;
    }
}
