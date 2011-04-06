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
		view.getMainWindow().getImageList().addListSelectionListener(new ImageListListener(controller));
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
	      ArrayList<ImagePanel> tmp = new ArrayList<ImagePanel>();
	      for (ImagePanel panel : imagePanels) {
	        if (panel.isSelected()) {
	          tmp.add(panel);
	          view.getMainWindow().getPanel().remove(panel);
	        }
	      }

	      /* On stocke dans une liste temporaire les image panel a supprimer
	       * pour éviter de modifier la liste en cours d'iteration */
	      for (ImagePanel panel : tmp) {
	        imagePanels.remove(panel);
	      }
	      refreshList();
	      view.getMainWindow().repaint();
	    }
	  }

	  /**
	   * Action listener for the import button in the main window
	   */
	  class ItemAdvanceListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      for (ImagePanel panel : imagePanels) {
	        if (panel.isSelected()) {
	          int z = view.getMainWindow().getPanel().getComponentZOrder(panel);
	          view.getMainWindow().getPanel().setComponentZOrder(panel, z-1);
	        }
	      }
	      refreshList();
	      view.getMainWindow().repaint();
	    }
	  }

	  /**
	   * Action listener for the import button in the main window
	   */
	  class ItemRetreatListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      for (ImagePanel panel : imagePanels) {
	        if (panel.isSelected()) {
	          int z = view.getMainWindow().getPanel().getComponentZOrder(panel);
	          view.getMainWindow().getPanel().setComponentZOrder(panel, z+1);
	        }
	      }
	      refreshList();
	      view.getMainWindow().repaint();
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
					ImagePanel panel = new ImagePanel(filename, description, position, listModel.getSize());
				    view.getMainWindow().getPanel().add(panel);
				    imagePanels.add(panel);
				    
				    
				    ImagePanelMouseListener ipml = new ImagePanelMouseListener(controller, panel);
				    panel.addMouseListener(ipml);
				    panel.addMouseMotionListener(ipml);
				    
				    refreshList();
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
				this.view.getMainWindow().getImageList().setSelectedIndex(panel.getIndex());
			}
		} else {
			// Sélection unique

			System.out.println("click dans Controller, sélection unique");
			for(int i =0; i < this.listModel.getSize() ; i++) {
				((ImagePanel) this.listModel.getElementAt(i)).setSelected(false);
			}
			panel.setSelected(true);
			this.view.getMainWindow().getImageList().setSelectedIndex(panel.getIndex());

		}
		refreshList();
		view.getMainWindow().repaint();
	}

	public void refreshList() {
		// On efface la liste, puis on recrée les éléments
		this.listModel.clear();
		for (ImagePanel panel : imagePanels) {
			this.listModel.addElement(panel);
		}
		
		// On récupère la position des éléments sélectionnés
		ArrayList<Integer> selected = new ArrayList<Integer>();
		int position = 0;
		for (ImagePanel panel : imagePanels) {
			if(panel.isSelected())
				selected.add(position);
			position++;
		}

		this.view.getMainWindow().getImageList().setSelectedIndices(toIntArray(selected));
	}
	
	int[] toIntArray(ArrayList<Integer> list)  {
	    int[] ret = new int[list.size()];
	    int i = 0;
	    for (Integer e : list)  
	        ret[i++] = e.intValue();
	    return ret;
	}

	public void clickOnList() {
		int[] selected = this.view.getMainWindow().getImageList().getSelectedIndices();
		for (ImagePanel panel : imagePanels) {
			panel.setSelected(false);
		}
		for(int i = 0; i < selected.length; i++) {
			((ImagePanel) this.listModel.getElementAt(selected[i])).setSelected(true);
		}
		view.getMainWindow().repaint();
	}
}
