package bridgeconstructor;

/**
 * La classe n'a pas besoin d'être instancié car unique
 * Elle sera remplie par l'utilisateur
 * en fonction de sa base de faits
 */
public class Environment {
	// Traffic
	private static boolean naval_traffic;
	private static boolean railway_traffic;
	private static boolean pedestrian_traffic;
	private static boolean road_traffic;
	
	// Risques Météorologiques
	private static boolean storm;
	private static boolean fire;
	private static boolean flood;
	
	// private Materials Sol;
	
	//	SETTERS
	//		SETTERS Traffic
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
	
	@Override
	public String toString() {
		return "ENVIRONMENT :\n" +
				"\tNaval Traffic = " + naval_traffic +
				"\tRailway Traffic = " + railway_traffic +
				"\tPedestrian Traffic = " + pedestrian_traffic +
				"\tRoad Traffic = " + road_traffic +
				"\tStorm = " + storm +
				"\tFire = " + fire +
				"\tFlood = " + flood;
	}
}
