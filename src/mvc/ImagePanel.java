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
	
	public ImagePanel(String filename, String description, Point position) {
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
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				unselect();
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				xorig = arg0.getXOnScreen();
				yorig = arg0.getYOnScreen();
				
				xPanelOrig = (int) getLocation().getX();
				yPanelOrig = (int) getLocation().getY();
				
				System.out.println("pointeur souris origine : "+xorig+", "+yorig);
				System.out.println("Position panel  origine : "+xPanelOrig+", "+yPanelOrig);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				select();
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent arg0) {}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				System.out.println("pointeur souris deplacé : "+arg0.getX()+", "+arg0.getY());
				System.out.println("déplacement calculé     : "+((int) xPanelOrig + (arg0.getX() - xorig))+", "+((int) yPanelOrig + (arg0.getY() - yorig)));
				setLocation((int) xPanelOrig + (arg0.getXOnScreen() - xorig), (int) yPanelOrig + (arg0.getYOnScreen() - yorig));
			}
		});
		
		
	}
	
	public void select()
	{
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
	
	
}
