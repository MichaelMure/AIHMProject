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
    private JScrollPane scrollPane;
    private JPanel panel;
    
    /** Creates new form NewJFrame2 */
    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        Dimension d1 = new Dimension(200, 300);
        Dimension d2 = new Dimension(800, 600);

        this.setPreferredSize(d1);
        this.setSize(d1);
        this.setMinimumSize(d1);
        
        this.setResizable(false);

        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setPreferredSize(d2);
        this.panel.setSize(d2);
        this.panel.setMinimumSize(d2);
        
        this.scrollPane = new JScrollPane(this.panel);
        this.setContentPane(this.scrollPane);
        
        
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

        
        pack();
    }
    
    public void addItemQuitListener(ActionListener actLst) {
    	ItemQuit.addActionListener(actLst);
	}
    
    public void addItemImportListener(ActionListener actLst) {
    	ItemImport.addActionListener(actLst);
	}
}
