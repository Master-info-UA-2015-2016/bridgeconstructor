package bridgeconstructor;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Florian
 */
public class ResponseInterface extends JFrame {
	private static final long serialVersionUID = 1L;
	private static String title = "Bridge Constructor - Response";
	
	List<Bridge> list;
	
	// Panel
	private JPanel main_panel;
		private JPanel up_panel;
		private JPanel list_panel;
	// Label
	private JLabel order;
	// Composition de la description d'un pont
	private JPanel bridge_panel;
		private JLabel type;
		private JLabel height;
		private JLabel width;	// MIN - MAX Width
		private JLabel length;
		private JLabel material;
		private JLabel price;
	
    /**
     *
     */
    public ResponseInterface() {
		super(title);
		
		list = new ArrayList<Bridge>();
		
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	
    /**
     *
     * @param LB
     */
    public ResponseInterface(List<Bridge> LB) {
		super(title);
		
		list = LB;
		for(Bridge B : list) System.out.println(B);
		
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}

	private void buildComposants() {
		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		
		// Panel
		main_panel = new JPanel();
			main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
		up_panel = new JPanel();
		list_panel = new JPanel();
			list_panel.setLayout(new BoxLayout(list_panel, BoxLayout.X_AXIS));
		// Label
		if(list.size() > 1)
			order = new JLabel("Les ponts suggérés : ");
		else order = new JLabel("Le pont suggéré : ");
		up_panel.add(order);
		// Bridge
		for(Bridge B : list) {
			// Construction
			bridge_panel = new JPanel();
				bridge_panel.setBorder(raisedetched);
			bridge_panel.setLayout(new BoxLayout(bridge_panel, BoxLayout.Y_AXIS));
				type = new JLabel(B.getType());
					type.setAlignmentX(Component.CENTER_ALIGNMENT);
				height = new JLabel("Hauteur : " + B.getHeight());
				width = new JLabel("Largeur : " + B.getMinWidth() + " - " + B.getMaxWidth());	// MIN - MAX Width
				length = new JLabel("Longueur : " + B.getLength());
				material = new JLabel("Matériau : " + B.getMaterial());
				price = new JLabel("Prix : " + B.getPrice());
			// Affichage
			bridge_panel.add(type);
			bridge_panel.add(height);
			bridge_panel.add(width);
			bridge_panel.add(length);
			bridge_panel.add(material);
			bridge_panel.add(price);
			
			list_panel.add(bridge_panel);
		}
	}
	
	private void buildInterface() {
		main_panel.add(up_panel);
		main_panel.add(list_panel);
		
		this.setContentPane(main_panel);
	}
	
	private void buildEvents() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
