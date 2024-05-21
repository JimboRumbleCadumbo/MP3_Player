package code;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;

public class Handler{

    public Handler(){

    }

    public void set_prev_song() {
        if (songNum == 0) {
            start_play();
        }else{
            songNum++;

        }
    }

    public void set_next_song() {

    }
}
