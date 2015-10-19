package bridgeconstructor;

import expertsystem.*;

//package expertsystem;

/**
 * La classe n'a pas besoin d'être instancié car unique
 * Elle sera remplie par l'utilisateur
 * en fonction de sa base de faits
 */
public class Environment /*implements FactsClass je n'ai pas réussi à utiliser static avec une interface*/ {
	//Faits
//	private static RulesBase RB;
	private static FactsBase FB;
	
//	private static void createRB(){
//		RB = new RulesBase();
//	}

	protected static void createFB(){
		// TODO (pour que tu voies) Tu n'utilises pas ta base de fait
		FB = new FactsBase();
		
		FB.addFact("Traffic naval", naval_traffic);
		FB.addFact("Traffic ferroviaire", railway_traffic);
		FB.addFact("Traffic routier", pedestrian_traffic);
		FB.addFact("Traffic pédestre", road_traffic);
		
		FB.addFact("Risque d'ouragan", storm);
		FB.addFact("Risque d'incendie", fire);
		FB.addFact("Risque d'inondation", flood);
	}
	
	// Traffic
	private static boolean naval_traffic = false;
	private static boolean railway_traffic = false;
	private static boolean pedestrian_traffic = false;
	private static boolean road_traffic = false;
	
	// Risques Météorologiques
	private static boolean storm = false;
	private static boolean fire = false;
	private static boolean flood = false;
	
	// Entre les deux points
	private static float length = 0;
	private static float height = 0;
	
	// private Materials Sol;
	
	public static void reset() {
		naval_traffic = false;
		railway_traffic = false;
		pedestrian_traffic = false;
		road_traffic = false;
		storm = false;
		fire = false;
		flood = false;
		length = 0;
		height = 0;
	}
	
//	SETTERS
	//	SETTERS Traffic
	public static void setNaval_traffic(boolean naval_traffic) {
		Environment.naval_traffic = naval_traffic;
	}
	
	public static void setRailway_traffic(boolean railway_traffic) {
		Environment.railway_traffic = railway_traffic;
	}
	
	public static void setPedestrian_traffic(boolean pedestrian_traffic) {
		Environment.pedestrian_traffic = pedestrian_traffic;
	}
	
	public static void setRoad_traffic(boolean road_traffic) {
		Environment.road_traffic = road_traffic;
	}
	
	//	SETTERS Risques Météorologiques
	public static void setStorm(boolean storm) {
		Environment.storm = storm;
	}
	
	public static void setFire(boolean fire) {
		Environment.fire = fire;
	}
	
	public static void setFlood(boolean flood) {
		Environment.flood = flood;
	}
	
	// 	SETTERS Autre
	public static void setLength(float length) {
		Environment.length = length;
	}
	
	public static void setHeight(float height) {
		Environment.height = height;
	}

// GETTERS
	//	GETTERS Traffic
	public static boolean isNaval_traffic() {
		return naval_traffic;
	}
	
	public static boolean isRailway_traffic() {
		return railway_traffic;
	}
	
	public static boolean isPedestrian_traffic() {
		return pedestrian_traffic;
	}
	
	public static boolean isRoad_traffic() {
		return road_traffic;
	}
	
	//	GETTERS Risques Météorologiques
	public static boolean isStorm() {
		return storm;
	}
	
	public static boolean isFire() {
		return fire;
	}
	
	public static boolean isFlood() {
		return flood;
	}
	
	//GETTERS Autre
	public static float getHeight() {
		return height;
	}
	
	public static float getLength() {
		return length;
	}
	
	public static void display() {
		System.out.println("ENVIRONMENT :" +
				"\tNaval Traffic = " + naval_traffic +
				",\tRailway Traffic = " + railway_traffic +
				",\tPedestrian Traffic = " + pedestrian_traffic +
				",\tRoad Traffic = " + road_traffic +
				",\tStorm = " + storm +
				",\tFire = " + fire +
				",\tFlood = " + flood +
				",\tHeight = " + height +
				",\tLength = " + length);
	}
	
	public static FactsBase saturateFactsBase() {
		FactsBase FB = new FactsBase();
		
		return FB;
	}
}
