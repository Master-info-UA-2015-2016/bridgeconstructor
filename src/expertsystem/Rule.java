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
	
	public Rule(Collection<Word> ants, Collection<Word> cons){
		antecedents= new ArrayList<Word>(ants);
		consequences= new ArrayList<Word>(cons);
	}
	
	public String toString(){
		String chain= new String("SI ");
		for (Word ant : antecedents){
			chain+= ant.toString() +" ET ";
		}
		chain+= "(dernier ET à supprimer, revoir algo)";
		chain+= " ALORS ";
		
		for (Word cons : consequences){
			chain+= cons.toString() +" ET ";
		}
		chain+= "(dernier ET à supprimer, revoir algo)";
		chain+= ".";
		
		return chain;
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
