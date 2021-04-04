package be.uantwerpen.fti.ei.invaders.audioEngine;


import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public abstract class AudioClip {

    private final Clip clip;

    public AudioClip(Clip clip) {
        this.clip = clip;
        clip.start();
    }

    public void update(GameSettings gameSettings) {
        final FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        control.setValue(getVolume(gameSettings));
    }

    protected abstract float getVolume(GameSettings gameSettings);

    public boolean hasFinishedPlaying() {
        return !clip.isRunning();
    }

    public void cleanUp() {
        clip.close();
    }
}
