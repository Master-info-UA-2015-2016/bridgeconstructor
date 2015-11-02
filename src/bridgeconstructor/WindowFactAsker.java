/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgeconstructor;

import expertsystem.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jérome
 */
public class WindowFactAsker implements FactAsker {
	JFrame parent;

	public WindowFactAsker(JFrame _parent) {
		this.parent = _parent;
	}

	@Override
	public Word askFactValueToUser(String factName) {

		boolean answer = false;

		// 1st OptionDialog
		String answerValue = JOptionPane.showInputDialog(parent, "Veuillez saisir la valeur de " + factName + " : ",
				"Bridge Contructor Alert", JOptionPane.QUESTION_MESSAGE);
		if (answerValue == null) {
            return null;
        }

		// 2nd OptionDialog
		int option = JOptionPane.showConfirmDialog(parent, "\tEst-ce que '" + answerValue + "' est correct ?",
				"Bridge Constructor Alert", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		switch (option) {
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

		if (answer) {
			try {
				float res = Float.parseFloat(answerValue);
				return new Comparison(factName, Operators.equal, res);
			} catch (NumberFormatException NFE) {
				boolean res = Boolean.parseBoolean(answerValue);
				return new Affirmation(factName, res);
			}
		} else {
            return askFactValueToUser(factName);
        }
	}

}
