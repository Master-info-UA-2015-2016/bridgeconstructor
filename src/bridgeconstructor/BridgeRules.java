package bridgeconstructor;

import java.util.ArrayList;

//Pour lecture XML
//import javax.swing.text.Document;
//import javax.swing.text.Element;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.SAXParser;
//import javax.xml.stream.XMLInputFactory;
//import javax.xml.stream.XMLStreamConstants;
//import javax.xml.stream.XMLStreamException;
//import javax.xml.stream.XMLStreamReader;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


//import org.xml.sax.InputSource;
//import org.xml.sax.SAXException;
//import org.xml.sax.XMLReader;
//import org.xml.sax.helpers.XMLReaderFactory;
//import com.sun.org.apache.xerces.internal.parsers.XMLParser;

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
			System.out.println("Parcour des règles");
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
	
	/**
	 * trop compliqué
	 * 
	 * @param filename
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 */
//	public static RulesBase initRulesBase(String filename) throws SAXException, IOException{
////		XMLParser parser;
////		SAXParser saxpars;
//		
////		XMLReader xr = XMLReaderFactory.createXMLReader();
//		
//		InputStream is = new FileInputStream(filename);
//		XMLInputFactory factory = XMLInputFactory.newInstance();
//		XMLStreamReader reader;
//		try {
//			reader = factory.createXMLStreamReader(is);
//
////	    	FileReader r = new FileReader(filename);
////			xr.parse(new InputSource(r));
//			try{
//				while (reader.hasNext()){
//				   if(reader.getEventType()==XMLStreamConstants.START_ELEMENT)
//				   {
//						if(reader.hasText() )
//					    {
//					        System.out.println(reader.getText());
//					    }
//					    reader.next();
//				   }
//				}
//			}catch (Exception e){
//				System.out.println("Impossible de parcourir le fichier XML");
//				e.printStackTrace();
//			}
//
//		} catch (XMLStreamException e1) {
//			e1.printStackTrace();
//		}
//		
////		org.jdom.Document document;
////		Element racine;
////		
////	    SAXBuilder sxb = new SAXBuilder();
////	    try
////	    {
////	       //On crée un nouveau document JDOM avec en argument le fichier XML
////	       //Le parsing est terminé ;)
////	       document = sxb.build(new File(filename));
////	    }
////	    catch(Exception e){}
//
//	    //On initialise un nouvel élément racine avec l'élément racine du document.
////	    racine = document.getRootElement();
//
//	    return bridge_rules;
//	}
}
