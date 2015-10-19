package expertsystem.deprecated;

/**
 * 
 * 
 * @author florian
 * @deprecated
 */
public class Variable {
	private String name;
	private int value;
	
	/**
	 * Constructeur
	 * @author florian
	 */
	public Variable(String _name, int _value){
		name= _name;
		value= _value;
	}
	
	public String getName(){
		return name;
	}

	public String toString(){
		return name +" = "+ value;
	}
	
	public int val(){
		return value;
	}
	
	public boolean isInf(int val){
		return (value < val);
	}
	
	public boolean isSup(int val){
		return (value > val);
	}
	
	public boolean isEqual(int val){
		return (value == val);
	}
	
	public boolean isInfEqual(int val){
		return (value <= val);
	}
	
	public boolean isSupEqual(int val){
		return (value >= val);
	}

}
