package expertsystem;

public class Affirmation implements Word {
	String sentence;
	boolean val;

	public Affirmation(String affirmation, boolean isTrue){
		sentence= affirmation;
		val= isTrue;
	}
	
	public String toString(){
		if (val)
			return sentence;
		else return "NON "+ sentence;
	}
	public boolean isTrue() {
		return val;
	}

}
