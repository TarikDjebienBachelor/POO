package exemple.util;
import java.util.*; //pour pouvoir utiliser les classes du paquetage java.util
                    // par exemple ArrayList et Iterator

/**
 * la classe des TapisRoulant sur lesquels pn peut poser les caisses jusqu'un certain poids
 * les tapis ont une (meme) capacite maximale definie par <tt>tailleMax</tt>
 * @author jc 
 * @version 2007-2008
 */
public class TapisRoulant {
    
    /** le nombre maximal de caisse sur le tapid */
    static final private int capacite = 2;
    
    /**
     * constructeurs d'objets de la classe TapisRoulant
     */
    public TapisRoulant(int poidsMax) {
        this.poidsMax = poidsMax;
    }
    
    // les attributs de la classe TapisRoulant
    /** le poids maximum des caisses supportees */
    private int poidsMax;
    /** le tapis proprement dit : les caisses portees */
    private ArrayList tapis = new ArrayList();
    
    // les methodes de la classe TapisRoulant
    /** donne le poids maximal accepte
     * @return le pods maximal accepte
     */
    public int donnePoidsMax() { return this.poidsMax; }
    
    /** la tapis recoit une caisse 
     * @param caisse la caisse recue
     */
    public void recoit(Caisse caisse) {
        if (!this.estPlein()) {
            this.tapis.add(caisse);
        }
        else {          // pas de gestion d'exception pour l'instant
            System.out.println("tapis plein, impossible de deposer");
        }
    }
    /** indique si le tapis est plein
     * @return <tt>true</tt> si le tapis est plein de caisses
     */
    public boolean estPlein() {
        return this.tapis.size() == capacite;
    }
    /** verifie si le tapis peut accepter la caisse, ie. si elle n'est pas trop lourde
     * @param caisse : la caisse a verifier
     */
    public boolean accepte(Caisse caisse) {
        return caisse.donnePoids() <= this.poidsMax;
    }
    /** affiche le contenu du tapis roulant
     */
    public void affiche() {
        System.out.println("le tapis porte "+this.tapis.size()+" caisse(s)");
        for (Iterator it = this.tapis.iterator(); it.hasNext(); ) {
            System.out.println(it.next().toString());
        }                   
    }
    /** vide le tapis
     */
    public void videTapis() {
        Iterator lesCaisses_it = this.tapis.iterator();
        while(lesCaisses_it.hasNext()) {
            lesCaisses_it.next();
            lesCaisses_it.remove();
        }
    }
}
