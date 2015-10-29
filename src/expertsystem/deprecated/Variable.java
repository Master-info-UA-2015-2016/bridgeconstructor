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
     * @param _name
     * @param _value
	 */
	public Variable(String _name, int _value){
		name= _name;
		value= _value;
	}
	
    /**
     *
     * @return
     */
    public String getName(){
		return name;
	}

    /**
     *
     * @return
     */
    public String toString(){
		return name +" = "+ value;
	}
	
    /**
     *
     * @return
     */
    public int val(){
		return value;
	}
	
    /**
     *
     * @param val
     * @return
     */
    public boolean isInf(int val){
		return (value < val);
	}
	
    /**
     *
     * @param val
     * @return
     */
    public boolean isSup(int val){
		return (value > val);
	}
	
    /**
     *
     * @param val
     * @return
     */
    public boolean isEqual(int val){
		return (value == val);
	}
	
    /**
     *
     * @param val
     * @return
     */
    public boolean isInfEqual(int val){
		return (value <= val);
	}
	
    /**
     *
     * @param val
     * @return
     */
    public boolean isSupEqual(int val){
		return (value >= val);
	}

}
