package util;
/**
 * la classe des Anneaux pos�s sur les Tours 
 * @author D.M. 
 * @version Fevrier 2006
 */
public class Anneau {
  /** La taille de l'anneau */
  private int taille;
  /** l'anneau sous l'anneau courant*/
  private Anneau dessous = null;
     /**
     * constructeurs d'objets de la classe Anneau
     */
  public Anneau (int taille){
    this.taille=taille;
  }
     /** On pose l'anneau courant sur l'anneau a
     * @param a : l'Anneau pos� en principe au sommet d'une tour
     */
  public void poserSur(Anneau a){
    this.dessous = a ;
  }
      /**  l'anneau courant est enlev� en principe du sommet d'une tour
      * <br>il n'y a donc plus d'anneau dessous
       */
  public void enlever(){
    this.dessous = null;
  }
    /** Indique la taille de l'anneau courant
    *@return La taille de l'anneau
    */
  public int getTaille(){
    return this.taille;
  }
    /** renvoie l'anneau situ� en dessous
    *@return  l'anneau
    */
  public Anneau getSous(){
    return this.dessous ;
  }
  public String toString(){
    return "("+this.taille+")";
  }
  /** c'est juste pour tester cette classe : ne devrait pas �tre utilis�e */
  
  public static void main (String [] args){
    Anneau a = new Anneau(1);
    Anneau b = new Anneau(2);
    a.poserSur(b);
    System.out.println(a+" sur "+a.getSous());
    a. enlever();
    System.out.println(a+" sur "+a.getSous());
  }
}