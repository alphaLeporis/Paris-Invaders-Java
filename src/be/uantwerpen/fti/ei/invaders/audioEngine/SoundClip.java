package be.uantwerpen.fti.ei.invaders.audioEngine;


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

}
