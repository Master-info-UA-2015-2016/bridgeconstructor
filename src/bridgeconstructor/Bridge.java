package bridgeconstructor;

import expertsystem.AIEngine;
import static java.lang.System.out;

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
	private float price;

	/**
	 * Constructeur par défaut de {@link Bridge}
	 */
	public Bridge() {
		height = 0;
		minWidth = 0;
		maxWidth = -1;
		length = 0;
		type = null;
		price = 0;

		out.println("BRIDGE : " + this.toString());
	}

	/**
	 *
	 * @param height
	 * @param minWidth
	 * @param maxWidth
	 * @param length
	 * @param type
	 * @param material
	 * @param price
	 */
	public Bridge(float height, float minWidth, float maxWidth, float length, TypeBridge type, float price) {
		this.height = height;
		this.minWidth = minWidth;
		this.minWidth = maxWidth;
		this.length = length;
		this.type = type;
		this.price = price;
	}

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

	/**
	 *
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
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
	 *
	 * @return
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * 
	 * @param type
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
				",\tTYPE = \"" + type + "\"" +
				",\tPRICE = " + price;
	}

}
