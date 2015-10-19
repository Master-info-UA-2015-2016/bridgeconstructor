package expertsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Créer un fichier pour la classe Fact (les faits ?)
 */
//class Fact{
//	boolean value; // est-ce qu'on utilise un booléen ou un String : 
//				//	plusieurs types de sols, vrai/faux pour chaque type ou un seul fait avec le type ? 
//	String name;
//	
//	public Fact(String factName, boolean factVal){
//		name= factName;
//		value= factVal;
//	}
//}
/**
 * 
 * 
 * @author florian
 * 
 * TODO ajouter fonction qui recherche dans la base de faits quels ponts sont constructibles ou ajouter dans une liste de resultat les ponts possibles 
 */
public class FactsBase {
	List<Word> facts;
	// TODO ? créer une liste de noms et une liste de faits (sans noms ?), pour la recherche des faits
	
	/**
	 * Constructeur base de faits
	 */
	public FactsBase(){
		facts= new ArrayList<Word>();
	}
	
	public String toString(){
		String chaine= "Base de faits : \n";
		for (Word fact : facts){
			chaine += "\t "+ fact.toString() +"\n";
		}
		
		return chaine;
	}
	
	/**
	 * Ajoute un fait -une affirmation/négation- dans la base de faits, à partir de son nom et de sa valeur
	 * @author florian
	 * 
	 * @param factName nom du nouveau fait
	 * @param factVal valeur (vrai ou faux) du nouveau fait
	 */
	public void addFact(String factName, boolean factVal){
		facts.add(new Affirmation(factName, factVal));
	}
	
	/**
	 * Ajoute un fait -comparaison- dans la base de faits, à partir de son nom et de sa valeur
	 * @author florian
	 * 
	 * @param factName nom du nouveau fait
	 * @param factVal valeur (vrai ou faux) du nouveau fait
	 */
	public void addFact(Variable var, Operators op, int valCondition){
		facts.add(new Comparison(var, op, valCondition));
	}

	/**
	 * Ajoute un fait, déja existant, dans la base de faits
	 * @author florian
	 * 
	 * @param factName nom du nouveau fait
	 * @param factVal valeur (vrai ou faux) du nouveau fait
	 */
	public void addFact(Word fact){
		facts.add(fact);
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
		return facts.contains(fact);
	}
	
	/**
	 * TODO vérifier Utile ? 
	 * @param fact
	 * @return
	 */
//	public boolean isTrue(Word fact){
//		return false;
//	}
	
}
