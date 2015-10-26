package bridgeconstructor;

import expertsystem.RulesBase;

public class Main {

	public enum types {Mobile, Suspendu, haubants, arcs_boutants};
	
	public static void main(String[] args) {
		// TODO : lister tous les types de ponts possibles et matériaux utilisables
		//		Créer un Bridge pour chaque ponts possible,
		//		contenant chaque matériau utilisable pour ce type de ponts ?
		//		on supprime le matériau utilisable ou le Bridge entier si il n'est plus envisagé ?
		
		RulesBase BR1= BridgeRules.initRulesBase("./bin/ressources/bridge_rules.xml");
		
		System.out.println(BR1);
		
		new AskInterface();
		
	}
}
