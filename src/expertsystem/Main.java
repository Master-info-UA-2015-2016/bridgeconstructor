package expertsystem;

import static expertsystem.Operators.inf_equal;
import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author Florian
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
		
		FactsBase FB= new FactsBase();
		
//		BASE DE FAITS
		Word taille= new Comparison("Taille pont", /*20,*/ inf_equal, 35);
		Word cars= new Affirmation("Présence traffic routier", false);
		FB.add(taille);
//		FB.addFact(cars);
		
		out.println(FB);
		
//		BASE DE REGLES
		ArrayList<Word> listAnt= new ArrayList<>();
		listAnt.add(taille);
		
		ArrayList<Word> listCons= new ArrayList<>();
		listCons.add(cars);
		
		
//		Rule taille_cars= new Rule(listAnt, listCons);
		
		RulesBase BR1= new RulesBase();
		BR1.addRule(listAnt, listCons);
//		BR1.addRule(taille_cars);
		
		out.println(BR1);
//		OTHER
		AIEngine moteur= new AIEngine(BR1);
		FB= moteur.forwardChaining(FB);

		out.println(FB);
		
		
	}

}
