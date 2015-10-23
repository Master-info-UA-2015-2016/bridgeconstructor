package expertsystem;

public class Comparison extends Word{
	private Operator op;
	private float valCondition;
	
	/**
	 * Constructeur
	 * @author florian
	 * 
	 * @param varName
	 * @param varValue
	 * @param _op
	 * @param _valCondition
	 */
	public Comparison(String varName, Operator _op, float _valCondition){
		super(varName);
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
		return name +" "+ op +" "+ valCondition ;
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
	public boolean isTrue(int valeurVariable) {
		if (op==Operators.inf){
			if (valeurVariable < valCondition)	return true;
		}else if (op==Operators.sup){
			if (valeurVariable > valCondition)	return true;
		}else if (op==Operators.equal){
			if (valeurVariable == valCondition)	return true;
		}else if (op==Operators.sup_equal){
			if (valeurVariable >= valCondition)	return true;
		}else if (op==Operators.inf_equal){
			if (valeurVariable <= valCondition)	return true;
		}
		
//			Cas par défaut
		return false; 
	}

	public boolean respect(Word other) {
		System.out.println("Verifie si Comp respecte Word");
		return false;
	}
	
	public boolean respect(Comparison other){
		System.out.println("Verifie si Comp repecte autre Comp");
		if (name == other.name){
			if ( ( (op == new Operator("<")) && (other.op == new Operator(">")) )|| ((op == new Operator(">")) && (other.op == new Operator("<")) ))
				return false;
			else {
				return (op == other.op && valCondition == other.valCondition);
			}
		}
		else return false;
	}

	public String getVal() {
		return ""+ op + valCondition;
	}
}
