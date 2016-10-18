package bridgeconstructor;

import bridgeconstructor.Exceptions.WrongOperatorException;
import expertsystem.Affirmation;
import expertsystem.Comparison;
import expertsystem.Operator;
import expertsystem.Operators;
import expertsystem.RulesBase;
import expertsystem.Word;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Florian
 */
public class BridgeRules {
	private static RulesBase bridge_rules;
    
    /**
     * Ajoute une comparaison dans une liste donnée
     * @param list
     * @param name
     * @param opString
     * @param value
     * @param isCons
     * @throws WrongOperatorException 
     */
    private static void addComparison(List<Word> list, String name, String opString, float value, boolean isCons) throws WrongOperatorException{
        if (isCons) {
            if (!opString.equals("=") && !opString.isEmpty()) {
                System.err.println("op.equals('=') ? " + "=".equals(opString) + " et op.equals('') ? " + opString.isEmpty());
                throw new WrongOperatorException(name, opString);
            } else {
                // une conséquence est forcément une égalité
                Comparison comp = new Comparison(name, Operators.equal, value);
                list.add(comp);
            }
        } else {
            Comparison comp = new Comparison(name, new Operator(opString), value);
            list.add(comp);
        }
    }
        
	/**
	 *
	 * @param node
	 * @param list
	 * @param isCons
	 */
	private static void parseToList(Node node, List<Word> list, boolean isCons) {
		// System.out.println("\t\tCurrent Element :" +
		// consequence.getNodeName());
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) node;
			String name = eElement.getAttribute("name");
            
			String type = eElement.getAttribute("type");
			if ("comparison".equals(type)) {
				String opString = eElement.getAttribute("operator");
				float value = Float.parseFloat(eElement.getAttribute("value"));
                try {
                    addComparison(list, name, opString, value, isCons);
                }catch (WrongOperatorException WOE){
                    WOE.show();
                }
			} else if (type.equals("affirmation")) {
				Affirmation aff;
				if (eElement.getAttribute("value").equals("true")) {
					aff = new Affirmation(name, true);
				} else {
                    aff = new Affirmation(name, false);
                }

				list.add(aff);
			} else {
                System.err.println("Type du mot incorrect");
            }
		}
	}

	/**
	 *
	 * @param nodeList
	 * @param isCons
	 * @return
	 */
	private static ArrayList<Word> parseNodeListToList(NodeList nodeList, boolean isCons) {
		ArrayList<Word> list = new ArrayList<Word>(); // déclaration de la liste
														// de mots à créer

		// System.out.println("\n\tParcours des mots");
		for (int j = 0; j < nodeList.getLength(); ++j) {
			Node consequence = nodeList.item(j);

			parseToList(consequence, list, isCons);
		}

		return list;
	}

	/**
	 *
	 * @param filename
	 */
	public static void initFromXML(String filename) {

		try {
			File fXmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());

			NodeList rules = doc.getElementsByTagName("bridge_rule");

			System.out.println("---------------------------------------");
			System.out.println("Ajout des règles à partir du fichier");
			// BOUCLE sur les Règles
			for (int i = 0; i < rules.getLength(); ++i) {
				Node rule = rules.item(i);

				NodeList antecedents = ((org.w3c.dom.Element) rule).getElementsByTagName("antecedent");
				ArrayList<Word> listAnt = parseNodeListToList(antecedents, false);

				NodeList consequences = ((org.w3c.dom.Element) rule).getElementsByTagName("consequence");
				ArrayList<Word> listCons = parseNodeListToList(consequences, true);

				bridge_rules.addRule(listAnt, listCons);
				// System.out.println("Règle ajoutée : BR maj");
				// System.out.println(bridge_rules);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("---------------------------------------");

		// return bridge_rules;
	}

	/**
	 *
	 * @param filename
	 * @return
	 */
	public static RulesBase initRulesBase(String filename) {
		bridge_rules = new RulesBase();

		BridgeRules.initFromXML(filename);

		return bridge_rules;
	}

}
