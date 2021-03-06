package bridgeconstructor;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Florian
 */
public class Main {

	//<editor-fold defaultstate="collapsed" desc="Definition du style visuel">
	/**
     * Définit le style du système comme style pour l'application
     * @author Scr3amer
	 */
	public static void setSystemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "System look and feel class not found.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, "System look and feel unsupported (weird isn't it ? ^^)", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, "Look and feel instantiation failure.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, "Look and feel illegal access.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
    //</editor-fold>

	public static void main(String[] args) {

		setSystemLookAndFeel();
        
        /* Créer et affiche l'interface */
        SwingUtilities.invokeLater(() -> {
            new AskInterface().setVisible(true);
        });

	}
}
