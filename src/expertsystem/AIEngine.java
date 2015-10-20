package expertsystem;

import java.util.Iterator;

/**
 * La classe utilisera les règles ainsi que la base de faits
 * @see Environment pour décider quel pont scierait à la base
 */

public class AIEngine {
	private RulesBase BR;
	
	public AIEngine(RulesBase _BR){
		BR= _BR;
	}
	
	/**
	 * On sature la BF (version de base, on boucle sur BR (sans ordre partiel))
	 * On vérifie que l'on fait au moins une inférence par cycle, sinon arrêt
	 * TODO WARNING l'algo semble ne pas prendre en compte les OU dans les conditions des règles
	 * @author Florian
	 * 
	 * @param BR ensemble de règles
	 * @param demandables ensemble de faits
	 * @param BF ensemble de faits initiaux (Environnment)
	 * 
	 * TODO à implémenter : VF, VA et VC
	 * VF(f) valeur de f dans BF
	 * VA(m, r)  affirmation ou négation du mot m dans Ant.(r), r € BR TODO demander (a Ugo ?) ce que c'est, si ce n'est pas un boolean (car on le compare à VF(m) )
	 * VC(m,r) affirmation ou négation du mot m dans Cons.(r), r € BR
	 */
	public FactsBase forwardChaining(FactsBase BF) {
		boolean inf= true;	// sert pour savoir si on a fait une inférence durant le cycle
		int nbInf= 0;
		
		while(inf){
			inf= false;
			// on fait une copie de la BR pour faire les itérations dessus, et ainsi pouvoir modifier la BR pendant le parcours de sa copie
			RulesBase BRcpy= new RulesBase(BR);
			
			/* On en peut pas supprimer une règle si on a un itérateur dessus */
			for ( Rule rule : BRcpy){
				
//				/*Antécédants des règles*/
				boolean dec= true;

//				Iterator<Word> iter= rule.getAntecedants().iterator();
//				while ( iter.hasNext() && dec ){

				// TODO OBLIGATOIRE, corriger contains() pour comparaison
				// TODO vérifier, je suppose que c'est ==, donc contains retourne vraie SSI mm nom et mm valeur
				// pas optimal, car on continue de vérifier, même si dec est déjà à faux
				for (Word wAnt : rule.getAntecedants()){ 
//					Word wAnt= iter.next();
					System.out.println("Parcours les antécédents");
					if ( !BF.contains(wAnt) )// && /*BF c valeur de f dans BF*/VF(f)!=/*VA(wAnt,r)*/wAnt.isTrue() || !BF.contains(wAnt) ))
						dec= false;
				}
				if (dec){
//						Je prend tout les conséquence de la regle en cours
//						/*Conséquences des règles*/,
					for (Word wCons : rule.getConsequences() ){
						BF.addFact(wCons);
					}
					inf= true;
					++nbInf;
					//TODO this.Mémoriser(r,nbInf) /* Pour l'explication TODO ???*/ 

					BR.tryRemove(rule); /* Une règle se déclenche au plus une fois */
				}
				
			}
		}
		System.out.println("Nb inférence chainage avant : "+ nbInf);
//		TODO retour et conclusion pour utilisateur (en passant par bridge-constructor)	
		return BF;
	}

}
