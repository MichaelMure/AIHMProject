package mvc;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 2151965732682186633L;
	private JLabel label;
	
	public ImagePanel(String filename, Point position) {
		ImageIcon icon = new ImageIcon(filename);
		this.label = new JLabel();
		this.label.setIcon(icon);
		this.label.setSize(200,200);
		this.label.setLocation(position);
		this.add(this.label);
		this.setSize(200, 200);
		this.label.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
