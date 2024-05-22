package code;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class GUI{

    public Music playing;
    PlayList play_list ;
    public GUI() {
        // Initialize Playlist
        Read_PlayList reader = new Read_PlayList();
        ArrayList<Music> usrPlaylist = reader.readMusic();
        play_list = new PlayList(usrPlaylist);
        playing = play_list.Previous_song();
        // Initialize GUI interface
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Music Player");

        frame.add(panel, BorderLayout.CENTER);
//        panel.setBounds(0,0,1000,700);
        panel.setLayout(null);        
        JLabel songList = new JLabel("");
        songList.setText(play_list.get_list_str());
        songList.setBounds(100, 0, 900, 350);
        panel.add(songList);
        
        //setup text and input box
        JButton prevBtn = new JButton("<<|");
        prevBtn.setBounds(200, 450, 100, 100);
        panel.add(prevBtn);

        JButton playBtn = new JButton("▶");
        playBtn.setBounds(300, 450, 100, 100);
        panel.add(playBtn);

        JButton pauseBtn = new JButton("||");
        pauseBtn.setBounds(400, 450, 100, 100);
        panel.add(pauseBtn);
        
        JButton stopBtn = new JButton("█");
        stopBtn.setBounds(500, 450, 100, 100);
        panel.add(stopBtn);

        JButton nextBtn = new JButton("|>>");
        nextBtn.setBounds(600, 450, 100, 100);
        panel.add(nextBtn);

        // Button action
        playBtn.addActionListener(actionEvent -> {
        	playing.start_play();
        });

        pauseBtn.addActionListener(actionEvent -> {
        	playing.pause_play();
        });
        stopBtn.addActionListener(actionEvent -> {
        	playing.stop_play();
        });
        prevBtn.addActionListener(actionEvent -> {
        	playing.stop_play();
        	playing = play_list.Previous_song();
        	playing.start_play();
        	songList.setText(play_list.get_list_str());
        });

        nextBtn.addActionListener(actionEvent -> {
        	playing.stop_play();
        	playing = play_list.Next_song();
        	playing.start_play();
        	songList.setText(play_list.get_list_str());
        });
        frame.setVisible(true);
    }
    
    public void update(){
    	
    }

}
