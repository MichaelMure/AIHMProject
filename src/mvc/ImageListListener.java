package mvc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ImageListListener implements ListSelectionListener {
	private Controller controller;
	
	public ImageListListener(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		controller.clickOnList();
		
	}

}
