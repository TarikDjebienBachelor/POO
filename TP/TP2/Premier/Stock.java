/** 
 * Classe Stock
 * @author Djebien Tarik
 * @version fevrier 2010
 */

 public class Stock{
     
    /* Attributs */
     private int quantite;
     
    /* Constructeurs */
     
     /**
      * Constructor for objects of class Stock.
      */
     
    public Stock(){
        this.quantite = 0;
    }// Constructeur par default

     /**
      * Constructor of initialization for objects of class Stock.
      * @param n quantite à affecter à l'objet construit.
      */
     
    public Stock(int n){
        this.quantite = n;
    }// Constructeur d'initialisation
    
    /* Accesseurs */
    
    /**
     * getQuantite - Consultation de la quantite de l'instance courante.
     * @return La quantite de l'instance courante.
     */
    
    public int getQuantite(){
        return this.quantite;
    }// getQuantite
    
    /* Methodes */
    
    /**
     * ajoute - ajoute et modifie la quantite de l'instance courante.
     * @param n quantite à ajouter à l'instance courante.
     */
    
    public void ajoute(int n){
        this.quantite += n;
    }// ajoute

    /**
     * retire - enleve et modifie la quantite de l'instance courante.
     * @param n quantite à retirer
     * @return la quantite exacte réellement retirer du stock
     */
    
    public int retire(int n){
        // Traitement conditionnelle
        if ( n <= this.quantite ) {
           this.quantite -= n;
           return n;
        }
        else{
        // Sauvegarde temporaire de la quantite courante
           int save = this.quantite;
           this.quantite = 0;
           return save;
        }
    }// retire    
    
}// class Stock