package expertsystem;

/**
 *
 * @author Florian
 */
public abstract class Word {

    /**
     *
     */
    protected String name;

    /**
     *
     * @param _name
     */
    public Word(String _name){
		name= _name;
	}
	
    /**
     *
     * @return
     */
    public abstract String toString();
//	public boolean isTrue(); TODO reimplémenter, modifier à cause de isTrue de Comparison
//	public abstract boolean equals(Word other);
	
    /**
     *
     * @return
     */
    public abstract String getVal();

    /**
     *
     * @param value
     * @return
     */
    public abstract boolean sameValue(String value);
	
    /**
     *
     * @return
     */
    public String getName(){
		return name;
	}
}
