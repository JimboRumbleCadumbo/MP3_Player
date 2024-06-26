package code;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Adding a draggable playlist to UI, useful when there's multiple songs in folder.
 */

public class DraggablePanel extends JPanel {
    private final JLabel label;
    private int mouseY;

    public DraggablePanel() {
        setLayout(null);

        label = new JLabel("list");
        label.setBounds(100, 0, 900, 1000);
        add(label);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.TOP);

        // Fetch Drag / Scrolling Action
        MouseAdapter mouseAdapter = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseY = e.getY();
            }

            public void mouseDragged(MouseEvent e) {
                int newY = label.getY() + (e.getY() - mouseY);
                if (newY < 0 && newY > -1000) {
                    label.setLocation(label.getX(), newY);
                }

            }
        };

        label.addMouseListener(mouseAdapter);
        label.addMouseMotionListener(mouseAdapter);
    }

    public void setText(String s) {
        label.setText(s);
    }

}
