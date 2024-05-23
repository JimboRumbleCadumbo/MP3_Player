package code;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import javax.sound.sampled.*;

/**
 * Reads the song folder and returns an Arraylist of Music Class objects.
 */

public class Read_Playlist {

    public ArrayList<Music> readMusic() {
        return readMusic(Objects.requireNonNull(getClass().getClassLoader().getResource("audio")).getPath());
    }

    /**
     * Reads wav files from folder, in this occasion, we only use .WAV files only
     *
     * @param path music folder path
     * @return an Arraylist of Music class objects
     */

    public ArrayList<Music> readMusic(String path) {
        //Setup song file path
        ArrayList<Music> myPlaylist = new ArrayList<>();
        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            // iterates every file in the folder, and fetch .WAV files only
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".wav")) {
                    try {
                        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioStream);
                        Music m = new Music(file.getName(), clip);
                        System.out.println(file.getName());
                        myPlaylist.add(m);
                    } catch (Exception e) {
                        System.out.println("error");
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
        if (myPlaylist.isEmpty()) {
            MessagePopup.showError("The list is empty!");
        }
        return myPlaylist;
    }
}
