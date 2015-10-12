package bridgeconstructor;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated code, ou un truc dans ce genre, je suis pas sûr.
		new Main();
		System.out.println("Prix des matériaux");
		
		System.out.println("Le prix de la pierre : " + Materials.getRockPrice());
		System.out.println("Le prix de l'acier : " +  Materials.getSteelPrice());
		System.out.println("Le prix du bois : " + Materials.getWoodPrice());
	}
}
