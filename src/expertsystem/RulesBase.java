package expertsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Florian
 */
public class RulesBase extends ArrayList<Rule>/*implements Iterable<Rule>*/{
//	protected List<Rule> rules;
	
	/**
	 * Constructeur par défaut de {@link RulesBase}
	 */
	public RulesBase(){
		super();
	}

	/**
	 * Constructeur par recopie {@link RulesBase}
     * @param other
	 */
//	public RulesBase(RulesBase other){
//		super(other);
//	}
	
	/**
	 * Constructeur de {@link RulesBase}
	 * @param rules : List de {@link Rule}
	 */
	public RulesBase(List<Rule> rules) {
		super(rules);
	}
	
//	public List<Rule> getRules() {
//		return this.rules;
//	}
	
    /**
     *
     * @return
     */
    	
    @Override
	public String toString(){
		String chaine= "Base de règles : \n";
		for (Rule rule : this){
			chaine += "\t "+ rule.toString() +"\n";
		}
		return chaine;
	}
	
	/**
	 * Rajoute une Règle dans la base de Règles à partir d'une liste d'Antécédents et de Conséquences 
     * @param antecedents Liste d'Antécédents
     * @param consequence Liste de Conséquences
	 */
	public void addRule(List<Word> antecedents, List<Word> consequence){
		this.add(new Rule(antecedents, consequence));
	}
	
	/**
	 * Ajoute une règle dans la Base de Règles
	 * @param r : {@link Rule}
	 */
	public void addRule(Rule r){
		this.add(r);
	}
	
	
	/**
	 * Vérifie si une règle est dans la base de règles
	 * @return vrai si le fait est présent
	 * 
	 * TODO vérifier : mm chose que pour les fait pour les </<= et >/>= ?
	 * TODO vérifier l'exécution
	 */
//	public boolean contains(Rule rule){
//		return rules.contains(rule);
//	}

	/**
	 * Supprime une règle est dans la base de règles
	 * @return vrai si le fait est présent
	 * 
	 * TODO vérifier l'exécution
	 */
//	public boolean tryRemove(Rule rule){
//		return rules.remove(rule);
//	}
	
//	public Iterator<Rule> iterator() {
//		return rules.iterator();
//	}
	
}
