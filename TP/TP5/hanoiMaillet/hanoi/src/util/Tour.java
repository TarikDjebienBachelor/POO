package util;
/**
 * la classe des Tours (3 tours constituent les tours de Hanoi)
 * @author D.M. 
 * @version Fevrier 2006
 */

public class Tour {

  /** le numéro de la tour*/
  private int numero;
  /** l'anneau au sommet de la tour*/
  private Anneau sommet = null;
  /** le nombre d'anneau de la tour*/
  private int hauteur=0;    
    /**
     * constructeurs d'objets de la classe Tour
     */
    public Tour (int numero){
      this.numero=numero;
    }
     /** la tour reçoit un anneau
     * @param a l'Anneau posé au sommet de la tour
     */
  public void ajouter(Anneau a) {
    a.poserSur(sommet);
    sommet = a;
    hauteur++;
  }
     /** Un anneau est enlevé au sommet de la tour
     * @return  l'Anneau enlevé du sommet de la tour
     */
  public Anneau retirer(){
    Anneau a = sommet;
    sommet = sommet.getSous();
    a.enlever();
    hauteur--;
    return a;
  }
     /** donne la hauteur de la tour
     * @return  le nombre d'Anneaux  de la tour
     */
  public int getHauteur(){
    return this.hauteur;
  }
    /** donne la taille de l'anneau au sommet de la tour
     * @return  la taille de l'anneau au sommet de la tour
     */
  public int getTailleSommet(){
    return this.sommet.getTaille();
  }
  public String toString(){
    String s="Tour "+numero+" : "; 
    if (hauteur>0)
      for (Anneau a = this.sommet; a!=null;a=a.getSous())
        s+=a;
    return s;
  }
/** c'est juste pour tester cette classe : ne devrait pas être utilisée */
  public static void main (String [] args){
    Tour uneTour= new Tour(1);
    System.out.println(uneTour);
    for(int i=10;i>0;i--)
      uneTour.ajouter(new Anneau(i));
    System.out.println(uneTour);
    uneTour.retirer();
    uneTour.retirer();
    System.out.println(uneTour);
  }
}