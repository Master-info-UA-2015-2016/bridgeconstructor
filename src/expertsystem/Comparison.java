package expertsystem;

public class Comparison implements Word{
	private Variable var;
	private Operators op;
	private int valCondition;
	
	
	public String toString(){
		if (op==Operators.inf)	return var.getName() +" < "+ valCondition ;
		else if (op==Operators.sup)	return var.getName() +" > "+ valCondition ;
		else if (op==Operators.equal)	return var.getName() +" = "+ valCondition ;
		else if (op==Operators.sup_equal)	return var.getName() +" >= "+ valCondition ;
		else if (op==Operators.inf_equal)	return var.getName() +" <= "+ valCondition ;
		
		return "ERROR_OP";
	}


	@Override
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
