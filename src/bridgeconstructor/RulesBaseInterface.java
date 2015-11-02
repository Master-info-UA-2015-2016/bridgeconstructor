package bridgeconstructor;

import static bridgeconstructor.BridgeRules.initRulesBase;
import expertsystem.Rule;
import expertsystem.RulesBase;
import java.awt.Color;
import static java.awt.Color.BLUE;
import java.awt.Component;
import java.awt.Cursor;
import static java.awt.Cursor.HAND_CURSOR;
import static java.awt.Cursor.getPredefinedCursor;
import java.awt.Desktop;
import static java.awt.Desktop.getDesktop;
import static java.awt.Desktop.isDesktopSupported;
import java.awt.GraphicsEnvironment;
import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import static java.lang.Runtime.getRuntime;
import static java.lang.System.err;
import static java.lang.System.getProperty;
import static java.lang.System.out;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
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
        
		RB = initRulesBase(file_path);
		
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.pack();
        //get local graphics environment to get maximum window bounds
        Rectangle screenSize= getLocalGraphicsEnvironment().getMaximumWindowBounds();
        this.setLocation((int)(screenSize.getWidth() - this.getWidth()) / 2,
						 	(int)(screenSize.getHeight() - this.getHeight()) / 2);
	}
    
	private void buildComposants() {
		main_panel = new JPanel();
			main_panel.setLayout(new BoxLayout(main_panel, Y_AXIS));
			scroll_pane = new JScrollPane(main_panel);
		
		rule = new JLabel("<html><u>bridge_rules.xml\n</u><html>");
		rule.setCursor(getPredefinedCursor(HAND_CURSOR));
			main_panel.add(rule);
			rule.addMouseListener(this);
			rule.setForeground(BLUE);
        for (Rule R : RB) {
            out.println(R);
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
            err.println("Impossible de 'notifier'");
        }
        
        super.dispose(); 
    } 

    
	private void buildEvents() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

    /**
     * Ouvre un fichier avec un éditeur de texte
     * @author Jérome
     * @param file_path nom du fichier à ouvrir
     */
    private void openFileInNotepad(String file_path){
    	String OS = getProperty("os.name");
        try {
            if(OS.equals("Linux")) {
                getRuntime().exec("gedit " + file_path);
            } else
                if(OS.startsWith("Windows")) {
                    getRuntime().exec("notepad " + file_path);
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
            if (isDesktopSupported()) {
                desktop = getDesktop();

                File file= new File(file_path);
                desktop.open(file);
            }else {
                openFileInNotepad(file_path);
            }
        } catch (IOException ex) {
            err.println("Erreur lors ouverture du fichier par défaut, essai avec éditeur de texte");
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
