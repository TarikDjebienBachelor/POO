/**
 * @(#)Test.java
 * La classe chargé d'éxecuter l'application en mode texte. 
 * @author SMIMITE Badr-Eddine
 * @version 1.00 
 */ 
 	
package game;

import java.math.*;
import clavier.*;
import java.lang.*;
import java.io.*;

public class TestAvecCatreTournante {

    public static void main(String[] arg){
    	
        Jeu J = new Jeu();
        Hand H1 = new Hand();
        Hand H2 = new Hand();
        String S = Clavier.readString("Entrez une partie valide de 4x5 :\n");
        J.distribuer(J.Chargerjeu(S));
        J.initFichier();
       
        Player P1 = J.getPlayer(1);
        Player P2 = J.getPlayer(2);
		char c='o';
		
        P1.afficher();
        P2.afficher();
        
        P1.addHand();
        P2.addHand();
        
        try{
        File f = new File("save/"+J.Fichier);
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);	
        bw.write("la partie " + J.getFichier() + "\n"); 
        while(!P1.aperdu() && !P2.aperdu() && c!='n'){
        	
        	J.enregistrer(bw);		
        	Carte C1 = J.play1();
        	H1.insertCard(C1);
        	Carte C2 = J.play2();
        	H2.insertCard(C2);
             
        	System.out.print("table :");
    		J.afficheTable();
    		if(C1.CompareTo(C2) > 0){
    			bw.write("vous avez gagne "+H2.toString2()+"\n");
    			P1.ramasser(J.getTable());
    			H1.clearHand();
    			H2.clearHand();
    			
    		}
    		if(C2.CompareTo(C1) > 0){
    			
    			bw.write("vous avez perdu "+H1.toString2()+"\n");
    			P2.ramasser(J.getTable());
    			H1.clearHand();
    			H2.clearHand();
    		}
    		if(C2.CompareTo(C1) == 0){
    			System.out.println("bataille");
    			C1 = J.play1();
        	    H1.insertCard(C1);
        	    C2 = J.play2();
        	    H2.insertCard(C2);
        	    System.out.println("....vous avez jouez sans tournez la carte......");
    		}	
    		
 
    		System.out.print("joueur 1 :"); P1.afficher();
    		System.out.print("joueur 2 :"); P2.afficher();
    	    
    	    if(P1.findHand() && P2.findHand()){
    	    	
    	    }
    		P1.addHand();
            P2.addHand();
    		 
    		  	
        }	
        J.enregistrer(bw);		
        bw.close();
        fw.close();	
        }catch(IOException e){
        		System.out.println("Error!"+ e.toString());
        }
        if(P1.aperdu() && P2.aperdu()){
        	System.out.println("match null!!");
        }
        else if(P1.aperdu()){
        	System.out.println("vous avez perdu");
        }
        else if(P2.aperdu()){
        	System.out.println("vous avez gangne");
        }
        J.Lire();	
    }
    
    
}