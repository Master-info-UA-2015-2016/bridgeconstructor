package bridgeconstructor;

import java.util.ArrayList;

import expertsystem.Affirmation;
import expertsystem.RulesBase;
import expertsystem.Word;

public class BridgeRules {
	private static RulesBase bridge_rules;
	
	public void initRulesBase() {
		bridge_rules = new RulesBase();
		
		// TODO Création de tous les antécédents
		ArrayList<Word> antecedents = new ArrayList<>();
		// TODO Créations de toutes les conséquences
		ArrayList<Word> consequents = new ArrayList<>();
		// TODO Lié antécédents et conséquences pour faire des règles
		
		// TODO les rajouter à bridge_rules - Base de Règle initiale
		// Création d'une règle
		bridge_rules.addRule(antecedents, consequents);
		
		//BASE DE REGLES
		ArrayList<Word> listAnt= new ArrayList<Word>();
			Affirmation fire= new Affirmation("fire", true);
		listAnt.add(fire);
		
		ArrayList<Word> listCons= new ArrayList<Word>();
			Affirmation rail= new Affirmation("TRAINS ?", false);
		listCons.add(rail);
				
		RulesBase BR1= new RulesBase();
		BR1.addRule(listAnt, listCons);
		
		System.out.println("Base de Règles Initiale : " + bridge_rules);
	}	
}
