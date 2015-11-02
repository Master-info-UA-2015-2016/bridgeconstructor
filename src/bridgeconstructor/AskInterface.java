package bridgeconstructor;

import static bridgeconstructor.BridgeRules.initRulesBase;
import static bridgeconstructor.Environment.getFactsBase;
import static bridgeconstructor.Environment.getLane_number;
import static bridgeconstructor.Environment.getLength;
import static bridgeconstructor.Environment.setCastle;
import static bridgeconstructor.Environment.setDaily_traffic;
import static bridgeconstructor.Environment.setForest;
import static bridgeconstructor.Environment.setHeight;
import static bridgeconstructor.Environment.setLane_number;
import static bridgeconstructor.Environment.setLength;
import static bridgeconstructor.Environment.setMountain;
import static bridgeconstructor.Environment.setNaval_traffic;
import static bridgeconstructor.Environment.setPedestrian_traffic;
import static bridgeconstructor.Environment.setRailway_traffic;
import static bridgeconstructor.Environment.setRoad_traffic;
import static bridgeconstructor.Environment.setWater;
import static bridgeconstructor.Environment.setWind;
import static bridgeconstructor.Material.Concrete;
import static bridgeconstructor.Material.Cord;
import static bridgeconstructor.Material.Steel;
import static bridgeconstructor.Material.Stone;
import static bridgeconstructor.Material.Wood;
import static bridgeconstructor.TypeBridge.arc;
import static bridgeconstructor.TypeBridge.beam;
import static bridgeconstructor.TypeBridge.drawbridge;
import static bridgeconstructor.TypeBridge.hanging;
import static bridgeconstructor.TypeBridge.shroud;
import static bridgeconstructor.TypeBridge.vault;
import expertsystem.AIEngine;
import expertsystem.Affirmation;
import static expertsystem.Affirmation.class;
import expertsystem.FactsBase;
import expertsystem.RulesBase;
import expertsystem.Word;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.LINE_END;
import static java.awt.BorderLayout.PAGE_END;
import static java.awt.BorderLayout.PAGE_START;
import java.awt.Component;
import java.awt.Container;
import java.awt.GraphicsEnvironment;
import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import static java.lang.System.out;
import java.text.NumberFormat;
import static java.text.NumberFormat.getIntegerInstance;
import static java.text.NumberFormat.getNumberInstance;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createEtchedBorder;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import static javax.swing.JButton.class;
import javax.swing.JCheckBox;
import static javax.swing.JCheckBox.class;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.JMenuItem.class;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import static javax.swing.border.EtchedBorder.RAISED;

/**
 * L'interface Graphique est construite à partir de cette classe
 */
