package be.uantwerpen.fti.ei.invaders.audioEngine;


import javax.sound.sampled.Clip;

/**
 * This abstract class will hold different types of clips that can be used by the AudioPlayer.
 */
public abstract class AudioClip {

    private final Clip clip;

    /**
     * stores the clip and starts playing.
     * @param clip is needed to know what clip to play.
     */
    public AudioClip(Clip clip) {
        this.clip = clip;
        clip.start();
    }

    /**
     * @return To check if a clip is done playing.
     */
    public boolean hasFinishedPlaying() {
        return !clip.isRunning();
    }

    /**
     * Closes the clip, resources can be released for new clips.
     */
    public void cleanUp() {
        clip.close();
    }

}
