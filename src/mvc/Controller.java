package mvc;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFileChooser;


import mvc.MainWindow;
import mvc.View;

public class Controller {
	private View view;
	private Point position;
	
	public Controller(View view){
		this.view = view;
		this.position = new Point(0, 0);

		
		initMainWindowListener();
		initFCWindowListener();
	}

	/* MainWindow */
	/**
	 * Initialize the listener for the main window
	 */
	private void initMainWindowListener() {
		MainWindow mw = this.view.getMainWindow();
		mw.addItemQuitListener(new ItemQuitListener());
		mw.addItemImportListener(new BtnImportListener());
	}
	
	/**
	 * Action listener for the quit button of the main window
	 */
	class ItemQuitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.disposeAll();
		}
	}
	
	/**
	 * Action listener for the import button in the main window
	 */
	class BtnImportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.showFileChooserWindow();
		}
	}
	
	/* FileChooserWindow */
	/**
	 * Initialize the File chooser window listener
	 */
	private void initFCWindowListener() {
		this.view.getFileChooserWindow().addFCActionListener(new FCActionListener());
		this.view.getFileChooserWindow().addFCWindowListener(new FCWindowListener());
	}
	
	/**
	 * Action listener for the file chooser
	 */
	class FCActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (JFileChooser.APPROVE_SELECTION.equals(e.getActionCommand())) {
				String filename = view.getFileChooserWindow().getPath();
				File file = new File(filename);
				if(file.exists()) {
					
				    view.getMainWindow().getPanel().add(new ImagePanel(filename, position));
				    view.getMainWindow().repaint();
				    position.setLocation(position.getX() + 10, position.getY() + 10);

				}
			} else if (JFileChooser.CANCEL_SELECTION.equals(e.getActionCommand())) {
				// Annulation
			}
			// Fermeture de la fenêtre
			view.hideFileChooserWindow();
		}
	}

	/**
	 * Window adaptater for the file chooser window
	 */
	class FCWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			view.hideFileChooserWindow();
		}
	}
}
