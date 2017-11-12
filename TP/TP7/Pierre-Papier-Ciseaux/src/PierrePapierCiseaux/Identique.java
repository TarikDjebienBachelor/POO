package PierrePapierCiseaux;
/** 
 * <p style= "font-size: 170%;" >  Classe  PierrePapierCiseaux.Identique </p>
 * @author Djebien Tarik
 * @version avril 2010
 */
public class Identique implements Strategie{

      /**
       * getCoup - renvoie un coup identique parmi PIERRE, PAPIER ET CISEAUX. 
       * @return le Coup identique.
       */
      public Coup getCoup(){
	// coup identique ici par exemple le coup PIERRE
	Coup identité = Coup.pierre;
	return identité;
      }// getCoup

}// Identique
