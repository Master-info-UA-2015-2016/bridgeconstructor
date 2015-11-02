/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expertsystem;

import static expertsystem.Operators.equal;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Florian
 */
public class TerminalFactAsker implements FactAsker{

    @Override
    public Word askFactValueToUser(String factName) {
        out.println("\n Veuillez entrer la valeur de : "+ factName);
            Scanner sc; sc= new Scanner(in);           
            String answerValue= sc.next();
            
            out.println("\tEst-ce que '"+ answerValue +"' est correcte ? true/false");
            boolean answer= sc.nextBoolean();
            if (answer){
                try{
                    float res= parseFloat(answerValue);
                    return new Comparison(factName, equal, res);
                }catch(NumberFormatException NFE){
                    boolean res= parseBoolean(answerValue);
                    return new Affirmation(factName, res);
                }
            }
            else {
                return askFactValueToUser(factName); // récursivité TODO voir si on supprime et retourne null ?
        }
    }
	
}
