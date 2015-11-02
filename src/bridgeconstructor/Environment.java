package bridgeconstructor;

import expertsystem.FactsBase;
import expertsystem.Operators;

/**
 * La classe n'a pas besoin d'être instancié car unique Elle sera remplie par
 * l'utilisateur en fonction de sa base de faits
 */
public class Environment {
	// Traffic
	private static boolean naval_traffic = false;
	private static boolean rail_traffic = false;
	private static boolean pedestrian_traffic = false;
	private static boolean road_traffic = false;
	private static float daily_traffic = 90; // Passage de véhicules par jour

	// Météo
	private static boolean wind = false;

	// Terrain
	private static boolean forest = false;
	private static boolean water = false;
	private static boolean mountain = false;

	// Mesure
	private static float length = 20;
	private static float height = 10;
	private static int lane_number = 2;

	// Bonus
	private static boolean castle = false;

	// private Materials Sol;

	/**
	 *
	 */

	public static void reset() {
		// Traffic
		naval_traffic = false;
		rail_traffic = false;
		pedestrian_traffic = false;
		road_traffic = false;
		daily_traffic = 90;
		// Météo
		wind = false;
		// Terrain
		forest = false;
		water = false;
		mountain = false;
		// Mesures
		length = 20;
		height = 10;
		lane_number = 2;
		// Bonus
		castle = false;
	}

	// SETTERS
	// SETTERS Traffic

	/**
	 *
	 * @param naval_traffic
	 */
	public static void setNaval_traffic(boolean naval_traffic) {
		Environment.naval_traffic = naval_traffic;
	}

	/**
	 *
	 * @param rail_traffic
	 */
	public static void setRailway_traffic(boolean rail_traffic) {
		Environment.rail_traffic = rail_traffic;
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
	public static void setDaily_traffic(float daily_traffic) {
		Environment.daily_traffic = daily_traffic;
	}

	// SETTERS Météo

	/**
	 * 
	 * @param wind
	 */
	public static void setWind(boolean wind) {
		Environment.wind = wind;
	}

	// SETTERS Terrain

	/**
	 *
	 * @param forest
	 */
	public static void setForest(boolean forest) {
		Environment.forest = forest;
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

	// SETTERS Mesures

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

	/**
	 * 
	 * @param lane_number
	 */
	public static void setLane_number(int lane_number) {
		Environment.lane_number = lane_number;
	}

	// SETTERS Bonus

	/**
	 *
	 * @param castle
	 */
	public static void setCastle(boolean castle) {
		Environment.castle = castle;
	}

	// GETTERS

	// GETTERS Traffic

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
	public static boolean isRail_traffic() {
		return rail_traffic;
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
	public static float getDaily_traffic() {
		return daily_traffic;
	}

	// GETTERS Météo

	/**
	 * 
	 * @return
	 */
	public static boolean isWind() {
		return wind;
	}

	// GETTERS Terrains

	/**
	 *
	 * @return
	 */

	public static boolean isForest() {
		return forest;
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

	// GETTERS Mesures

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

	/**
	 * 
	 * @return
	 */
	public static int getLane_number() {
		return lane_number;
	}

	// GETTERS Bonus

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
		System.out.println("ENVIRONMENT :" + "\tNaval Traffic = " + naval_traffic + ",\tRailway Traffic = "
				+ rail_traffic + ",\tPedestrian Traffic = " + pedestrian_traffic + ",\tRoad Traffic = " + road_traffic
				+ ",\tDaily Traffic = " + daily_traffic + ",\tWind = " + wind + ",\tWood = " + forest + ",\tWater = "
				+ water + ",\tMountain = " + mountain + ",\tHeight = " + height + ",\tLength = " + length
				+ ",\tLane Number = " + lane_number + ",\tCastle = " + castle);
	}

	/**
	 * Saturation de la base de faits {@link FactsBase}
	 * 
	 * @return
	 */
	public static FactsBase getFactsBase() {
		FactsBase FB = new FactsBase();

		System.out.println("---------------------------------------");
		System.out.println("Initialisation de la base de faits");
		System.out.println("---------------------------------------");

		/* Ajout des faits */
		// Traffic
		FB.addFact("naval traffic", naval_traffic);
		FB.addFact("pedestrian traffic", pedestrian_traffic);
		FB.addFact("rail traffic", rail_traffic);
		FB.addFact("road traffic", road_traffic);
		FB.addFact("daily traffic", Operators.equal, daily_traffic);
		// Météo
		FB.addFact("wind", wind);
		// Terrains
		FB.addFact("water", water);
		FB.addFact("forest", forest);
		FB.addFact("mountain", mountain);
		// Mesure
		FB.addFact("length", Operators.equal, length);
		FB.addFact("height", Operators.equal, height);
		FB.addFact("lane number", Operators.equal, lane_number);
		// Bonus
		FB.addFact("castle", castle);
		return FB;
	}
}