public class AskInterface extends JFrame implements ActionListener, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	
	private static final String title = "Bridge Constructor - Ask";
    private static final String rules_path = "./ressources/bridge_rules.xml";
	
	private NumberFormat float_format;
	private NumberFormat int_format;
	
	// Menu
	private JMenuBar menuBar;
		private JMenu file;
			private JMenuItem item_close;
		private JMenu show;
			private JMenuItem item_show_rules;
		private JMenuItem other_chaining;
	// Panel
	private JPanel up_panel;
	private JPanel center_panel;
		private JPanel traffic_panel;
		private JPanel meteo_panel;
		private JPanel ground_panel;
		private JPanel measure_panel;
			private JPanel label_panel;
			private JPanel field_panel;
		private JPanel bonus_panel;
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
	private JLabel daily_traffic;
	private JFormattedTextField daily_traffic_field;
	// Météo
	private JLabel meteo;
	private JCheckBox wind_box;
	// Terrain
	private JLabel ground;
	private JCheckBox forest_box;
	private JCheckBox water_box;
	private JCheckBox mountain_box;
	// Mesure
	private JLabel measure;
	private JLabel height;
	private JLabel length;
	private JLabel lane_number;
	private JFormattedTextField height_field;
	private JFormattedTextField length_field;
	private JFormattedTextField lane_number_field;
	
	// Bonus
	private JLabel bonus;
	private JCheckBox castle_box;
	// Bouton
	private JButton reset_button;
	private JButton confirm_button;
	
    public AskInterface() {
		super(title);
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.setResizable(false);
		this.pack();

        //get local graphics environment to get maximum window bounds
        Rectangle screenSize= getLocalGraphicsEnvironment().getMaximumWindowBounds();
        this.setLocation((int)(screenSize.getWidth() - this.getWidth()) / 2,
						 	(int)(screenSize.getHeight() - this.getHeight()) / 2);
        
		this.setVisible(true);
    
	}
    
    public String getRulesPath() { return rules_path; }
	
	private void buildComposants() {
		float_format = getNumberInstance();
		int_format = getIntegerInstance();
		
		// Menu
		menuBar = new JMenuBar();
			file = new JMenu("Fichier");
				item_close = new JMenuItem("Quitter");
			show = new JMenu("Afficher");
				item_show_rules = new JMenuItem("Base de règles");
            other_chaining = new JMenuItem("Arrière et mixte");
		// Panel
		main_panel = new JPanel(new BorderLayout());
		up_panel = new JPanel();
		center_panel = new JPanel();
			center_panel.setLayout(new BoxLayout(center_panel, Y_AXIS));
			traffic_panel = new JPanel(new GridLayout(3, 2));
			meteo_panel = new JPanel(new GridLayout(0, 1));
			ground_panel = new JPanel(new GridLayout(2, 2));
			measure_panel = new JPanel(new GridLayout(1,1));
				label_panel = new JPanel(new GridLayout(0, 1));
				field_panel = new JPanel(new GridLayout(0, 1));
			bonus_panel = new JPanel();
		down_panel = new JPanel();
		// Label
		order = new JLabel("Veuillez sélectionner les caractéristiques de l'environnement :");
		// Traffic box
		traffic = new JLabel("Traffic :");
		naval_box = new JCheckBox("Traffic Naval");
		railway_box = new JCheckBox("Traffic Ferroviaire");
		pedestrian_box = new JCheckBox("Traffic Piéton");
		road_box = new JCheckBox("Traffic Routier");
		daily_traffic = new JLabel("Densité du Traffic :");
		daily_traffic_field = new JFormattedTextField(int_format);
		// Météo Box
		meteo = new JLabel("Météo :");
		wind_box =  new JCheckBox("Vent");
		// Terrains
		ground = new JLabel("Terrain : ");
		forest_box = new JCheckBox("Forêt");
		water_box = new JCheckBox("Eau");
		mountain_box = new JCheckBox("Montagne");
		// Mesure
		measure = new JLabel("Mesures :");
		height = new JLabel("Hauteur (m) :");
		height_field = new JFormattedTextField(float_format);
			height_field.setColumns(10);
			height_field.setValue(Environment.getHeight());
		length = new JLabel("Longueur (m) :");
		length_field = new JFormattedTextField(float_format);
			length_field.setColumns(10);
			length_field.setValue(getLength());
		lane_number = new JLabel("Nombre de voies : ");
		lane_number_field = new JFormattedTextField(int_format);
			lane_number_field.setColumns(10);
			lane_number_field.setValue(getLane_number());
		// Bonus
		bonus = new JLabel("Bonus :");
		castle_box = new JCheckBox("Château");
		// Bouton
		reset_button = new JButton("Reinitialiser");
		confirm_button = new JButton("Tout est fait !");
	}
	
	private void buildInterface() {
		Border raisedetched = createEtchedBorder(RAISED);
		
		// Menu
		file.add(item_close);
		show.add(item_show_rules);
		menuBar.add(file);
		menuBar.add(show);
		menuBar.add(other_chaining);
		setJMenuBar(menuBar);
		
		up_panel.add(order);
		// Traffic Panel Choice
		traffic_panel.setBorder(raisedetched);
		traffic_panel.add(naval_box);
		traffic_panel.add(road_box);
		traffic_panel.add(railway_box);
		traffic_panel.add(pedestrian_box);
		traffic_panel.add(daily_traffic);
		traffic_panel.add(daily_traffic_field);
		// Meteo Panel Choice
		meteo_panel.setBorder(raisedetched);
		meteo_panel.add(wind_box);
		// Terrain Panel Choice
		ground_panel.setBorder(raisedetched);
		ground_panel.add(water_box);
		ground_panel.add(forest_box);
		ground_panel.add(mountain_box);
		// Measure Panel TextField
		label_panel.add(height);
		label_panel.add(length);
		label_panel.add(lane_number);
		field_panel.add(height_field);
		field_panel.add(length_field);
		field_panel.add(lane_number_field);
		measure_panel.setBorder(raisedetched);
		measure_panel.add(label_panel, CENTER);
		measure_panel.add(field_panel, LINE_END);
		// Bonus Panel
		bonus_panel.setBorder(raisedetched);
		bonus_panel.add(castle_box);
		
		center_panel.add(traffic);
			traffic.setAlignmentX(CENTER_ALIGNMENT);
		center_panel.add(traffic_panel);
		center_panel.add(meteo);
			meteo.setAlignmentX(CENTER_ALIGNMENT);
		center_panel.add(meteo_panel);
		center_panel.add(ground);
			ground.setAlignmentX(CENTER_ALIGNMENT);
		center_panel.add(ground_panel);
		center_panel.add(measure);
			measure.setAlignmentX(CENTER_ALIGNMENT);
		center_panel.add(measure_panel);
		center_panel.add(bonus);
			bonus.setAlignmentX(CENTER_ALIGNMENT);
		center_panel.add(bonus_panel);
		
		down_panel.add(reset_button);
		down_panel.add(confirm_button);
		
		main_panel.add(up_panel, PAGE_START);
		main_panel.add(center_panel, CENTER);
		main_panel.add(down_panel, PAGE_END);
		
		this.setContentPane(main_panel);
		this.reset();
	}
	
	private void buildEvents() {
		// Menu
		item_close.addActionListener(this);		
		item_show_rules.addActionListener(this);
		other_chaining.addActionListener(this);
		
		// CheckBox
		this.naval_box.addActionListener(this);
		this.railway_box.addActionListener(this);
		this.pedestrian_box.addActionListener(this);
		this.road_box.addActionListener(this);
		this.wind_box.addActionListener(this);
		this.forest_box.addActionListener(this);
		this.mountain_box.addActionListener(this);
		this.water_box.addActionListener(this);
		this.castle_box.addActionListener(this);
		
		// TextField
		this.height_field.addPropertyChangeListener("value", this);
		this.length_field.addPropertyChangeListener("value", this);
		this.daily_traffic_field.addPropertyChangeListener("value", this);
		this.lane_number_field.addPropertyChangeListener("value", this);

		// Boutons
		this.reset_button.addActionListener(this);
		this.confirm_button.addActionListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
    /**
     *
     * @param e
     */
    @Override
	public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        
        if(source.getClass() == class) {
            if(source == other_chaining){
                this.setVisible(false);
                BackwardInterface BI= new BackwardInterface(this, rules_path);
                BI.setVisible(true);
            }
			if(source == item_close) {
                this.dispose();
            } else if(source == item_show_rules){
				RulesBaseInterface RBI= new RulesBaseInterface(this);
                    this.setVisible(false);
                    RBI.setVisible(true);
            }
		} else if(source.getClass() == class) {
			if(source == reset_button) {
				this.reset();
			} else if(source == confirm_button) {
				launchForwardChaining();
			}
		} else if(source.getClass() == class) {
			JCheckBox CB = (JCheckBox) source;
			if(CB == naval_box) {
                setNaval_traffic(CB.isSelected());
            } else if(CB == railway_box) {
                setRailway_traffic(CB.isSelected());
            } else if(CB == pedestrian_box) {
                setPedestrian_traffic(CB.isSelected());
            } else if(CB == road_box) {
                setRoad_traffic(CB.isSelected());
            } else if(CB == wind_box) {
                setWind(CB.isSelected());
            } else if(CB == water_box) {
                setWater(CB.isSelected());
            } else if(CB == forest_box) {
                setForest(CB.isSelected());
            } else if(CB == mountain_box) {
                setMountain(CB.isSelected());
            } else if(CB == castle_box) {
                setCastle(CB.isSelected());
            }
		}
	}

    /**
     *
     * @param evt
     */
    @Override
	public void propertyChange(PropertyChangeEvent evt) {
		Object source = evt.getSource();
		if(source == height_field)
			setHeight(((Number)height_field.getValue()).floatValue());
		else if(source == length_field)
			setLength(((Number)length_field.getValue()).floatValue());
		else if(source == daily_traffic_field)
			setDaily_traffic(((Number)daily_traffic_field.getValue()).floatValue());
		else if(source == lane_number_field)
			setLane_number(((Number)lane_number_field.getValue()).intValue());
	}

	private void reset() {
		Environment.reset();
		naval_box.setSelected(false);
		pedestrian_box.setSelected(false);
		railway_box.setSelected(false);
		road_box.setSelected(false);
		daily_traffic_field.setValue(90);
		wind_box.setSelected(false);
		water_box.setSelected(false);
		forest_box.setSelected(false);
		mountain_box.setSelected(false);
		height_field.setValue(10);
		length_field.setValue(20);
		lane_number_field.setValue(2);
		castle_box.setSelected(false);
	}
	
	/**
	 * Effectue le traitement du Chaînage Avant
	 */
	private void launchForwardChaining(){
		ArrayList<Bridge> LB = new ArrayList<>();
        ArrayList<Material> LM = new ArrayList<>();
        
//        BASE DE FAITS
		FactsBase FB = getFactsBase();
		out.println(FB);
        
//		BASE DE REGLES
		RulesBase BR1;	
        BR1 = initRulesBase(rules_path);
		out.println(BR1);
		
//		OTHER
		AIEngine moteur= new AIEngine(BR1);
		FB = moteur.forwardChaining(FB);

		out.println("\n------------------------");
		out.println("Résultat :");
		out.println("------------------------");
		out.println(FB);

		// TODO dans le traitement, commencé par supprimer les répétitions moteur.purge() ?
		
		// Création de l'affirmation correspondant aux matériaux
		Affirmation UCord, UConc, URock, USteel, UWood;
		UCord = new Affirmation("use cord", true);					// Corde
		UConc = new Affirmation("use concrete", true);				// Béton
		URock = new Affirmation("use rock", true);					// Pierre
		USteel = new Affirmation("use steel", true);			 	// Acier
		UWood = new Affirmation("use wood", true);					// Bois
		
		out.println("------------------------");
		out.println("Choix du matériau :");
		out.println("------------------------");
		// 1er cas : la base de fait spécifie de matériaux
		if(containsMaterial(FB)) {
			out.println("Matériau(x) spécifié(s)");
			for(Word w : FB) {
				if(w.getClass() == class) {
					Affirmation A = (Affirmation) w;
					if(A.equals(UCord)) {
						out.println("Corde");
						LM.add(Cord);
					} else if(A.equals(UConc)) {
						out.println("Béton");
						LM.add(Concrete);
					} else if(A.equals(URock)) {
						out.println("Pierre");
						LM.add(Stone);
					} else if(A.equals(USteel)) {
						out.println("Acier");
						LM.add(Steel);
					} else if(A.equals(UWood)) {
						out.println("Bois");
						LM.add(Wood);
					}
				}
			}
		} else {
			out.println("Pas de Matériau spécifié");
			// 2nd cas : la bas de fait ne spécifie pas de matériaux
			LM.add(Concrete);
			LM.add(Cord);
			LM.add(Steel);
			LM.add(Stone);
			LM.add(Wood);
			
			for(Word w : FB) {
				if(w.getClass() == class) {
					Affirmation A = (Affirmation) w;
					if(A.isOpposite(UCord)) {
						out.println("Pas de Corde");
						LM.remove(Cord);
					} else if(A.isOpposite(UConc)) {
						out.println("Pas de Béton");
						LM.remove(Concrete);
					} else if(A.isOpposite(URock)) {
						out.println("Pas de Pierre");
						LM.remove(Stone);
					} else if(A.isOpposite(USteel)) {
						out.println("Pas d'Acier");
						LM.remove(Steel);
					} else if(A.isOpposite(UWood)) {
						out.println("Pas de Bois");
						LM.remove(Wood);
					}
				}
			}
		}
		
		// Création de l'affirmation correspondant aux types de pont
		Affirmation BA, BB, BH, BS, BV, DB;
		BA = new Affirmation("bridge arc considered", true);		// Pont à/en arc (Bridge arc)
		BB = new Affirmation("bridge beam considered", true);		// Pont à poutres (Bridge beam)
		BH = new Affirmation("bridge hanging considered", true);	// Pont suspendu (Bridge hanging)
		BS = new Affirmation("bridge shroud considered", true);		// Pont à hauban (Bridge shroud)
		BV = new Affirmation("bridge vault considered", true);		// Pont à voûtes (Bridge vault)
        DB = new Affirmation("drawbridge considered", true);		// Pont-levis (Drawbridge)

		out.println("------------------------");
		out.println("Choix du pont :");
		out.println("------------------------");
		for(Word w : FB) {
			if(w.getClass() == class) {
				Affirmation A = (Affirmation) w;
				if(A.equals(BA)) {
					out.println("Pont en Arc");
					LB.add(new Bridge(Environment.getHeight(), getLane_number(), getLength(), arc));
				} else if(A.equals(BB)) {
					out.println("Pont à Poutres");
					LB.add(new Bridge(Environment.getHeight(), getLane_number(), getLength(), beam));
				} else if(A.equals(BH)) {
					out.println("Pont Suspendu");
					LB.add(new Bridge(Environment.getHeight(), getLane_number(), getLength(), hanging));
				} else if(A.equals(BS)) {
					out.println("Pont à hauban");
					LB.add(new Bridge(Environment.getHeight(), getLane_number(), getLength(), shroud));
				} else if(A.equals(BV)) {
					out.println("Pont à Voûtes");
					LB.add(new Bridge(Environment.getHeight(), getLane_number(), getLength(), vault));
				} else if(A.equals(DB)) {
					out.println("Pont Levis !");
					LB.add(new Bridge(Environment.getHeight(), getLane_number(), getLength(), drawbridge));
				}
			}
		}
		
		if(LB.isEmpty()) {
            showMessageDialog(null, "Aucun pont ne répond au critère", "Bridge Constructor - Alert" , ERROR_MESSAGE);
        } else {
			ResponseInterface RI= new ResponseInterface(LB, LM);
            RI.setVisible(true);
			this.dispose();
		}
	}
	
	private boolean containsMaterial(FactsBase FB) {
        return (FB.stream().anyMatch((W) -> (W.getName().startsWith("use") && ((Affirmation)W).isTrue()))) ;
	}
}
