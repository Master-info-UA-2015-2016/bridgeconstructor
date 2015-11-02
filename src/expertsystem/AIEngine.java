package expertsystem;

import java.util.Iterator;
import java.util.List;

/**
 * La classe utilisera les règles ainsi que la base de faits
 * 
 * @see Environment pour décider quel pont scierait à la base
 */

public class AIEngine {
	private final RulesBase RB;

	/**
	 * Constructeur du Systeme Expert
	 * 
	 * @param _RB
	 *            base de règle du Systeme Expert
	 */
	public AIEngine(RulesBase _RB) {
		RB = _RB;
	}

	/**
	 * On sature la BF (version de base, on boucle sur BR (sans ordre partiel))
	 * On vérifie que l'on fait au moins une inférence par cycle, sinon arrêt
	 * 
	 * @author Florian
	 * @param BF
	 *            ensemble de faits initiaux (Environnment)
	 * 
	 *            VF(f) valeur de f dans BF VA(m, r) affirmation ou négation du
	 *            mot m dans Ant.(r), r € BR VC(m,r) affirmation ou négation du
	 *            mot m dans Cons.(r), r € BR
	 * @return la base de faits avec le chainage avant appliqué
	 */
	public FactsBase forwardChaining(FactsBase BF) {
		boolean inf = true; // pour savoir si on a fait une inférence durant le
							// cycle
		int nbInf = 0;

		System.out.println("-------------------------------------------------------");
		System.out.println("|   SATURATION DE LA BASE DE FAITS : Chainage avant   |");

		while (inf) {
			inf = false;
			// on fait une copie de la BR, on peut alors la modifier pendant le
			// parcours de sa copie
			RulesBase BRcpy = new RulesBase(RB);

			for (Rule rule : BRcpy) { // parcours de toutes les règles de la
										// copies => Parcours en Largeur
				System.out.println("Recherche applicable : " + rule);

				// /*Antécédants des règles*/
				boolean dec = true;

				for (Iterator<Word> it = rule.getAntecedents().iterator(); it.hasNext() && dec;) {
					Word wAnt = it.next();

					Word tmp = BF.contains(wAnt);
					if (tmp == null || !wAnt.sameValue(tmp
							.getVal())/* (tmp.getVal()).equals(wAnt.getVal()) */ ) { // VF(f)!=VA(wAnt,r)
                        dec = false;
                    }
				}

				if (dec) {
                    // On ajoute toutes les conséquences de la règle car elle
                    // est vraie
                    rule.getConsequences().stream().forEach((wCons) -> {
                        BF.add(wCons);
                    });
					inf = true;
					++nbInf;
					// TODO this.Mémoriser(r,nbInf) /* Pour l'explication ???*/
					System.out.println("\tRègle appliquée");
					RB.remove(
							rule); /* Une règle se déclenche au plus une fois */
				}

			}
		}
		System.out.println("Nb inférence chainage avant : " + nbInf);
		return BF;
	}

	/**
	 * Retourne une base de règles, ces dernières ayant toutes pour conséquences
	 * au moins le fait A
	 * 
	 * @param factName
	 *            nom du fait
	 * @return RulesBase
	 */
	private RulesBase getRulesWithAntecedent(Word fact) {
		RulesBase getAntecedent = new RulesBase();
        RB.stream().forEach((rule) -> {
            boolean b = false;
            for (Word W : rule.getAntecedents()) {
                if (W.equals(fact)) {
                    b = true;// TODO à vérifier
                }
            }
            if (b) {
                getAntecedent.add(rule);
            }
        });
		System.out.println("\n Règles contenant '" + fact + "' en prémisse : " + getAntecedent);
		return getAntecedent;
	}

