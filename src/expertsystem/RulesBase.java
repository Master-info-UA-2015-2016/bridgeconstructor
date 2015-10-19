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
		String chaine= "Base de règles : \n";
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
	 * Ajoute une règle dans la BR
	 * @author florian
	 * 
	 */
	public void addRule(List<Word> ant, List<Word> cons){
		rules.add(new Rule(ant, cons));
	}
	
	/**
	 * Ajoute une règle dans la BR
	 * @author florian
	 * 
	 */
	public void addRule(Rule r){
		rules.add(r);
	}
	
	
	/**
	 * Vérifie si une règle est dans la base de règles
	 * @return vrai si le fait est présent
	 * 
	 * TODO vérifier : mm chose que pour les fait pour les </<= et >/>= ? 
	 */
	public boolean contains(Rule rule){
		return rules.contains(rule);
	}
	
}
