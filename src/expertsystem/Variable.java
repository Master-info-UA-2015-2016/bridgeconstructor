package expertsystem;


public class Variable {
	private String name;
	private int valeur;
	
	public String getName(){
		return name;
	}
	
	public int val(){
		return valeur;
	}
	
	public boolean isInf(int val){
		return (valeur < val);
	}
	
	public boolean isSup(int val){
		return (valeur > val);
	}
	
	public boolean isEqual(int val){
		return (valeur == val);
	}
	
	public boolean isInfEqual(int val){
		return (valeur <= val);
	}
	
	public boolean isSupEqual(int val){
		return (valeur >= val);
	}
	
	/**
	 * PAS UTILE A PRIORI
	 * @author Florian
	 * 
	 * @param op
	 * @param condition
	 * @return
	 */

}
