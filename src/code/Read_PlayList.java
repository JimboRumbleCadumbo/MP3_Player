package code;

import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;

public class Read_PlayList {

    public ArrayList<Music> readMusic() {
        return readMusic(getClass().getClassLoader().getResource("audio").getPath());
    }

    public ArrayList<Music> readMusic(String path) {
        //Setup song file path
        ArrayList<Music> myPlaylist = new ArrayList<>();
        String directoryPath = path;
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

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
        if (myPlaylist.size() == 0) {
            MessagePopup.showError("The list is empty!");
        }
        return myPlaylist;
    }
}
