/*
 *      Test.java
 * 
 *      Programme de test de la classe Mot
 *		 
 *      Copyright 2010 tarik User <tarik@ubuntu>
 *      
 *      This program is free software; you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation; either version 2 of the License, or
 *      (at your option) any later version.
 *      
 */


public class Test {

	public static void main (String args[]) {
	
	// Declaration des variables
	Mot m = new Mot(args[0]);
	Mot t = new Mot("timoleon");
	Mot abracadabra = new Mot("abracadabra");
	Mot crabada = new Mot("crabada");
	Mot darbcaaraba = new Mot("darbcaaraba");
	Mot darbcabraba = new Mot("darbcabraba");
	
	System.out.println("\n \t \t JEU DE TEST DES METHODES DE LA CLASSE MOT  ");
	System.out.println("\n \t \t \t  AVEC LE MOT \" "+m.toString()+"\" \n \n ");	
	
	
	// Jeu de Test 
	System.out.println("Le mot "+m.toString()+" a une longueur de : "+m.longueur());
	System.out.println("Comparons votre mot avec celui-ci : "+t.toString());
	System.out.println(m.toString()+" est identique à "+t.toString()+" ? \n reponse : "+m.memeMot(t));
	System.out.println("Nombre d'occurence du caractere 't' dans "+m.toString()+" : "+m.nbDOccurencesDuChar('t'));
	System.out.println("L'inverse de "+m.toString()+" : "+ m.inverse().toString());
	System.out.println(m.toString()+" contient-il "+t.toString()+" ?\n reponse : "+m.contient(t));
	System.out.println(m.toString()+" rime t-il avec "+t.toString()+" ?\n reponse : "+m.rimeAvec(t)+"\n");
	
	System.out.println("\t Test de la methode public Mot[] extraitAvant(char c) : \n");
	
	System.out.println("timoleon.extraitAvant('o') donne : ");
	System.out.print("Mot[] = |"+(t.extraitAvant('o'))[0].toString());
	System.out.println(" | "+(t.extraitAvant('o'))[1].toString()+" |");
	
	System.out.println("timoleon.extraitAvant('i') donne : ");
	System.out.print("Mot[] = |"+(t.extraitAvant('i'))[0].toString());
	System.out.println(" | "+(t.extraitAvant('i'))[1].toString()+" |");
	
	System.out.println("timoleon.extraitAvant('z') donne : ");
	System.out.print("Mot[] = |"+(t.extraitAvant('z'))[0].toString());
	System.out.println(" | "+(t.extraitAvant('z'))[1].toString()+" |\n");
	
	System.out.println("timoleon.extraitAvant('t') donne : ");
	System.out.print("Mot[] = |"+(t.extraitAvant('t'))[0].toString());
	System.out.println(" | "+(t.extraitAvant('t'))[1].toString()+" |\n");
	
	System.out.println("timoleon.extraitAvant('n') donne : ");
	System.out.print("Mot[] = |"+(t.extraitAvant('n'))[0].toString());
	System.out.println(" | "+(t.extraitAvant('n'))[1].toString()+" |\n");
	
	System.out.println(m.toString()+" est-il un palindrome ?\n reponse : "+m.estPalindrome());
	System.out.println(" \"abracadabra\" est-il un anagramme de \"crabada\" ?\n reponse : "+abracadabra.estAnagramme(crabada));
	System.out.println(" \"abracadabra\" est-il un anagramme de \"darbcaaraba\" ?\n reponse : "+abracadabra.estAnagramme(darbcaaraba));
	System.out.println(" \"abracadabra\" est-il un anagramme de \"darbcabraba\" ?\n reponse : "+abracadabra.estAnagramme(darbcabraba));
	System.out.println(m.toString()+" est-il un Nom propre ?\n reponse : "+m.estNomPropre()+"\n");
	System.out.println("\t\t FIN DU JEU DE TEST.");
		
	}
}
