package expertsystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Une règle, contient des antécédants séparées par des OU ou ET, et des conséquences, séparées par des ET
 * @author Florian
 * TODO comment implémenter les OU / ET, + parenthèses ? Doit ressembler aux opérations mathématiques ?
 */
public class Rule {
	private List<Word> antecedents;
	private List<Word> consequences;
	
	public Rule(Collection<Word> antecedents, Collection<Word> consequences){
		this.antecedents= new ArrayList<Word>(antecedents);
		this.consequences= new ArrayList<Word>(consequences);
	}
	
	public String toString(){
		String s= "SI ";
		for (int i=0 ; i<antecedents.size() ; i++) {
			if(i > 0) s+= " ET ";
			Word antecedent = antecedents.get(i);
			s+= antecedent.toString();
		}
		s+= " ALORS ";
		for (int i=0 ; i<consequences.size() ; i++) {
			if(i > 0) s+= " ET ";
			Word consequence = consequences.get(i);
			s+= consequence.toString();
		}
		s+= ".";
		
		return s;
	}
	
	// ajouter si ET ou OU
	public void addAnt(Word ant){
		antecedents.add(ant);
	}
	
	public void addConsequences(Word cons){
		consequences.add(cons);
	}

	public List<Word> getAntecedants() {
		return antecedents;
	}
	
	public List<Word> getConsequences() {
		return consequences;
	}
	
}
