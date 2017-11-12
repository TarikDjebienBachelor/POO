package hanoi;
import hanoi.util.*;
import hanoi.io.*;
import java.util.*;

/*
 *      Hanoi.java
 *      
 *      Copyright 2010 tarik User <tarik@ubuntu>
 *      
 *      This program is free software; you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation; either version 2 of the License, or
 *      (at your option) any later version.
 *      
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *      
 *      You should have received a copy of the GNU General Public License
 *      along with this program; if not, write to the Free Software
 *      Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 *      MA 02110-1301, USA.
 */

/* LE JEU DES TOURS DE HANOI. (RESOLUTION RECURSIVE) */

/** 
 * <p style= "font-size: 170%;" >  Classe  hanoi.Hanoi </p>
 * @author Djebien Tarik
 * @version mars 2010
 */

 public class Hanoi{
     
    /* Attributs */
    private Tour[] lesTours;
    
    /* Nombre de déplacements de disques*/
    private int nbDeplacement = 0;
        
    /* Constructeurs */
     
     /**
      * Constructor of initialization for objects of class Hanoi.
      * @param n nombre de disques maximal que l'on peut affecter au 3 tours construites.
      */
     
    public Hanoi(int n){
        this.lesTours = new Tour[3];
        this.lesTours[0] = new Tour(1,n);
        this.lesTours[1] = new Tour(2,n);
        this.lesTours[2] = new Tour(3,n);
        
        for(int i= n ; i > 0 ; i--){
		  this.lesTours[0].empiler(new Disque(i));
		}//for
    }// Constructeur d'initialisation Hanoi

    /* Accesseurs et Mutateurs */

     /**
     * getLesTours - Consultation des 3 tours du jeu de hanoi courant.
     * @return les tours situes sur l'instance hanoi courante.
     */
    public Tour[] getLesTours(){
        return this.lesTours;
    }// getLesTours    

     /**
     * getNbDeplacement - Consultation du nombre de deplacement total effectue pour terminer le jeu de hanoi courant.
     * @return le nombre de coups total pour terminer l'instance jeu hanoi courante.
     */
    public int getNbDeplacement(){
        return this.nbDeplacement;
    }// getNbDeplacement 
        
    /* Methodes */
    
     /**
      * isDeplacementValide - predicat qui teste si le deplacement d'un disque de la tour de depart vers la tour d'arrivee est autorise.
      * @param depart la tour de depart.
      * @param arrivee la tour de destination.
      * @return VRAI si le disque peut etre deplace, FAUX sinon.
      */
     public boolean isDeplacementValide(Tour depart,Tour arrivee){
	 try{
    	return (depart.getSommet().compareTo(arrivee.getSommet()));
	 	}
	 catch (IllegalStateException e){
		//e.printStackTrace();
		return false;
		}
     }// isDeplacementValide
    
    
    /**
     * deplacerDisque - deplacer un disque d'une tour vers une autre.
     * @param depart la tour de depart.
     * @param arrivee la tour de destination.
     */
    public void deplacerDisque(Tour depart,Tour arrivee) {
        try {
			arrivee.empiler(depart.getSommet());
			depart.depiler();
			// Affichage du deplacement effectué
			this.dessiner();
			this.nbDeplacement++;
			System.out.println("Deplacement : "+depart.getNumero()+" -> "+arrivee.getNumero()+"\n");
			}
        catch (IllegalStateException e){
			//e.printStackTrace();
		} 
    }// deplacerDisque    
    
    /**
     * deplacerNDisques - 
     * 					  deplacer N disque d'une tour vers une autre,
     * 					  par transition avec la tour intermediaire.
     *                    VERSION RECURSIVE.
     * 
     * @param N nombre de disques a deplacer.
     * @param depart la tour de depart.
     * @param arrivee la tour de destination.
     * @param intermediaire la tour qui servira de transition.
     */
    public void deplacerNDisques(int N,Tour depart,Tour arrivee,Tour intermediaire){
        if (N == 1) {
			deplacerDisque(depart,arrivee);	
		} else {
			deplacerNDisques(N-1,depart,intermediaire,arrivee);
			deplacerDisque(depart,arrivee);
			deplacerNDisques(N-1,intermediaire,arrivee,depart);
		}
    }// deplacerNDisques
    
    /**
     * jeu - lance le jeu des tours de hanoi.
     */ 
    public void jeu(){
        this.deplacerNDisques(this.lesTours[0].getNbDisques(),this.lesTours[0],this.lesTours[1],this.lesTours[2]);
    }// jeu

    /** Indique la fin du jeu de Hanoi.
     *  @return TRUE quand tous les anneaux sont sur la tour de destination.
  	 */
  	public boolean fini(){
    return (this.lesTours[0].getHauteur() == this.lesTours[1].getNbDisques());
  	}
    
    /**
     * dessiner - Affichage des tours de hanoi sur la sortie standard.
     */
    
    public void dessiner(){
		// pour chaque etage des 3 tours
		for (int i = 1 ; i <= this.lesTours[0].getHauteur() ; i++){
			// pour chacune des 3 tours
			for (Tour tourCourante : this.lesTours){
			    //la chaine contenant le nombre d'espace et son compteur
			    String space = new String("");
			    //la chaine contenant le nombre d'underscore
	  			String underscore = new String("");
	  		// Si il existe un disque a cet etage 	
	  		if((tourCourante.getLesDisques())[(tourCourante.getHauteur())-i] != null){
	  		// Alors	
	  			//On calcule puis construit le nombre d'underscore necessaire
	  			for (int j=1; j <= tourCourante.getLesDisques()[(tourCourante.getHauteur())-i].getTaille(); j++){
		  		underscore  += "_";
	  			}
	  			//On calcule puis construit le nombre d'espace necessaire
	  			for (int k= tourCourante.getHauteur(); k > tourCourante.getLesDisques()[tourCourante.getHauteur()-i].getTaille(); k--){
	  			space += " ";	
	  			}
			}else{
				for(int l=1; l <= tourCourante.getHauteur();l++){
				space += " ";
				}
			}
	  		//on dessine les disques des 3 tours de hanoi situés a l'etage courant
	  		System.out.print(space.concat(underscore)+"|"+underscore.concat(space));
			   //on separe chaque tour de hanoi avec un espace
			   System.out.print(" ");	
			}// pour chaque tour de hanoi
		System.out.print("\n");
		// On effectue un passage a la ligne a la fin de l'etage courant
		}// On passe à l'etage suivant
		String socle = new String("");
		for (int m=1; m <= (2 * (this.lesTours[0].getHauteur()))+ 1;m++){
			socle += "=";
		}
		System.out.println(socle+" "+socle+" "+socle);
		String legende = new String("");
		for (int n=1; n <= (this.lesTours[0].getHauteur())-2;n++){
			legende += " ";
		}
		System.out.println(legende+"Tour1"+legende+" "+legende+"Tour2"+legende+" "+legende+"Tour3"+legende);
	}// dessiner
		
		
		
											/* METHODE MAIN PRINCIPAL */
		
		
		
/** Methode principale - Propose un choix pour une resolution automatique ou manuelle.
 * 						 Remarque: le nombre de disques doit etre place en premier parametre
 * 								   sur la ligne de commande a l'execution.
 *
 */
    public static void main (String args[]) {		
	    
	    boolean gagne = false;
	    
	    // Declaration affectation du nombres de disques par parametre à l'execution
	    if (args.length != 0){
	    try{
	    int nombre = Integer.parseInt(args[0]);
		// Affichage
	   
	    System.out.println("\n\n\t LE JEU DES TOURS DE HANOI ! \n\n");
		
		// Instanciation du jeu de hanoi ainsi que son affichage
		if (nombre > 0){
		Hanoi game = new Hanoi(nombre);
	    game.dessiner();
		
		// Choix du menu
	    System.out.println("\nLe Jeu commence avec "+nombre+" Disques.\n\n\t\t Choississez votre menu : \n");
	    System.out.println("Tapez '1' pour le mode automatique (VERSION RECURSIVE).");
	    System.out.println("Tapez '2' pour le mode manuelle avec invite de commande.");
	    System.out.print("Votre decision : ");
	    Scanner sc1 = new Scanner(System.in);
	    int menu  = sc1.nextInt();
	     
	    if (menu == 1){	
        									 /*   MODE AUTOMATIQUE   */
	    
	   
		
		// On lance le Jeu
	    game.jeu();
	    System.out.println("Jeu realisé en "+game.getNbDeplacement()+" deplacements.");
	    System.out.println("Complexité O(2^("+game.getLesTours()[0].getHauteur()+")-1) = O(2^n)\n avec n : nombres de disques.");
	    System.out.println("Complexité de classe exponentielle.");
		}				
		
		else{
			
											/*   MODE MANUELLE   */
		
		// On cree une instance de HanoiInput
		HanoiInput monInput = new HanoiInput();
		System.out.print("\n\nLes trois tours son désignées respectivement par les lettres \n g comme GAUCHE , c comme CENTRE et d comme DROITE.\n");  
		System.out.print("Pour effectuer un déplacement, il faut taper le mot de deux lettres correspondant\n à tour de départ tour d'arrivée.\n");
		System.out.print("Par exemple en tapant gc, on déplace le disque au sommet de la tour gauche sur la tour centrale.\n");
		System.out.println("On peut quitter en tapant quit.\n La partie se termine si tous les disques ont été deplacé sur la tour 2.");
		
		//Le jeu tourne
		monInput.readInput();
			while ((monInput.isDeplacement()) && (!(game.fini()))){
				if((game.isDeplacementValide(game.getLesTours()[monInput.getDe()],game.getLesTours()[monInput.getVers()]))
				|| ((game.getLesTours()[monInput.getVers()].estVide()) && !game.getLesTours()[monInput.getDe()].estVide()))
				{
				game.deplacerDisque(game.getLesTours()[monInput.getDe()],game.getLesTours()[monInput.getVers()]);
				}
				else
				if (game.getLesTours()[monInput.getDe()].estVide()){
					System.out.println("> La tour "+game.getLesTours()[monInput.getDe()].getNumero()+" est vide !");
					} else {
				  System.out.println("> Interdit : Le disque est plus grand ! ");
			  		}
				if(!(game.fini())){
				monInput.readInput();}
				if (game.fini()) { gagne = true;}
		}// Tant que le jeu n'est pas terminé
		
		System.out.println("Jeu realisé en "+game.getNbDeplacement()+" deplacements.");
		}//if MENU AUTO / MANUELLE
	
	// Fin Alternative
	if (!gagne){
	System.out.println("\n\t \t GAME OVER!\n \t THANK YOU FOR PLAYING! ");
	}else{
	System.out.println("\n\t CONGRATULATIONS!\n \t THANK YOU FOR PLAYING! ");
	}
	}
	if (nombre <= 0){System.out.println("Aucun Disque n'a été deposé!");}
	System.out.println("\n --- Hanoi - POO - Djebien Tarik - mars 2010 ---");
	}
	catch (NumberFormatException e) {
    		System.out.println("Entrez un entier positif en parametre!");
    }
	} else System.out.println("Entrez un entier en premier parametre à l'execution correspondant aux nombres de disques\ndeposés sur la tour de depart.\nExemple :\n'java -jar hanoi.jar 5' pour deposer 5 disques ");
	
	}// Methode Principale
		
}// class Hanoi
