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

public class RulesBaseInterface extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;

	private static String title = "Base de Règles";
	
	private RulesBase RB;
	
	private JPanel main_panel;
		private JScrollPane scroll_pane;
		private JLabel rule;
	
	public RulesBaseInterface() {
		super(title);
		
		RB = BridgeRules.initRulesBase("./bin/ressources/bridge_rules.xml");
		
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
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
		for(Rule R : RB.getRules()) {
			System.out.println(R);
			StringBuilder s = new StringBuilder(R.toString());
			rule = new JLabel(s.toString());
			main_panel.add(rule);
		}
	}
	
	private void buildInterface() {
		setContentPane(scroll_pane);
	}
	
	private void buildEvents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			Runtime.getRuntime().exec("gedit ./bin/ressources/bridge_rules.xml");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
