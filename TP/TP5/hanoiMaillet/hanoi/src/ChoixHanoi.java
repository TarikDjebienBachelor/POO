import javax.swing.*; 
import java.awt.event.*; 
public class ChoixHanoi extends JDialog  implements ActionListener {

 // ,String titre,String msg,int type
  public ChoixHanoi(JFrame fp) { 
    super(fp,"Mode",true); // appel au constructeur de Dialog 
    // true --> fenêtre modale 
    add("Center",new JLabel("Choisissez"));
    JPanel pbouton=new JPanel(); // var locale référençant la ligne de boutons 
    JButton b; // var locale référençant les boutons succesifs
   
      pbouton.add(b=new JButton("Iteratif")); // ajout du bouton 
      b.addActionListener(this); // auto-inscription
  
    
      pbouton.add(b=new JButton("Récursif")); // ajout du bouton 
      b.addActionListener(this); // auto-inscription
    

      pbouton.add(b=new JButton("Manuel")); // ajout du bouton 
      b.addActionListener(this); // auto-inscription 

    add("East",pbouton);
    pack(); // calcul de la meilleure taille 
    setResizable(false); // fenêtre non retaillable 
  show() ;
  }

  /** méthode exécutée sur actionnement d'un des 3 boutons */
  public void actionPerformed(ActionEvent e) {
    setVisible(false);  // cacher le Dialogue, donc débloquer 
    if (e.getActionCommand().equals("Iteratif")) {
      System.out.println("Jeu Iteratif");
      String[] s =new String[1];
      s[0] =JOptionPane.showInputDialog(null,"Entrez le nombre de disques");
      HanoiIt.main(s);
    } else if (e.getActionCommand().equals("Récursif")){
      System.out.println("Jeu Récursif"); 
      String[] s ={JOptionPane.showInputDialog(null,"Entrez le nombre de disques")};
      Hanoi.main(s);
    } else if (e.getActionCommand().equals("Manuel")){ 
      System.out.println("Jeu Manuel");
      HanoiManuel.main(null);
    } 
    System.exit(0);
  }

  public static void main(String args[]) { 
    JFrame f=new JFrame("fenêtre principale");
    f.pack();
    f.show(); 
    ChoixHanoi w1=new ChoixHanoi(f); 
  }
}