	/**
	 * Retourne une base des règles contenant le nom d'un fait donné en conséquence
	 * 
	 * @param factName nom du fait
	 * @return RulesBase
	 */
	private RulesBase getRulesWithConsequent(String factName) {
		RulesBase getConsequent = new RulesBase();
		RB.stream().forEach((rule) -> {
			boolean b = false;
			for (Word W : rule.getConsequences()) {
                if ((W.getName()).equals(factName)){
                    b = true;
                }
            }
			if (b) {
				getConsequent.add(rule);
			}
		});
		System.out.println("\n Règles contenant '" + factName + "' en conséquence : " + getConsequent);
		return getConsequent;
	}

	/**
	 * Procédure VERIF
	 * 
	 * @param WList
	 *            ensemble de buts à vérifier tous
	 * @param FB
	 *            : {@link FactsBase}
	 * @return boolean
	 */
	private boolean backwardOnList(List<Word> WList, FactsBase FB, FactAsker asker) {
		// System.out.println("------------------------------------------------");
		// System.out.println("| RECHERCHE DES BUTS, par Chainage arrière |");
		// System.out.println("------------------------------------------------");

		System.out.println("    Recherche de la liste de " + WList.size() + " buts par Chainage arrière");
		for (Word word : WList) {
			Word ver = backwardChaining(word.getName(), FB, asker, false);
			if (!ver.sameValue(word.getVal())) {
                return false;
            }
		}
		return true;
	}

	/**
	 * Chainage mixte sur une LISTE de buts
	 * 
	 * @param WList ensemble de buts à vérifier tous
	 * @param FB {@link FactsBase}
	 * @return boolean
	 */
	private boolean mixtOnList(List<Word> WList, FactsBase FB, FactAsker asker) {
//		System.out.println("    Recherche de la liste de " + WList.size() + " buts par Chainage mixte");
		for (Word word : WList) {
			Word ver = backwardChaining(word.getName(), FB, asker, true);
			if (ver == null || !word.sameValue(ver.getVal())) {
                return false;
            }
		}
		return true;
	}

	/**
	 * Chaînage Arrière - Procédure DEMO
	 * 
	 * @param goal
	 *            But dont on cherche la valeur
	 * @param FB
	 *            : La Base de Faits
	 * @param asker
	 *            classe permettant de demander les faits demandables à
	 *            l'utilisateur
     * @param isMixt
	 * @return boolean
	 */
	public Word backwardChaining(String goal, FactsBase FB, FactAsker asker, boolean isMixt) {
		if (isMixt) {
            System.out.println("---Recherche de la valeur de -" + goal + "- par chainage mixte---");
        } else {
            System.out.println("---Recherche de la valeur de -" + goal + "- par chainage arrière---");
        }

		boolean found = false;
		Word goal_fact;

		// 1er cas évident :
		goal_fact = FB.contains(goal);
		if (goal_fact != null) {
			System.out.println("la BF contient : " + goal);
			found = true;
		} else {
			// 2e cas : rechercher si b est déductible à partir de BR u BF
			System.out.println("\tla BF ne contient pas " + goal + ", recherche de sa valeur à partir des règles");

			/*
			 * TODO attention gestion de la cohérence, si une valeur est
			 * trouvée, les autres règles qui auraient puent contedire cette
			 * valeur sont ignorées
			 */
            RulesBase rules_getting_goal_in_consequence = getRulesWithConsequent(goal);
			for (Iterator<Rule> it = rules_getting_goal_in_consequence.iterator(); it.hasNext() && !found;) {
				Rule rule = it.next();
				System.out.println("Essai pour prouver que la règle " + rule + " est vraie");
                if (isMixt) {
                    found = mixtOnList(rule.getAntecedents(), FB, asker);
                } else {
                    found = backwardOnList(rule.getAntecedents(), FB, asker);
                }
                
				if (found) {
					List<Word> conseq = rule.getConsequences();
					for (Word cons : conseq) {
                        if ((cons.getName()).equals(goal)) {
                            goal_fact= cons;
                        }
						FB.add(cons);
						System.out.println("Ajout de " + cons + " dans la base de faits");
					}
				}
			}

            // 3ème cas : sinon voir si b est demandable
            if (!found && FB.isFactDemandable(goal)) {
                // Si b est demandable;  Poser la question b ? 
                // Demande à l'utilisateur s'il connait la valeur de goal
                goal_fact = asker.askFactValueToUser(goal);
                if (goal_fact != null) {
                    System.out.println("'" + goal_fact + "' ajouté à la base de faits");
                    FB.add(goal_fact);
                }
            }
		}
		// Dans tous les cas mémoriser et ajouter à la BF FAUX, dans 1er cas,
		// déjà dans BF

		if (found == true) {
			System.out.println("Valeur trouvée : " + goal_fact);
		}
        
        // Chainage avant avec le fait trouvé si on est en chainage mixte
        if (isMixt && goal_fact != null) {
            forwardOnRulesWithAntecedent(goal_fact, FB);
        }
        
		return goal_fact;
	}
    
