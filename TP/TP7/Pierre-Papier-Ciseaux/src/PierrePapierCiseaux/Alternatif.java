package PierrePapierCiseaux;
/** 
 * <p style= "font-size: 170%;" >  Classe  PierrePapierCiseaux.Alternatif </p>
 * @author Djebien Tarik
 * @version avril 2010
 */
public class Alternatif implements Strategie{
      
      private Coup precedent = Coup.ciseaux;
      
      /**
       * getCoup - renvoie un coup parmi PIERRE, PAPIER ET CISEAUX alternativement dans cet ordre. 
       * @return le Coup selon un cycle PIERRE, PAPIER puis CISEAUX.
       */
      public Coup getCoup(){
	precedent = precedent.coupSuivant();
	return precedent;
      }// getCoup

}// Alternatif
