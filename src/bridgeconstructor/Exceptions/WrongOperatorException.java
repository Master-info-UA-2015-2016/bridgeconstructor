/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgeconstructor.Exceptions;

/**
 * Si l'opérateur est différent de '=', on ne peut pas ajouter de conséquence
 * @author Florian
 */
public class WrongOperatorException extends Exception {
    private static final long serialVersionUID = 1L;
    
    private final String name;
    private final String op;

    public WrongOperatorException(String compName, String opString){
        name= compName;
        op= opString;
    }
    
    @Override
    public String toString(){
        String chaine= "impossible d'ajouter la comparaison -" + name
                + "- comme conséquence : opérateur "+ op +" différent de '=')";
        chaine+="\n"+super.toString();
        return chaine;
    }
    
    public void show(){
        System.err.println(toString());
    }
}
