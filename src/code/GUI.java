package code;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class GUI{

    public Music_Play player = new Music_Play();

    public GUI() {
        // Initialize Playlist
        Read_PlayList reader = new Read_PlayList();
        ArrayList<File> usrPlaylist = reader.readMusic();

        // Initialize GUI interface
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Music Player");

        frame.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        //setup text and input box
        JButton prevBtn = new JButton("<<|");
        prevBtn.setBounds(200, 350, 100, 100);
        panel.add(prevBtn);

        JButton playBtn = new JButton("Start");
        playBtn.setBounds(300, 350, 100, 100);
        panel.add(playBtn);

        JButton stopBtn = new JButton("Stop");
        stopBtn.setBounds(400, 350, 100, 100);
        panel.add(stopBtn);

        JButton nextBtn = new JButton("|>>");
        nextBtn.setBounds(500, 350, 100, 100);
        panel.add(nextBtn);

        // Button action
        playBtn.addActionListener(actionEvent -> {
            player.start_play();
        });

        stopBtn.addActionListener(actionEvent -> {
            player.stop_play();
        });

        prevBtn.addActionListener(actionEvent -> {

        });

        nextBtn.addActionListener(actionEvent -> {

        });

        frame.setVisible(true);
    }

}
