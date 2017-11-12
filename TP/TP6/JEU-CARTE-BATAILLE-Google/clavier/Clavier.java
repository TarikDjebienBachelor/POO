package clavier;

import java.lang.*;
import java.io.*;

public class Clavier{
//public static byte   readByte();
//public static short  readShort();
//public static int    readInt();
//public static long   readLong();
//public static float  readFloat();
//public static double readDouble();
//public static String readString();
//public static StringBuffer readStringBuffer();

// les memes avec message (surcharge) pas encore disponible
// par exemple: public static byte readByte(String mess);

//public static StringBuffer StoSB(String param);


	// variable d'erreur utilise a la fois pour le Clavier et pour le type
	
	public static boolean erreur = false;
	
	
	// methode de recuperation d'un entier byte au Clavier
	public static byte readByte(){	
		Clavier.erreur=false;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		byte valeur=0;
		String line="";
	
		try{line = entree.readLine();}
		catch(IOException e){Clavier.erreur=true;}
		
		try{valeur = Byte.parseByte(line);}
		catch(NumberFormatException e){Clavier.erreur=true;}
		
		return valeur;
	} // byte readByte()

	// methode de recuperation d'un entier short au Clavier
	public static short readShort(){	
		Clavier.erreur=false;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		short valeur=0;
		String line="";
	
		try{line = entree.readLine();}
		catch(IOException e){Clavier.erreur=true;}
		
		try{valeur = Short.parseShort(line);}
		catch(NumberFormatException e){Clavier.erreur=true;}
		
		return valeur;
	} // short readShort()

	// methode de recuperation d'un entier int au Clavier
	public static int readInt(){	
		Clavier.erreur=false;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		int valeur=0;
		String line="";
	
		try{line = entree.readLine();}
		catch(IOException e){Clavier.erreur=true;}
		
		try{valeur = Integer.parseInt(line);}
		catch(NumberFormatException e){Clavier.erreur=true;}
		
		return valeur;
	} // int readInt()
				
	// methode de recuperation d'un entier long au Clavier
	public static long readLong(){	
		Clavier.erreur=false;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		long valeur=0;
		String line="";
	
		try{line = entree.readLine();}
		catch(IOException e){Clavier.erreur=true;}
		
		try{valeur = Long.parseLong(line);}
		catch(NumberFormatException e){Clavier.erreur=true;}
		
		return valeur;
	} // long readLong()
	

	// methode de recuperation d'un reel float au Clavier
	public static float readFloat(){	
		Clavier.erreur=false;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		float valeur=0;
		String line="";
	
		try{line = entree.readLine();}
		catch(IOException e){Clavier.erreur=true;}
		
		try{valeur = Float.parseFloat(line);}
		catch(NumberFormatException e){Clavier.erreur=true;}
		
		return valeur;
	} // float readFloat()
		
	// methode de recuperation d'un reel double au Clavier
	public static double readDouble(){	
		Clavier.erreur=false;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		double valeur=0;
		String line="";
	
		try{line = entree.readLine();}
		catch(IOException e){Clavier.erreur=true;}

		try{valeur = Double.parseDouble(line);}
		catch(NumberFormatException e){Clavier.erreur=true;}
		
		return valeur;
	} // double readDouble()


	// methode de recuperation d'une chaine String au Clavier
	public static String readString(){
		Clavier.erreur=false;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		String line="";
	
		try{line = entree.readLine();}
		catch(IOException e){Clavier.erreur=true;}
		
		return line;
	} // String readString()
		
	// methode de recuperation d'un caractere (char) au Clavier
	public static char readChar(){
		Clavier.erreur=false;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		char valeur = (char)0;
	
		try{valeur = (char)entree.read();}
		catch(IOException e){Clavier.erreur=true;}
		
        	return valeur;
	} // char readChar()

	// methode de recuperation d'une chaine StringBuffer au Clavier
	public static StringBuffer readStringBuffer(){
		Clavier.erreur=false;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		String line="";
	
		try{line = entree.readLine();}
		catch(IOException e){Clavier.erreur=true;}
		
		return Clavier.StoSB(line);
		}

//////////////////////////////////////////////////////////////

	//recuperation d'un byte au clavier, avec message
	public static byte readByte(String message){
		System.out.print(message);
		return readByte();
	} // byte readByte(String)

	//recuperation d'un short au clavier, avec message
	public static short readShort(String message){
		System.out.print(message);
		return readShort();
	} // short readShort(String)

	//recuperation d'un int au clavier, avec message
	public static int readInt(String message){
		System.out.print(message);
		return readInt();
	} // int readInt(String)

	//recuperation d'un long au clavier, avec message
	public static long readLong(String message){
		System.out.print(message);
		return readLong();
	} // long readLong(String)

	//recuperation d'un float au clavier, avec message
	public static float readFloat(String message){
		System.out.print(message);
		return readFloat();
	} // float readFloat(String)

	//recuperation d'un double au clavier, avec message
	public static double readDouble(String message){
		System.out.print(message);
		return readDouble();
	} // double readDouble(String)

	//recuperation d'un String au clavier, avec message
	public static String readString(String message){
		System.out.print(message);
		return readString();
	} // String readString(String)

	//recuperation d'un char au clavier, avec message
	public static char readChar(String message){
		System.out.print(message);
		return readChar();
	} // char readChar(String)

	//recuperation d'un StringBuffer au clavier, avec message
	public static StringBuffer readStringBuffer(String message){
		System.out.print(message);
		return readStringBuffer();
	} // StringBuffer readStringBuffer(String)

/////////////////////////////////////////////////////////////////////

	// methode de conversion d'une String en une StringBuffer
	public static StringBuffer StoSB(String param){
		StringBuffer c = new StringBuffer();
		c.append(param);
		return c;
	} // StringBuffer StoSB(String)


} // fin de la classe Clavier !!!!!!
