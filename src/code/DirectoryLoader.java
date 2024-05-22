package code;

import java.io.File;

import javax.swing.*;

/**
 * Add a Directory Loader button onto the application
 */

public class DirectoryLoader extends JButton {

    DirectoryLoader(GUI gui) {
        setText("open");
        addActionListener(e -> {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int result = fileChooser.showOpenDialog(gui.frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                System.out.println("Selected directory: " + path);
                gui.play_list.SongList = gui.reader.readMusic(path);
                gui.playing.stop_play();
                gui.playing = gui.play_list.Previous_song();
                gui.songList.setText(gui.play_list.get_list_str());
            }
        });
    }
}
