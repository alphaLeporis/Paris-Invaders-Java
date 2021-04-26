package be.uantwerpen.fti.ei.invaders.audioEngine;


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
}
