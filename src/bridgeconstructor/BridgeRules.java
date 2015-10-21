package bridgeconstructor;

import java.util.ArrayList;

//Pour lecture XML
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


import java.io.*;


import expertsystem.Affirmation;
import expertsystem.RulesBase;
import expertsystem.Word;


public class BridgeRules {
	private static RulesBase bridge_rules;
	
	public static RulesBase initRulesBase() {
		bridge_rules = new RulesBase();
		
//		// TODO Création de tous les antécédents
//		ArrayList<Word> antecedents = new ArrayList<Word>();
//		// TODO Créations de toutes les conséquences
//		ArrayList<Word> consequents = new ArrayList<Word>();
//		// TODO Lié antécédents et conséquences pour faire des règles
//		
//		// TODO les rajouter à bridge_rules - Base de Règle initiale
//		// Création d'une règle
//		bridge_rules.addRule(antecedents, consequents);
//		
		//BASE DE REGLES
		/// Règle 1 :
//			ArrayList<Word> listAnt= new ArrayList<Word>();
//				Affirmation fire= new Affirmation("fire", true);
//			listAnt.add(fire);
//		
//			ArrayList<Word> listCons= new ArrayList<Word>();
//				Affirmation rail= new Affirmation("TRAINS ?", false);
//			listCons.add(rail);
				
		RulesBase BR1= new RulesBase();
//		BR1.addRule(listAnt, listCons);
		System.out.println("Base de Règles Initiale : " + bridge_rules);
		
		BridgeRules.initFromXML("/home/florian/git/bridgeconstructor/bin/ressources/bridge_rules.xml");
		
		return bridge_rules;
	}
	

//	public static RulesBase initRulesBase(String filename) {
//		ifstream xml= new ifstream(filename);
//
//		if (xml.canRead() && xml.isFile()){
//			xml.
//		}
//		
//	    return bridge_rules;
//	}
	
	public static void initFromXML(String filename){
		
		try {
	
			File fXmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = (Document) dBuilder.parse(fXmlFile);
					
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
	
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					
			NodeList rules = ((org.w3c.dom.Document) doc).getElementsByTagName("bridge_rule");

			
			System.out.println("----------------------------");
			System.out.println("Parcours des règles");
//			BOUCLE sur les Règles
			for (int i = 0; i < rules.getLength(); ++i) {
				Node rule = rules.item(i);
				
				NodeList antecedents= ((org.w3c.dom.Element)rule).getElementsByTagName("antecedent");
				ArrayList<Word> listAnt= new ArrayList<Word>(); // déclaration de la liste d'antécédents à créer
				
				System.out.println("\tParcours des antecedents");
				for (int j = 0; j < antecedents.getLength(); ++j) {
					Node antecedent = antecedents.item(j);
				
				//		BOUCLE sur les Antécédents					
//					System.out.println("\t\tCurrent Element :" + antecedent.getNodeName());
					if (antecedent.getNodeType() == Node.ELEMENT_NODE) {		
						Element eElement = (Element) antecedent;
						
//						TODO ajouter gestion des Comparaisons
						String nameAnt= eElement.getAttribute("name");
						Affirmation aff;
						if(eElement.getAttribute("value").equals(true)){
							aff= new Affirmation(nameAnt, true);
						}
						else aff= new Affirmation(nameAnt, false);
							
						listAnt.add(aff);
//						System.out.println("\t\tAntecedant name : " + eElement.getAttribute("name") + ", value : " + eElement.getAttribute("value"));
					}
				}
				
				NodeList consequences= ((org.w3c.dom.Element)rule).getElementsByTagName("consequence");
				ArrayList<Word> listCons= new ArrayList<Word>(); // déclaration de la liste d'antécédents à créer
				
//				System.out.println("\n\tParcours des consequences");
				for (int j = 0; j < consequences.getLength(); ++j) {
					Node consequence = consequences.item(j);

				//		BOUCLE sur les Consequences
//					System.out.println("\t\tCurrent Element :" + consequence.getNodeName());
					if (consequence.getNodeType() == Node.ELEMENT_NODE) {		
						Element eElement = (Element) consequence;
						
						String nameAnt= eElement.getAttribute("name");
						Affirmation aff;
						if(eElement.getAttribute("value").equals(true)){
							aff= new Affirmation(nameAnt, true);
						}
						else aff= new Affirmation(nameAnt, false);
							
						listCons.add(aff);
//						System.out.println("\t\tConsequence name : " + eElement.getAttribute("name") + ", value : " + eElement.getAttribute("value"));
					}
				}

				bridge_rules.addRule(listAnt, listCons);
				System.out.println("Règle ajoutée : BR maj");
				System.out.println(bridge_rules);
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

		System.out.println("----------------------------");
		
//		return bridge_rules;
	}
	
}
