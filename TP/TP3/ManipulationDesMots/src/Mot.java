/*
 *      Mot.java
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

/* Manipulation sur des mots */

/** 
 * <p style= "font-size: 170%;" > POO - TP3 : Manipulation sur des mots </p>
 * @author Djebien Tarik
 * @version fevrier 2010
 */

public class Mot {

	/* Attributs */

	private String valeur;
	
	/* Constructeurs */

     /**
      * Constructor of initialization for objects of class Mot.
      * @param v Chaine de caractere associee a l'instance lors de sa creation.
      */
      
	public Mot(String v){
	this.valeur= v;
	}
	
	/* Accesseurs */
    /**
     * toString - Consultation de la valeur associee au mot courant.
     * @return La chaine de caractere associee au mot courant.
     */
	public String toString(){
	return this.valeur;
	}//toString

	/* Methodes */ 

    /**
     * longueur - La longueur du mot.
     * @return  Le nombre de caracteres constituant le mot.
     */
	public int longueur(){
	return this.valeur.length();	
	}//longueur

    /**
     * memeMot - Test d'egalite entre deux mots.
     * @param m Le mot a comparer avec le mot courant.
     * @return  TRUE ssi le mot en parametre est identique au mot courant, FALSE sinon.
     */	
	public boolean memeMot(Mot m){
	return this.valeur.equals(m.valeur);
	}//memeMot

    /**
     * nbDOccurencesDuChar - calcule le nombre d'occurences d'un caractere donne dans le mot.
     * @param c caractere a rechercher dans le mot.
     * @return  Le nombre de fois que ce caractere apparait dans le mot courant.
     */	
	public int nbDOccurencesDuChar(char c){
	int res=0;
	for(int i=0; i< this.longueur() ; i++ ){
		if ((this.valeur.charAt(i) == Character.toLowerCase(c)) || (this.valeur.charAt(i) == Character.toUpperCase(c))){
			res++;}
		}//for
	return res;
	}//nbDOccurencesDuChar

    /**
     * inverse - Le mirroir du mot initial.
     * @return  L'objet Mot dont la valeur est l'inverse de celle du mot courant.
     */	
	public Mot inverse(){
	String res = "";
	for(int j=(this.longueur())-1; j>=0; j--){
		res = res + this.valeur.charAt(j); 
		}//for
	Mot m = new Mot(res);
	return m;
	}//inverse

    /**
     * contient - Predicat testant si le mot donne est un "sous-mot" du mot courant.
     * @param m Le "sous-mot" a rechercher dans le mot courant.
     * @return  TRUE ssi le mot donne est un "sous-mot" du mot courant, FALSE sinon.
     */	
	public boolean contient(Mot m){
	boolean res = false;
	for(int i=0; i<this.longueur(); i++){
	  if((this.valeur.charAt(i) == m.valeur.charAt(0)) && ((this.longueur())-i >= m.longueur())){
	  res = (this.valeur.substring(i,i + (m.longueur())).equals(m.valeur));
	  }//if
	}//for
	return res;
	}//contient

    /**
     * rimeAvec - regarde si le mot donne rime avec le mot courant.
     * @param m Le mot sur lesquelle on teste le predicat.
     * @return  TRUE si leur 3 derniers caracteres sont identiques, FALSE sinon.
     */	
	public boolean rimeAvec(Mot m){
	String suffixe = m.valeur.substring((m.longueur())-3);
	return ((m.longueur() >= 3) && (this.valeur.endsWith(suffixe))) ;
	}//rimeAvec

    /**
     * extraitAvant - Scinde le mot courant au niveau du caractere donne.
     * @param c Caractere dont l'on cherche sa premiere occurence dans le mot courant.
     * @return  Un tableau de deux mots, le premier correspond au plus petit prefixe du mot
     *          precedant la premiere occurrence du caractere passe en parametre inclus,
     * 			le second correspond au reste du mot(sans le caractere).
     * 			Si le caractere n'existe pas dans le mot, le premier element du 
     * 			tableau resultat est le mot vide et le second est le mot lui-meme.
     */
	public Mot[] extraitAvant(char c){
	String s = new String();
	       s = s.valueOf(c);
	Mot[] res = new Mot[2];
	Mot test = new Mot(s);
	if (!(this.contient(test))){
		res[0]= new Mot("");
		res[1]= new Mot(this.valeur); 
	}
	else{
	    res[0]= new Mot(this.valeur.substring(0,this.valeur.indexOf(s)+1));
	    res[1]= new Mot(this.valeur.substring((this.valeur.indexOf(s))+1));
	}//if
	return res;
	}//extraitAvant

    /**
     * estPalindrome - Predicat qui teste si le mot courant est un Palindrome.
     * @return  TRUE ssi le mot courant est un Palindrome, FALSE sinon.
     */	
	public boolean estPalindrome(){
	return this.memeMot(this.inverse());
	}//estPalindrome
	
	/**
     * estAnagramme - Predicat qui teste si le mot donne est un anagramme du mot courant.
     * @param m Mot avec lequel on teste le predicat sur l'instance courante.
     * @return  TRUE ssi le mot donne est un anagramme du mot courant, FALSE sinon.
     */	
	public boolean estAnagramme(Mot m){
	boolean res = true;
	if (m.longueur() != this.longueur()){
		res = false;   
	}
	else{
	int i = 0;	
	while ((i < this.longueur()) && (res = true)){
	res = (((this.nbDOccurencesDuChar(this.valeur.charAt(i))) == (m.nbDOccurencesDuChar(this.valeur.charAt(i))))
			&& ((m.nbDOccurencesDuChar(m.valeur.charAt(i))) == (this.nbDOccurencesDuChar(m.valeur.charAt(i)))));
	i++;
	}//while
	}//if
	return res;
	}//estAnagramme
	
	
    /**
     * estNomPropre - Predicat qui teste si le mot courant est un Nom Propre.
     * @return TRUE ssi le mot courant commence par une majuscule, FALSE sinon. 
     */	
	public boolean estNomPropre(){
	return Character.isUpperCase(this.valeur.charAt(0));
	}// estNomPropre

}// Class Mot
