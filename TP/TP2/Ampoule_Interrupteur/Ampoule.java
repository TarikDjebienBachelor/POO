/** 
 * Classe  Ampoule
 * @author Djebien Tarik
 * @version fevrier 2010
 */


public class Ampoule{

    /* Attributs */
     
     public int idAmpoule;
     private int puissance;
     private String couleur;
     public boolean bouton;
     public int idInterrupteurAssocié;
     
          
    /* Constructeurs */
     
     /**
      * Constructor of initialization for objects of class Ampoule.
      * Par default, l'ampoule construite est eteinte.
      * @param id identifiant à affecter à l'objet Ampoule construit.
      * @param p  puissance à affecter à l'objet Ampoule construit.
      * @param c  couleur à affecter à l'objet Ampoule construit.
      */
     public Ampoule(int id, int p, String c){
        this.idAmpoule = id;
        this.puissance = p;
        this.couleur = c;
        this.bouton = false;
        this.idInterrupteurAssocié = 0;
    
     }// Constructeur d'initialisation
    
    /* Accesseurs */
    
    /**
     * getNumeroSerie - Consultation du code serie de l'ampoule courante.
     * @return Le code serie (l'identifiant) de l'ampoule courante.
     */
    public int getNumeroSerie(){
        return this.idAmpoule;
    }// getNumeroSerie
    
    /**
     * getPuissance - Consultation de la puissance de l'ampoule courante.
     * @return La puissance de l'ampoule courante.
     */
    public int getPuissance(){
        return this.puissance;
    }// getPuissance
    
    /**
     * setPuissance - Modification de la puissance de l'ampoule courante.
     * @param p Puissance de l'ampoule courante à modifier.
     */
    public void setPuissance(int p){
        this.puissance = p;
    }// setPuissance    
    
    /**
     * getCouleur - Consultation de la couleur de l'ampoule courante.
     * @return La couleur de l'ampoule courante.
     */
    public String getCouleur(){
        return this.couleur;
    }// getCouleur  
    
    /**
     * setCouleur - Modification de la couleur de l'ampoule courante.
     * @param c Couleur de l'ampoule courante à modifier.
     */
    public void setCouleur(String c){
        this.couleur = c;
    }// setCouleur   
    
    /* Methodes */
    
    /**
     * toString - description de l'ampoule courante.
     * @return "L'ampoule numero [0-9][0-9]* a une puissance de [0-9][0-9]* Watt, 
     * elle est de couleur (unecouleur), elle (est|n'est pas) allumée."
     */
    public String toString(){
        String lumiere = ( this.bouton == true)? "est":"n'est pas";
        return "L'ampoule numero "+this.idAmpoule+" a une puissance de "+this.puissance+" Watt, elle est de couleur "+this.couleur+", elle "+lumiere+" allumée.";
    }// toString 
    
    /**
     * estAllume - Predicat : l'ampoule est - elle allumée? 
     * @return  TRUE si l'ampoule courante est allumée FALSE sinon.
     */
    
    public boolean estAllume(){
        return this.bouton;
    }// estAllume
    
}// classe Ampoule
