package bridgeconstructor;

public class Main {

	public enum types {Mobile, Suspendu, haubants, arcs_boutants};
	
	public static void main(String[] args) {
		// TODO : lister tous les types de ponts possibles et matériaux utilisables
//		Créer un Bridge pour chaque ponts possible,
//		contenant chaque matériau utilisable pour ce type de ponts ?
//		on supprime le matériau utilisable ou le Bridge entier si il n'est plus envisagé ?
	
//###################
//		Tests
//##################

//###################
//		Fin Tests
//##################
		Materials materiaux = new Materials();
		System.out.println("Prix des matériaux");

		System.out.println("Le prix de la pierre : " + materiaux.getRockPrice());
		System.out.println("Le prix de l'acier : " + materiaux.getSteelPrice());
		System.out.println("Le prix du bois : " + materiaux.getWoodPrice());
		System.out.println("Le prix du béton : " + materiaux.getConcretePrice());
		
		/*GraphicInterface configWindow= */new GraphicInterface();
		
	}
}
