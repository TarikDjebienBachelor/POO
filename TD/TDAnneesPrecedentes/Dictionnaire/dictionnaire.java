Une classe dictionnaire

import java.io.*;

public class Dico {
  // Lettre � stocker
  char lettre;
  // Dictionnaire des suffixes
  Dico suffixe;
  // Dictionnaire des mots commen�ants par une lettre plus grande
  // que 'lettre' dans l'ordre alphab�tique
  Dico autreLettre;
  
  // Constructeur simple initialisant chacun des attributs d'un
  // objet Dico.
  private Dico(char lettre, Dico suffixe, Dico autreLettre) {
    this.lettre = lettre;
    this.suffixe = suffixe;
    this.autreLettre = autreLettre;
  }

  // Constructeur r�cursif construisant un dictionnaire contenant
  // un unique mot pass� en argument
  public Dico(String mot) {
    if (mot == null || mot.length() == 0) {
      this.lettre = '*';
      this.suffixe = null;
    } else {
      this.lettre = mot.charAt(0);
      this.suffixe = new Dico(mot.substring(1));
    }
    this.autreLettre = null;
  }
  // M�thode statique ajoutant mot au dictionnaire pass�
  // en second argument
  public static Dico ajouter(String mot, Dico precedent) {
    // Si le dictionnaire est vide construire un dictionnaire
    // contenant uniquement mot.
    if (precedent == null) {
      return new Dico(mot);
    }
    // Si mot null ne pas modifier le dictionnaire
    if(mot == null) {
      return precedent;
    }
    // Si longueur du mot nulle et '*' d�j� � cet endroit
    // ne pas modifier le dictionnaire ('*' plus petit que
    // toutes les lettres dans l'ordre < ), sinon ajouter '*'
    // avant toutes les autres lettres contenu dans le dictionnaire
    // pr�c�dent.
    if(mot.length() == 0) {
      if (precedent.lettre == '*') {
        return precedent;
      } else {
        return new Dico('*',null,precedent);
      }
    }
    // Si la premi�re lettre du mot est plus petite que toutes les premi�res
    // lettres des autres mots du dictionnaire ajouter le mot avant tous 
    // les autres mots.
    if (precedent.lettre > mot.charAt(0)) {
      Dico temp = new Dico(mot);
      temp.autreLettre = precedent;
      return temp;
    }
    // Si la premi�re lettre du mot est plus grande que la premi�re lettre
    // du dictionnaire, ajouter le mot au dictionnaire des mots commen�ants
    // par d'autres lettres
    if (precedent.lettre < mot.charAt(0)) {
      precedent.autreLettre = ajouter(mot,precedent.autreLettre);
      return precedent;
    }
    // Si la premi�re lettre du mot est d�j� dans le dictionnaire, 
    // ajouter le suffie du mot au dictionnaire des suffixes de cette lettre.
    precedent.suffixe = ajouter(mot.substring(1),precedent.suffixe);
    return precedent;
  }

