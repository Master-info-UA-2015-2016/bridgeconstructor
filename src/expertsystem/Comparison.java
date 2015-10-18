package expertsystem;

public class Comparison implements Word{
	protected Variable var;
	private Operators op;
	private int valCondition;
	
	/**
	 * Constructeur
	 * @author florian
	 * 
	 * @param varName
	 * @param varValue
	 * @param _op
	 * @param _valCondition
	 */
	public Comparison(String varName, int varValue, Operators _op, int _valCondition){
		var= new Variable(varName, varValue);
		op= _op;
		valCondition= _valCondition;		
	}

	/**
	 * Constructeur avec variable déjà existante
	 * @author florian
	 * 
	 * @param varName
	 * @param varValue
	 * @param _op
	 * @param _valCondition
	 */
	public Comparison(Variable _var, Operators _op, int _valCondition){
		var= _var;
		op= _op;
		valCondition= _valCondition;		
	}
	
//	#########################
//	######	Getters	#########
//	#########################
	
	/**
	 * Retour sous forme de chaine de la classe
	 */
	public String toString(){
		if (op==Operators.inf)	return var.getName() +"("+ var.val() +") < "+ valCondition ;
		else if (op==Operators.sup)	return var.getName() +"("+ var.val() +") > "+ valCondition ;
		else if (op==Operators.equal)	return var.getName() +"("+ var.val() +") = "+ valCondition ;
		else if (op==Operators.sup_equal)	return var.getName() +"("+ var.val() +") >= "+ valCondition ;
		else if (op==Operators.inf_equal)	return var.getName() +"("+ var.val() +") <= "+ valCondition ;
		
		return "ERROR_OP";
	}
	
	/**
	 * TODO A redéfinir pour que contains fasse la bonne vérification
	 * @param other
	 * @return
	 */
//	public boolean equals(Comparison other){
//		if (this.var.equals(other.var) ) {
//			
//			if (op==Operators.inf){
//				
//			}else if (op==Operators.sup){
//			
//			}else if (op==Operators.equal){
//			
//			}else if (op==Operators.sup_equal){
//			
//			}else if (op==Operators.inf_equal){
//			
//			}
//			
//		}
//		return false;
//	}

	/**
	 * Retourne si la comparaison est exacte ou non
	 * @author florian
	 */
	public boolean isTrue() {
		if (op==Operators.inf){
			if (var.val() < valCondition)	return true;
		}else if (op==Operators.sup){
			if (var.val() > valCondition)	return true;
		}else if (op==Operators.equal){
			if (var.val() == valCondition)	return true;
		}else if (op==Operators.sup_equal){
			if (var.val() >= valCondition)	return true;
		}else if (op==Operators.inf_equal){
			if (var.val() <= valCondition)	return true;
		}
		
//			Cas par défaut
		return false; 
	}
}
