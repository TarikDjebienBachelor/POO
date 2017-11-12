
import util.*;
/**
 * la classe du jeu de hanoi (3 tours constituent les "tours de Hanoi" : déplacements automatiques)
 *<br/> <H2 style="color:red"> Version itérative </H2> 
 * @author D.M. 
 * @version Fevrier 2006
 * @see <a href="Hanoi.png" > schema uml</a>
 */
public class HanoiIt {
  private Jeu leJeu;    
  /** Nombre de déplacements de disques*/
  private int nbDepl =0;
  private int laTourDuPetit = 0;
     /**
     * constructeurs d'objets de la classe HanoiIt (itératif)
     */
  public HanoiIt(int nbdsq){
      leJeu = new Jeu(nbdsq);
    }
     /**
     * Pour l'affichage du jeu
     */
  public String toString(){
    return leJeu.toString();
  }
  /** La méthode  qui effectue le déplacement du plus petit disque
  *@param d 0 déplacement du petit sur la tour située à sa droite <br /> d=1 à sa gauche <br /> (on imagine les tours disposées en cercle) 
  */
  public void deplacer1(int d) { 
    int aCote = (laTourDuPetit+1+d)%3; 
    leJeu.deplacement(this.laTourDuPetit,aCote);
    this.laTourDuPetit = aCote ;
    this.nbDepl++;
    }
 

  
 /*
  public void deplacer2() { 
    boucles:
      for (int i = 0;i<3; i++)
        for (int j = 0;j<3; j++)
          if ((i!=this.laTourDuPetit) && (i!=j) && leJeu.deplacementPossible(i,j)){
            leJeu.deplacement(i,j);
            this.nbDepl++;
            break boucles;
          }
    }
 */  
  /** La méthode  qui effectue le déplacement du disque sur les 
  * tours voisines de celle qui contient le plus petit
  *<br /> remarque : il n'y a qu'un déplacement possible
  */
  public void deplacer2() { 
    int i = (this.laTourDuPetit +1) % 3;
    int j = (this.laTourDuPetit +2) % 3;
    if (leJeu.deplacementPossible(i,j))
      leJeu.deplacement(i,j);
    else  
      leJeu.deplacement(j,i);
    this.nbDepl++;
  }
/** la méthode principale de l'application */
  public static void main (String [] args){
    if (args.length>0){
      int nb=Integer.parseInt(args[0]);
        HanoiIt jeuHanoi = new HanoiIt(nb) ;
        nb = nb % 2;
        System.out.println(jeuHanoi);
        jeuHanoi.deplacer1(nb);
        System.out.println(jeuHanoi);
        while (!jeuHanoi.leJeu.fini()){
          jeuHanoi.deplacer2();
          System.out.println(jeuHanoi);
          jeuHanoi.deplacer1(nb);
          System.out.println(jeuHanoi);
        }    
        System.out.println("En "+Integer.toString(jeuHanoi.nbDepl)+" déplacements");
    } else
  System.out.println("Nombre de disques en paramètre ");
  }
}
