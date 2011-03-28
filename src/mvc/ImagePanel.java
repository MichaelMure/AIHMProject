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
	
	public ImagePanel(String filename, Point position) {
		this.icon = new ImageIcon(filename);
		this.labelIcon = new JLabel();
		this.labelIcon.setIcon(icon);
		this.labelIcon.setSize(this.icon.getIconWidth(), this.icon.getIconHeight());
		this.labelIcon.setLocation(position);
		this.add(this.labelIcon);
		this.setSize(this.labelIcon.getWidth(), this.labelIcon.getHeight()+10);
		
		this.labelText = new JLabel();
		this.labelText.setText(this.icon.getDescription());
		this.add(this.labelText);
		this.labelText.setSize(this.labelIcon.getWidth(), 10);
		this.labelText.setLocation(0, this.labelIcon.getHeight());
		
		this.setBackground(Color.white);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				xorig = arg0.getX();
				yorig = arg0.getY();
				
				xPanelOrig = (int) getLocation().getX();
				yPanelOrig = (int) getLocation().getY();
				
				System.out.println("pointeur souris origine : "+xorig+", "+yorig);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent arg0) {}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				setLocation(xPanelOrig + (arg0.getX() - xorig), yPanelOrig + (arg0.getY() - yorig));
			}
		});
		
		
	}
	
}
