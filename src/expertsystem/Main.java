package expertsystem;

public class Main {

	public static void main(String[] args) {
		
		FactsBase FB= new FactsBase();
		
		Word taille= new Comparison("Taille pont", 20, Operators.inf_equal, 35);
		Word cars= new Affirmation("Présence traffic routier", false);
		FB.addFact(taille);
		FB.addFact(cars);
		
		FB.show();
	}

}
