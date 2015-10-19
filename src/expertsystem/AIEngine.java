package expertsystem;

import java.util.List;

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
	public void forwardChaining(FactsBase BF) {
		boolean inf= true;	// sert pour savoir si on a fait une inférence durant le cycle
		int nbInf= 0;
		
		while(inf){
			inf= false;
			for (Rule rule : BR){
				boolean dec= true;
//				/*Antécédants des règles*/,
				for (Word wAnt : rule.getAntecedants()){
					while(dec){
						// TODO OBLIGATOIRE, corriger contains pour comparaison
						// TODO vérifier, je suppose que c'est ==, donc contains retourne vraie SSI mm nom et mm valeur
						if ( ( BF.contains(wAnt) // && /*valeur de f dans BF*/VF(f)!=/*Est-ce que ce ne serait pas == ? (erreur sur poly prof ?)*/ /*VA(wAnt,r)*/wAnt.isTrue() || !BF.contains(wAnt) ))
								) ) 
							dec= false;
					}
					
					if (dec){
//						Je prend tout les conséquence de la regle en cours
//						/*Conséquences des règles*/,
						for (Word wCons : rule.getConsequences() ){
							BF.addFact(wCons);
//							TODO BF.add({VC(m,r), m})   Je n'ai pas vraiment compris :( 
							BR.tryRemove(rule); /* Une règle se déclenche au plus une fois */
							
							inf= true;
							++nbInf;
							//TODO this.Mémoriser(r,nbInf) /* Pour l'explication TODO ???*/ 
						}
						
					}
					
				}
				
			}
		}
		System.out.println("Nb inférence chainage avant : "+ nbInf);
//		TODO retour et conclusion pour utilisateur (en passant par bridge-constructor)
	}
	
}
