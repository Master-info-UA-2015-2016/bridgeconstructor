package bridgeconstructor;

import expertsystem.AIEngine;

/**
 * La classe sera instanciée algorithmiquement grâce à
 * 
 * @see AIEngine puis affiché à l'utilisateur
 */
public class Bridge {

	private float minHeight;
	private float minWidth;
	private float maxWidth;
	private float length;
	private String type;
	private Material material;
	private float price;

	/**
	 * Constructeur par défaut de {@link Bridge}
	 */
	public Bridge() {
		minHeight = 0;
		minWidth = 0;
		maxWidth = -1;
		length = 0;
		type = "";
		material = null;
		price = 0;

		System.out.println("BRIDGE : " + this.toString());
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
	public Bridge(float height, float minWidth, float maxWidth, float length, String type, Material material,
			float price) {
		this.minHeight = height;
		this.minWidth = minWidth;
		this.minWidth = maxWidth;
		this.length = length;
		this.type = type;
		this.material = material;
		this.price = price;
	}

	// SETTERS

	/**
	 *
	 * @param height
	 */
	public void setHeight(float height) {
		this.minHeight = height;
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
	public void setType(String type) {
		this.type = type;
	}

	/**
	 *
	 * @param material
	 */
	public void setMaterial(Material material) {
		this.material = material;
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
		return minHeight;
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
	public String getType() {
		return type;
	}

	/**
	 *
	 * @return
	 */
	public Material getMaterial() {
		return material;
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
	 * @return
	 */
	public String toString() {
		// TODO toString Material
		return "min HEIGHT = " + minHeight + ",\tmin WIDTH = " + minWidth + ",\tmax WIDTH = " + maxWidth
				+ ",\tLENGTH = " + length + ",\tTYPE = \"" + type + "\"" + ",\tMATERIAL = " + material + ",\tPRICE = "
				+ price;
	}

}
