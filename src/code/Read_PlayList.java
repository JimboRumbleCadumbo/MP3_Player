package code;

import java.io.File;
import java.util.ArrayList;

public class Read_PlayList {
    public ArrayList<File> myPlaylist = new ArrayList<>();

    public ArrayList<File> readMusic(){
        //Setup song file path
        String directoryPath = "src/audio";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".wav")) {
                    System.out.println(file.getName());
                    myPlaylist.add(file);
                }
            }
        } else {
            System.out.println("Directory does not exist！");
        }
        return myPlaylist;
    }

    ArrayList<File> getMyPlaylist(){
        return myPlaylist;
    }
}
