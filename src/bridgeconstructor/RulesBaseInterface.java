package bridgeconstructor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import expertsystem.Rule;
import expertsystem.RulesBase;
import expertsystem.Word;

public class RulesBaseInterface extends JFrame implements ActionListener{

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
		
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	
	private void buildComposants() {
		main_panel = new JPanel();
			main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
			scroll_pane = new JScrollPane(main_panel);
			
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
