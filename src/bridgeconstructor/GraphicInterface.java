package bridgeconstructor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * L'interface Graphique est construite à partir de cette classe
 *
 */
public class GraphicInterface extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private static String title = "Bridge Constructor";
	
	// Layout
	private GridLayout grid_layout;
	private BoxLayout box_layout;
	// Panel
	private JPanel up_panel;
	private JPanel center_panel;
	private JPanel down_panel;
	private Container main_panel;
	// Label
	private JLabel order;
	// Traffic Box
	private JCheckBox naval_box;
	private JCheckBox railway_box;
	private JCheckBox pedestrian_box;
	private JCheckBox road_box;
	// Risques Météorologiques Box
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
		// Layout
		grid_layout = new GridLayout(4, 4);
		box_layout = new BoxLayout(main_panel, BoxLayout.Y_AXIS);
		
		// Panel
		up_panel = new JPanel();
		center_panel = new JPanel();
		down_panel = new JPanel();
		// Label
		order = new JLabel("Veuillez sélectionner les caractéristiques de l'environnement");
		// Traffic box
		naval_box = new JCheckBox("Traffic Naval");
		railway_box = new JCheckBox("Traffic Ferroviaire");
		pedestrian_box = new JCheckBox("Traffic Piéton");
		road_box = new JCheckBox("Traffic Routier");
		// Risques Météorologies Box
		storm_box =  new JCheckBox("Tempête");
		fire_box = new JCheckBox("Incendie");
		flood_box = new JCheckBox("Inondation");
		
		// Bouton
		button = new JButton("Tout est fait !");
	}
	
	private void buildInterface() {
		up_panel.add(order);
		
		center_panel.setLayout(grid_layout);
			center_panel.add(naval_box);
			center_panel.add(railway_box);
			center_panel.add(pedestrian_box);
			center_panel.add(road_box);
			center_panel.add(storm_box);
			center_panel.add(fire_box);
			center_panel.add(flood_box);
			center_panel.add(Box.createRigidArea(new Dimension(0, 5)));
			center_panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			
		down_panel.add(button);

		//Put everything together, using the content pane's BorderLayout.
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
			if(B == button)
				System.out.println("En attente...");
		} else if(e.getSource().getClass() == JCheckBox.class) {
			CBB = (JCheckBox) e.getSource();
			if(CBB == naval_box)
				Environment.setNaval_traffic(CBB.isSelected());
			if(CBB == railway_box)
				Environment.setRailway_traffic(CBB.isSelected());
			if(CBB == pedestrian_box)
				Environment.setPedestrian_traffic(CBB.isSelected());
			if(CBB == road_box)
				Environment.setRoad_traffic(CBB.isSelected());
			if(CBB == storm_box)
				Environment.setStorm(CBB.isSelected());
			if(CBB == fire_box)
				Environment.setFire(CBB.isSelected());
			if(CBB == flood_box)
				Environment.setFlood(CBB.isSelected());
			Environment.display();
		}
	}
	
	

}
