import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class GUI{
    //    JTextField usrText;
    public GUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Music Player");

        frame.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        //setup text and input box

        JButton playBtn = new JButton("Start");
        playBtn.setBounds(100, 100, 100, 100);
        panel.add(playBtn);

        JButton stopBtn = new JButton("Stop");
        stopBtn.setBounds(200, 100, 100, 100);
        panel.add(stopBtn);

        // Button action
//        playBtn.addActionListener(actionEvent -> {
//
//        });



        frame.setVisible(true);
    }

}
