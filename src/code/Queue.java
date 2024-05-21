package code;

import java.util.ArrayList;

public class Queue {
    public ArrayList<String> SongList = new ArrayList<>();

    public void addSongToQueue(String name){
        SongList.add(name);
    }
    public ArrayList<String> getSongList(){
        return SongList;
    }
}
