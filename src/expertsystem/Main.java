package expertsystem;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		FactsBase FB= new FactsBase();
		
//		BASE DE FAITS
		Word taille= new Comparison("Taille pont", /*20,*/ Operators.inf_equal, 35);
		Word cars= new Affirmation("Présence traffic routier", false);
		FB.add(taille);
//		FB.addFact(cars);
		
		System.out.println(FB);
		
//		BASE DE REGLES
		ArrayList<Word> listAnt= new ArrayList<Word>();
		listAnt.add(taille);
		
		ArrayList<Word> listCons= new ArrayList<Word>();
		listCons.add(cars);
		
		
//		Rule taille_cars= new Rule(listAnt, listCons);
		
		RulesBase BR1= new RulesBase();
		BR1.addRule(listAnt, listCons);
//		BR1.addRule(taille_cars);
		
		System.out.println(BR1);
//		OTHER
		AIEngine moteur= new AIEngine(BR1);
		FB= moteur.forwardChaining(FB);

		System.out.println(FB);
		
		
	}

}
