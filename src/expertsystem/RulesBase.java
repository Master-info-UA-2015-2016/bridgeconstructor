package expertsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Gestion de la Base de Règles
 */
public class RulesBase extends ArrayList<Rule>{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut de {@link RulesBase}
	 */
	public RulesBase(){
		super();
	}
	
	/**
	 * Constructeur de {@link RulesBase}
	 * @param rules : List de {@link Rule}
	 */
	public RulesBase(List<Rule> rules) {
		super(rules);
	}
	
    /**
     *
     * @return
     */
    	
    @Override
	public String toString(){
		String chaine= "Base de règles : \n";
        chaine = this.stream().map((rule) -> "\t "+ rule.toString() +"\n").reduce(chaine, String::concat);
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
     *
     * @return
     */
    @Override
    public Object clone() {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
