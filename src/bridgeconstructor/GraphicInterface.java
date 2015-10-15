package bridgeconstructor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * L'interface Graphique est construite à partir de cette classe
 *
 */
public class GraphicInterface extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private static String title = "Bridge Constructor";
	private BoxLayout box_layout;
	private JPanel panneau;
	// Traffic Box
	private JCheckBox naval_box;
	private JCheckBox railway_box;
	private JCheckBox pedestrian_box;
	private JCheckBox road_box;
	// Risques Météorologiques Box
	private JCheckBox storm_box;
	private JCheckBox fire_box;
	private JCheckBox flood_box;
	
	public GraphicInterface() {
		super(title);
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.setResizable(true);
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	
	private void buildComposants() {
		panneau = new JPanel();
			panneau.setBackground(Color.GRAY);
		box_layout = new BoxLayout(panneau, BoxLayout.Y_AXIS);
		
		// Traffic box
		naval_box = new JCheckBox("Traffic Naval");
		railway_box = new JCheckBox("Traffic Ferroviaire");
		pedestrian_box = new JCheckBox("Traffic Piéton");
		road_box = new JCheckBox("Traffic Routier");
		// Risques Météorologies Box
		storm_box =  new JCheckBox("Tempête");
		fire_box = new JCheckBox("Incendie");
		flood_box = new JCheckBox("Inondation");
	}
	
	private void buildInterface() {
		panneau.setLayout(box_layout);
		panneau.add(naval_box);
		panneau.add(railway_box);
		panneau.add(pedestrian_box);
		panneau.add(road_box);
		panneau.add(storm_box);
		panneau.add(fire_box);
		panneau.add(flood_box);
		this.setContentPane(panneau);
	}
	
	private void buildEvents() {
		this.naval_box.addActionListener(this);
		this.railway_box.addActionListener(this);
		this.pedestrian_box.addActionListener(this);
		this.road_box.addActionListener(this);
		this.storm_box.addActionListener(this);
		this.fire_box.addActionListener(this);
		this.flood_box.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox B = (JCheckBox) e.getSource();
		if(B == naval_box) {
			Environment.setNaval_traffic(B.isSelected());
			return;
		}
		if(B == railway_box) {
			Environment.setRailway_traffic(B.isSelected());
			return;
		}
		if(B == pedestrian_box) {
			Environment.setPedestrian_traffic(B.isSelected());
			return;
		}
		if(B == road_box) {
			Environment.setRoad_traffic(B.isSelected());
			return;
		}
		if(B == storm_box) {
			Environment.setRoad_traffic(B.isSelected());
			return;
		}
		if(B == fire_box) {
			Environment.setFire(B.isSelected());
			return;
		}
		if(B == flood_box) {
			Environment.setFlood(B.isSelected());
			return;
		}
	}

}
