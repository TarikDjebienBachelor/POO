package util;
/**
 * la classe du jeu  d�finie et manipule les 3 tours 
 * Certaines m�thodes ne seront pas utilis�es dans la version r�cursive
 * @author D.M. 
 * @version Fevrier 2006
 */
public class Jeu {
   /** le nombre d'anneaux au d�part et passant d'une tour � l'autre */
  private int nbAnneaux;
   /** les 3 tours d�finissant le jeu */ 
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
  /** Indique la fin des d�placements
  *@return TRUE quand tous les anneaux sont sur la tour 2
  */
  public boolean fini(){
    return lesTours[2].getHauteur() == nbAnneaux;
  }
  /** Indique si le d�placement est autoris�
  *@param depart La tour o� on pr�l�ve l'anneau
  *@param arrivee La tour o� on d�pose l'anneau
  *@return vrai quand la tour d'arriv�e peut 
  * r�cevoir l'anneau pr�lev� sur la tour de d�part
  */
  public boolean deplacementPossible(int depart, int arrivee){
    return (lesTours[depart].getHauteur()>0) && (
      (lesTours[arrivee].getHauteur()==0)||
      (lesTours[arrivee].getTailleSommet()>lesTours[depart].getTailleSommet()));
  }
  /** Le d�placement (la v�rification pr�c�dente doit �tre faite avant) 
  * d'invoquer cette m�thode
  *@param depart La tour o� on pr�l�ve l'anneau
  *@param arrivee La tour o� on d�pose l'anneau
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
/** c'est juste pour tester cette classe : ne devrait pas �tre utilis�e */
  public static void main (String [] args){
    Jeu leJeu = new Jeu(6);
    System.out.println(leJeu);
  
    System.out.println("D�placement de 0 --> 1");
    if (leJeu.deplacementPossible(0,1)){
      leJeu.deplacement(0,1);
      System.out.println(leJeu);
    } else
      System.out.println("D�placement Impossible");
  
    System.out.println("D�placement de 0 --> 2");
    if (leJeu.deplacementPossible(0,2)){
      leJeu.deplacement(0,2);
      System.out.println(leJeu);
    } else
      System.out.println("D�placement Impossible");
  
  
    System.out.println("D�placement de 0 --> 1");
    if (leJeu.deplacementPossible(0,1)){
      leJeu.deplacement(0,1);
      System.out.println(leJeu);
    } else
      System.out.println("D�placement Impossible"); 
  
  }
  }