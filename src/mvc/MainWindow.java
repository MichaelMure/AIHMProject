package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -7219620606214091173L;
	private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem ItemQuit;
    private JMenuItem ItemImport;
    private JScrollPane jScrollPane1;
    private JPanel jPanel;
    
    /** Creates new form NewJFrame2 */
    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        this.getContentPane().add(jScrollPane1);
        
        jPanel = new JPanel();
        jPanel.setBackground(Color.gray);
        jPanel.setMinimumSize(new Dimension(800, 600));
        jScrollPane1.setViewportView(jPanel);
        
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        ItemQuit = new JMenuItem();
        ItemImport = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Fichier");

        ItemImport.setText("Importer");
        jMenu1.add(ItemImport);

        ItemQuit.setText("Quitter");
        jMenu1.add(ItemQuit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        this.setMinimumSize(new Dimension(600, 480));
        pack();
    }
    
    public void addItemQuitListener(ActionListener actLst) {
    	ItemQuit.addActionListener(actLst);
	}
    
    public void addItemImportListener(ActionListener actLst) {
    	ItemImport.addActionListener(actLst);
	}
}
