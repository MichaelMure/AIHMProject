package mvc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ImagePanelMouseListener implements MouseListener, MouseMotionListener {
	ImagePanel panel;
	private int xorig, yorig;
	private int xPanelOrig, yPanelOrig;
	private Controller controller;
	
	public ImagePanelMouseListener(Controller controller, ImagePanel panel) {
		this.controller = controller;
		this.panel = panel;
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		xorig = arg0.getXOnScreen();
		yorig = arg0.getYOnScreen();
		
		xPanelOrig = (int) panel.getLocation().getX();
		yPanelOrig = (int) panel.getLocation().getY();
		
		System.out.println("pointeur souris origine : "+xorig+", "+yorig);
		System.out.println("Position panel  origine : "+xPanelOrig+", "+yPanelOrig);
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		controller.clickOn(panel, arg0);


	}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("pointeur souris deplacé : "+arg0.getX()+", "+arg0.getY());
		System.out.println("déplacement calculé     : "+((int) xPanelOrig + (arg0.getX() - xorig))+", "+((int) yPanelOrig + (arg0.getY() - yorig)));
		panel.setLocation((int) xPanelOrig + (arg0.getXOnScreen() - xorig), (int) yPanelOrig + (arg0.getYOnScreen() - yorig));
	}
}


