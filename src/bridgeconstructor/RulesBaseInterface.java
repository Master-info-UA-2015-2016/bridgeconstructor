package bridgeconstructor;

import expertsystem.Rule;
import expertsystem.RulesBase;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Florian
 */
public class RulesBaseInterface extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;

	private static final String title = "Base de Règles";
	private static final String file_path = "./ressources/bridge_rules.xml";
	
	private final RulesBase RB;
    private final Component parent;
	
	private JPanel main_panel;
		private JScrollPane scroll_pane;
		private JLabel rule;
	
    /**
     *
     * @param caller composant qui a crée la RBI
     */
    public RulesBaseInterface(Component caller) {
		super(title);
		parent= caller;
        
		RB = BridgeRules.initRulesBase(file_path);
		
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.pack();
        //get local graphics environment to get maximum window bounds
        Rectangle screenSize= GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        this.setLocation((int)(screenSize.getWidth() - this.getWidth()) / 2,
						 	(int)(screenSize.getHeight() - this.getHeight()) / 2);
	}
    
	private void buildComposants() {
		main_panel = new JPanel();
			main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
			scroll_pane = new JScrollPane(main_panel);
		
		rule = new JLabel("<html><u>bridge_rules.xml\n</u><html>");
		rule.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			main_panel.add(rule);
			rule.addMouseListener(this);
			rule.setForeground(Color.BLUE);
        for (Rule R : RB) {
            System.out.println(R);
            String s = R.toString();
            rule = new JLabel(s);
            main_panel.add(rule);
        }
	}
	
	private void buildInterface() {
		setContentPane(scroll_pane);
	}
    /** 
     * 
     */ 
     @Override 
     public void dispose(){ 
        try{
            parent.setVisible(true);
        }catch (Exception e){
            System.err.println("Impossible de 'notifier'");
        }
        
        super.dispose(); 
    } 

    
	private void buildEvents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

    /**
     * Ouvre un fichier avec un éditeur de texte
     * @author Jérome
     * @param file_path nom du fichier à ouvrir
     */
    private void openFileInNotepad(String file_path){
    	String OS = System.getProperty("os.name");
        try {
            if(OS.equals("Linux")) {
                Runtime.getRuntime().exec("gedit " + file_path);
            } else
                if(OS.startsWith("Windows")) {
                    Runtime.getRuntime().exec("notepad " + file_path);
            }
      
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    /**
     *
     * @param e
     */
    @Override
	public void mouseClicked(MouseEvent e) {
        Desktop desktop;

        try {
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();

                File file= new File(file_path);
                desktop.open(file);
            }else {
                openFileInNotepad(file_path);
            }
        } catch (IOException ex) {
            System.err.println("Erreur lors ouverture du fichier par défaut, essai avec éditeur de texte");
            openFileInNotepad(file_path);
        }
        
	}

    /**
     *
     * @param e
     */
    @Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

    /**
     *
     * @param e
     */
    @Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

    /**
     *
     * @param e
     */
    @Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

    /**
     *
     * @param e
     */
    @Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
