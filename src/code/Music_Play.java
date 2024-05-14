package code;

import javax.sound.sampled.*;
import java.io.File;

public class Music_Play {

    Clip clip;
    int songNum=0;

    /**
     * A function that starts playing the music
     */
    public Music_Play() {
//        String audioFilePath = String.valueOf(Music_Play.class.getResource(filePath));
//        System.out.println(audioFilePath);
//        File audioFile = new File(filePath);
        Read_PlayList newList = new Read_PlayList();
        newList.myPlaylist = newList.readMusic();
        File songFile = newList.myPlaylist.get(0);
        System.out.println(songFile.exists());
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(songFile);

            System.out.println(audioStream);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
        }catch (Exception e) {
            System.out.println("error");
        }
    }

    public void start_play() {
        clip.start();
    }

    public void stop_play() {
        clip.stop();
    }

    public void set_prev_song() {
//        if(songNum == 0){
//            songNum =
//        }
    }

    public void set_next_song() {

    }

}