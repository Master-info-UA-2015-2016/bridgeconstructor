/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expertsystem;

import java.util.Scanner;

/**
 * @author Florian
 */
public class TerminalFactAsker implements FactAsker{

    /**
     *
     * @param factName
     * @return
     */
    @Override
    public Word askFactValueToUser(String factName) {
        System.out.println("\n Veuillez entrer la valeur de : "+ factName);
            Scanner sc= new Scanner(System.in);           
            String answerValue= sc.next();
            
            System.out.println("\tEst-ce que '"+ answerValue +"' est correcte ? true/false");
            boolean answer= sc.nextBoolean();
            sc.close();
            if (answer){
                try{
                    float res= Float.parseFloat(answerValue);
                    return new Comparison(factName, Operators.equal, res);
                }catch(NumberFormatException NFE){
                    boolean res= Boolean.parseBoolean(answerValue);
                    return new Affirmation(factName, res);
                }
            }
            else {
                return askFactValueToUser(factName); // récursivité @see voir si on peut/doit retourner null ?
        }
    }
	
}
