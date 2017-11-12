import javax.swing.JOptionPane; 
/**
 * la classe des choix du jeu de hanoi (3 tours constituent les tours de Hanoi)
 *<br/> <H2 style="color:red"> Permet de choisir entre manuel ou automatique Algorithme it�ratif ou r�cursif </H2> 
 * @author D.M. 
 * @version Fevrier 2006
 * @see <a href="Hanoi.png" > schema uml</a>
 */
public class ChoixHanoi2 {
/** M�thode principale<br/>
 * propose un choix et ex�cute l'une des m�thode main de<br/>
 * Hanoi (r�cursif)<br/>
 * HanoiIt (�ratif)<br/>
 * HanoiManuel<br/>
 */
  public static void main(String args[]) { 
    String ch;
    while (((ch=JOptionPane.showInputDialog(null,"Choisissez entre: \n<I>teratif\n<R>�cursif\n<M>anuel"))                !=null) && 
                ((ch=ch.toUpperCase()).length()>1) && 
                ("MIR".indexOf(ch.charAt(0))<0));
    if (ch!=null){
      if (ch.equals("M")){ 
        System.out.println("Jeu Manuel");
        HanoiManuel h= new HanoiManuel();       // il s'agit ici d'une possibilit� qui n'est
        h.main(null);                           // pas la meilleure (main est "static")
      } else if (ch.equals("I")) {
        System.out.println("Jeu Iteratif");
        String[] s =new String[1];
        s[0] =JOptionPane.showInputDialog(null,"Entrez le nombre de disques");
        HanoiIt.main(s);                        // pr�f�rez celle-ci pour les m�thodes "static"
      } else if (ch.equals("R")){
        System.out.println("Jeu R�cursif");          
        String[] s ={JOptionPane.showInputDialog(null,"Entrez le nombre de disques")};
        Hanoi.main(s);
      } 
    }
  }
}