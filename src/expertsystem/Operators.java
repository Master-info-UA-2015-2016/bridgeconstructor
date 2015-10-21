package expertsystem;

//public enum Operators{
//	sup, inf, equal, sup_equal, inf_equal
//}

/* Essai avec variables static, ECHOUE*/
public class Operators{
	
	/* Définition de tous les opérateurs possibles pour la classe */
	public static Operator sup= new Operator(">");
	public static Operator inf= new Operator("<");
	public static Operator equal= new Operator("=");
	public static Operator sup_equal= new Operator(">=");
	public static Operator inf_equal= new Operator("<=");
	
}