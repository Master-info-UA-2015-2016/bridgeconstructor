package bridgeconstructor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResponseInterface extends JFrame implements ActionListener, PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private static String title = "Bridge Constructor - Response";
	
	// Label
	private JLabel order;
	
	public ResponseInterface() {
		super(title);
		buildComposants();
		buildInterface();
		buildEvents();
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	
	public ResponseInterface(List<Bridge> LB) {
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
		order = new JLabel("Voici les caractéristiques du pont : ");
		
	}
	
	private void buildInterface() {
		this.setContentPane(order);
	}
	
	private void buildEvents() {
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
