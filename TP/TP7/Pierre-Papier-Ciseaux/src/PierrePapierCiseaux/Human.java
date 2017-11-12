package PierrePapierCiseaux;
import java.util.Scanner;
/** 
 * <p style= "font-size: 170%;" >  Classe  PierrePapierCiseaux.Aleatoire </p>
 * @author Djebien Tarik
 * @version avril 2010
 */
public class Human implements Strategie{
      
      /**
       * getCoup - renvoie un coup choisit par l'utilisateur. 
       * @return le Coup de la selection de l'utilisateur.
       */
      public Coup getCoup(){
	// Selection de coup
	System.out.println("Entrez votre coup :");
	System.out.println("- Tapez 'pierre' pour pierre.\n- Tapez 'papier' pour papier.\n- Tapez 'ciseaux' pour ciseaux.");
	Scanner sc = new Scanner(System.in);
	String monCoup = sc.nextLine();
	Coup selection = Coup.valueOf(monCoup);
	return selection;
      }// getCoup
      
}// Human
