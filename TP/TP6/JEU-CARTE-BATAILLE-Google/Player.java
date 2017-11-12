/**
 * @(#)Player.java
 * La classe Carte est une classe dédier à présenter un joueur 
 * avec l'historique de ses mains.
 * @author SMIMITE Badr-Eddine
 * @version 1.00 
 */ 
package game;

import java.util.*;
import java.lang.*;

public class Player{
    private Hand H;
    private List ListeHand;
    
    /**
     * Constructeur par initialisation.
     */
    public Player(){
       this.ListeHand = new Vector();
       H = new Hand();
    }
    
    /**
     * ajoute une main a l'historique des mains jouées.
     */
    public void addHand(){
    	 Hand t = new Hand(this.H);
    	 this.ListeHand.add(t);
    }
    
    /**
     * ajoute une carte dans la main courante du joueur.
     */
    public void addCard(Carte C){
    	this.H.insertCard(C);
    }
    
    
    /**
     * ramasserles cartes d'une autre main et les inserer dans la main courante.
     */
    public void ramasser(Hand table){
    	/*
    	 *on suppose que table contient au moins deux cartes 
    	 * et les deux premieres cartes sont diférentes
    	 */
    	 
    	 try{
    	 
    	 Carte C1 = new Carte(table.getHead());
    	 table.deletHead();
    	 Carte C2 = new Carte(table.getHead());
    	 table.deletHead();
    	 if(C1.CompareTo(C2) > 0){ // C1 > C1
    	 	this.H.insertCard(C1);
    	 	this.H.insertCard(C2); 
    	 }
    	 else{ // C2 > C1
    	 	this.H.insertCard(C2);
    	 	this.H.insertCard(C1);
    	 }
    	 while(table.getNCard()!= 0){
    	 	Carte C = new Carte(table.getHead());
    	 	table.deletHead();
    	 	this.H.insertCard(C);
    	 	
    	 }
    	 }catch(NullPointerException e){
    	 	System.out.println("error!");
    	 }
    	
    }
    
    /**
     * poser une carte. renvoie la premiere carte et la supprime de la carte courante.
     */
    public Carte poserCarte(){
    	Carte C;
    	C = new Carte(this.H.getFirstCard());
    	this.H.deletFirst();
    	return C;
    }
    
    
    /**
     * recherche d'une main équivalente à la main courante dans l'historique 
     * des mains jouées.
     */
    public boolean findHand(){
    	boolean d = false;
    	int i =0;
    	while(i< this.ListeHand.size() && d==false){
    		Hand t = (Hand) this.ListeHand.get(i);
    		if(t.CompareTo(this.H)){
    			d = true;
    		}
    		else{
    			i++;
    		}
    	}
    	return d;
    }
    
    /**
     * renvoie si le joueur à perdu ou non.
     */
    public boolean aperdu(){
    	return this.H.estVide();
    }
    
    /**
     * affiche la main courante.
     */
    public void afficher(){
    	this.H.afficher();
    }
    
    /**
     * affiche l'historique des main.
     */
    public void afficherListe(){
    	for(int i=0;i<this.ListeHand.size();i++){
    		Hand t = (Hand) this.ListeHand.get(i);
    		t.afficher();
    	}
    }
    
    /**
     * renvoie une chaine de caractére avec les numeros dans 
     * l'ordre de la main courante
     */
    public String toString(){
    	return this.H.toString();
    }

    /**
     * renvoie une chaine de caractére avec les cartes dans 
     * l'ordre de la main courante
     */    
    public String toString2(){
    	return this.H.toString2();
    }
}
