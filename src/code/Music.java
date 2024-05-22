package code;

import javax.sound.sampled.*;
import java.io.File;

public class Music extends Handler{

    Clip clip;
    public String name;
    int songNum=0;

    /**
     * A function that starts playing the music
     */
    public Music(String name,Clip clip) {
    		this.name = name;
    		this.clip = clip;
//        Read_PlayList newList = new Read_PlayList();
//        newList.myPlaylist = newList.readMusic();
//        File songFile = newList.myPlaylist.get(0);
//        System.out.println(songFile.exists());
//        try {
//            AudioInputStream audioStream = AudioSystem.getAudioInputStream(songFile);
//
//            System.out.println(audioStream);
//
//            clip = AudioSystem.getClip();
//            clip.open(audioStream);
//        }catch (Exception e) {
//            System.out.println("error");
//        }
    }

    public void start_play() { clip.start(); }
    public void stop_play() {
    	clip.stop();
    	clip.flush();
    	clip.setFramePosition(0);
    }
    public void pause_play() { clip.stop(); }
}