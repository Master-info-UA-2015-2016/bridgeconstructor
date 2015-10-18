package expertsystem;

import java.util.List;

/*
 * Une règle, contient des antécédants séparées par des OU ou ET, et des conséquences, séparées par des ET
 * @author Florian
 * TODO comment implémenter les OU / ET, + parenthèses ? Doit ressembler aux opérations mathématiques ?
 */
public class Rule {
	private List<Word> ant;
	private List<Word> cons;

	public List<Word> getAntecedants() {
		return ant;
	}
	
	public List<Word> getConsequences() {
		return cons;
	}
	
}
