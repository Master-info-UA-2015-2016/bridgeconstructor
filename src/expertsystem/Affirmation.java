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
	
	public boolean equals(Word other) {
		return false;
	}
	
	public boolean equals(Affirmation other) {
		System.out.println("Comparaison entre 2 affirmations");
		return (sentence == other.sentence && val == other.val);
	}

}
