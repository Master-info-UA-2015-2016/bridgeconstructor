package expertsystem;

import java.util.Iterator;
import java.util.List;

import bridgeconstructor.Environment;

/**
 * La classe utilisera les règles ainsi que la base de faits
 * 
 * @see Environment pour décider quel pont scierait à la base
 */

public class AIEngine {
	private RulesBase RB;

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
		System.out.println("-------------------------------------------------------");

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
							.getVal())/* (tmp.getVal()).equals(wAnt.getVal()) */ ) // VF(f)!=VA(wAnt,r)
						dec = false;
				}

				if (dec) {
					// On ajoute toutes les conséquences de la règle car elle
					// est vraie
					for (Word wCons : rule.getConsequences()) {
						BF.add(wCons);
					}
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
	private RulesBase getRulesWithAntecedent(String factName) {
		RulesBase getAntecedent = new RulesBase();
		for (Rule rule : RB) {

			boolean b = false;
			for (Word W : rule.getAntecedents())
				if ((W.getName()).equals(factName))
					b = true;
			if (b)
				getAntecedent.add(rule);
		}
		return getAntecedent;
	}

	/**
	 * Retourne une base de règles, ces dernières ayant toutes pour conséquences
	 * au moins le fait A
	 * 
	 * @param factName
	 *            nom du fait
	 * @return RulesBase
	 */
	private RulesBase getRulesWithConsequent(String factName) {
		RulesBase getConsequent = new RulesBase();
		RB.stream().forEach((rule) -> {
			boolean b = false;
			for (Word W : rule.getConsequences())
				if ((W.getName()).equals(factName))
					b = true;
			if (b) {
				getConsequent.add(rule);
			}
		});
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

		System.out.println("Recherche de la liste de " + WList.size() + " buts par Chainage arrière");
		for (Word word : WList) {
			Word ver = backwardChaining(word.getName(), FB, asker);
			if (!ver.sameValue(word.getVal()))
				return false;
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
	 * @return boolean
	 */
	public Word backwardChaining(String goal, FactsBase FB, FactAsker asker) {
		System.out.println("Recherche de la valeur de -" + goal + "- par chainage arrière");

		Word goal_fact;
		boolean found = false;

		// 1er cas évident :
		goal_fact = FB.contains(goal);
		if (goal_fact != null) {
			System.out.println("la BF contient : " + goal);
			found = true;
		} else {
			// 2e cas : rechercher si b est déductible à partir de BR u BF
			System.out.println("\tla BF ne contient pas " + goal + ", recherche de sa valeur à partir des règles");
			RulesBase rules_getting_goal_in_consequence = getRulesWithConsequent(goal);
			System.out.println("\n Règles contenant '" + goal + "' : " + rules_getting_goal_in_consequence);

			/*
			 * TODO attention gestion de la cohérence, si une valeur est
			 * trouvée, les autres règles qui auraient puent contedire cette
			 * valeur sont ignorées
			 */
			for (Iterator<Rule> it = rules_getting_goal_in_consequence.iterator(); it.hasNext() && !found;) {
				Rule rule = it.next();
				System.out.println("Essai pour prouver que la règle " + rule + " est vraie");
				found = backwardOnList(rule.getAntecedents(), FB, asker);
				if (found) {
					List<Word> conseq = rule.getConsequences();
					for (Word W : conseq) {
						FB.add(W);
						System.out.println("Ajout de " + W + " dans la base de faits");
					}
				}
			}
		}

		// 3ème cas : sinon voir si b est demandable
		if (!found && FB.isFactDemandable(goal)) {
			// Si b est demandable
			// Poser la question b ?
			// Demande à l'utilisateur s'il connait la valeur de goal :

			// goal_fact = response(goal); // VRAI, FAUX, ou inconnu (Pas
			// vraiment ici)
			goal_fact = asker.askFactValueToUser(goal);
			if (goal_fact != null) {
				System.out.println("'" + goal_fact + "' ajouté à la base de faits");
				FB.add(goal_fact);
			}

		}
		// Dans tous les cas mémoriser et ajouter à la BF FAUX, dans 1er cas,
		// déjà dans BF

		if (found == true) {
			System.out.println("Valeur trouvée : " + goal_fact);
			FB.add(goal_fact);
		}
		return goal_fact;
	}

	/**
	 * Chainage mixte sur une LISTE de buts
	 * 
	 * @param WList
	 *            ensemble de buts à vérifier tous
	 * @param FB
	 *            : {@link FactsBase}
	 * @return boolean
	 */
	private boolean mixtOnList(List<Word> WList, FactsBase FB, FactAsker asker) {
		// System.out.println("------------------------------------------------");
		// System.out.println("| RECHERCHE DES BUTS, par Chainage arrière |");
		// System.out.println("------------------------------------------------");

		System.out.println("Recherche de la liste de " + WList.size() + " buts par Chainage arrière");
		for (Word word : WList) {
			Word ver = mixtChaining(word.getName(), FB, asker);
			if (!ver.sameValue(word.getVal()))
				return false;
		}
		return true;
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
	public Word mixtChaining(String goal, FactsBase FB, FactAsker asker) {
		System.out.println("Recherche de la valeur de -" + goal + "- par chainage arrière");

		Word goal_fact;
		boolean found = false;

		// 1er cas évident :
		goal_fact = FB.contains(goal);
		if (goal_fact != null) {
			System.out.println("la BF contient : " + goal);
			found = true;
		} else {
			// 2e cas : rechercher si b est déductible à partir de BR u BF
			System.out.println("\tla BF ne contient pas " + goal + ", recherche de sa valeur à partir des règles");
			RulesBase rules_getting_goal_in_consequence = getRulesWithConsequent(goal);
			System.out.println("\n Règles contenant '" + goal + "' : " + rules_getting_goal_in_consequence);

			/*
			 * TODO attention gestion de la cohérence, si une valeur est
			 * trouvée, les autres règles qui auraient puent contedire cette
			 * valeur sont ignorées
			 */
			for (Iterator<Rule> it = rules_getting_goal_in_consequence.iterator(); it.hasNext() && !found;) {
				Rule rule = it.next();
				System.out.println("Essai pour prouver que la règle " + rule + " est vraie");
				found = mixtOnList(rule.getAntecedents(), FB, asker);

				if (found) {
					List<Word> conseq = rule.getConsequences();
					for (Word W : conseq) {
						FB.add(W);
						System.out.println("Ajout de " + W + " dans la base de faits");
					}
				}
			}
		}

		// 3ème cas : sinon voir si b est demandable
		if (!found && FB.isFactDemandable(goal)) {
			// Si b est demandable
			// Poser la question b ?
			// Demande à l'utilisateur s'il connait la valeur de goal :

			// goal_fact = response(goal); // VRAI, FAUX, ou inconnu (Pas
			// vraiment ici)
			goal_fact = asker.askFactValueToUser(goal);
			if (goal_fact != null) {
				System.out.println("'" + goal_fact + "' ajouté à la base de faits");
				FB.add(goal_fact);
			}

		}
		// Dans tous les cas mémoriser et ajouter à la BF FAUX, dans 1er cas,
		// déjà dans BF

		if (found == true) {
			System.out.println("Valeur trouvée : " + goal_fact);
			FB.add(goal_fact);
		}

		// Chainage avant sur la règle
		RulesBase RB_of_goal_in_antecedent;
		RB_of_goal_in_antecedent = new RulesBase(getRulesWithAntecedent(goal));
		AIEngine AI_for_forward = new AIEngine(RB_of_goal_in_antecedent);
		FB = AI_for_forward.forwardChaining(FB);

		return goal_fact;
	}

	/**
	 * 
	 * @param FB
	 * @return
	 */
	public FactsBase purge(FactsBase FB) {
		FactsBase base = FB;
		boolean find;
		Affirmation A;
		Comparison C;
		int i = 0;
		while (i < base.size()) {
			find = false;
			Word W = base.get(i);
			System.out.println(W);
			// Dans le cas : Si c'est une Affirmation
			if(W.getClass() == Affirmation.class) {
				A = (Affirmation) W;
				// int j=i+1;
				for (int j = i + 1; j < base.size(); j++) {
					if(base.get(j).getClass() == Affirmation.class) {
						Affirmation ANext = (Affirmation) base.get(j);
						if (A.equals(ANext)) {
							System.out.println("Occurence de " + A + " trouvé (Purged)");
							base.remove(j);
							find = true;
							break;
						}
					}
				}
			} else
				// Dans le cas : Si c'est une Comparaison
				if(W.getClass() == Comparison.class) {
					C = (Comparison) W;
					// int j=i+1;
					for (int j = i + 1; j < base.size(); j++) {
						if(base.get(j).getClass() == Comparison.class) {
							Comparison CNext = (Comparison) base.get(j);
							if (C.equals(CNext)) {
								System.out.println("Occurence de " + C + "trouvé");
								base.remove(j);
								find = true;
								break;
							}
						}
					}
				}
			if (!find)
				i++;
		}
		return base;
	}
}
