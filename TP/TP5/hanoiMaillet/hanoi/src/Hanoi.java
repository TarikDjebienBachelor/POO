
import util.*;
/**
 * la classe du jeu de hanoi (3 tours constituent les "tours de Hanoi" : d�placements automatiques)
 *<br/> <H2 style="color:red"> Version R�cursive </H2>
 * @author D.M. 
 * @version Fevrier 2006
 * @see <a href="Hanoi.png" onclick="window.open(quoi.href,'','width=800,height=600,scrollbars=yes,resizable=yes,dependent=yes,status=no,toolbar=no,menubar=no');return false;"> schema uml</a>
 */
public class Hanoi {
  private Jeu leJeu;    
  /** Nombre de d�placements de disques*/
  private int nbDepl =0;
     /**
     * constructeurs d'objets de la classe Jeu
     */
  public Hanoi(int nbdsq){
      leJeu = new Jeu(nbdsq);
    }
  public String toString(){
    return leJeu.toString();
  }
  /** La m�thode r�cursive qui effectue les d�placements
  *@param hauteur Le nombre d'anneaux qu'il faut d�placer
  *@param depart La tour o� on pr�l�ve les anneaux
  *@param arrivee La tour o� on d�pose les anneaux
  *@param intermediaire La tour par laquelle les anneaux peuvent transiter
  *@param verbeux TRUE quand on veut voir les affichages interm�diaires
  */
  public void deplacerTour(int hauteur , int depart , int arrivee , int intermediaire, boolean verbeux) { 
    if (hauteur>0){
      this.deplacerTour(hauteur-1, depart, intermediaire , arrivee ,verbeux);
      if (verbeux) System.out.println(leJeu);
      nbDepl++;  
      leJeu.deplacement(depart,arrivee);
      this.deplacerTour(hauteur-1, intermediaire , arrivee , depart,verbeux);
    }
  } 
/** la m�thode principale de l'application */
  public static void main (String [] args){
    if (args.length>0){
      int nb=Integer.parseInt(args[0]);
        Hanoi jeuHanoi = new Hanoi(nb) ;
        jeuHanoi.deplacerTour(nb,0,2,1,true);
        System.out.println("En "+Integer.toString(jeuHanoi.nbDepl)+" d�placements");
    } else
  System.out.println("Nombre de disques en param�tre ");
  }
}
