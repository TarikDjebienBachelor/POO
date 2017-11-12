package compteur;

/**
 * Counter.java
 * 
 * @author <a href="mailto:jean-christophe.routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */

public interface Compteur {
    /** fournit la valeur courante du compteur
     * @return  la valeur courante du compteur
     */
    public int getCurrentValue();
    /** incremente la valeur du compteur
     */
    public void increment();
    /** initialise le compteur
     * @param init la valeur initiale du compteur
     */
    public void init(int init);
}// Counter
