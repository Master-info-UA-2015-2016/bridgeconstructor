package expertsystem;

/**
 *
 * @author Florian
 */
public abstract class Word {

    /**
     *
     */
    private String name;

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
    @Override
    public abstract String toString();
	
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
    public abstract boolean respectValue(String value);

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Vérifie si le mot a la même valeur, ou si sa condition est respectée 
     * dans le cas d'une Comparison
     * @param other mot à comparer
     * @return vrai si le mots "respecte" la valeur de l'autre mot
     */
    public abstract boolean respectValue(Word other);

}
