package hanoi.io;

/**
* Définit une classe pour la saisie des commandes de
* déplacement d'un utilisateur du progamme Hanoi
* @author yroos
*/
public class HanoiInput {
	
	// contient la dernière saisie de l'utilisateur sous forme de cha^ine
  private String lastInput ;
	
  /** Construit un nouveau HanoiInput avec une dernière saisie nulle
  */
  public HanoiInput() { 
	this.lastInput = null ;
  }
	
	// convertit un "nom" de tour en numéro
  private static int num(char c) {
		switch(c) {
			case 'g' : return 0 ;
			case 'c' : return 1 ;
			case 'd' : return 2 ;
			default : return - 1 ;
		}
	}
	
	//convertit en numéro de tour un numéro de caractère
  // d'une commande de déplacement
  private int numDe(int i) {
  	if (! this.isDeplacement()) throw new IllegalStateException() ;
  		return HanoiInput.num(this.lastInput.charAt(i)) ;
	}
	
	// Vérifie si une cha^ine de caractères est une entrée correcte :
  // déplacement ou quit
  private static boolean isAnInput(String s) {
		if (s == null) return false ;
		if (s.equals("quit")) return true ;
		if (s.length() != 2) return false ;
		return HanoiInput.num(s.charAt(0)) > -1 && HanoiInput.num(s.charAt(1)) > -1 ;
	}
	
  /** Stocke la dernière saisie correcte de l'utilisateur
  * attend une nouvelle saisie jusqu'à l'obtention d'une saisie correcte
  */
  public void readInput() {
		String s = null ;
		while (! isAnInput(s)) {			
			System.out.print("> ") ;
			try {	
				s = Input.readString().trim().toLowerCase() ;
			} catch (java.io.IOException e) {s = null ;}
			if (! isAnInput(s)) System.out.println("   ?") ;			
		}
		this.lastInput = s ;
	}
  	
  /** Détermine si la dernière saisie correcte de l'utilisateur
  * est un déplacement ou un quit
  * @return true ssi il s'agit d'un déplacement
  */
  public boolean isDeplacement() {
	return ! "quit".equals(this.lastInput) ;
  }
  	
  /** Retourne le numéro de tour de départ si la
  * dernière saisie est un déplacement.
  * @return le numéro de tour de départ
  * @throws IllegalStateException si la dernière saisie n'est pas un déplacement
  */
  public int getDe() {
    return this.numDe(0) ;
  }
	
  /** Retourne le numéro de tour d'arrivée si la
  * dernière saisie est un déplacement.
  * @return le numéro de tour de départ
  * @throws IllegalStateException si la dernière saisie n'est pas un déplacement
  */
  public int getVers() {
     return this.numDe(1) ;
   }
	

}
