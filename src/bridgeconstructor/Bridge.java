package bridgeconstructor;

import expertsystem.AIEngine;

/**
 * La classe sera instanciée algorithmiquement grâce à
 * @see AIEngine puis affiché à l'utilisateur
 */
public class Bridge {
	//TODO remplir la classe
	
	public enum Material {
		Steel,
		Wood,
		Rock,
		Concrete,
		Cord
	}
	
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
		minHeight= 0;
		minWidth= 0;
		maxWidth= -1;
		length= 0;
		type = "";
		material = null;
		price = 0;
		
		System.out.println("BRIDGE : " + this.toString());
	}
	
	public Bridge(float height, float minWidth, float maxWidth, float length, String type, Material material, float price) {
		this.minHeight = height;
		this.minWidth = minWidth;
		this.minWidth = maxWidth;
		this.length = length;
		this.type = type;
		this.material = material;
		this.price = price;
	}

	//	SETTERS
	public void setHeight(float height) {
		this.minHeight = height;
	}
	
	public void setMinWidth(float width) {
		this.minWidth = width;
	}
	
	public void setMaxWidth(float width) {
		this.maxWidth = width;
	}
	
	public void setLength(float length) {
		this.length = length;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	// GETTERS
	public float getHeight() {
		return minHeight;
	}
	
	public float getMinWidth() {
		return minWidth;
	}

	public float getMaxWidth() {
		return maxWidth;
	}
	
	public float getLength() {
		return length;
	}
	
	public String getType() {
		return type;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public float getPrice() {
		return price;
	}
	
	public String toString() {
		//TODO toString Material
		return "min HEIGHT = " + minHeight +
			",\tmin WIDTH = " + minWidth +
			",\tmax WIDTH = " + maxWidth +
			",\tLENGTH = " + length +
			",\tTYPE = \"" + type + "\"" +
			",\tMATERIAL = " + material +
			",\tPRICE = " + price;
	}
	
}
