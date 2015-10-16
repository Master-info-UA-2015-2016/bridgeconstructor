package expertsystem;

import java.util.List;

class Fact{
	boolean value; // est-ce qu'on utilise un booléen ou un String : 
				//	plusieurs types de sols, vrai/faux pour chaque type ou un seul fait avec le type ? 
	String name;
	
	public Fact(String factName, boolean factVal){
		name= factName;
		value= factVal;
	}
}

public class FactsBase {
	List<Fact> facts;
	
	public FactsBase(){

	}
	
	/**
	 * Ajoute un fait dans la base de faits
	 * @author florian
	 * 
	 * @param factName nom du nouveau fait
	 * @param factVal valeur (vrai ou faux) du nouveau fait
	 */
	public void addFact(String factName, boolean factVal){
		facts.add(new Fact(factName, factVal));
	}
	
}
