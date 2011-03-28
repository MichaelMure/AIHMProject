package mvc;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2151965732682186633L;
	private ImageIcon icon;
	
	public ImageLabel(String filename, String description) {
		this.icon = new ImageIcon(filename, description);
		this.setIcon(icon);
		this.setSize(200,200);
	}
	
}
