package expertsystem;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * La classe utilisera les règles ainsi que la base de faits
 * @see Environment pour décider quel pont scierait à la base
 */

public class AIEngine extends Interface {
	private RulesBase BR;
	
    /**
     *
     * @param _BR
     */
    public AIEngine(RulesBase _BR){
		BR= _BR;
	}

	/**
	 * On sature la BF (version de base, on boucle sur BR (sans ordre partiel))
	 * On vérifie que l'on fait au moins une inférence par cycle, sinon arrêt
	 * @author Florian
	 * 
	 * @param BR ensemble de règles
	 * @param BF ensemble de faits initiaux (Environnment)
	 * 
	 * VF(f) valeur de f dans BF
	 * VA(m, r)  affirmation ou négation du mot m dans Ant.(r), r € BR
	 * VC(m,r) affirmation ou négation du mot m dans Cons.(r), r € BR
     * @return la base de faits avec le chainage avant appliqué
	 */
	public FactsBase forwardChaining(FactsBase BF) {
		boolean inf= true;	// pour savoir si on a fait une inférence durant le cycle
		int nbInf= 0;

		System.out.println("-------------------------------------------------------");
		System.out.println("|   SATURATION DE LA BASE DE FAITS : Chainage avant   |");
		System.out.println("-------------------------------------------------------");
		
		while(inf){
			inf= false;
			// on fait une copie de la BR, on peut alors la modifier pendant le parcours de sa copie
			RulesBase BRcpy= new RulesBase(BR);
			
			for ( Rule rule : BRcpy){ // parcours de toutes les règles de la copies => Parcours en Largeur
				System.out.println("Recherche applicable : " + rule);
				
//				/*Antécédants des règles*/
				boolean dec= true;

                for (Iterator<Word> it = rule.getAntecedants().iterator() ; it.hasNext() && dec;) {
                    Word wAnt = it.next();
                    
                    Word tmp= BF.contains(wAnt);
                    if ( tmp == null || ! wAnt.sameValue(tmp.getVal())/*(tmp.getVal()).equals(wAnt.getVal())*/ ) // VF(f)!=VA(wAnt,r)
                        dec= false;
                }
                
				if (dec){
//					On ajoute toutes les conséquences de la règle car elle est vraie
					for (Word wCons : rule.getConsequences() ) {
						BF.add(wCons);
					}
					inf= true;
					++nbInf;
					//TODO this.Mémoriser(r,nbInf) /* Pour l'explication ???*/ 
					System.out.println("\tRègle appliquée");
					BR.remove(rule); /* Une règle se déclenche au plus une fois */
				}
				
			}
		}
		System.out.println("Nb inférence chainage avant : "+ nbInf);
		return BF;
	}
	
	/**
	 * Retourne une base de règles, ces dernières ayant toutes pour conséquences au moins le fait A
	 * @param factName nom du fait
	 * @return RulesBase
	 */
	private RulesBase getRulesWithConsequent(String factName) {
		RulesBase getConsequent = new RulesBase();
		for(Rule rule : BR) {
			
			boolean b = false;
			for(Word W : rule.getConsequences())
				if((W.getName()).equals(factName))
					b = true;
			if(b)
				getConsequent.add(rule);
		}
		return getConsequent;
	}
    
    /**
	 * Retourne une base de règles, ces dernières ayant toutes pour conséquences au moins le fait A
	 * @param fact fait
	 * @return RulesBase
	 */
	private RulesBase getRulesWithConsequent(Word fact) {
        return getRulesWithConsequent(fact.getName());
    }
    
    private Word response(String goal){
            System.out.println("\n Veuillez entrer la valeur de : "+ goal);
            Scanner sc; sc= new Scanner(System.in);           
            String answerValue= sc.next();
            
            System.out.println("\tEst-ce que '"+ answerValue +"' est correcte ? true/false");
            boolean answer= sc.nextBoolean();
            if (answer){
                try{
                    float res= Float.parseFloat(answerValue);
                    return new Comparison(goal, Operators.equal, res);
                }catch(NumberFormatException NFE){
                    boolean res= Boolean.parseBoolean(goal);
                    return new Affirmation(goal, res);
                }
            }
            else return response(goal); // récursivité
    }
	
	
	/**
	 * Procédure VERIF
	 * @param WList ensemble de buts à vérifier tous
	 * @param FB : {@link FactsBase}
	 * @return boolean
	 */
	private boolean backwardOnList(List<Word> WList, FactsBase FB) {
//		System.out.println("------------------------------------------------");
//		System.out.println("|   RECHERCHE DES BUTS, par Chainage arrière   |");
//		System.out.println("------------------------------------------------");
		
		System.out.println("Recherche de la liste de "+ WList.size() +" buts par Chainage arrière");
		for(Word word : WList) {
			Word ver = backwardChaining(word.getName(), FB);
			if( !ver.sameValue(word.getVal())) return false;
		}
		return true;
	}
	
	/**
	 * Chaînage Arrière - Procédure DEMO
	 * @param goal : But récursivement établi (b dans l'exemple)
	 * @param FB : La Base de Faits
	 * @return boolean 
	 */
	public Word backwardChaining(String goal, FactsBase FB) {    
		System.out.println("Recherche de la valeur de -"+ goal +"- par chainage arrière");
	
        Word goal_fact;
		boolean found = false;
        
		// 1er cas évident :
        goal_fact= FB.contains(goal);
		if(goal_fact != null) {
            System.out.println("la BF contient : "+ goal);
            found = true;
        }
        else {
            // 2e cas : rechercher si b est déductible à partir de BR u BF
            System.out.println("\tla BF ne contient pas "+ goal +", recherche de sa valeur à partir des règles");
            RulesBase rules_getting_goal_in_consequence= getRulesWithConsequent(goal);
            System.out.println("\n Règles contenant '"+ goal +"' : "+ rules_getting_goal_in_consequence);
            
            /* TODO attention gestion de la cohérence, si une valeur est trouvée,
                les autres règles qui auraient puent contedire cette valeur sont ignorées */
            for (Iterator<Rule> it = rules_getting_goal_in_consequence.iterator(); it.hasNext() && !found;) {
                Rule rule = it.next();
                System.out.println("Essai pour prouver que la règle "+ rule +" est vraie");
                found = backwardOnList(rule.getAntecedants(), FB);
                if (found){
                    List<Word> conseq= rule.getConsequences();
                    for(Word W : conseq) {
                        FB.add(W);
                        System.out.println("Ajout de " + W + " dans la base de faits");
                    }
                }
            }
        }
            
		// 3ème cas : sinon voir si b est demandable
		if(!found  && FB.isFactDemandable(goal)) {
						// Si b est demandable
			// Poser la question b ?
                // Demande à l'utilisateur s'il connait la valeur de goal :

            //goal_fact = response(goal); // VRAI, FAUX, ou inconnu (Pas vraiment ici)
			goal_fact = askFactValueToUser(goal, null);
            if (goal_fact != null) {
                System.out.println("'"+ goal_fact +"' ajouté à la base de faits");
                FB.add(goal_fact);
            }
                           
        /// OLD
//			Word fact= FB.contains(goal);
//			if (fact != null){
//				// Alors fact n'est pas inconnu, on test si il est vrai
//				found = ( (goal.getVal()).equals( fact.getVal() ) );
//			}
//			else found= false; 
            
		}
		// Dans tous les cas mémoriser et ajouter à la BF FAUX, dans 1er cas, déjà dans BF
        
		if(found == true) {
            System.out.println("Valeur trouvée : "+ goal_fact);
			FB.add(goal_fact);
        }
		return goal_fact;
	}

}
