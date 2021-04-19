package be.uantwerpen.fti.ei.invaders.audioEngine;


import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

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
     * at every update we will check the volume, this is useful for an in-game volume setting.
     */
    public void update() {
        setVolume();
    }

    /**
     * @return Gets the volume based on the type of AudioClip.
     */
    protected abstract float getVolume();

    /**
     * Sets the volume of the current clip. This is not supported by every OS or clip.
     */
    void setVolume() {
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            final FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float range = control.getMaximum() - control.getMinimum();
            float gain = (range * getVolume()) + control.getMinimum();

            control.setValue(gain);
        }
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
