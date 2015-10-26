package expertsystem;

public class Operator {
	String chaine;
	
	public Operator(String chaine){
		this.chaine = chaine;
	}
	
	public String toString(){
		return chaine;
	}
	
	public boolean equals(Operator other){
		return chaine.equals(other.chaine);
	}
}
