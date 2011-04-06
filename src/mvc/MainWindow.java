package mvc;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -7219620606214091173L;
	private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem ItemQuit;
    private JMenuItem ItemImport;
    private JSplitPane splitPane;
    private JScrollPane scrollImagePane;
    private JPanel imagePanel;
    private JScrollPane scrollListPane;
    
    /** Creates new form NewJFrame2 */
    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        Dimension mainWDim = new Dimension(800, 800);
        Dimension imagesWDim = new Dimension(1200, 1200);

        this.setPreferredSize(mainWDim);
        this.setSize(mainWDim);
        this.setMinimumSize(mainWDim);
        
        this.setResizable(false);

        this.imagePanel = new JPanel();
        this.imagePanel.setLayout(null);
        this.imagePanel.setPreferredSize(imagesWDim);
        this.imagePanel.setSize(imagesWDim);
        this.imagePanel.setMinimumSize(imagesWDim);
        

        
        this.scrollImagePane = new JScrollPane(this.imagePanel);
        
        this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
        		this.scrollImagePane , null);
        
        //this.splitPane.setDividerLocation(mainWDim.width * 3 / 4);
        this.setContentPane(splitPane);

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

        this.setTitle("Images");
        pack();
    }
    
    public void addItemQuitListener(ActionListener actLst) {
    	ItemQuit.addActionListener(actLst);
	}
    
    public void addItemImportListener(ActionListener actLst) {
    	ItemImport.addActionListener(actLst);
	}
    
    public JPanel getPanel() {
    	return this.imagePanel;
    }
    
}
