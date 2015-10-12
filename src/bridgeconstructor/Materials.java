package bridgeconstructor;

import java.io.File;

public class Materials {
	float steelPrice;
	float woodPrice;
	float rockPrice;
	float concretePrice;
	
	
	private void initMaterials(File filMat){
		// TODO lecture du fichier xml pour initialiser les prix
		
		// TODO supprimer solution temporaire init prix
		steelPrice= 50;
		woodPrice= 10;
		rockPrice= 35;
		concretePrice= 25;
	}
	
	public Materials(){
		initMaterials(new File("test.xml"));
	}
	
	public float getSteelPrice() {
		return steelPrice;
	}
	
	public float getConcretePrice() {
		return concretePrice;
	}
	
	public float getRockPrice() {
		return rockPrice;
	}
	
	public float getWoodPrice() {
		return woodPrice;
	}
	
	// TODO toString
}
