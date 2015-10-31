package bridgeconstructor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import expertsystem.*;

public class BackwardInterface extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private static String title = "Bridge Constructor - Chaînage arrière";
	
	private String[] type = { "Pont Mobile", "Pont Suspendu", "Pont à Haubants", "Pont à Arcs-Boutants", "Pont-Levis" };
	
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
		private JComboBox<String> fact_list;
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
						backward_radio.setSelected(true);
					mixt_radio = new JRadioButton("Mixte");
				radio_group.add(backward_radio);
			    radio_group.add(mixt_radio);
		center_panel = new JPanel(new GridLayout(1, 1));
			fact = new JLabel("But : ");
			fact_list = new JComboBox<>(type);
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
			center_panel.add(fact_list);
		
			bottom_panel.add(confirm);
		
		main_panel.add(up_panel, BorderLayout.NORTH);
		main_panel.add(center_panel, BorderLayout.CENTER);
		main_panel.add(bottom_panel, BorderLayout.SOUTH);
		
		setContentPane(main_panel);
	}
	
	public void buildEvents() {
		backward_radio.addActionListener(this);
		mixt_radio.addActionListener(this);
		
		fact_list.addActionListener(this);
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
		}
	}

	private String getCorrespondingBridge(String s) {
		switch(s) {
			case "Pont Mobile" :		// "Pont-Mobile"
				// TODO on l'avait pas enlevé ?
				return "Pont Mobile";
			case "Pont Suspendu" :		// "Pont Suspendu"
				return "bridge hanging considered";
			case "Pont à Haubants" :		// "Pont à Haubants"
				return "bridge shroud considered";
			case "Pont à Arcs-Boutants" :		// "Pont à Arcs-Boutants"
				return "bridge arc considered";
			case "Pont-Levis" :		// "Pont-Levis"
				return "drawbridge considered";
		}
		return s;
	}
	
	private void launchBackwardChaining() {

		String goalName = getCorrespondingBridge(fact_list.getSelectedItem().toString());
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
//		Word found_value = moteur.backwardChaining(goalName, FB, new TerminalFactAsker()); /*Version dans terminal*/
        Word found_value = moteur.backwardChaining(goalName, FB, new WindowFactAsker());
        
        if (found_value != null){
            JOptionPane.showMessageDialog(this, "La valeur de "+ goalName +" a été trouvée : "+
                    "\n\t"+ found_value);
            System.out.println("La valeur de "+ goalName +" a été trouvée : ");
            System.out.println("\t"+ found_value);
        }
        else {
             System.out.println("\n"+
                    "Impossible de déduire "+ goalName);
        }
	}
	
	private void launchMixtChaining() {
		String goalName = getCorrespondingBridge(fact_list.getSelectedItem().toString());
		if(goalName.equals("")) {
			JOptionPane.showMessageDialog(null, "Aucune saisie effectuée", "Bridge Constructor - Alert" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		System.out.println("Lancement Chaînage Mixte");		
	}
}
