package expertsystem;

public enum Operators{
	sup, inf, equal, sup_equal, inf_equal
}

/* Essai avec variables static, ECHOUE
//public class Operators{
//	private char op;
//	private String chaine;
//	
//	/* Définition de tous les opérateurs possibles pour la classe */
//	public static char sup= 0;
//	public static char inf= 1;
//	public static char equal= 2;
//	public static char sup_equal= 3;
//	public static char inf_equal= 4;
//	
//	public Operators(char op, String chaine){
//		this.chaine = chaine;
//		this.op= op;
//	}
//}