package expertsystem;

import static java.lang.Boolean.parseBoolean;
import static java.lang.System.out;

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
            return name;
        } else {
            return "NO "+ name;
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
		out.println("Compare Aff avec Word : ");
		return false;
	}
	
    /**
     *
     * @param other
     * @return
     */
    public boolean equals(Affirmation other) {
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
    @Override
    public boolean sameValue(String value) {
		out.print("\t"+this + " == "+ value +" ? ");
		boolean _val= parseBoolean(value);
        if (val == _val){
            out.println("YES");
            return true;
        }
            out.println("NO");
        return false;
	}
    
    public boolean isOpposite(Affirmation A) {
    	return (this.name.equals(A.name) && this.val != A.val);
    }
}
