package bridgeconstructor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated code, ou un truc dans ce genre, je suis pas sûr.
		Materials materiaux = new Materials();
		System.out.println("Prix des matériaux");

		System.out.println("Le prix de la pierre : " + materiaux.getRockPrice());
		System.out.println("Le prix de l'acier : " + materiaux.getSteelPrice());
		System.out.println("Le prix du bois : " + materiaux.getWoodPrice());
		System.out.println("Le prix du béton : " + materiaux.getConcretePrice());
	
		Environment E = new Environment();
		Bridge B = new Bridge();
		
		System.out.println("L'Environnement : " + E.toString());
		System.out.println("Le Pont : " + B.toString());
		
		new GraphicInterface();
	}
}
