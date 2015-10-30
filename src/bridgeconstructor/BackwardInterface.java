package bridgeconstructor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import expertsystem.AIEngine;
import expertsystem.FactsBase;
import expertsystem.RulesBase;

public class BackwardInterface extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private static String title = "Bridge Constructor - Chaînage arrière";
	
	private JPanel main_panel;
	private JPanel up_panel;
		private JPanel up_up_panel;
			private JLabel chaining_choice;
		private JPanel up_center_panel;
			private ButtonGroup radio_group;
				private JRadioButton backward_radio;
				private JRadioButton mixt_radio;
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
        pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void buildComposants() {
		main_panel = new JPanel(new BorderLayout());
		up_panel = new JPanel(new BorderLayout());
			up_up_panel = new JPanel();
				chaining_choice = new JLabel("Choix du chaînage : ");
			up_center_panel = new JPanel(new GridLayout(0, 1));
				radio_group = new ButtonGroup();
					backward_radio = new JRadioButton("Arrière");
					mixt_radio = new JRadioButton("Mixte");
				radio_group.add(backward_radio);
			    radio_group.add(mixt_radio);
		center_panel = new JPanel(new GridLayout(1, 1));
			fact = new JLabel("But : ");
			fact_field = new JTextField();
		bottom_panel = new JPanel();
			confirm = new JButton("Confirmer");
	}
	
	public void buildInterface() {
				up_up_panel.add(chaining_choice);
				up_center_panel.add(backward_radio);
				up_center_panel.add(mixt_radio);
			up_panel.add(up_up_panel, BorderLayout.NORTH);
			up_panel.add(up_center_panel, BorderLayout.CENTER);       
				
			center_panel.add(fact);
			center_panel.add(fact_field);
		
			bottom_panel.add(confirm);
		
		main_panel.add(up_panel, BorderLayout.NORTH);
		main_panel.add(center_panel, BorderLayout.CENTER);
		main_panel.add(bottom_panel, BorderLayout.SOUTH);
		
		setContentPane(main_panel);
	}
	
	public void buildEvents() {
		backward_radio.addActionListener(this);
		mixt_radio.addActionListener(this);
		
		fact_field.addActionListener(this);
		confirm.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent E) {
		Object O = E.getSource();
		if(O.getClass() == JButton.class) {
			JButton B = (JButton) O;
			if(B == confirm) {
				if(backward_radio.isSelected())
					launchBackwardChaining();
				else if(mixt_radio.isSelected())
					launchMixtChaining();
			}
		} else if(O.getClass() == JTextField.class) {
			JTextField TF = (JTextField) O;
			if(TF == fact_field) launchBackwardChaining();
		} else if(O.getClass() == JRadioButton.class) {
			System.out.println(O);
		}
		
	}

	private void launchBackwardChaining() {
		String goalName = fact_field.getText();
		if(goalName.equals("")) {
			JOptionPane.showMessageDialog(null, "Aucune saisie effectuée", "Bridge Constructor - Alert" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		System.out.println("Lancement Chaînage Arrière");
		
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
	
	private void launchMixtChaining() {
		String goalName = fact_field.getText();
		if(goalName.equals("")) {
			JOptionPane.showMessageDialog(null, "Aucune saisie effectuée", "Bridge Constructor - Alert" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		System.out.println("Lancement Chaînage Mixte");		
	}
}
