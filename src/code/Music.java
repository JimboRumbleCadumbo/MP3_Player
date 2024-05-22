package code;

import javax.sound.sampled.*;
import java.io.File;

public class Music {

    Clip clip;
    public String name;
    int songNum=0;

    /**
     * A function that starts playing the music
     */
    public Music(String name,Clip clip) {
    		this.name = name;
    		this.clip = clip;
    }

    public void start_play() { clip.start(); }
    public void stop_play() {
    	clip.stop();
    	clip.flush();
    	clip.setFramePosition(0);
    }
    public void pause_play() { clip.stop(); }
}