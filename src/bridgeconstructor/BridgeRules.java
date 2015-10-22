package bridgeconstructor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
//Pour lecture XML
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import expertsystem.Affirmation;
import expertsystem.Comparison;
import expertsystem.Operator;
import expertsystem.RulesBase;
import expertsystem.Word;


public class BridgeRules {
	private static RulesBase bridge_rules;
	
	public static RulesBase initRulesBase(String filename) {
		bridge_rules = new RulesBase();
		
		BridgeRules.initFromXML(filename);
		
		return bridge_rules;
	}
	
	public static void parseToList(Node node, List<Word> list){
//		System.out.println("\t\tCurrent Element :" + consequence.getNodeName());
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) node;
			
			String nameAnt= eElement.getAttribute("name");
			String type= eElement.getAttribute("type");
			
			if (type.equals("comparison") ) {
				Comparison comp= new Comparison(nameAnt,
						new Operator(eElement.getAttribute("operator")),
						Float.parseFloat(eElement.getAttribute("value")) );
				
				list.add(comp);
			}
			else if (type.equals("affirmation")){
				Affirmation aff;
				if(eElement.getAttribute("value").equals("true")){
					aff= new Affirmation(nameAnt, true);
				}
				else aff= new Affirmation(nameAnt, false);
					
				list.add(aff);
			}
			else System.err.println("Type du mot incorrect");
		}
	}
	
	public static ArrayList<Word> parseNodeListToList(NodeList nodeList){
		ArrayList<Word> list= new ArrayList<Word>(); // déclaration de la liste de mots à créer
		
//		System.out.println("\n\tParcours des mots");
		for (int j = 0; j < nodeList.getLength(); ++j) {
			Node consequence = nodeList.item(j);
			
			parseToList(consequence, list);
		}
		
		return list;
	}
	
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
				ArrayList<Word> listAnt= parseNodeListToList(antecedents);
				
				NodeList consequences= ((org.w3c.dom.Element)rule).getElementsByTagName("consequence");
				ArrayList<Word> listCons= parseNodeListToList(consequences);

				bridge_rules.addRule(listAnt, listCons);
//				System.out.println("Règle ajoutée : BR maj");
//					System.out.println(bridge_rules);
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

		System.out.println("----------------------------");
		
//		return bridge_rules;
	}
	
}
