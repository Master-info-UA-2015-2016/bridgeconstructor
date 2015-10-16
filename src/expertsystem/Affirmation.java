package expertsystem;

public class Affirmation implements Word {
	String sentence;
	boolean val;

	public String toString(){
		if (val)
			return sentence;
		else return "NON "+ sentence;
	}
	public boolean isTrue() {
		return val;
	}

}
