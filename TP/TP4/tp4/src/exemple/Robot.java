package exemple;  
import exemple.util.*;

/**
 * Le robot : capable de porter une caisse 
 * a la fois et de la deposer sur un tapis roulant
 * 
 * @author jc 
 * @version 2007-2008
 */


public class Robot {
    /**
     * constructeurs d'objets de la classe Robot
     */
    public Robot() {
	this.caisseTenue = null;
    }
    
    // les attributs de la classe Robot
    /** la caisse actuellement portee par le robot */
    private Caisse caisseTenue;
    
    // les methodes de la classe Robot
    /** le robot prend une caisse si il n'en tenait aucune
     * @param caisse la caisse prise
     */
    public void prend(Caisse caisse) {
        if (!this.porteCaisse()) {
            this.caisseTenue = caisse;
	}
    }
    /** le robot pose la caisse qu'il tient sur le tapis precise
     * @param tapis le tapis sur lequel la caisse est deposee
     */
    public void poseSur(TapisRoulant tapis) {
        if (this.porteCaisse() && tapis.accepte(caisseTenue) && ! tapis.estPlein()) {
            tapis.recoit(caisseTenue);
            this.caisseTenue = null;
        }   
        else {
            if (! this.porteCaisse()) {
                System.out.println("pas de caisse tenue");
            }
            else if (tapis.estPlein()) {
                System.out.println("tapis plein");
            }
            else {
                System.out.println("caisse trop lourde pour le tapis : " + 
				   this.caisseTenue.donnePoids() +" pour "+tapis.donnePoidsMax()+" au max");
            }
        }
    }
    /** retourne <t>vrai</t> si le robot tient une caisse
     * @return <t>vrai</t> si le robot tient une caisse
     */
    public boolean porteCaisse() {
        return this.caisseTenue != null;
    }
    
    public static void main(String[] args) {

	System.out.println("debut du main de robot.Robot");	

	Robot robbie = new Robot();
	TapisRoulant tapis1 = new TapisRoulant(50);
	TapisRoulant tapis2 = new TapisRoulant(150);
	Caisse caisse10 = new Caisse(10);
	Caisse caisse15 = new Caisse(15);
	Caisse caisse100 = new Caisse(100);
	Caisse caisse60 = new Caisse(60);

	robbie.prend(caisse10);
	robbie.poseSur(tapis1);
	robbie.prend(caisse15);
	robbie.poseSur(tapis1);
	robbie.prend(caisse100);
	robbie.poseSur(tapis2);
	
	tapis1.affiche();

	System.out.println("fin du main de robot.Robot");
    }    
}


