package mvc;

import mvc.FileChooserWindow;
import mvc.MainWindow;


public class View {
		
		private MainWindow mainWindow;
		private FileChooserWindow fileChooserWindow;

		
		/**
		 * Constructor of the view 
		 * @param model
		 */
		public View() {
			this.mainWindow = new MainWindow();
			this.mainWindow.setVisible(true);
			
			this.fileChooserWindow = new FileChooserWindow();
		}

		/**
		 * Delete all the window
		 */
		public void disposeAll() {
			this.fileChooserWindow.dispose();
			this.mainWindow.dispose();

		}
		
		/* MainWindow */
		/**
		 * Return the main window
		 */
		public MainWindow getMainWindow() {
			return this.mainWindow;
		}
		
		/**
		 * Display the main window
		 */
		public void showMainWindow() {
			this.mainWindow.setVisible(true);
		}

		/**
		 * Hide the main window
		 */
		public void hideMainWindow() {
			this.mainWindow.setVisible(false);
		}

		/* FileChooserWindow */
		/**
		 * Return the file chooser window
		 */
		public FileChooserWindow getFileChooserWindow() {
			return this.fileChooserWindow;
		}
		
		/**
		 * Display the file chooser window
		 */
		public void showFileChooserWindow() {
			this.fileChooserWindow.setVisible(true);
		}

		/**
		 * Display the file chooser window and set his title.
		 * @param name
		 */
		public void showFileChooserWindow(String name) {
			this.fileChooserWindow.setTitle(name);
			this.showFileChooserWindow();
		}
		
		/**
		 * Hide the file chooser window
		 */
		public void hideFileChooserWindow() {
			this.fileChooserWindow.setVisible(false);
		}
}
