package hanoi.util;


/** 
 * <p style= "font-size: 170%;" > Classe  hanoi.util.Disque </p>
 * @author Djebien Tarik
 * @version mars 2010
 */

 public class Disque{
     
    /* Attributs */
     private int taille;
     
    /* Constructeurs */
     
     /**
      * Constructor of initialization for objects of class hanoi.util.Disque.
      * @param N taille a affecter a l'objet disque construit.
      */
     
    public Disque(int N){
        this.taille = N;
    }// Constructeur d'initialisation
    
    /* Accesseurs et Mutateurs */
    
    /**
     * getTaille - Consultation de la taille de l'instance disque courante.
     * @return la taille de l'instance disque courante.
     */
    
    public int getTaille(){
        return this.taille;
    }// getTaille
    
    
    /* Methodes */
    
    /**
     * compareTo - description.
     * @param d Le disque avec lequel on teste la comparaison avec le disque courant.
     * @return  TRUE si le disque en parametre est plus grand que le disque courant, FALSE sinon.
     */
    
    public boolean compareTo(Disque d){
        return (d.getTaille() >= this.taille);
    }// compareTo
    

}// class Disque
