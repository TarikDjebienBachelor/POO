package PierrePapierCiseaux;
/** 
 * <p style= "font-size: 170%;" >  Classe  PierrePapierCiseaux.Aleatoire </p>
 * @author Djebien Tarik
 * @version avril 2010
 */
public class Aleatoire implements Strategie{
      
      /**
       * getCoup - renvoie un coup aleatoire parmi PIERRE, PAPIER ET CISEAUX. 
       * @return le Coup aleatoire.
       */
      public Coup getCoup(){
	// tableau de coup
	Coup[] tabCoup = Coup.values();
	// nombre aleatoire
	java.util.Random r = new java.util.Random(); 
	int i= r.nextInt(3); //nbr aleatoire de [0,3[ = {0,1,2}
	// coup aleatoire
	return tabCoup[i];
      }// getCoup
      
}// Aleatoire