    // CHAINAGE MIXTE //
    
    private void forwardOnRulesWithAntecedent(Word fact, FactsBase FB) {
		// Chainage avant sur la règle
		RulesBase RB_of_goal_in_antecedent;
		RB_of_goal_in_antecedent = new RulesBase(getRulesWithAntecedent(fact));
		AIEngine AI_for_forward = new AIEngine(RB_of_goal_in_antecedent);
		FB = AI_for_forward.forwardChaining(FB);
    }

	/**
	 * Chaînage mixte sur UN but
	 * 
	 * @param goal
	 *            But dont on cherche la valeur
	 * @param FB
	 *            : La Base de Faits
	 * @param asker
	 *            classe permettant de demander les faits demandables à
	 *            l'utilisateur
	 * @return boolean
	 */
//	public Word mixtChaining(String goal, FactsBase FB, FactAsker asker) {
//		System.out.println("---Recherche de la valeur de -" + goal + "- par chainage mixte---");
//
//		Word goal_fact;
//		boolean found = false;
//
//		// 1er cas évident :
//		goal_fact = FB.contains(goal);
//		if (goal_fact != null) {
//			System.out.println("la BF contient : " + goal);
//			found = true;
//		} else {
//			// 2e cas : rechercher si b est déductible à partir de BR u BF
//			System.out.println("\tla BF ne contient pas " + goal + ", recherche de sa valeur à partir des règles");
//			RulesBase rules_getting_goal_in_consequence = getRulesWithConsequent(goal, goalFact);
//			System.out.println("\n Règles contenant '" + goal + "' : " + rules_getting_goal_in_consequence);
//
//			/*
//			 * TODO attention gestion de la cohérence, si une valeur est
//			 * trouvée, les autres règles qui auraient puent contedire cette
//			 * valeur sont ignorées
//			 */
//			for (Iterator<Rule> it = rules_getting_goal_in_consequence.iterator(); it.hasNext() && !found;) {
//				Rule rule = it.next();
//				System.out.println("Essai pour prouver que la règle " + rule + " est vraie");
//				found = mixtOnList(rule.getAntecedents(), FB, asker);
//
//				if (found) {
//					List<Word> conseq = rule.getConsequences();
//					for (Word W : conseq) {
//						FB.add(W);
//						System.out.println("Ajout de " + W + " dans la base de faits");
//					}
//				}
//			}
//		}
//
//		// 3ème cas : sinon voir si b est demandable
//		if (!found && FB.isFactDemandable(goal)) {
//			// Si b est demandable
//			// Poser la question b ?
//			// Demande à l'utilisateur s'il connait la valeur de goal :
//
//			// goal_fact = response(goal); // VRAI, FAUX, ou inconnu (Pas
//			// vraiment ici)
//			goal_fact = asker.askFactValueToUser(goal);
//			if (goal_fact != null) {
//				System.out.println("'" + goal_fact + "' ajouté à la base de faits");
//				FB.add(goal_fact);
//			}
//
//		}
//		// Dans tous les cas mémoriser et ajouter à la BF FAUX, dans 1er cas,
//		// déjà dans BF
//
//		if (found == true) {
//			System.out.println("Valeur trouvée : " + goal_fact);
//		}
//    
//        return goal_fact;
//	}
}