  // M�thode de recherche du mot dans le dictionnaire.
  public boolean rechercher(String mot) {
    // Si le mot ou le dictionnaire sont vide retourner faux
    if (mot == null) {
      return false;
    }
    // Si la longueur du mot est nulle, retourner vrai si 
    // la lettre courante est '*', sinon retourner faux.
    if (mot.length() == 0){
      return (lettre == '*');
    }
    // Si la premi�re lettre du mot est plus petite que la 
    // premi�re lettre de tous les mots du dictionnaire le 
    // mot n'est pas dans le dictionnaire.
    if (lettre > mot.charAt(0)) {
      return false;
    }
    // Si la premi�re lettre du mot est plus grande que la lettre courante,
    // rechercher le mot dans le dictionnaire des mots commen�ants par une autre lettre
    if (lettre < mot.charAt(0)) {
      return autreLettre.rechercher(mot);
    }
    // Si la premi�re lettre du mot est la lettre courante, rechercher le suffixe du mot 
    // dans le dictionnaire.
    return suffixe.rechercher(mot.substring(1));
  }
  // M�thode utilis�e par println() pour afficher le dictionnaire. 
  // Appelle l'autre m�thode toString avec un suffixe vide.
  public String toString(){
    return this.toString("");
  }
  // M�thode utilis�e pour afficher le dictionnaire.
  public String toString(String prefix){
    String tmp = "";
    if (lettre == '*'){
      // Si '*' est la lettre courante le pr�fixe est un mot du dictionnaire,
      // le stocker pour l'affichage suivi du caract�re '\n' (retour � la ligne).
      tmp = prefix + "\n";
    } else {
      // Sinon ajouter la lettre courante au pr�fixe pour afficher le dictionnaire des
      // suffixes.
      tmp = suffixe.toString(prefix+lettre);
    }
    // Si le dictionnaire des mots commen�ants par une autre lettre n'est pas vide
    // l'afficher.
    if(autreLettre != null) {
      tmp += autreLettre.toString(prefix);
    }
    return tmp;
  }
  
  // M�thode statique qui retire un mot du dictionnaire pass� en argument 
  public static Dico retirer(String mot, Dico precedent){
    if (mot == null) {
      return precedent;
    }
    if (precedent == null) {
      return null;
    }
    // Si mot vide retirer '*'
    if (mot.length() == 0) {
      if (precedent.lettre == '*') {
        return precedent.autreLettre;
      } else {
        return precedent;
      }
    }
    // Si la premi�re lettre du mot plus petite que la lettre courante,
    // le mot n'est pas dans le dictionnaire, retourner le dictionnaire 
    // inchang�.
    if (precedent.lettre > mot.charAt(0)) {
      return precedent;
    }
    // Si la premi�re lettre du mot est sup�rieure � la lettre courante,
    // mettre � jour le dictionnaire des mots commen�ants par une autre 
    // lettre
    if (precedent.lettre < mot.charAt(0)) {
      precedent.autreLettre = retirer(mot,precedent.autreLettre);
      return precedent;
    }
    // Si la premi�re lettre du mot est �gale � la lettre courante, 
    // mettre � jour le dictionnaire des suffixe en retirant le suffixe du mot.
    // Si le dictionnaire des suffixe est non vide retourner le dictionnaire 
    // pr�c�dent mis � jour sinon, il n'y plus de mot dans le dictionnaire commen�ant 
    // par la lettre courante elle est donc �limin�e en retournant le dictionnaire des 
    // mots commen�ants par une autre lettre. 
    precedent.suffixe = retirer(mot.substring(1),precedent.suffixe);
    if(precedent.suffixe==null) {
      return precedent.autreLettre;
    }
    return precedent;
  }
  
  // V�rificateur orthographique qui lit l'ensemble des mots du dictionnaire dans un fichier
  // pass� en premier argument et v�rifie que les mots du fichier pass� en second argument font 
  // partie du dictionnaire.
  public static void main(String args[]) throws Exception {
   if(args.length != 2) {
      System.err.println("Usage: java Dico <dico> <fichier>");
      System.exit(1);
    }
    Dico d = null;
    FileReader dico = new FileReader(args[0]);
    StreamTokenizer st = new StreamTokenizer(dico);
    st.ordinaryChar('.');
    while (st.nextToken() != StreamTokenizer.TT_EOF){
      if(st.ttype == StreamTokenizer.TT_WORD)
        d = ajouter(st.sval,d);
    }
    FileReader fichier = new FileReader(args[1]);
    st = new StreamTokenizer(fichier);
    st.ordinaryChar('.');
    while (st.nextToken() != StreamTokenizer.TT_EOF){
      if(st.ttype == StreamTokenizer.TT_WORD)
        if(!rechercher(st.sval,d))
          System.out.println(st.sval);
    }
  }
}