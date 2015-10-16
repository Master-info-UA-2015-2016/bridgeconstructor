package expertsystem;

/**
 * La classe utilisera les règles ainsi que la base de faits
 * @see Environment pour décider quel pont scierait à la base
 */

public class AIEngine {
	private Word[] BF;
	
	/**
	 * On sature la BF (version de base, on boucle sur BR (sans ordre partiel))
	 * On vérifie que l'on fait au moins une inférence par cycle, sinon arrêt
	 * @author Florian
	 * 
	 * @param BR ensemble de règles (Environnment)
	 * @param demandables ensemble de faits
	 * @param BF ensemble de faits initiaux
	 * 
	 * VF(f) valeur de f dans BF
	 * VA(m, r)  affirmation ou négation du mot m dans Ant.(r), r € BR
	 * VC(m,r) affirmation ou négation du mot m dans Cons.(r), r € BR
	 */
	private void BFSaturation(/*Rule*/int[] BR/*(Environnment)*/, /*Fait*/Word[] Ant) {
		boolean inf= true;
		int nbInf= 0;
		
		while(inf){
			inf= false;
			for (/*Rule*/int rule : BR){
				boolean dec= true;
				for (/*Fait*/Word word : Ant){
					while(dec){
						if ( ( BF.contains(word) && VF(word) != VA(word,r) )|| !BF.contains(word) )
							dec= false;
					}
					
					if (dec){
						for (){
							
						}
						
					}
					
				}
					
			}
		}
	}
	
	
	
	public boolean forwardChaining(){
		
		
		return true;
	}
}
