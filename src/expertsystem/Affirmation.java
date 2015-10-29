package expertsystem;

/**
 *
 * @author Florian
 */
public class Affirmation extends Word {
	boolean val;

    /**
     *
     * @param affirmation
     * @param isTrue
     */
    public Affirmation(String affirmation, boolean isTrue){
		super(affirmation);
		val= isTrue;
	}
	
    /**
     *
     * @return
     */
    public String toString(){
		if (val)
			return name;
		else return "NON "+ name;
	}

    /**
     *
     * @return
     */
    public boolean isTrue() {
		return val;
	}
	
    /**
     *
     * @param other
     * @return
     */
    public boolean equals(Word other) {
		System.out.println("Compare Aff avec Word : ");
		return false;
	}
	
    /**
     *
     * @param other
     * @return
     */
    public boolean equals(Affirmation other) {
		System.out.println("Comparaison entre 2 affirmations");
		return (name.equals(other.name) && val == other.val);
	}

    /**
     *
     * @return
     */
    public String getVal() {
		return ""+ val;
	}

    /**
     *
     * @param value
     * @return
     */
    public boolean sameValue(String value) {
		System.out.println(this + " a la valeur "+ value +" ?");
		boolean _val= Boolean.parseBoolean(value);
		return val == _val;
	}
}
