package mvc;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2151965732682186633L;
	private ImageIcon icon;
	
	public ImageLabel(String filename, String description, Point position) {
		this.icon = new ImageIcon(filename, description);
		this.setIcon(icon);
		this.setSize(200,200);
		this.setLocation(position);
		this.addMouseMotionListener(new MouseMotionListener() {
			
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
