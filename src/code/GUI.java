package code;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;
import java.io.IOException;

/**
 * Initialize the application window using JSwing GUI
 */

public class GUI {

    public Music playing;
    PlayList play_list;
    Read_PlayList reader = new Read_PlayList();
    ProgressBar pBar = new ProgressBar();
    DraggablePanel songList;
    JFrame frame;

    public GUI() {
        // Initialize Playlist
        ArrayList<Music> usrPlaylist = reader.readMusic();
        play_list = new PlayList(usrPlaylist);
        playing = play_list.Previous_song();

        // Initialize GUI interface
        frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Music Player");

        frame.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        DirectoryLoader dirBtn = new DirectoryLoader(this);
        dirBtn.setBounds(0, 0, 80, 30);
        panel.add(dirBtn);

        // Draggable playlist
        songList = new DraggablePanel();
        songList.setText(play_list.get_list_str());
        songList.setBounds(100, 50, 900, 350);
        panel.add(songList);

        //setup text and input box
        JButton prevBtn = new JButton("<<|");
        prevBtn.setBounds(200, 450, 100, 100);
        panel.add(prevBtn);

        JToggleButton playBtn = new JToggleButton("▶");
        playBtn.setBounds(300, 450, 100, 100);
        panel.add(playBtn);

        JButton stopBtn = new JButton("█");
        stopBtn.setBounds(400, 450, 100, 100);
        panel.add(stopBtn);

        JButton nextBtn = new JButton("|>>");
        nextBtn.setBounds(500, 450, 100, 100);
        panel.add(nextBtn);

        JToggleButton ranBtr = new JToggleButton("random:off");
        ranBtr.setBounds(700, 450, 100, 100);
        panel.add(ranBtr);

        panel.add(pBar.bar.body_panel);
        pBar.bar.body_panel.setBounds(100, 600, 800, 15);

        // Play Button action
        playBtn.addActionListener(actionEvent -> {
            if (playBtn.isSelected()) {
                playBtn.setText("||");
                playing.start_play();
            } else {
                playBtn.setText("▶");
                playing.pause_play();
            }

        });

        // Stop Button action
        stopBtn.addActionListener(actionEvent -> {
            playing.stop_play();
            playBtn.setSelected(false);
            playBtn.setText("▶");
        });

        // Previous Song Button action
        prevBtn.addActionListener(actionEvent -> {
            playing.stop_play();
            playing = play_list.Previous_song();
            playing.start_play();
            songList.setText(play_list.get_list_str());
        });

        // Next Song Button action
        nextBtn.addActionListener(actionEvent -> {
            playing.stop_play();
            playing = play_list.Next_song();
            playing.start_play();
            songList.setText(play_list.get_list_str());
        });

        // Random Button action
        ranBtr.addActionListener(actionEvent -> {
            if (ranBtr.isSelected()) {
                ranBtr.setText("random:on");
                play_list.random = true;
            } else {
                ranBtr.setText("random:off");
                play_list.random = false;
            }
        });

        frame.setVisible(true);
    }

    // Function that updates the progress bar
    public void update() {
        pBar.update(playing);
    }

}
