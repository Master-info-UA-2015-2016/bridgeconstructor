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
		if (val) {
            return getName();
        } else {
            return "NO "+ getName();
        }
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
		AIEngine.flux.println("Compare Aff avec Word : ");
		return false;
	}
	
    /**
     *
     * @param other
     * @return
     */
    public boolean equals(Affirmation other) {
		return (getName().equals(other.getName()) && val == other.val);
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
    @Override
    public boolean sameValue(String value) {
		AIEngine.flux.print("\t"+this + " == "+ value +" ? ");
		boolean _val= Boolean.parseBoolean(value);
        if (val == _val){
            AIEngine.flux.println("YES");
            return true;
        }
            AIEngine.flux.println("NO");
        return false;
	}
    
    /**
     *
     * @param A
     * @return
     */
    public boolean isOpposite(Affirmation A) {
    	return (this.getName().equals(A.getName()) && this.val != A.val);
    }

    /**
     *
     * @param other
     * @return
     */
    @Override
    public boolean sameValue(Word other) {
        if(other.getClass()==Affirmation.class){
            return sameValue(other.getVal());
        }
        else return false;
    }
}
