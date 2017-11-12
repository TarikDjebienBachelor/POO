package PierrePapierCiseaux;

/** 
 * <p style= "font-size: 170%;" >  Classe  PierrePapierCiseaux.Strategie </p>
 * @author Djebien Tarik
 * @version avril 2010
 */
 
public interface Strategie{
      /**
       * getCoup - renvoie un coup parmi PIERRE, PAPIER ET CISEAUX adapte a la strategie courante. 
       * @return le Coup selon la strategie.
       */    
    public Coup getCoup();
}// Stategie
