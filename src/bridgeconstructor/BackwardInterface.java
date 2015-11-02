package bridgeconstructor;

import static bridgeconstructor.BridgeRules.initRulesBase;
import static bridgeconstructor.Environment.getFactsBase;
import expertsystem.AIEngine;
import expertsystem.FactsBase;
import expertsystem.RulesBase;
import expertsystem.Word;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.err;
import static java.lang.System.out;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import static javax.swing.JButton.class;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BackwardInterface extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private static final String title = "Bridge Constructor - Chaînage arrière";
    private final String rules_path;
	
	private final String[] type = {"Pont à Arcs-Boutants", "Pont à Haubants", "Pont à Poutres", "Pont Suspendu",  "Pont-Levis" };
	
    private FactsBase FB;
    
    Component parent;
    
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
		
        
//###################################
//            METHODES
//###################################
        
    /**
     * Constructeur
     * @param caller composant graphique qui a crée la fenêtre
     * @param rulesPath chemin du fichier xml de règles
     */    
	public BackwardInterface(Component caller, String rulesPath) {
		super(title);
        parent= caller;
        rules_path= rulesPath;
		
		buildComposants();
		buildInterface();
		buildEvents();
		
		setResizable(false);
		setSize(150, 50);
        pack(); // redondant, mais utile car taille différente selon OS
        //get local graphics environment to get maximum window bounds
        Rectangle screenSize= getLocalGraphicsEnvironment().getMaximumWindowBounds();
        this.setLocation((int)(screenSize.getWidth() - this.getWidth()) / 2,
						 	(int)(screenSize.getHeight() - this.getHeight()) / 2);
	}

	private void buildComposants() {
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
	
	private void buildInterface() {
				up_up_panel.add(chaining_choice);
				up_center_panel.add(backward_radio);
				up_center_panel.add(mixt_radio);
			up_panel.add(up_up_panel, NORTH);
			up_panel.add(up_center_panel, CENTER);       
				
			center_panel.add(fact);
			center_panel.add(fact_list);
		
			bottom_panel.add(confirm);
		
		main_panel.add(up_panel, NORTH);
		main_panel.add(center_panel, CENTER);
		main_panel.add(bottom_panel, SOUTH);
		
		setContentPane(main_panel);
	}
	
	private void buildEvents() {
		backward_radio.addActionListener(this);
		mixt_radio.addActionListener(this);
		
		fact_list.addActionListener(this);
		confirm.addActionListener(this);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent E) {
		Object O = E.getSource();
		if(O.getClass() == class) {
			JButton B = (JButton) O;
			if(B == confirm) {
				if(backward_radio.isSelected()) {
                    launchBackwardChaining();
                } else if(mixt_radio.isSelected()) {
                    launchMixtChaining();
                }
			}
		}
	}
    
    @Override
    public void dispose(){
        parent.setVisible(true);
        super.dispose();
    }

	private String getCorrespondingBridge(String s) {
		switch(s) {
			case "Pont à Arcs-Boutants" :
				return "bridge arc considered";
			case "Pont à Haubants" :
				return "bridge shroud considered";
			case "Pont à Poutres" :
				return "bridge beam considered";
			case "Pont Suspendu" :
				return "bridge hanging considered";
			case "Pont-Levis" :		// "Pont-Levis"
				return "drawbridge considered";
		}
		return s;
	}
    
    /**
     * Initialiste la base de faits et crée un Systeme Expert
     * @return Systeme Expert crée
     * @author Florian
     */
    private AIEngine initChaining(){		
        // Base de Faits
		FB = getFactsBase();
		out.println(FB);
        
		// Base de Règles
		RulesBase BR;	
        BR = initRulesBase(rules_path);	
		out.println(BR);
        
		return new AIEngine(BR);
    }
    
    private boolean giveResultToUser(Word result){
        if (result != null){
            //Fenetre
            showMessageDialog(this, "La valeur de "+ result.getName() +" a été trouvée : "+
                    "\n\t"+ result);
            // Terminal
            out.println("La valeur de "+ result.getName() +" a été trouvée : ");
            out.println("\t"+ result);
            
            return true;
        }
        else {
            // Fenetre
            showMessageDialog(null, "Impossible de déduire le résultat",
                     "Bridge Constructor - Alert" , ERROR_MESSAGE);
            //Terminal
             err.println("\n"+
                    "Impossible de déduire le résultat");
             
            return true;
        }
    }
	
    /**
     * Lance le traitement du Chaînage Arrière
     */
	private void launchBackwardChaining() {
        // On ne peut pas faire de fonction à cause de "return;"
		String goalName = getCorrespondingBridge(fact_list.getSelectedItem().toString());
		if(goalName.isEmpty()) {
			showMessageDialog(null, "Aucune saisie effectuée", "Bridge Constructor - Alert" , ERROR_MESSAGE);
			return;
		}
        
		// Lancement du chainage
		AIEngine moteur = initChaining();
        
		out.println("Lancement Chaînage Arrière");
//		Word found_value = moteur.backwardChaining(goalName, FB, new TerminalFactAsker()); /*Version dans terminal*/
        Word found_value = moteur.backwardChaining(goalName, FB, new WindowFactAsker(this), false);
        
        // Recupération du résultat
        giveResultToUser(found_value);
	}
	
	/**
	 * Lance le traitement du Chaînage Mixte
	 */
	private void launchMixtChaining() {
        // On ne peut pas faire de fonction à cause de "return;"
		String goalName = getCorrespondingBridge(fact_list.getSelectedItem().toString());
		if(goalName.isEmpty()) {
			showMessageDialog(null, "Aucune saisie effectuée", "Bridge Constructor - Alert" , ERROR_MESSAGE);
			return;
		}
		
        // Lancement du chainage
		AIEngine moteur = initChaining();
        
		out.println("Lancement Chaînage Mixte");
//		Word found_value = moteur.mixtChaining(goalName, FB, new TerminalFactAsker()); /*Version dans terminal*/
        Word found_value = moteur.backwardChaining(goalName, FB, new WindowFactAsker(this), true);
        
        // Recupération du résultat
        giveResultToUser(found_value);
	}
}
