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
	 * Procédure VERIF
	 * @param W : ensemble de buts à vérifier tous
	 * @param FB : {@link FactsBase}
	 * @return boolean
	 */
	private boolean VERIF(List<Word> WList, FactsBase FB) {
		boolean ver = true;
		for(Word W : WList) {
			ver = backwardChaining(W, FB);
			if(ver == false) break;	
		}
		return ver;
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
				System.out.println("Parcours des antécédents");
				for (Word wAnt : rule.getAntecedants()){ 
//					Word wAnt= iter.next();
					
					Word tmp= BF.contains(wAnt);
					if ( tmp == null || ! (tmp.getVal()).equals(wAnt.getVal()) ) // /*BF c valeur de f dans BF*/VF(f)!=/*VA(wAnt,r)*/
						dec= false;
					
				}
				if (dec){
//						Je prend tout les conséquence de la regle en cours
//						/*Conséquences des règles*/,
					for (Word wCons : rule.getConsequences() ){
						BF.add(wCons);
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
	
	/**
	 * Retourne une base de règles, ces dernières ayant toutes pour conséquences au moins le fait A
	 * @param A : Fait
	 * @return RulesBase
	 */
	private RulesBase getRulesWithConsequent(Word A) {
		RulesBase RB = new RulesBase(BR);
		for(int i = 0 ; i < RB.rules.size() ; i++) {
			Rule R = RB.rules.get(i);
			boolean b = false;
			for(Word W : R.getConsequences())
				if(W.equals(A)) 
					b = true;
			if(!b)
				RB.rules.remove(i);
		}
		return RB;
	}
	
	/**
	 * Chaînage Arrière - Procédure DEMO
	 * @param A : But récursivement établi (b dans l'exemple)
	 * @param FB : La Base de Faits
	 * @return boolean 
	 */
	public boolean backwardChaining(Word W, FactsBase FB) {
		// La procédure devrait s'appeler DEMO...
		RulesBase RB = new RulesBase(BR);
		
		boolean dem = false;
		// 1er cas évident :
		if(FB.contains(W) != null) dem = true;
		// 2eme cas : rechercher si b déductible à partir de BR U BF
		for(Rule R : getRulesWithConsequent(W)) {	// non optimisé
			dem = VERIF(R.getAntecedants(), FB);
			if(dem) break;
		}
		// 3ème cas : sinon voir si b est demandable
		if(dem == false && FB.isFactDemandable(W)) {
						// Si b est demandable
			Word fact= FB.contains(W);
			if (fact != null){
				// Alors fact n'est pas inconnu, on test si il est vrai
				dem = (W.getVal() == fact.getVal() );
			}
			else dem= false; 
				
			// Poser la question b ?
			// dem = reponse(b)				VRAI, FAUX, ou inconnu
		}
		// Dans tous les cas mémoriser et ajouter à la BF
		if(dem == true)
			FB.add(W);
		// return dem ?
		return dem;
	}

}
