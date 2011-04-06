package mvc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class ImageListListener implements ListDataListener, MouseListener {
	private Controller controller;
	
	public ImageListListener(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void contentsChanged(ListDataEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void intervalAdded(ListDataEvent arg0) {}

	@Override
	public void intervalRemoved(ListDataEvent arg0) {}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click sur list");
		controller.refreshList();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
