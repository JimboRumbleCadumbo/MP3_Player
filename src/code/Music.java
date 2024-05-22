package code;

import javax.sound.sampled.*;
import java.io.File;

/**
 * Mainly handles playing the music
 */

public class Music {

    Clip clip;
    public String name;

    /**
     * Music class object constructor
     *
     * @param name The name of the song read from song folder
     * @param clip Preload the song into this clip, allows us to read the details of the song
     */
    public Music(String name, Clip clip) {
        this.name = name;
        this.clip = clip;
    }

    public void start_play() {
        clip.start();
    }

    public void stop_play() {
        clip.stop();
        clip.flush(); // flush the current clip to restart the song
        clip.setFramePosition(0);
    }

    public void pause_play() {
        clip.stop();
    }
}