package expertsystem;

/**
 *
 * @author Florian
 */
public class Operator {
	private String chaine;
	
    /**
     *
     * @param chaine
     */
    public Operator(String chaine){
		this.chaine = chaine;
	}
	
    /**
     *
     * @return
     */
    public String toString(){
		return chaine;
	}
	
    /**
     *
     * @param other
     * @return
     */
    public boolean equals(Operator other){
		return chaine.equals(other.chaine);
	}
}
