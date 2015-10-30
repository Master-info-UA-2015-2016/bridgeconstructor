package expertsystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Une règle, contient des antécédants séparées par des OU ou ET, et des conséquences, séparées par des ET
 * @author Florian
 * TODO comment implémenter les OU / ET, + parenthèses ? Doit ressembler aux opérations mathématiques ?
 */

/**
 *
 * @author Florian
 */

public class Rule {
	private List<Word> antecedents;
	private List<Word> consequences;
	
    /**
     *
     * @param antecedents
     * @param consequences
     */
    public Rule(Collection<Word> antecedents, Collection<Word> consequences){
		this.antecedents= new ArrayList<Word>(antecedents);
		this.consequences= new ArrayList<Word>(consequences);
	}
	
    /**
     *
     * @return
     */
    public String toString(){
		String s= "IF ";
		for (int i=0 ; i<antecedents.size() ; i++) {
			if(i > 0) s+= " AND ";
			Word antecedent = antecedents.get(i);
			s+= antecedent.toString();
		}
		s+= " THEN ";
		for (int i=0 ; i<consequences.size() ; i++) {
			if(i > 0) s+= " AND ";
			Word consequence = consequences.get(i);
			s+= consequence.toString();
		}
		s+= ".";
		
		return s;
	}
	
	// ajouter si ET ou OU

    /**
     *
     * @param ant
     */
    	public void addAnt(Word ant){
		antecedents.add(ant);
	}
	
    /**
     *
     * @param cons
     */
    public void addConsequences(Word cons){
		consequences.add(cons);
	}

    /**
     *
     * @return
     */
    public List<Word> getAntecedants() {
		return antecedents;
	}
	
    /**
     *
     * @return
     */
    public List<Word> getConsequences() {
		return consequences;
	}
	
}
