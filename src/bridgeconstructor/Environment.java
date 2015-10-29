package bridgeconstructor;

import expertsystem.*;

/**
 * La classe n'a pas besoin d'être instancié car unique
 * Elle sera remplie par l'utilisateur
 * en fonction de sa base de faits
 */
public class Environment {
	// Traffic
	private static boolean naval_traffic = false;
	private static boolean railway_traffic = false;
	private static boolean pedestrian_traffic = false;
	private static boolean road_traffic = false;
	private static float density = 0;					// Passage de véhicules par jour
	
	// Météo
	private static boolean storm = false;
	
	// Terrain
	private static boolean wood = false;
	private static boolean water = false;
	private static boolean mountain = false;
	
	// Mesure
	private static float length = 0;
	private static float height = 0;
	
	// Bonus
	private static boolean castle = false;
	
	// private Materials Sol;
	
    /**
     *
     */
    	
	public static void reset() {
		// Traffic
		naval_traffic = false;
		railway_traffic = false;
		pedestrian_traffic = false;
		road_traffic = false;
		density = 0;
		// Météo
		storm = false;
		// Terrain
		wood = false;
		water = false;
		mountain = false;
		// Mesures
		length = 0;
		height = 0;
		// Bonus
		castle = false;
	}
	
//	SETTERS
	//	SETTERS Traffic

    /**
     *
     * @param naval_traffic
     */
    	public static void setNaval_traffic(boolean naval_traffic) {
		Environment.naval_traffic = naval_traffic;
	}
	
    /**
     *
     * @param railway_traffic
     */
    public static void setRailway_traffic(boolean railway_traffic) {
		Environment.railway_traffic = railway_traffic;
	}
	
    /**
     *
     * @param pedestrian_traffic
     */
    public static void setPedestrian_traffic(boolean pedestrian_traffic) {
		Environment.pedestrian_traffic = pedestrian_traffic;
	}
	
    /**
     *
     * @param road_traffic
     */
    public static void setRoad_traffic(boolean road_traffic) {
		Environment.road_traffic = road_traffic;
	}
	
    /**
     *
     * @param density
     */
    public static void setDensity(float density) {
		Environment.density = density;
	}
	
	//	SETTERS Météo

    /**
     *
     * @param storm
     */
    	public static void setStorm(boolean storm) {
		Environment.storm = storm;
	}
	
	//	SETTERS Terrain 

    /**
     *
     * @param wood
     */
    	public static void setWood(boolean wood) {
		Environment.wood = wood;
	}
	
    /**
     *
     * @param water
     */
    public static void setWater(boolean water) {
		Environment.water = water;
	}
	
    /**
     *
     * @param mountain
     */
    public static void setMountain(boolean mountain) {
		Environment.mountain = mountain;
	}
	
	// 	SETTERS Mesures

    /**
     *
     * @param length
     */
    	public static void setLength(float length) {
		Environment.length = length;
	}
	
    /**
     *
     * @param height
     */
    public static void setHeight(float height) {
		Environment.height = height;
	}
	
	// 	SETTERS Bonus

    /**
     *
     * @param castle
     */
    	public static void setCastle(boolean castle) {
		Environment.castle = castle;
	}

// GETTERS
	
	//	GETTERS Traffic

    /**
     *
     * @return
     */
    	public static boolean isNaval_traffic() {
		return naval_traffic;
	}
	
    /**
     *
     * @return
     */
    public static boolean isRailway_traffic() {
		return railway_traffic;
	}
	
    /**
     *
     * @return
     */
    public static boolean isPedestrian_traffic() {
		return pedestrian_traffic;
	}
	
    /**
     *
     * @return
     */
    public static boolean isRoad_traffic() {
		return road_traffic;
	}
	
    /**
     *
     * @return
     */
    public static float getDensity() {
		return density;
	}
	
	//	GETTERS Météo

    /**
     *
     * @return
     */
    	public static boolean isStorm() {
		return storm;
	}
	
	//	GETTERS Terrains
	
    /**
     *
     * @return
     */
    	
	public static boolean isWood() {
		return wood;
	}
	
    /**
     *
     * @return
     */
    public static boolean isWater() {
		return water;
	}
	
    /**
     *
     * @return
     */
    public static boolean isMountain() {
		return mountain;
	}
	
	//	GETTERS Mesures

    /**
     *
     * @return
     */
    	public static float getHeight() {
		return height;
	}
	
    /**
     *
     * @return
     */
    public static float getLength() {
		return length;
	}
	
	//	GETTERS Bonus

    /**
     *
     * @return
     */
    	public static boolean getCastle() {
		return castle;
	}
	
	/**
	 * Affichage du contenu de la classe (Un toString() static)
	 */
	public static void print() {
		System.out.println("ENVIRONMENT :" +
				"\tNaval Traffic = " + naval_traffic +
				",\tRailway Traffic = " + railway_traffic +
				",\tPedestrian Traffic = " + pedestrian_traffic +
				",\tRoad Traffic = " + road_traffic +
				",\tDensity = " + density +
				",\tStorm = " + storm +
				",\tWood = " + wood +
				",\tWater = " + water +
				",\tMountain = " + mountain +
				",\tHeight = " + height +
				",\tLength = " + length +
				",\tCaslte = " + castle);
	}
	
	/**
	 * Saturation de la base de faits
	 * {@link FactsBase}
     * @return 
	 */
	public static FactsBase getFactsBase() {
		FactsBase FB = new FactsBase();
		int lane_number= 2; // TODO mettre dans l'interface
		int daily_traffic= 90; // TODO mettre dans l'interface

		System.out.println("---------------------------------------");
		System.out.println("Initialisation de la base de faits");
		System.out.println("---------------------------------------");
		
	/* Ajout des faits */
		//		Traffic
			FB.addFact("naval traffic", naval_traffic);
			FB.addFact("pedestrian traffic", pedestrian_traffic);
			FB.addFact("railway traffic", railway_traffic);
			FB.addFact("road traffic", road_traffic);
			FB.addFact("density", Operators.equal, density);
		//		Météo
			FB.addFact("storm", storm);
		//		Terrains
			FB.addFact("water", water);
			FB.addFact("wood", wood);
			FB.addFact("mountain", mountain);
		// 		Mesure
			FB.addFact("length", Operators.equal, length);
			FB.addFact("height", Operators.equal, height);
			FB.addFact("lane number", Operators.equal, lane_number);
			FB.addFact("resistance", Operators.equal, 0);
			FB.addFact("daily traffic", Operators.equal, daily_traffic);
		//		Bonus
			FB.addFact("castle", castle);
		return FB;
	}
}
