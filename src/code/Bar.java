package code;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class Bar {
	JPanel body_panel = new JPanel();
	public JLabel bar = new JLabel();
	public JLabel outline = new JLabel();

	double current;
	double max;
	public Bar(int size) {
		body_panel.setBounds(50,50,size,size);
		outline.setBounds(0,0,size,15);
		bar.setBounds(0,0,size,15);
		BufferedImage bufimg = null;
		try {
		    bufimg = ImageIO.read(getClass().getResource("bar.png"));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		Image dimg = bufimg.getScaledInstance(bar.getWidth(), bar.getHeight(),
		        Image.SCALE_SMOOTH);       
		bar.setIcon(new ImageIcon(dimg));
		try {
		    bufimg = ImageIO.read(getClass().getResource("baroutline.png"));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		dimg = bufimg.getScaledInstance(outline.getWidth(), outline.getHeight(),
		        Image.SCALE_SMOOTH);
        outline.setIcon(new ImageIcon(dimg));
		body_panel.setLayout(null);
		body_panel.setOpaque(false);
		body_panel.add(bar);
		body_panel.add(outline);

		
	}
	public void setCurr(double value) {
		current = value;
		update_ui();
	}
	
	public void setMax(double value) {
		max = value;
		update_ui();
	}
	void update_ui() {
		if(current<0) {
			current = 0;
		}else if (current > max) {
			current = max;
		}
		double delta =bar.getWidth();
		bar.setLocation((int)(current/max*delta-delta),bar.getY());
	}
}
