package code;

import java.util.ArrayList;
import java.util.Random;

public class PlayList {
    ArrayList<Music> SongList;
    int index =0;
    boolean random = false;
    PlayList(ArrayList<Music> SongList){
    	this.SongList = SongList;
    }
    
    public Music Previous_song() {
    	if(index-1>=0) {
			index--;
		}
		return SongList.get(index);
	}
    public Music Next_song() {
    	if(random) {
    		return Ran_song();
    	}else {
    		if(index+1<SongList.size()) {
    			index++;
    		}
    		return SongList.get(index);
    	}
		
	}
    public Music Ran_song() {
    	Random r =new Random();
    	int nextI=0;
    	do {
    		nextI = r.nextInt()%SongList.size();
    		nextI = Math.abs(nextI);
    	}while(nextI == index);
    	index = nextI;
		return SongList.get(index);
	}
    public String get_list_str() {
		String list="<html>";
		for(int i=0;i<SongList.size();i++) {
			if(i==index) {
				list+="<html><font size='6'>"+SongList.get(i).name+"</font><br>";
			}else {
				list+=SongList.get(i).name+"<br>";
			}
			
		}
		return list;
	}
}
