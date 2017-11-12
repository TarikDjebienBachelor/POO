import javax.swing.JOptionPane; 
/**
 * la classe des choix du jeu de hanoi (3 tours constituent les tours de Hanoi)
 *<br/> <H2 style="color:red"> Permet de choisir entre manuel ou automatique Algorithme itératif ou récursif </H2> 
 * @author D.M. 
 * @version Fevrier 2006
 * @see <a href="Hanoi.png" > schema uml</a>
 */
public class ChoixHanoi2 {
/** Méthode principale<br/>
 * propose un choix et exécute l'une des méthode main de<br/>
 * Hanoi (récursif)<br/>
 * HanoiIt (ératif)<br/>
 * HanoiManuel<br/>
 */
  public static void main(String args[]) { 
    String ch;
    while (((ch=JOptionPane.showInputDialog(null,"Choisissez entre: \n<I>teratif\n<R>écursif\n<M>anuel"))                !=null) && 
                ((ch=ch.toUpperCase()).length()>1) && 
                ("MIR".indexOf(ch.charAt(0))<0));
    if (ch!=null){
      if (ch.equals("M")){ 
        System.out.println("Jeu Manuel");
        HanoiManuel h= new HanoiManuel();       // il s'agit ici d'une possibilité qui n'est
        h.main(null);                           // pas la meilleure (main est "static")
      } else if (ch.equals("I")) {
        System.out.println("Jeu Iteratif");
        String[] s =new String[1];
        s[0] =JOptionPane.showInputDialog(null,"Entrez le nombre de disques");
        HanoiIt.main(s);                        // préférez celle-ci pour les méthodes "static"
      } else if (ch.equals("R")){
        System.out.println("Jeu Récursif");          
        String[] s ={JOptionPane.showInputDialog(null,"Entrez le nombre de disques")};
        Hanoi.main(s);
      } 
    }
  }
}