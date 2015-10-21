package bridgeconstructor;

import java.util.ArrayList;

// Pour lecture XML
import java.io.*;
//import org.jdom.*;
//import org.jdom.input.*;
//import org.jdom.filter.*;
//import java.util.List;
//import java.util.Iterator;


import expertsystem.Affirmation;
import expertsystem.RulesBase;
import expertsystem.Word;


public class BridgeRules {
	private static RulesBase bridge_rules;
	
	public static void initRulesBase() {
		bridge_rules = new RulesBase();
		
		// TODO Création de tous les antécédents
		ArrayList<Word> antecedents = new ArrayList<>();
		// TODO Créations de toutes les conséquences
		ArrayList<Word> consequents = new ArrayList<>();
		// TODO Lié antécédents et conséquences pour faire des règles
		
		// TODO les rajouter à bridge_rules - Base de Règle initiale
		// Création d'une règle
		bridge_rules.addRule(antecedents, consequents);
		
		//BASE DE REGLES
		/// Règle 1 :
			ArrayList<Word> listAnt= new ArrayList<Word>();
				Affirmation fire= new Affirmation("fire", true);
			listAnt.add(fire);
		
			ArrayList<Word> listCons= new ArrayList<Word>();
				Affirmation rail= new Affirmation("TRAINS ?", false);
			listCons.add(rail);
				
		RulesBase BR1= new RulesBase();
		BR1.addRule(listAnt, listCons);
		
		System.out.println("Base de Règles Initiale : " + bridge_rules);
	}
	
	public static RulesBase initRulesBase(String filename){
		org.jdom.Document document;
		Element racine;
		
	    SAXBuilder sxb = new SAXBuilder();
	    try
	    {
	       //On crée un nouveau document JDOM avec en argument le fichier XML
	       //Le parsing est terminé ;)
	       document = sxb.build(new File(filename));
	    }
	    catch(Exception e){}

	    //On initialise un nouvel élément racine avec l'élément racine du document.
	    racine = document.getRootElement();

	    return bridge_rules;
	}
}
