/**
 * @(#)Jeu.java
 * La classe Jeu est dédié à présenter un jeu 
 * entre deux joueurs  
 * @author SMIMITE Badr-Eddine
 * @version 1.00 
 */ 
package game;

import java.math.*;
import clavier.*;
import java.lang.*;
import java.io.*;

public class Jeu {
	
	private Player P1;
	private Player P2;
	private Hand table;
    String Fichier;
    
    
    /**
     * Constructeur par initialisation.
     */
    public Jeu() {
    	P1 = new Player();
    	P2 = new Player();
    	table = new Hand();
    	Fichier = new String();
    }
    
    /**
     * renvoie un joueur selon son numero.
     * <br> 1 pour joueur 1.
     * <br> 2 pour joueur 2.
     * <br> sinon <b>null</b>.
     */
    public Player getPlayer(int a){
    	if(a == 1){
    		return this.P1;
    	}
    	else if(a == 2){
    		return this.P2;
    	}
    	else{
    		return null;
    	}
    }
    /**
     * renvoie une main qui présente la table du jeu.
     */
    public Hand getTable(){
    	return this.table;
    }
    
    /**
     * renvoie le fichier de la partie.
     */
    public String getFichier(){
    	return this.Fichier;
    }
    
    /**
     * initialise un tableau de carte avec un jeu de 5x4.
     */
    public static Carte[] init(){
    	Carte C[];
    	C = new Carte[20];
    	C[0]= new Carte(1,'C');
    	C[1]= new Carte(1,'D');
    	C[2]= new Carte(1,'H');
    	C[3]= new Carte(1,'S');
    	C[4]= new Carte(2,'C');
    	C[5]= new Carte(2,'D');
    	C[6]= new Carte(2,'H');
    	C[7]= new Carte(2,'S');
    	C[8]= new Carte(3,'C');
    	C[9]= new Carte(3,'D');
    	C[10]= new Carte(3,'H');
    	C[11]= new Carte(3,'S');
    	C[12]= new Carte(4,'C');
    	C[13]= new Carte(4,'D');
    	C[14]= new Carte(4,'H');
    	C[15]= new Carte(4,'S');
    	C[16]= new Carte(5,'C');
    	C[17]= new Carte(5,'D');
    	C[18]= new Carte(5,'H');
    	C[19]= new Carte(5,'S');
    	
    	return C;
    }
    
    /**
     * initialise un tableau de carte à partir 
     * d'une caine de caractéres.
     */
    public Carte[] Chargerjeu(String S){
    	
    	Carte[] C = new Carte[20];
    	if(S == null){
    		return null;
    	}
    	else{
    		if(S.length() < 20){
    			 return null;
    		}	 
    		else{
    		
    		for(int i=0;i<20;i++){
    			char Cr = S.charAt(i);
    			C[i]=new Carte((int)Cr - 48,'C');
    		}
    		return C;
    		}
    	}
    }
    /**
     * initialise le fichier de la partie.
     */
    public void initFichier(){
    	this.Fichier = this.P1.toString();
    	this.Fichier = this.Fichier + this.P2.toString();
    	this.Fichier = this.Fichier + ".bjc";
    }
    
    /**
     * Enregistre les mains des deux joueurs.
     */
    public void enregistrer(BufferedWriter bw){
           try{  
            bw.write("joueur 1 : "+this.P1.toString2()+"\n");
            bw.write("joueur 2 : "+this.P2.toString2()+"\n");	
           }catch(IOException e){
           	  System.out.println(e.toString());
           } 	     
    	
    }
    
    /**
     * lire une partie à partir du fichier de la partie.
     */
    public void Lire(){
    	try{
    		
    		File f = new File("save/"+this.Fichier);
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
            
             String S = dis.readLine();
             System.out.println(S);
             while(S != null){
             	S = dis.readLine();
             	System.out.println(S);
             }         
              
            dis.close();
            bis.close();
            fis.close();
           
    	}catch(IOException e){
    		System.out.println("Error !" + e.toString());
    	}
    }
    
    /**
     * battre un jeu de carte.
     */
    public static Carte[] battre(Carte C[]){	
     	int i;
    	int j;
    	Carte t;
    	
    	for(i=0;i<20;i++){
    		
    		double k = Math.random()*(20-i) + i;
    		j = (int)Math.floor(k);
    	    t = C[i];
    	    C[i] = C[j];
    	    C[j] = t;
    	}
    	return C;
    }
    
    /**
     * distribuer un jeu de carte sur les deux joueurs.
     */
    public void distribuer(Carte C[]){
    	
    	int i=0;
    	if(C != null){
    	
    	while(i<10){
    		this.P1.addCard(C[i]);
    		i++;
    	}
    	while(i<20){
    		this.P2.addCard(C[i]);
    		i++;
    	}
    	}
    }
   
    /**
     * joueur1 pose une carte.
     */
    public Carte play1(){
    	Carte C = this.P1.poserCarte();
    	if(C != null){
    		this.table.insertCard(C);
    		return C;
    	}
    	else{
    		return null;
    	}
    }
    
     /**
     * joueur2 pose une carte.
     */
     public Carte play2(){
    	Carte C = this.P2.poserCarte();
    	if(C != null){
    		this.table.insertCard(C);
    		return C;
    	}
    	else{
    		return null;
    	}
    }
    
    /**
     * affiche la table du jeu. 
     */
    public void afficheTable(){
    	this.table.afficher();
    }
    
    
}