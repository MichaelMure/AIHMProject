package mvc;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 2151965732682186633L;
	private ImageIcon icon;
	private JLabel labelIcon;
	private JLabel labelText;
	private int xorig, yorig;
	private int xPanelOrig, yPanelOrig;
	private boolean selected;
	private Controller controller;
	
	public ImagePanel(String filename, String description, Point position) {
		this.controller = controller;
		this.selected = false;
		this.icon = new ImageIcon(filename, description);
		this.labelIcon = new JLabel();
		this.labelIcon.setIcon(icon);
		this.labelIcon.setSize(this.icon.getIconWidth(), this.icon.getIconHeight());
		this.labelIcon.setLocation(position);
		this.add(this.labelIcon);
		this.setSize(this.labelIcon.getWidth(), this.labelIcon.getHeight()+12);
		
		this.labelText = new JLabel();
		this.labelText.setText(this.icon.getDescription());
		this.add(this.labelText);
		this.labelText.setSize(this.labelIcon.getWidth(), 12);
		this.labelText.setLocation(0, this.labelIcon.getHeight());
		
		this.setBackground(Color.white);
				
	}
	
	public void select()
	{
		System.out.println("select() dans ImagePanel");
		this.selected = true;
		this.setBackground(Color.orange);
		this.repaint();
	}
	
	public void unselect()
	{
		this.selected = false;
		this.setBackground(Color.white);
		this.repaint();
	}
	
	public void setSelected(boolean isSelected) {
		if(isSelected)
			select();
		else
			unselect();
		
	}

	public boolean isSelected() {
		return selected;
	}

}
