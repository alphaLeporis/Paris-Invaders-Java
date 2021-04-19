package be.uantwerpen.fti.ei.invaders.audioEngine;


import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;

import javax.sound.sampled.Clip;

/**
 * This class will store a sound clip.
 */
public class SoundClip extends AudioClip {
    /**
     * The constructor calls super to initialise our sound clip.
     * @param clip is needed to know what clip we want store.
     */
    public SoundClip(Clip clip) {
        super(clip);
    }

    /**
     * Gets the sound volume inside the GameSettings.
     * @return the desired volume.
     */
    @Override
    protected float getVolume() {
        return GameSettings.SOUND_VOLUME;
    }
}
