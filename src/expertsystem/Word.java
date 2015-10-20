package expertsystem;

public abstract class Word {
	protected String name;

	public Word(String _name){
		name= _name;
	}
	
	public abstract String toString();
//	public boolean isTrue(); TODO reimplémenter, modifier à cause de isTrue de Comparison
	public boolean equals(Word other){
		System.out.println("Comparaison avec un mot");
		return super.equals(other);
	};

	
	public String getName(){
		return name;
	}
}
