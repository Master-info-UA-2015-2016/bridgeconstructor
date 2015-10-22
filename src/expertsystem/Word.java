package expertsystem;

public abstract class Word {
	protected String name;

	public Word(String _name){
		name= _name;
	}
	
	public abstract String toString();
//	public boolean isTrue(); TODO reimplémenter, modifier à cause de isTrue de Comparison
//	public abstract boolean equals(Word other);
	
	public abstract String getVal();

	
	public String getName(){
		return name;
	}
}
