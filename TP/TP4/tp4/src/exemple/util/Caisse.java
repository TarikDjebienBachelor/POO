package exemple.util;  


/**
 * la classe des caisses
 *  Dans cette version simple elles sont de differents poids, mais on ne distingue
 *  pas les instances autrement
 * 
 * @author jc 
 * @version 2007-2008
 */

public class Caisse {   
    
    /**
     * constructeurs d'objets de la classe Caisse
     */
    public Caisse(int poids) {
        this.poids = poids;
    }
    
    // les attributs de la classe Caisse
    /** le poids de la caisse */
    private int poids;
    
    // les methodes de la classe Caisse 
     /** donnePoids - retourne le poids de la caisse courante.
     * @return le poids de l'instance courante caisse.
     */
    public int donnePoids() {
        return this.poids;
    }
    
 
     /** toString - description de la caisse courante.
     * @return la description de l'instance courante caisse sous la forme "caisse de poids <son poids > ".
     */
    public String toString() {
        return "caisse de poids "+this.poids;
    }
}
