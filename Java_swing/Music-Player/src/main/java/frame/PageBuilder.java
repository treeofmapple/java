package frame;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import functions.SystemFunctions;
import functions.objects.Fonts;
import functions.objects.SystemObjects;

public class PageBuilder extends JFrame implements SystemObjects, Fonts {

	private static final long serialVersionUID = 1L;
	private final SystemFunctions funct = new SystemFunctions();
	
    public PageBuilder() {
    	selectTheme();
    	setTitle("Notepad");
    	setSize(800, 400);
    	setFont(jetmono);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLayout(new BorderLayout());
    	setSystemIcon();
    	buildMenuBar();
    }
    
    private void setSystemIcon() {
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(getClass().getResource("/resource/icons/musica.png"));
        } catch (Exception e) {
            System.err.println("Icon not found, using default system icon.");
        }

        if (icon != null && icon.getImage() != null) {
            setIconImage(icon.getImage());
        }
    }
    
    private void buildMenuBar() {
    	JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        
        openItem.addActionListener(e -> funct.openFile());
        saveItem.addActionListener(e -> funct.saveFile());
        exitItem.addActionListener(e -> System.exit(0));
        
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

	public static void selectTheme() {
	    try {
	        UIManager.setLookAndFeel(new FlatDarkLaf());
	    } catch (Exception ex) {
	        System.err.println("Failed to initialize LaF");
	    }
	}
    
}


