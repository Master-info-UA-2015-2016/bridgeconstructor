package bridgeconstructor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * L'interface Graphique est construite à partir de cette classe
 *
 */
public class GraphicInterface extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private static String title = "Bridge Constructor";
	private JPanel panneau;
	private JButton bouton;
	int i;
	
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
		i = 0;
		
		panneau = new JPanel();
			panneau.setBackground(Color.GRAY);
		bouton = new JButton("Oh, un bouton !");
	}
	
	private void buildInterface() {
		panneau.add(bouton);
		this.setContentPane(panneau);
	}
	
	private void buildEvents() {
		this.bouton.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton B = (JButton) e.getSource();
		if(B == bouton) {
			i++;
			System.out.println("Clic n°"+i);
		}
	}

}
