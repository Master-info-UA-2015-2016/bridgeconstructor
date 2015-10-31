package expertsystem;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class Interface {
	
	Word askFactValueToUser(String factName, JFrame frame) {
		
		boolean answer = false;

		// 1st OptionDialog
	    String answerValue = JOptionPane.showInputDialog(null, "Veuillez saisir la valeur de " + factName + " : ", "Bridge Contructor Alert", JOptionPane.QUESTION_MESSAGE);
	    if(answerValue == null) return null;
	    
	    // 2nd OptionDialog
	    int option = JOptionPane.showConfirmDialog(null, "\tEst-ce que '"+ answerValue +"' est correct ?", "Bridge Constructor Alert", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    switch(option) {
	    	case JOptionPane.OK_OPTION:
	    		answer = true;
	    		break;
	    	case JOptionPane.NO_OPTION:
	    		answer = false;
	    		break;
	    	case JOptionPane.CANCEL_OPTION:
	    		return null;
	    	case JOptionPane.CLOSED_OPTION:
	    		return null;
	    }

	    if(answer) {
			try{
                float res= Float.parseFloat(answerValue);
                return new Comparison(factName, Operators.equal, res);
            }catch(NumberFormatException NFE){
                boolean res= Boolean.parseBoolean(factName);
                return new Affirmation(factName, res);
            }
		} else return askFactValueToUser(factName, frame);
	}
}
