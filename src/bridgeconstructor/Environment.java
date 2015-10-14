package bridgeconstructor;

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
	
	// Risques Météorologiques
	private static boolean storm = false;
	private static boolean fire = false;
	private static boolean flood = false;
	
	// private Materials Sol;
	
	//	SETTERS
	//		SETTERS Traffic
	public static void addNavalTraffic(){
		naval_traffic= true;
	}

	public static void addRaiwayTraffic(){
		railway_traffic= true;
	}

	public static void addPedestrianTraffic(){
		pedestrian_traffic= true;
	}

	public static void addRoadTraffic(){
		road_traffic= true;
	}
	
	
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
	
	//		SETTERS Risques Météorologiques
	public static void setStorm(boolean storm) {
		Environment.storm = storm;
	}
	
	public static void setFire(boolean fire) {
		Environment.fire = fire;
	}
	
	public static void setFlood(boolean flood) {
		Environment.flood = flood;
	}
	
	// GETTERS
	//		GETTERS Traffic
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
	
	//		GETTERS Risques Météorologiques
	public static boolean isStorm() {
		return storm;
	}
	
	public static boolean isFire() {
		return fire;
	}
	
	public static boolean isFlood() {
		return flood;
	}
	
	public static void display() {
		System.out.println("L'ENVIRONMENT :\n" +
				"\tNaval Traffic = " + naval_traffic +
				",\tRailway Traffic = s" + railway_traffic +
				",\tPedestrian Traffic = " + pedestrian_traffic +
				",\tRoad Traffic = " + road_traffic +
				",\nStorm = " + storm +
				",\tFire = " + fire +
				",\tFlood = " + flood);
	}
}
