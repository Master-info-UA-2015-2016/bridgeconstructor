package bridgeconstructor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 * L'interface Graphique est construite à partir de cette classe
 *
 */
public class GraphicInterface extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private static String title = "Bridge Constructor";
	
	// Panel
	private JPanel up_panel;
	private JPanel center_panel;
		private JPanel traffic_panel;
		private JPanel meteo_panel;
	private JPanel down_panel;
	private Container main_panel;
	// Label
	private JLabel order;
	// Traffic
	private JLabel traffic;
	private JCheckBox naval_box;
	private JCheckBox railway_box;
	private JCheckBox pedestrian_box;
	private JCheckBox road_box;
	// Risques Météorologiques Box
	private JLabel meteo;
	private JCheckBox storm_box;
	private JCheckBox fire_box;
	private JCheckBox flood_box;
	// Bouton
	private JButton button;
	
	public GraphicInterface() {
		super(title);
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	
	private void buildComposants() {
		// Panel
		up_panel = new JPanel();
		center_panel = new JPanel();
			center_panel.setLayout(new BoxLayout(center_panel, BoxLayout.Y_AXIS));
			traffic_panel = new JPanel(new GridLayout(2, 2));
			meteo_panel = new JPanel(new GridLayout(2, 2));
		down_panel = new JPanel();
		// Label
		order = new JLabel("Veuillez sélectionner les caractéristiques de l'environnement :");
		// Traffic box
		traffic = new JLabel("Traffic :");
		naval_box = new JCheckBox("Traffic Naval");
		railway_box = new JCheckBox("Traffic Ferroviaire");
		pedestrian_box = new JCheckBox("Traffic Piéton");
		road_box = new JCheckBox("Traffic Routier");
		// Risques Météorologies Box
		meteo = new JLabel("Météo : ");
		storm_box =  new JCheckBox("Tempête");
		fire_box = new JCheckBox("Incendie");
		flood_box = new JCheckBox("Inondation");
		
		// Bouton
		button = new JButton("Tout est fait !");
	}
	
	private void buildInterface() {
		up_panel.add(order);
		
		//center_panel.setLayout(grid_layout);
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
		center_panel.add(traffic);
			traffic.setAlignmentX(Component.CENTER_ALIGNMENT);
		center_panel.add(traffic_panel);
		center_panel.add(meteo);
			meteo.setAlignmentX(Component.CENTER_ALIGNMENT);
		center_panel.add(meteo_panel);
			
		down_panel.add(button);

		main_panel = getContentPane();
		main_panel.add(up_panel, BorderLayout.PAGE_START);
		main_panel.add(center_panel, BorderLayout.CENTER);
		main_panel.add(down_panel, BorderLayout.PAGE_END);
		
		this.setContentPane(main_panel);
	}
	
	private void buildEvents() {
		this.naval_box.addActionListener(this);
		this.railway_box.addActionListener(this);
		this.pedestrian_box.addActionListener(this);
		this.road_box.addActionListener(this);
		this.storm_box.addActionListener(this);
		this.fire_box.addActionListener(this);
		this.flood_box.addActionListener(this);
		this.button.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox CBB;
		JButton B;
		if(e.getSource().getClass() == JButton.class) {
			B = (JButton) e.getSource();
			if(B == button) {
				// TODO On fait quoi une fois que l'utilisateur a terminé son choix ? (Je connais la réponse, peut-être)
				System.out.println("En attente...");
				new Bridge();
				this.dispose();
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
			Environment.display();
		}
	}
	
	

}
