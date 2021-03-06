package PierrePapierCiseaux;
import java.util.*;
/*
 *      Jeu.java
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

					/* LE JEU "PIERRE - PÄPIER - CISEAUX" */

/** 
 * <p style= "font-size: 170%;" >  Classe  PierrePapierCiseaux.Jeu </p>
 * @author Djebien Tarik
 * @version avril 2010
 */

public class Jeu{

	/* Attributs */
	private int nbTours;
	private Joueur j1;
	private Joueur j2;
	
	/* Constructeurs */
     
     /**
      * Constructor of initialization for objects of class Jeu.
      * @param duree le nombre de tours de la partie.
      * @param playerone Le joueur numero 1.
      * @param playertwo Le joueur numero 2.
      */
    
	public Jeu(int duree, Joueur playerone, Joueur playertwo){
	this.nbTours = duree;
	this.j1 = playerone;
	this.j2 = playertwo;
	}// Constructeur d'initialisation Jeu

	/* Accesseurs et Mutateurs */
	
    /**
     * getNbTours - Consultation du nombre de tours du jeu.
     * @return le nombre de tours du jeu courant.
     */
	public int getNbTours(){
	return this.nbTours;
	}// getNbTours

    /**
     * getPlayerOne - Consultation du joueur 1.
     * @return le joueur 1.
     */
	public Joueur getPlayerOne(){
	return this.j1;
	}// getPlayerOne

    /**
     * getPlayerTwo - Consultation du joueur 2.
     * @return le joueur 2.
     */
	public Joueur getPlayerTwo(){
	return this.j2;
	}// getPlayerTwo 

	/**
	 * setNbTours - Modification du nombre de tours de la partie.
	 * @param t le nouveau nombre de tours de l'instance Jeu courante.
	 */
	public void setNbTours(int t){
	this.nbTours = t;
	}//setNbTours

	/**
	 * setPlayerOne - Modification du joueur1 de la partie.
	 * @param p1 le nouveau joueur1 de l'instance Jeu courante.
	 */
	public void setPlayerOne(Joueur p1){
	this.j1 = p1;
	}//setPlayerOne

	/**
	 * setPlayerTwo - Modification du joueur2 de la partie.
	 * @param p2 le nouveau joueur2 de l'instance Jeu courante.
	 */
	public void setPlayerTwo(Joueur p2){
	this.j2 = p2;
	}//setPlayerTwo
	
	/* Methodes */
	
 	/**
 	 * start - lancement de la partie.
 	 */
 	public void start(){
 	for(int i=0;i<this.getNbTours();i++){
 	// CONFRONTATION
 	Coup coupDuJoueur1 = this.j1.joue();
 	Coup coupDuJoueur2 = this.j2.joue();
 	System.out.println(coupDuJoueur1.name()+" VS "+coupDuJoueur2.name());
 	switch (coupDuJoueur1.compareCoup(coupDuJoueur2)){
 	  // EGALITE
 	  case 0 : {
 	  this.j1.ajouterPoints(1);
 	  this.j2.ajouterPoints(1);
 	  }
 	  break;
 	  // Joueur1 GAGNE
 	  case 1 : {
 	  this.j1.ajouterPoints(2);
 	  this.j2.ajouterPoints(0);
 	  }
 	  break;
 	  // Joueur2 GAGNE
 	  case -1 :{
 	  this.j1.ajouterPoints(0);
 	  this.j2.ajouterPoints(2);
 	  }
 	  break;
 	}//switch
 	
 	}//for
 	
 	//AFFICHAGE DU VAINQUEUR
 	System.out.println("SCORE :");
 	System.out.println(this.j1.getName()+" : "+this.j1.getNbPoints());
 	System.out.println(this.j2.getName()+" : "+this.j2.getNbPoints());
 	if(this.j1.getNbPoints()>this.j2.getNbPoints()){
 	System.out.println(this.j1.getName()+" a gagné.");
 	}else if(this.j1.getNbPoints()<this.j2.getNbPoints()){
 	System.out.println(this.j2.getName()+" a gagné.");
 	}else
 	System.out.println("Match Nul.");
 	}// start 

											/* METHODE MAIN PRINCIPAL */
											
	/**
	 * main - Methode Principale.
	 */
	public static void main(String[] args){
	
	System.out.println("Selectionner le mode de jeu :");
	System.out.println("- Tapez 1 pour jouer contre l'ordinateur.");
	System.out.println("- Tapez 2 pour ordinateur contre ordinateur.");
	Scanner sc = new Scanner(System.in);
	int modeDeJeu = sc.nextInt();
	if (modeDeJeu == 2){
	Joueur Tarik = new Joueur(new Aleatoire(),"Tarik");
	Joueur Dijkstra = new Joueur(new Alternatif(),"Dijkstra");
	Jeu   Partie = new Jeu(10,Tarik,Dijkstra);
	Partie.start();
	}else{
	System.out.println("Entrez votre nom : ");
	Scanner sc2 = new Scanner(System.in);
	String  str = sc2.nextLine();
	System.out.println("Entrez le nombre de tours de la partie : ");
	Scanner sc3 = new Scanner(System.in);
	int    nbToursPartie = sc3.nextInt();
	Joueur you = new Joueur(new Human(),str);
	Joueur terminator = new Joueur(new Aleatoire(),"Terminator");
	Jeu Partie2 = new Jeu(nbToursPartie,you,terminator);
	Partie2.start();
	}
	}// main
	
}// class Jeu
