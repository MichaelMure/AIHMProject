package mvc;

import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -7219620606214091173L;
	private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem ItemQuit;
    private JMenuItem ItemImport;
    private JScrollPane jScrollPane1;
    
    /** Creates new form NewJFrame2 */
    public MainWindow() {
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        ItemQuit = new JMenuItem();
        ItemImport = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Fichier");

        ItemQuit.setText("Importer");
        jMenu1.add(ItemQuit);

        ItemImport.setText("Quitter");
        jMenu1.add(ItemImport);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
        );

        pack();
    }
    
    public void addItemQuitListener(ActionListener actLst) {
    	ItemQuit.addActionListener(actLst);
	}
    
    public void addItemImportListener(ActionListener actLst) {
    	ItemImport.addActionListener(actLst);
	}
}
