package mvc;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2151965732682186633L;
	private ImageIcon icon;
	
	public ImageLabel(String filename) {
		// FIXME : ajout description
		String description = "default descr";
		this.icon = new ImageIcon(filename, description);
	}
}
