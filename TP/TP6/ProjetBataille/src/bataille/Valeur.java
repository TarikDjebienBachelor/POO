package bataille;

public enum Valeur {
    sept, huit, neuf, dix, valet, dame, roi, as;


//public class Valeur implements Comparable<Valeur>{
	
	public int compareValeur(Valeur v){
	  return this.ordinal() - v.ordinal();
	}




}
