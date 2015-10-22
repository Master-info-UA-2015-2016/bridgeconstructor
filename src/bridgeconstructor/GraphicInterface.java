package bridgeconstructor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import expertsystem.AIEngine;
import expertsystem.FactsBase;
import expertsystem.RulesBase;

/**
 * L'interface Graphique est construite à partir de cette classe
 *
 */
public class GraphicInterface extends JFrame implements ActionListener, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	
	private static String title = "Bridge Constructor";
	
	// Panel
	private JPanel up_panel;
	private JPanel center_panel;
		private JPanel traffic_panel;
		private JPanel meteo_panel;
		private JPanel other_panel;
			private JPanel label_panel;
			private JPanel field_panel;
	private JPanel down_panel;
	private Container main_panel;
	// Label
	private JLabel order;
	// Traffic
	private JLabel traffic;
	private JCheckBox naval_box;
	private JCheckBox pedestrian_box;
	private JCheckBox railway_box;
	private JCheckBox road_box;
	// Risques Météorologiques
	private JLabel meteo;
	private JCheckBox fire_box;
	private JCheckBox flood_box;
	private JCheckBox storm_box;
	// Autre
	private JLabel other;
	private JLabel height;
	private JLabel length;
	private JFormattedTextField height_field;
	private JFormattedTextField length_field;
	private NumberFormat format;
	// Bouton
	private JButton quit_button;
	private JButton reset_button;
	private JButton confirm_button;
	
	public GraphicInterface() {
		super(title);
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	
	private void buildComposants() {
		// Panel
		main_panel = new JPanel(new BorderLayout());
		up_panel = new JPanel();
		center_panel = new JPanel();
			center_panel.setLayout(new BoxLayout(center_panel, BoxLayout.Y_AXIS));
			traffic_panel = new JPanel(new GridLayout(2, 2));
			meteo_panel = new JPanel(new GridLayout(2, 2));
			other_panel = new JPanel(new GridLayout(1,1));
				label_panel = new JPanel(new GridLayout(0, 1));
				field_panel = new JPanel(new GridLayout(0, 1));
		down_panel = new JPanel(new BorderLayout());
		// Label
		order = new JLabel("Veuillez sélectionner les caractéristiques de l'environnement :");
		// Traffic box
		traffic = new JLabel("Traffic :");
		naval_box = new JCheckBox("Traffic Naval");
		railway_box = new JCheckBox("Traffic Ferroviaire");
		pedestrian_box = new JCheckBox("Traffic Piéton");
		road_box = new JCheckBox("Traffic Routier");
		// Risques Météorologies Box
		meteo = new JLabel("Météo :");
		storm_box =  new JCheckBox("Tempête");
		fire_box = new JCheckBox("Incendie");
		flood_box = new JCheckBox("Inondation");
		// Autre
		other = new JLabel("Autre :");
		format = NumberFormat.getNumberInstance();
		height = new JLabel("Hauteur (m) :");
		height_field = new JFormattedTextField(format);
			height_field.setColumns(10);
			height_field.setValue(Environment.getHeight());
		length = new JLabel("Longueur (m) :");
		length_field = new JFormattedTextField(format);
			length_field.setColumns(10);
			length_field.setValue(Environment.getLength());
		// Bouton
		quit_button = new JButton("Quitter");
		reset_button = new JButton("Reintialiser");
		confirm_button = new JButton("Tout est fait !");
	}
	
	private void buildInterface() {
		up_panel.add(order);
		
		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		// Traffic Panel Choice
		traffic_panel.setBorder(raisedetched);
		traffic_panel.add(naval_box);
		traffic_panel.add(road_box);
		traffic_panel.add(railway_box);
		traffic_panel.add(pedestrian_box);
		// Meteo Panel Choice
		meteo_panel.setBorder(raisedetched);
		meteo_panel.add(storm_box);
		meteo_panel.add(fire_box);
		meteo_panel.add(flood_box);
		// Other Panel TextField
		label_panel.add(height);
		label_panel.add(length);
		field_panel.add(height_field);
		field_panel.add(length_field);
		other_panel.setBorder(raisedetched);
		other_panel.add(label_panel, BorderLayout.CENTER);
		other_panel.add(field_panel, BorderLayout.LINE_END);
		center_panel.add(traffic);
			traffic.setAlignmentX(Component.CENTER_ALIGNMENT);
		center_panel.add(traffic_panel);
		center_panel.add(meteo);
			meteo.setAlignmentX(Component.CENTER_ALIGNMENT);
		center_panel.add(meteo_panel);
		center_panel.add(other);
			other.setAlignmentX(Component.CENTER_ALIGNMENT);
		center_panel.add(other_panel);
			
		down_panel.add(quit_button, BorderLayout.WEST);
		down_panel.add(reset_button, BorderLayout.CENTER);
		down_panel.add(confirm_button, BorderLayout.EAST);
		
		main_panel.add(up_panel, BorderLayout.PAGE_START);
		main_panel.add(center_panel, BorderLayout.CENTER);
		main_panel.add(down_panel, BorderLayout.PAGE_END);
		
		this.setContentPane(main_panel);
		this.reset();
	}
	
	private void buildEvents() {
		this.naval_box.addActionListener(this);
		this.railway_box.addActionListener(this);
		this.pedestrian_box.addActionListener(this);
		this.road_box.addActionListener(this);
		this.storm_box.addActionListener(this);
		this.fire_box.addActionListener(this);
		this.flood_box.addActionListener(this);
		this.height_field.addPropertyChangeListener("value", this);
		this.length_field.addPropertyChangeListener("value", this);

		// Boutons
		this.quit_button.addActionListener(this);
		this.reset_button.addActionListener(this);
		this.confirm_button.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox CBB;
		JButton B;
		if(e.getSource().getClass() == JButton.class) {
			B = (JButton) e.getSource();
			if(B == quit_button) {
				this.dispose();
			} else if(B == reset_button) {
				this.reset();
			} else if(B == confirm_button) {
				this.dispose();
				launchForwardChaining();
				// TODO afficher le pont & le prix sélectionné
			}
		} else if(e.getSource().getClass() == JCheckBox.class) {
			CBB = (JCheckBox) e.getSource();
			if(CBB == naval_box)
				Environment.setNaval_traffic(CBB.isSelected());
			else if(CBB == railway_box)
				Environment.setRailway_traffic(CBB.isSelected());
			else if(CBB == pedestrian_box)
				Environment.setPedestrian_traffic(CBB.isSelected());
			else if(CBB == road_box)
				Environment.setRoad_traffic(CBB.isSelected());
			else if(CBB == storm_box)
				Environment.setStorm(CBB.isSelected());
			else if(CBB == fire_box)
				Environment.setFire(CBB.isSelected());
			else if(CBB == flood_box)
				Environment.setFlood(CBB.isSelected());
			Environment.print();
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Object source = evt.getSource();
		if(source == height_field) {
			Environment.setHeight(((Number)height_field.getValue()).floatValue());
		} else if(source == length_field) {
			Environment.setLength(((Number)length_field.getValue()).floatValue());
		}
		Environment.print();
	}

	private void reset() {
		Environment.reset();
		naval_box.setSelected(false);
		pedestrian_box.setSelected(false);
		railway_box.setSelected(false);
		road_box.setSelected(false);
		fire_box.setSelected(false);
		flood_box.setSelected(false);
		storm_box.setSelected(false);
		height_field.setValue(0);
		length_field.setValue(0);
		
		Environment.print();
	}
	
	// private ou public ? void ou boolean ?
	private void launchForwardChaining(){
		FactsBase FB= Environment.getFactsBase();
		System.out.println(FB);
		
		
//		BASE DE REGLES
//		ArrayList<Word> listAnt= new ArrayList<Word>();
//			Affirmation fire= new Affirmation("fire", true);
//			Comparison taille= new Comparison("length", Operators.inf, 25);
//		listAnt.add(fire);
//		listAnt.add(taille);
//		
//		ArrayList<Word> listCons= new ArrayList<Word>();
//			Affirmation rail= new Affirmation("TRAINS ?", false);
//		listCons.add(rail);
//				
//		RulesBase BR1= new RulesBase();
//		BR1.addRule(listAnt, listCons);
		
		RulesBase BR1= BridgeRules.initRulesBase("./bin/ressources/bridge_rules.xml");
				
		System.out.println(BR1);
//		OTHER
		AIEngine moteur= new AIEngine(BR1);
		FB= moteur.forwardChaining(FB);

		System.out.println(FB);
				
	}
}
