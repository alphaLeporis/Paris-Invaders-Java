package be.uantwerpen.fti.ei.invaders.audioEngine;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This class holds different audioclips, this could be music, sounds or a combination of both.
 */
public class AudioPlayer {

    private final List<AudioClip> audioClips;

    /**
     * The constructor instantiates a new ArrayList that will contain sounds or music
     */
    public AudioPlayer() {
        audioClips = new ArrayList<>();
    }

    /**
     * This method will call the update method of each clip and check for clips that have finished and have to be deleted.
     */
    public void update() {
        List.copyOf(audioClips).forEach(audioClip -> {
            if(audioClip.hasFinishedPlaying()) {
                audioClip.cleanUp();
                audioClips.remove(audioClip);
            }
        });
    }

    /**
     * Plays music. On repeat.
     * @param fileName The filename of a music clip inside the /sounds folder used by the method getClip().
     */
    public void playMusic(String fileName) {
        final Clip clip = getClip(fileName);
        final MusicClip musicClip = new MusicClip(clip);
        assert clip != null;
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        audioClips.add(musicClip);
    }

    /**
     * Plays sound
     * @param fileName The filename of a sound clip inside the /sounds folder used by the method getClip().
     */
    public void playSound(String fileName) {
        final Clip clip = getClip(fileName);
        final SoundClip soundClip = new SoundClip(clip);
        audioClips.add(soundClip);
    }

    /**
     * Removes all the music that is currently stored.
     */
    public void removeMusic() {
        List.copyOf(audioClips).forEach(audioClip -> {
            audioClip.cleanUp();
            audioClips.remove(audioClip);
        });
    }

    /**
     * Gets a clip inside /sounds relative to the resource folder. And stores it.
     * @param fileName is needed to know what sound to store
     * @return the Clip based on the fileName param
     */
    private Clip getClip(String fileName) {
        final URL soundFile = AudioPlayer.class.getResource("/sounds/" + fileName);
        try {
            assert soundFile != null;
            try(AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile)) {
                final Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.setMicrosecondPosition(0);
                return clip;

            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        return null;
    }
}
