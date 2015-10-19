package expertsystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RulesBase {
	List<Rule> rules;
	
	public RulesBase(){
		rules= new ArrayList<Rule>();
	}
	
	public String toString(){
		String chaine= "Base de faits : \n";
		for (Rule rule : rules){
			chaine += "\t "+ rule.toString() +"\n";
		}
		
		return chaine;
	}
	
	public void show(){
		System.out.println(this.toString());
		System.out.println("------------------------------------------");
	}
	
	/**
	 * Ajoute un fait -une affirmation/négation- dans la base de faits, à partir de son nom et de sa valeur
	 * @author florian
	 * 
	 * @param factName nom du nouveau fait
	 * @param factVal valeur (vrai ou faux) du nouveau fait
	 */
	public void add(List<Word> ant, List<Word> cons){
		rules.add(new Rule(ant, cons));
	}
	
	/**
	 * Ajoute un fait -comparaison- dans la base de faits, à partir de son nom et de sa valeur
	 * @author florian
	 * 
	 * @param factName nom du nouveau fait
	 * @param factVal valeur (vrai ou faux) du nouveau fait
	 */
	public void addFact(Variable var, Operators op, int valCondition){
		rules.add(new Comparison(var, op, valCondition));
	}

	/**
	 * Ajoute un fait, déja existant, dans la base de faits
	 * @author florian
	 * 
	 * @param factName nom du nouveau fait
	 * @param factVal valeur (vrai ou faux) du nouveau fait
	 */
	public void addFact(Word fact){
		rules.add(fact);
	}
	
	/**
	 * Vérifie si un fait est dans la base de faits
	 * TODO PEUT ETRE ne vérifier que les noms ?
	 * TODO OBLIGATOIRE, si x < 5 VRAI, alors v < 7 est VRAI,
	 * 		donc il faut modifier la fonction pour l'appliquer sur les "comparisons",
	 *  	modifier Comparison.equals() suffit ?
	 * @return vrai si le fait est présent
	 */
	public boolean contains(Word fact){
		return rules.contains(fact);
	}
}
