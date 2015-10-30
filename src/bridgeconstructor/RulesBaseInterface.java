package bridgeconstructor;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import expertsystem.Rule;
import expertsystem.RulesBase;

/**
 *
 * @author Florian
 */
public class RulesBaseInterface extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;

	private static final String title = "Base de Règles";
	private static final String file_path = "./ressources/bridge_rules.xml";
	
	
	private final RulesBase RB;
	
	private JPanel main_panel;
		private JScrollPane scroll_pane;
		private JLabel rule;
	
    /**
     *
     */
    public RulesBaseInterface() {
		super(title);
		
		RB = BridgeRules.initRulesBase(file_path);
		
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	
    /**
     *
     */
    @Override
    public void dispose(){
        this.getParent().setVisible(true);
		this.setVisible(false);
        super.dispose();
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
	
	private void buildEvents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

    /**
     *
     * @param e
     */
    @Override
	public void mouseClicked(MouseEvent e) {
		try {
			Runtime.getRuntime().exec("gedit " + file_path);
		} catch (IOException e1) {
			e1.printStackTrace();
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
