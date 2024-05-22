package code;

import java.util.ArrayList;
import java.util.Random;

/**
 * PlayList class for handling music order
 */

public class PlayList {
    ArrayList<Music> SongList;
    int index = 0;
    boolean random = false;

    PlayList(ArrayList<Music> SongList) {
        this.SongList = SongList;
    }

    public Music Previous_song() {
        if (index - 1 >= 0) {
            index--;
        }
        return SongList.get(index);
    }

    public Music Next_song() {
        if (random) {
            return Ran_song();
        } else {
            if (index + 1 < SongList.size()) {
                index++;
            }
            return SongList.get(index);
        }
    }

    /**
     * Plays a random song in the list
     *
     * @return the selected random song
     */
    public Music Ran_song() {
        Random r = new Random();
        int nextI = 0;
        do {
            nextI = r.nextInt() % SongList.size();
            nextI = Math.abs(nextI);
        } while (nextI == index);
        index = nextI;
        return SongList.get(index);
    }

    /**
     * Get the song names from list
     *
     * @return The strings of the songs
     */
    public String get_list_str() {
        StringBuilder list = new StringBuilder("<html>");
        for (int i = 0; i < SongList.size(); i++) {
            if (i == index) {
                list.append("<html><font size='6'>").append(SongList.get(i).name).append("</font><br>");
            } else {
                list.append(SongList.get(i).name).append("<br>");
            }
        }
        return list.toString();
    }
}
