package bridgeconstructor;

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
<<<<<<< Upstream, based on branch 'master' of https://github.com/flodavid/bridgeconstructor
		height = 0;
		width = 0;
		length = 0;
		type = "";
		material = new Materials();
		price = 0;
	}
	
	public Bridge(float height, float width, float length, String type, Materials material, float price) {
		this.height = height;
		this.width = width;
		this.length = length;
		this.type = type;
		this.material = material;
		this.price = price;
=======
		minHeight= 0;
		minWidth= 0;
		maxWidth= -1;
		length= 0;
		
		
>>>>>>> 0d005b6 ajout de commentaires et modif attributs Bridge
	}

	//	SETTERS
	public void setHeight(float height) {
		this.height = height;
	}
	
	public void setWidth(float width) {
		this.width = width;
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
		return height;
	}
	
	public float getWidth() {
		return width;
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
<<<<<<< Upstream, based on branch 'master' of https://github.com/flodavid/bridgeconstructor
		return "HEIGHT = " + height +
				"\tWIDTH = " + width +
				",\tLENGTH = " + length +
				",\tTYPE = " + type +
				",\tMATERIALS = --- "+
				",\tPRICE = " + price;
=======
		return "min HEIGHT = " + minHeight +
			"\tmin WIDTH = " + minWidth +
			"\tmax WIDTH = " + maxWidth +
			"LENGTH = " + length +
			"TYPE = " + type +
			"MATERIALS = --- "+
			"PRICE = " + price;
>>>>>>> 0d005b6 ajout de commentaires et modif attributs Bridge
	}
	
}
