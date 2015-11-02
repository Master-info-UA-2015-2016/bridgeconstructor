package bridgeconstructor;

import expertsystem.AIEngine;

/**
 * La classe sera instanciée algorithmiquement grâce à
 * 
 * @see AIEngine puis affiché à l'utilisateur
 */
public final class Bridge {

	private final float size_lane = (float) 2.50;
	
	private float height;
	private float minWidth;
	private float maxWidth;
	private float length;
	private TypeBridge type;

	/**
	 * Constructeur par défaut de {@link Bridge}
	 */
	public Bridge() {
		height = 0;
		minWidth = 0;
		maxWidth = -1;
		length = 0;
		type = null;

		System.out.println("BRIDGE : " + this.toString());
	}

	/**
	 *
	 * @param height
	 * @param minWidth
	 * @param maxWidth
	 * @param length
	 * @param type
	 * @param price
	 */
	public Bridge(float height, float minWidth, float maxWidth, float length, TypeBridge type) {
		this.height = height;
		this.minWidth = minWidth;
		this.minWidth = maxWidth;
		this.length = length;
		this.type = type;
	}

    /**
     * Constructeur
     * Le calcul de la largeur est effectuée grâce au nombre de voies
     * @param height : Hauteur 
     * @param lane_number : Nombre de voies
     * @param length : Longueur
     * @param type : Type de pont
     */
    public Bridge(float height, int lane_number, float length, TypeBridge type) {
		this.height = height;
		this.length = length;
		this.type = type;
		this.minWidth = lane_number * size_lane;
		this.maxWidth = lane_number * size_lane + (float)0.50;
	}
	
	// SETTERS

	/**
	 *
	 * @param height
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 *
	 * @param width
	 */
	public void setMinWidth(float width) {
		this.minWidth = width;
	}

	/**
	 *
	 * @param width
	 */
	public void setMaxWidth(float width) {
		this.maxWidth = width;
	}

	/**
	 *
	 * @param length
	 */
	public void setLength(float length) {
		this.length = length;
	}

	/**
	 *
	 * @param type
	 */
	public void setType(TypeBridge type) {
		this.type = type;
	}

	// GETTERS

	/**
	 *
	 * @return
	 */
	public float getHeight() {
		return height;
	}

	/**
	 *
	 * @return
	 */
	public float getMinWidth() {
		return minWidth;
	}

	/**
	 *
	 * @return
	 */
	public float getMaxWidth() {
		return maxWidth;
	}

	/**
	 *
	 * @return
	 */
	public float getLength() {
		return length;
	}

	/**
	 *
	 * @return
	 */
	public TypeBridge getType() {
		return type;
	}

	/**
	 * @return le prix du pont pour la Corde
	 */
	public float getPriceCord() {
		float price_length = length * Constante.cord_length;
		float price_width = maxWidth * Constante.cord_width;
		float price = (price_length * price_width) * Constante.coef_height * Constante.coef_cord;
		
		return price;
	}
	
	/**
	 * @return le prix du pont pour le Béton
	 */
	public float getPriceConcrete() {
		float price_length = length * Constante.concrete_length;
		float price_width = maxWidth * Constante.concrete_width;
		float price = (price_length * price_width) * Constante.coef_height * Constante.coef_concrete;
		
		return price;
	}
	
	/**
	 * @return le prix du pont pour l'Acier
	 */
	public float getPriceSteel() {
		float price_length = length * Constante.steel_length;
		float price_width = maxWidth * Constante.steel_width;
		float price = (price_length * price_width) * Constante.coef_height * Constante.coef_steel;
		
		return price;
	}
	
	/**
	 * @return le prix du pont pour la Pierre
	 */
	public float getPriceStone() {
		float price_length = length * Constante.stone_length;
		float price_width = maxWidth * Constante.stone_width;
		float price = (price_length * price_width) * Constante.coef_height * Constante.coef_stone;
		
		return price;
	}
	
	/**
	 * @return le prix du pont pour le Bois
	 */
	public float getPriceWood() {
		float price_length = length * Constante.wood_length;
		float price_width = maxWidth * Constante.wood_width;
		float price = (price_length * price_width) * Constante.coef_height * Constante.coef_wood;
		
		return price;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getStringType() {
		switch(type) {
			case arc :
				return "Arc-Boutants";
			case beam :
				return "Poutres";
			case drawbridge :
				return "Pont-Levis";
			case hanging :
				return "Suspendu";
			case shroud :
				return "Haubans";
			case vault :
				return "Voûtes";
			default :
				return "";
		}
	}
	
	/**
	 *
	 * @return
	 */
	public String toString() {
		return "HEIGHT = " + height + 
				",\tmin WIDTH = " + minWidth + 
				",\tmax WIDTH = " + maxWidth + 
				",\tLENGTH = " + length + 
				",\tTYPE = \"" + type + "\"";
	}

}
