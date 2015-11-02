/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgeconstructor;

import expertsystem.Affirmation;
import expertsystem.Comparison;
import expertsystem.FactAsker;
import expertsystem.Operators;
import static expertsystem.Operators.equal;
import expertsystem.Word;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.CLOSED_OPTION;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;

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
		String answerValue = showInputDialog(parent, "Veuillez saisir la valeur de " + factName + " : ",
				"Bridge Contructor Alert", QUESTION_MESSAGE);
		if (answerValue == null) {
            return null;
        }

		// 2nd OptionDialog
		int option = showConfirmDialog(parent, "\tEst-ce que '" + answerValue + "' est correct ?",
				"Bridge Constructor Alert", YES_NO_OPTION, QUESTION_MESSAGE);
		switch (option) {
		case OK_OPTION:
			answer = true;
			break;
		case NO_OPTION:
			answer = false;
			break;
		case CANCEL_OPTION:
			return null;
		case CLOSED_OPTION:
			return null;
		}

		if (answer) {
			try {
				float res = parseFloat(answerValue);
				return new Comparison(factName, equal, res);
			} catch (NumberFormatException NFE) {
				boolean res = parseBoolean(answerValue);
				return new Affirmation(factName, res);
			}
		} else {
            return askFactValueToUser(factName);
        }
	}

}
