package bridgeconstructor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import expertsystem.AIEngine;
import expertsystem.FactsBase;
import expertsystem.RulesBase;

public class BackwardInterface extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private static String title = "Bridge Constructor - Chaînage arrière";
	
	private JPanel main_panel;
	private JPanel center_panel;
		private JLabel fact;
		private JTextField fact_field;
	private JPanel bottom_panel;
		private JButton confirm;
		
	public BackwardInterface() {
		super(title);
		
		buildComposants();
		buildInterface();
		buildEvents();
		
		setResizable(false);
		setSize(150, 50);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void buildComposants() {
		main_panel = new JPanel(new BorderLayout());
		center_panel = new JPanel(new GridLayout(1, 1));
			fact = new JLabel("But : ");
			fact_field = new JTextField();
		bottom_panel = new JPanel();
			confirm = new JButton("Confirmer");
	}
	
	public void buildInterface() {
		center_panel.add(fact);
		center_panel.add(fact_field);
		
		bottom_panel.add(confirm);
		
		main_panel.add(center_panel, BorderLayout.CENTER);
		main_panel.add(bottom_panel, BorderLayout.SOUTH);
		
		setContentPane(main_panel);
	}
	
	public void buildEvents() {
		fact_field.addActionListener(this);
		confirm.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent E) {
		Object O = E.getSource();
		if(O.getClass() == JButton.class) {
			JButton B = (JButton) O;
			if(B == confirm) launchBackwardChaining();
		} else if(O.getClass() == JTextField.class) {
			JTextField TF = (JTextField) O;
			if(TF == fact_field) launchBackwardChaining();
		}
		
	}

	private void launchBackwardChaining() {
		String goalName = fact_field.getText();
		if(goalName.equals("")) {
			JOptionPane.showMessageDialog(null, "Aucune saisie effectuée", "Bridge Constructor - Alert" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		
        // Base de Faits
		FactsBase FB = Environment.getFactsBase();
		System.out.println(FB);
        
		// Base de Règles
		RulesBase BR;	
        BR = BridgeRules.initRulesBase("./ressources/bridge_rules.xml");	
		System.out.println(BR);
        
		// OTHER
		AIEngine moteur = new AIEngine(BR);
		boolean found = moteur.backwardChaining(goalName, FB);
        
        if (found){
            System.out.println("la valeur de "+ goalName +" a été trouvée");
            System.out.println("\n"+
                    FB);
        }
        else {
             System.out.println("\n"+
                    "Impossible de déduire "+ goalName);
        }
	}
}
