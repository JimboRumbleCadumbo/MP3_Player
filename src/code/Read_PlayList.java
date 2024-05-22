package code;

import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;
public class Read_PlayList {
    

    public ArrayList<Music> readMusic(){
        //Setup song file path
    	ArrayList<Music> myPlaylist = new ArrayList<>();    
        String directoryPath =getClass().getClassLoader().getResource("audio").getPath();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".wav")) {
                	try {
                		Clip clip;
	                	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	                    clip = AudioSystem.getClip();
	                    clip.open(audioStream);
	                    Music m = new Music(file.getName(),clip);
	                    System.out.println(file.getName());
	                    myPlaylist.add(m);
                    }catch (Exception e) {
                    	System.out.println("error");
                    }
                	
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
        return myPlaylist;
    }
}
