package bridgeconstructor;

/**
 * La classe sera instanciée algorithmiquement grâce à
 * @see AIEngine puis affiché à l'utilisateur
 */
public class Bridge {
	//TODO remplir la classe
	
	private float height;
	private float width;
	private float length;
	private String type;
	private Materials material;
	private float price;
	
	/**
	 * Constructeur de Bridge
	 */
	public Bridge() {
		
	}

	public String toString() {
		//TODO toString Material
		return "HEIGHT = " + height +
				"\tWIDTH = " + width +
				"LENGTH = " + length +
				"TYPE = " + type +
				"MATERIALS = --- "+
				"PRICE = " + price;
	}
	
}
