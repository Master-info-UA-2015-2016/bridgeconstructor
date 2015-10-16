package expertsystem;

import java.util.List;

/**
 * La classe utilisera les règles ainsi que la base de faits
 * @see Environment pour décider quel pont scierait à la base
 */

public class AIEngine {
	private FactsBase BF;
	
	/**
	 * On sature la BF (version de base, on boucle sur BR (sans ordre partiel))
	 * On vérifie que l'on fait au moins une inférence par cycle, sinon arrêt
	 * @author Florian
	 * 
	 * @param BR ensemble de règles (Environnment)
	 * @param demandables ensemble de faits
	 * @param BF ensemble de faits initiaux
	 * 
	 * VF(f) valeur de f dans BF
	 * VA(m, r)  affirmation ou négation du mot m dans Ant.(r), r € BR
	 * VC(m,r) affirmation ou négation du mot m dans Cons.(r), r € BR
	 */
	private void BFSaturation(/*RulesBase??*/List<Rule> BR/*(Environnment)*/, /*Antécédants des règles, crée fctn ou autre*/Word[] Ant, /*Antécédants des règles, crée fctn ou autre*/Word[] Cons) {
		boolean inf= true;
		int nbInf= 0;
		
		while(inf){
			inf= false;
			for (Rule rule : BR){
				boolean dec= true;
				for (/*Fait*/Word wAnt : Ant){
					while(dec){
						if ( ( BF.contains(wAnt) && VF(wAnt) != VA(wAnt,r) )|| !BF.contains(wAnt) )
							dec= false;
					}
					
					if (dec){
//						Je prend tout les conséquence de la regle en cours,
						for (/*Fait*/Word wCons : rule.getConsequences() ){
							BF.add(wCons);
//							TODO BF.add({VC(m,r), m})   Je n'ai pas vraiment compris :( 
							BR.remove(rule); /* Une règle se déclenche au plus une fois */
							
							inf= true;
							++nbInf;
							//TODO this.Mémoriser(r,nbInf) /* Pour l'explication TODO ???*/ 
						}
						
					}
					
				}
					
			}
		}
	}
	
	
	
	public boolean forwardChaining(){
		
		
		return true;
	}
}
