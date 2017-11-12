package bataille;

/*
 *      Bataille.java
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

					/* LE JEU DE LA BATAILLE AVEC CARTES. (32 CARTES POUR CHAQUES JOUEURS) */

/** 
 * <p style= "font-size: 170%;" >  Classe  bataille.Bataille </p>
 * @author Djebien Tarik
 * @version mars 2010
 */

public class Bataille{

	/* Attributs */
	private TasCartes table;
	private TasCartes joueur1;
	private TasCartes joueur2;
	
	/* Constructeurs */
     
     /**
      * Constructor of initialization for objects of class Bataille.
      * @param t  La table de jeu.
      * @param j1 Le joueur numero 1.
      * @param j2 Le joueur numero 2.
      */
    
	public Bataille(TasCartes t, TasCartes j1, TasCartes j2){
	this.table = t;
	this.joueur1 = j1;
	this.joueur2 = j2;
	}// Constructeur d'initialisation Bataille

	/* Accesseurs et Mutateurs */
	
	/**
     * getTable - Consultation du tas de cartes de la table du jeu de bataille.
     * @return le tas de cartes situes sur la table de l'instance Bataille courante.
     */
	public TasCartes getTable(){
	return this.table;
	}// getTable

	 /**
     * getPlayerOne - Consultation du tas de cartes du joueur 1 du jeu de bataille.
     * @return le tas de cartes du joueur 1 de l'instance Bataille courante.
     */
	public TasCartes getPlayerOne(){
	return this.joueur1;
	}// getPlayerOne

	 /**
     * getPlayerTwo - Consultation du tas de cartes du joueur 2 du jeu de bataille.
     * @return le tas de cartes du joueur 2 de l'instance Bataille courante.
     */
	public TasCartes getPlayerTwo(){
	return this.joueur2;
	}// getPlayerTwo

	/**
	 * setTable - Modification du tas de cartes de la table du jeu de bataille.
	 * @param t le nouveau tas de cartes situes sur la table de l'instance Bataille courante.
	 */
	public void setTable(TasCartes t){
	this.table = t;
	}//setTable

	/**
	 * setPlayerOne - Modification du tas de cartes du joueur 1 du jeu de bataille.
	 * @param j1 le nouveau tas de cartes du joueur1 de l'instance Bataille courante.
	 */
	public void setPlayerOne(TasCartes j1){
	this.joueur1 = j1;
	}//setPlayerOne

	/**
	 * setPlayerTwo - Modification du tas de cartes du joueur 2 du jeu de bataille.
	 * @param j2 le nouveau tas de cartes du joueur2 de l'instance Bataille courante.
	 */
	public void setPlayerTwo(TasCartes j2){
	this.joueur2 = j2;
	}//setPlayerTwo
	
	/**
	 * joue - Lancement du jeu de bataille pour l'instance courante.
	 */
	public void joue(){
	boolean jeuTermine = false;
	System.out.println("joueur1 : "+joueur1.getNbCartes()+" cartes.");
	System.out.println("Tas de Carte du Joueur 1 :\n"+joueur1.afficherTasCartes()+"\n");
	System.out.println("joueur2 : "+joueur2.getNbCartes()+" cartes.");
	System.out.println("Tas de Carte du Joueur 2 :\n"+joueur2.afficherTasCartes());
	try{Thread.sleep(10000);}catch(Exception e){}
	while(!jeuTermine){
	try{
	Carte c1 = this.joueur1.enleveCarteEnTete();
	System.out.println("Joueur 1 :"+c1.toString());
	this.table.ajouteCarteEnFin(c1);
	Carte c2 = this.joueur2.enleveCarteEnTete();
	System.out.println("Joueur 2 :"+c2.toString());
	this.table.ajouteCarteEnFin(c2);
	int resultat = c1.compareTo(c2);
	if (resultat > 0){
	System.out.println("Joueur 1 a gagné.");
	this.joueur1.ajouteDesCartesEnFin(table);
	}
	if (resultat < 0){
	System.out.println("Joueur 2 a gagné.");
	this.joueur2.ajouteDesCartesEnFin(table);
	}
	if (resultat == 0){
		System.out.println("BATAILLE");
	}
	}catch (TasVideException e){
	jeuTermine = true;
	}catch (TasPleinException f){
	//f.printStackTrace();
	}
	}//while
	String winner = (this.joueur1.estVide()) ? "joueur2":"joueur1";
	System.out.println("Le "+winner+" a remporté la partie.");
	}//joue

											/* METHODE MAIN PRINCIPAL */
											
	/**
	 * main - Methode Principale.
	 */
	public static void main(String[] args){
	TasCartes laTable   = new TasCartes();
	TasCartes leJoueur1 = new TasCartes();
	TasCartes leJoueur2 = new TasCartes();
	leJoueur1.initialiserTasCartes();
	leJoueur2.initialiserTasCartes();
	leJoueur1.melangerTasCartes();
	leJoueur2.melangerTasCartes();
	Bataille game = new Bataille(laTable,leJoueur1,leJoueur2);
	game.joue();
	}// main

}// class Bataille
