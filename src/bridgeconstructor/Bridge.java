package bridgeconstructor;

import expertsystem.AIEngine;

/**
 * La classe sera instanciée algorithmiquement grâce à
 * @see AIEngine puis affiché à l'utilisateur
 */
public class Bridge {
	//TODO remplir la classe
	
	private float minHeight;
	private float minWidth;
	private float maxWidth;
	private float length;
	private String type;
	private Materials material;
	private float price;
	
	/**
	 * Constructeur par défaut de Bridge
	 */
	public Bridge() {
		minHeight= 0;
		minWidth= 0;
		maxWidth= -1;
		length= 0;
		type = "";
		material = new Materials();
		price = 0;
	}
	
	public Bridge(float height, float minWidth, float maxWidth, float length, String type, Materials material, float price) {
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
	
	public void setMaterial(Materials material) {
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
	
	public Materials getMaterial() {
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
			",\tTYPE = " + type +
			",\tMATERIALS = --- "+
			",\tPRICE = " + price;
	}
	
}
