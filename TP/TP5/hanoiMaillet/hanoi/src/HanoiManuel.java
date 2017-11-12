import util.*;
import javax.swing.JOptionPane;
/**
 * la classe  du jeu de hanoi (3 tours constituent les "tours de Hanoi" : déplacements manuels)
 *<br/> <H2 style="color:red"> Version Manuelle : c'est l'utilisateur qui déplace les disques </H2> 
 * @author D.M. 
 * @version Fevrier 2006
 * @see <a href="Hanoi.png" > schema uml</a>
 */
public class HanoiManuel {
  private Jeu leJeu;      
  /** Nombre de déplacements de disques*/
  private int nbDepl =0;
     /**
     * Pour l'affichage du jeu
     */
  public String toString(){
    return leJeu.toString();
  }
     /**
     * Permet de d'entrer et de controler une valeur entière
     *@return le nombre de disques sur la tour de départ
     */
  public int definirTaille(){  
    String valr ;
    boolean err=true;
    int n=0;
    while (err){
      valr = JOptionPane.showInputDialog(null,"Entrez un entier");
      err = (valr==null) || valr.equals("");
      try {n=Integer.parseInt(valr) ;} catch (Exception e) {err=true;}
      if (err) JOptionPane.showMessageDialog(null,"Vous devez entrer un entier");    
    }
    return n;
  }
     /**
     * Permet de d'entrer les numéros des tours de départ et d'arrivée
     *@return 2 caractères numériques parmi 0,1 ou 2
     */
  public String getDeplacement(){  
    String valr ;
    while ( ((valr = JOptionPane.showInputDialog(null,"Entrez 2 caractères : depart destination"))==                  null) || 
                    (valr.equals("")) || 
                    (valr.length()!=2) || 
                    ("012".indexOf(valr.charAt(0))<0) || 
                    ("012".indexOf(valr.charAt(1))<0) ){
      JOptionPane.showMessageDialog(null,"Vous devez 2 caractères parmi 0,1 ou 2");    
    }
    return valr;
  }
/** la méthode principale de l'application */
  public static void main (String [] args){
    System.out.println("Tours de Hanoi");
    System.out.println("Choisissez le nombre de disques");
    HanoiManuel h= new HanoiManuel();  
    h.leJeu = new Jeu(h.definirTaille());
    System.out.println("donnez 2 chiffres ");
    String da;
    int d;int a;
    System.out.println(h);
    while (!h.leJeu.fini()){
      System.out.println("deplacement : "+(h.nbDepl+1));
      da = h.getDeplacement();
      d = da.charAt(0)-'0';
      a = da.charAt(1)-'0';
      if (h.leJeu.deplacementPossible(d,a)){
        h.leJeu.deplacement(d,a);
        h.nbDepl++;
      } else        
        System.out.println("deplacement Impossible");
      System.out.println(h);
    }
    System.out.println("nombre de déplacements total : "+h.nbDepl);
  }
}