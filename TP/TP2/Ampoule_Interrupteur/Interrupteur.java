/** 
 * Classe  Interrupteur
 * @author Djebien Tarik
 * @version fevrier 2010
 */

public class Interrupteur{
     
    /* Attributs */
     private int idInterrupteur; // ID de l'interrupteur
     private Ampoule connexion; // Ampoule connecté à l'interrupteur
     private boolean etat; // Etat de l'interrupteur : ON ou OFF
        
    /* Constructeurs */
     
     /**
      * Constructor of initialization for objects of class Interrupteur.
      * Par default, l'interrupteur est sur position OFF.
      * Il a le même ID que l'ampoule qui lui est associée.
      * @param a Ampoule à connecter avec l'interrupteur construit.
      */
     
    public Interrupteur(Ampoule a){      
      if ( a.idInterrupteurAssocié == 0 ) {
        this.etat = false;
        this.connexion = a;
        a.idInterrupteurAssocié = a.idAmpoule;
        this.idInterrupteur = a.idInterrupteurAssocié;
      }
      else {}
    }// Constructeur d'initialisation
    
   /* Accesseurs */
    
    /**
     * getAmpoule - Consultation de l'ID de l'ampoule associée à l'interrupteur courant.
     * @return L'ID de l'ampoule associée à l'interrupteur courant.
     */
    public int getAmpoule(){
        return this.connexion.idAmpoule;
    }// getAmpoule
    
    /* Methodes */ 
    
    
    /**
     * changerConnexionInterrupteur - relier l'interrupteur courant à une nouvelle ampoule.
     * @param a L'ampoule a relier à l'interrupteur courant.     
     */
    public void changerConnexionInterrupteur(Ampoule a){
        this.etat = false;
        if (this.connexion != null){ this.connexion.bouton = false;}
        this.connexion = null;
        this.connexion = a;
    }// changerConnexionInterrupteur
    
    /**
     * allumer - allumer l'interrupteur: passer en postion ON.
     */
    public void allumer(){
        this.etat = true;
        this.connexion.bouton = true;
    }// allumer    
    
    /**
     * eteindre - eteindre l'interrupteur: passer en postion OFF.
     */
    public void eteindre(){
        this.etat = false;
        this.connexion.bouton = false;
    }// eteindre    
    
    /**
     * toString - description de l'interrupteur courant.
     * @return  "L'interrupteur numero [0-9]* est connecté à l'ampoule (ID Ampoule associé), il est en position (ON/OFF)."
     */
    public String toString(){
        String voyant = ( this.etat == true )? "ON" : "OFF";
        return "L'interrupteur numero "+this.idInterrupteur+" est connecté à l'ampoule "+this.connexion.idAmpoule+", il est en position "+voyant+".";
    }// toString 

}// class  Interrupteur