package bridgeconstructor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

public class ResponseInterface extends JFrame implements ActionListener, PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private static String title = "Bridge Constructor - Response";
	
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
	
	private void buildComposants() {
		
	}
	
	private void buildInterface() {
		
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
