package mvc;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;


import mvc.MainWindow;
import mvc.View;

public class Controller {
	private View view;
	private Point position;
	private ArrayList<ImagePanel> imagePanels;
	private Controller controller;
	private ImageListModel listModel;
	
	public Controller(View view){
		this.view = view;
		this.position = new Point(0, 0);
		this.controller = this;
		
		this.listModel = new ImageListModel();
		view.getMainWindow().getImageList().setModel(this.listModel);
		view.getMainWindow().getImageList().addMouseListener(new ImageListListener(this));
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
		mw.addItemImportListener(new ItemImportListener());
		mw.addItemDeleteListener(new ItemDeleteListener());
		mw.addItemAdvanceListener(new ItemAdvanceListener());
		mw.addItemRetreatListener(new ItemRetreatListener());
		imagePanels = new ArrayList<ImagePanel>();
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
	class ItemImportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.showFileChooserWindow();
		}
	}
	
	/**
	 * Action listener for the import button in the main window
	 */
	class ItemDeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	/**
	 * Action listener for the import button in the main window
	 */
	class ItemAdvanceListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	/**
	 * Action listener for the import button in the main window
	 */
	class ItemRetreatListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
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
				String description = view.getFileChooserWindow().getFilename();
				
				File file = new File(filename);
				if(file.exists()) {
					ImagePanel panel = new ImagePanel(filename, description, position);
				    view.getMainWindow().getPanel().add(panel);
				    //imagePanels.add(panel);
				    
				    ImagePanelMouseListener ipml = new ImagePanelMouseListener(controller, panel);
				    panel.addMouseListener(ipml);
				    panel.addMouseMotionListener(ipml);
				    listModel.addElement(panel);
				    
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

	public void clickOn(ImagePanel panel, MouseEvent event) {
		System.out.println(panel);
		
		if(event.isShiftDown()) {
			// Sélection multiple
			if(panel.isSelected()) 	// le panel est déjà sélectionné => on désélectionne
				panel.setSelected(false);
			else {					// le panel n'est pas sélectionné => on sélectionne
				panel.setSelected(true);
			}
		} else {
			// Sélection unique

			System.out.println("click dans Controller, sélection unique");
			for(int i =0; i < this.listModel.getSize() ; i++) {
				((ImagePanel) this.listModel.getElementAt(i)).setSelected(false);
			}
			panel.setSelected(true);
		}
		
		view.getMainWindow().repaint();
	}

	public void refreshList() {
		// Un click est effectué sur la liste, la liste des éléments a peut-être changé
		// On déselectionne tout, puis on resélectionne ceux réellement sélectionnés
		
		for(int i = 0; i < this.listModel.getSize() ; i++) {
			((ImagePanel) this.listModel.getElementAt(i)).setSelected(false);
		}	
		
		int[] selectedIndices = this.view.getMainWindow().getImageList().getSelectedIndices();
		for(int i = 0; i < selectedIndices.length ; i++) {
			((ImagePanel) this.listModel.getElementAt(selectedIndices[i])).setSelected(true);
		}
		view.getMainWindow().repaint();
	}
}
