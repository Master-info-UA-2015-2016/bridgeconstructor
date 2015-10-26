package expertsystem;

public class Affirmation extends Word {
	boolean val;

	public Affirmation(String affirmation, boolean isTrue){
		super(affirmation);
		val= isTrue;
	}
	
	public String toString(){
		if (val)
			return name;
		else return "NON "+ name;
	}
	public boolean isTrue() {
		return val;
	}
	
	public boolean equals(Word other) {
		System.out.println("Compare Aff avec Word : ");
		return false;
	}
	
	public boolean equals(Affirmation other) {
		System.out.println("Comparaison entre 2 affirmations");
		return (name.equals(other.name) && val == other.val);
	}

	public String getVal() {
		return ""+ val;
	}

	public boolean sameValue(String value) {
		System.out.println(this + " a la valeur "+ value +" ?");
		boolean _val= Boolean.parseBoolean(value);
		return val == _val;
	}
}
