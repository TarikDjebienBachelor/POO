package util;
/**
 * la classe du jeu  définie et manipule les 3 tours 
 * Certaines méthodes ne seront pas utilisées dans la version récursive
 * @author D.M. 
 * @version Fevrier 2006
 */
public class Jeu {
   /** le nombre d'anneaux au départ et passant d'une tour à l'autre */
  private int nbAnneaux;
   /** les 3 tours définissant le jeu */ 
  private Tour[] lesTours = new Tour[3];
     /**
     * constructeurs d'objets de la classe Jeu
     */
    public Jeu (int nbAnneaux){
      this.nbAnneaux=nbAnneaux;
    for (int i=0;i<3;i++) 
      lesTours[i]= new Tour(i);
    for(int i=nbAnneaux;i>0;i--)
      lesTours[0].ajouter(new Anneau(i));  
    }
  /** Indique la fin des déplacements
  *@return TRUE quand tous les anneaux sont sur la tour 2
  */
  public boolean fini(){
    return lesTours[2].getHauteur() == nbAnneaux;
  }
  /** Indique si le déplacement est autorisé
  *@param depart La tour où on prélève l'anneau
  *@param arrivee La tour où on dépose l'anneau
  *@return vrai quand la tour d'arrivée peut 
  * récevoir l'anneau prélevé sur la tour de départ
  */
  public boolean deplacementPossible(int depart, int arrivee){
    return (lesTours[depart].getHauteur()>0) && (
      (lesTours[arrivee].getHauteur()==0)||
      (lesTours[arrivee].getTailleSommet()>lesTours[depart].getTailleSommet()));
  }
  /** Le déplacement (la vérification précédente doit être faite avant) 
  * d'invoquer cette méthode
  *@param depart La tour où on prélève l'anneau
  *@param arrivee La tour où on dépose l'anneau
  */
  public void deplacement(int depart, int arrivee){
      lesTours[arrivee].ajouter(lesTours[depart].retirer());
  } 
     /**
     * Pour l'affichage du jeu
     */
  public String toString(){
    String s="Tour de Hanoi \n"; 
    for (int i=0;i<3;i++) 
        s+= lesTours[i] + "\n";
    return s;
  }
  /**  La hauteur de la tour 
  *@param le numero de la tour
  *@return Le nombre d'anneau sur la tour 
  */
  public int getHauteur(int numTour){
    return lesTours[numTour].getHauteur();
  }
/** c'est juste pour tester cette classe : ne devrait pas être utilisée */
  public static void main (String [] args){
    Jeu leJeu = new Jeu(6);
    System.out.println(leJeu);
  
    System.out.println("Déplacement de 0 --> 1");
    if (leJeu.deplacementPossible(0,1)){
      leJeu.deplacement(0,1);
      System.out.println(leJeu);
    } else
      System.out.println("Déplacement Impossible");
  
    System.out.println("Déplacement de 0 --> 2");
    if (leJeu.deplacementPossible(0,2)){
      leJeu.deplacement(0,2);
      System.out.println(leJeu);
    } else
      System.out.println("Déplacement Impossible");
  
  
    System.out.println("Déplacement de 0 --> 1");
    if (leJeu.deplacementPossible(0,1)){
      leJeu.deplacement(0,1);
      System.out.println(leJeu);
    } else
      System.out.println("Déplacement Impossible"); 
  
  }
  }