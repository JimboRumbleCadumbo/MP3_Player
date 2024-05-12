package org.app;

import javax.sound.sampled.*;
import java.io.File;

public class Music_Play {

    public static Music_Play usrMusicPlay = new Music_Play("src/audio/usrmusic.wav",true);
    Clip clip;

    /**
     * A function that starts playing the music
     * @param fileName the path of the songs
     * @param loop
     */

    public Music_Play(String fileName, boolean loop) {
//        String audioFilePath = Music_Play.class.getResource(name).getPath();
        File audioFile = new File(fileName);

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        }catch (Exception e) {
            System.out.println("error");
        }
        if(loop) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void start_play() {
        clip.start();
    }

    public void stop_play() {
        clip.stop();
    }

}