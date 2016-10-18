package bridgeconstructor;

import expertsystem.AIEngine;
import expertsystem.Affirmation;
import expertsystem.FactsBase;
import expertsystem.RulesBase;
import expertsystem.Word;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

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
		private JMenu authors;
			private JMenuItem author_1;
			private JMenuItem author_2;
		private JMenu show;
			private JMenuItem item_show_rules;
            private JMenuItem item_traces;
		private JMenuItem other_chaining;
		private JMenuItem about;
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
	
    /**
     *
     */
    public AskInterface() {
		super(title);
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.setResizable(false);
		this.pack();

        //get local graphics environment to get maximum window bounds
        Rectangle screenSize= GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        this.setLocation((int)(screenSize.getWidth() - this.getWidth()) / 2,
						 	(int)(screenSize.getHeight() - this.getHeight()) / 2);
        
	}
    
    /**
     *
     * @return
     */
    public String getRulesPath() { return rules_path; }
	
	private void buildComposants() {
		float_format = NumberFormat.getNumberInstance();
		int_format = NumberFormat.getIntegerInstance();
		
		// Menu
		menuBar = new JMenuBar();
			file = new JMenu("Fichier");
				item_close = new JMenuItem("Quitter");
			authors = new JMenu("Auteurs");
				author_1 = new JMenuItem("Florian DAVID");
				author_2 = new JMenuItem("Jérôme FOURMOND");
			show = new JMenu("Afficher...");
				item_show_rules = new JMenuItem("Base de règles");
				item_traces= new JCheckBoxMenuItem("Traces abrégées");
                    item_traces.setSelected(false);
            other_chaining = new JMenuItem("Arrière et mixte");
            about = new JMenuItem("?");
		// Panel
		main_panel = new JPanel(new BorderLayout());
		up_panel = new JPanel();
		center_panel = new JPanel();
			center_panel.setLayout(new BoxLayout(center_panel, BoxLayout.Y_AXIS));
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
			length_field.setValue(Environment.getLength());
		lane_number = new JLabel("Nombre de voies : ");
		lane_number_field = new JFormattedTextField(int_format);
			lane_number_field.setColumns(10);
			lane_number_field.setValue(Environment.getLane_number());
		// Bonus
		bonus = new JLabel("Bonus :");
		castle_box = new JCheckBox("Château");
		// Bouton
		reset_button = new JButton("Reinitialiser");
		confirm_button = new JButton("Tout est fait !");
	}
	
	private void buildInterface() {
		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		
		// Menu
		file.add(item_close);
		authors.add(author_1);
        authors.add(author_2);
		show.add(item_show_rules);
        show.add(item_traces);
		menuBar.add(file);
		menuBar.add(authors);
		menuBar.add(show);
		menuBar.add(other_chaining);
		menuBar.add(about);
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
		measure_panel.add(label_panel, BorderLayout.CENTER);
		measure_panel.add(field_panel, BorderLayout.LINE_END);
		// Bonus Panel
		bonus_panel.setBorder(raisedetched);
		bonus_panel.add(castle_box);
		
		center_panel.add(traffic);
			traffic.setAlignmentX(Component.CENTER_ALIGNMENT);
		center_panel.add(traffic_panel);
		center_panel.add(meteo);
			meteo.setAlignmentX(Component.CENTER_ALIGNMENT);
		center_panel.add(meteo_panel);
		center_panel.add(ground);
			ground.setAlignmentX(Component.CENTER_ALIGNMENT);
		center_panel.add(ground_panel);
		center_panel.add(measure);
			measure.setAlignmentX(Component.CENTER_ALIGNMENT);
		center_panel.add(measure_panel);
		center_panel.add(bonus);
			bonus.setAlignmentX(Component.CENTER_ALIGNMENT);
		center_panel.add(bonus_panel);
		
		down_panel.add(reset_button);
		down_panel.add(confirm_button);
		
		main_panel.add(up_panel, BorderLayout.PAGE_START);
		main_panel.add(center_panel, BorderLayout.CENTER);
		main_panel.add(down_panel, BorderLayout.PAGE_END);
		
		this.setContentPane(main_panel);
		this.reset();
	}
	
	private void buildEvents() {
		// Menu
		item_close.addActionListener(this);
        author_1.addActionListener(this);
        author_2.addActionListener(this);
		item_show_rules.addActionListener(this);
		other_chaining.addActionListener(this);
		about.addActionListener(this);
		
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
    /**
     *
     * @param e
     */
    @Override
	public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        
        if(source.getClass() == JMenuItem.class) {
            if(source.equals(about)){
                Desktop desktop;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                    try {
                        desktop.open(new File("README.txt"));
                    } catch (IOException ex) {
                        Logger.getLogger(AskInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            if(source.equals(other_chaining)) {
                this.setVisible(false);
                BackwardInterface BI= new BackwardInterface(this, rules_path, item_traces.isSelected());
                BI.setVisible(true);
            // Envoi d'e-mail aux auteurs
            } else if(source.equals(author_1)) {
                Desktop desktop;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                    try {
                        desktop.mail(new URI("mailto:fl.david.53@gmail.com?subject=BridgeConstructor"));
                    } catch (IOException | URISyntaxException ex) {
                        Logger.getLogger(AskInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if(source.equals(author_2)) {
                Desktop desktop;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                    try {
                        desktop.mail(new URI("mailto:jerome@fourdmond.fr?subject=BridgeConstructor"));
                    } catch (IOException | URISyntaxException ex) {
                        Logger.getLogger(AskInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
//                Fermeture fenetre
            } else if(source.equals(item_close)) {
                this.dispose();
//                Montrer la base de règles
            } else if(source.equals(item_show_rules)) {
				RulesBaseInterface RBI= new RulesBaseInterface(this);
                    this.setVisible(false);
                    RBI.setVisible(true);
            }
		} else if(source.getClass() == JButton.class) {
			if(source.equals(reset_button)) {
				this.reset();
			} else if(source.equals(confirm_button)) {
				launchForwardChaining();
			}
		} else if(source.getClass() == JCheckBox.class) {
			JCheckBox CB = (JCheckBox) source;
			if(CB.equals(naval_box)) {
                Environment.setNaval_traffic(CB.isSelected());
            } else if(CB.equals(railway_box)) {
                Environment.setRailway_traffic(CB.isSelected());
            } else if(CB.equals(pedestrian_box)) {
                Environment.setPedestrian_traffic(CB.isSelected());
            } else if(CB.equals(road_box)) {
                Environment.setRoad_traffic(CB.isSelected());
            } else if(CB.equals(wind_box)) {
                Environment.setWind(CB.isSelected());
            } else if(CB.equals(water_box)) {
                Environment.setWater(CB.isSelected());
            } else if(CB.equals(forest_box)) {
                Environment.setForest(CB.isSelected());
            } else if(CB.equals(mountain_box)) {
                Environment.setMountain(CB.isSelected());
            } else if(CB.equals(castle_box)) {
                Environment.setCastle(CB.isSelected());
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
		if(source.equals(height_field)) {
            Environment.setHeight(((Number)height_field.getValue()).floatValue());
        } else if(source.equals(length_field)) {
            Environment.setLength(((Number)length_field.getValue()).floatValue());
        } else if(source.equals(daily_traffic_field)) {
            Environment.setDaily_traffic(((Number)daily_traffic_field.getValue()).floatValue());
        } else if(source.equals(lane_number_field)) {
            Environment.setLane_number(((Number)lane_number_field.getValue()).intValue());
        }
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
		FactsBase FB = Environment.getFactsBase();

		System.out.println(FB);
        
//		BASE DE REGLES
		RulesBase BR1;	
        BR1 = BridgeRules.initRulesBase(rules_path);
		System.out.println(BR1);
		
//		CALCUL
		AIEngine moteur= new AIEngine(BR1, item_traces.isSelected());
		FB = moteur.forwardChaining(FB);

//      RESULTAT
		System.out.println("\n------------------------");
		System.out.println("    Résultat :");
		System.out.println("------------------------");
		System.out.println(FB);
		
		// Création de l'affirmation correspondant aux matériaux
		Affirmation UCord, UConc, URock, USteel, UWood;
		UCord = new Affirmation("use cord", true);					// Corde
		UConc = new Affirmation("use concrete", true);				// Béton
		URock = new Affirmation("use rock", true);					// Pierre
		USteel = new Affirmation("use steel", true);			 	// Acier
		UWood = new Affirmation("use wood", true);					// Bois
		
		System.out.println("------------------------");
		System.out.println("Choix du matériau :");
		System.out.println("------------------------");
		// 1er cas : la base de fait spécifie de matériaux
		if(containsMaterial(FB)) {
			System.out.println("Matériau(x) spécifié(s)");
			for(Word w : FB) {
				if(w.getClass() == Affirmation.class) {
					Affirmation A = (Affirmation) w;
					if(A.equals(UCord)) {
						System.out.println("Corde");
						LM.add(Material.Cord);
					} else if(A.equals(UConc)) {
						System.out.println("Béton");
						LM.add(Material.Concrete);
					} else if(A.equals(URock)) {
						System.out.println("Pierre");
						LM.add(Material.Stone);
					} else if(A.equals(USteel)) {
						System.out.println("Acier");
						LM.add(Material.Steel);
					} else if(A.equals(UWood)) {
						System.out.println("Bois");
						LM.add(Material.Wood);
					}
				}
			}
		} else {
			System.out.println("Pas de Matériau spécifié");
			// 2nd cas : la bas de fait ne spécifie pas de matériaux
			LM.add(Material.Concrete);
			LM.add(Material.Cord);
			LM.add(Material.Steel);
			LM.add(Material.Stone);
			LM.add(Material.Wood);
			
			for(Word w : FB) {
				if(w.getClass() == Affirmation.class) {
					Affirmation A = (Affirmation) w;
					if(A.isOpposite(UCord)) {
						System.out.println("Pas de Corde");
						LM.remove(Material.Cord);
					} else if(A.isOpposite(UConc)) {
						System.out.println("Pas de Béton");
						LM.remove(Material.Concrete);
					} else if(A.isOpposite(URock)) {
						System.out.println("Pas de Pierre");
						LM.remove(Material.Stone);
					} else if(A.isOpposite(USteel)) {
						System.out.println("Pas d'Acier");
						LM.remove(Material.Steel);
					} else if(A.isOpposite(UWood)) {
						System.out.println("Pas de Bois");
						LM.remove(Material.Wood);
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

		System.out.println("------------------------");
		System.out.println("Choix du pont :");
		System.out.println("------------------------");
		for(Word w : FB) {
			if(w.getClass() == Affirmation.class) {
				Affirmation A = (Affirmation) w;
				if(A.equals(BA)) {
					System.out.println("Pont en Arc");
					LB.add(new Bridge(Environment.getHeight(), Environment.getLane_number(), Environment.getLength(), TypeBridge.arc));
				} else if(A.equals(BB)) {
					System.out.println("Pont à Poutres");
					LB.add(new Bridge(Environment.getHeight(), Environment.getLane_number(), Environment.getLength(), TypeBridge.beam));
				} else if(A.equals(BH)) {
					System.out.println("Pont Suspendu");
					LB.add(new Bridge(Environment.getHeight(), Environment.getLane_number(), Environment.getLength(), TypeBridge.hanging));
				} else if(A.equals(BS)) {
					System.out.println("Pont à hauban");
					LB.add(new Bridge(Environment.getHeight(), Environment.getLane_number(), Environment.getLength(), TypeBridge.shroud));
				} else if(A.equals(BV)) {
					System.out.println("Pont à Voûtes");
					LB.add(new Bridge(Environment.getHeight(), Environment.getLane_number(), Environment.getLength(), TypeBridge.vault));
				} else if(A.equals(DB)) {
					System.out.println("Pont Levis !");
					LB.add(new Bridge(Environment.getHeight(), Environment.getLane_number(), Environment.getLength(), TypeBridge.drawbridge));
				}
			}
		}
		
		if(LB.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aucun pont ne répond au critère", "Bridge Constructor - Alert" , JOptionPane.ERROR_MESSAGE);
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
