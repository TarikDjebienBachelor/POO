package bataille;

/** 
 * <p style= "font-size: 170%;" >  Classe  bataille.Carte </p>
 * @author Djebien Tarik
 * @version mars 2010
 */

public class Carte implements Comparable<Carte>{

	/* Attributs */
	
	private Valeur valeur;
	private Couleur couleur;
	
	/* Constructeurs */
     
    /**
     * Constructor of initialization for objects of class Carte.
     * @param v la Valeur a associer.
     * @param c la Couleur a associer.
     */
	public Carte(Valeur v, Couleur c){
		this.valeur = v;
		this.couleur= c;
	}//Carte

	/* Accesseurs et Mutateurs */
	
	/**
     * getValeur - Consultation de la valeur de la carte courante.
     * @return la valeur de la carte courante.
     */
	public Valeur getValeur(){
	return this.valeur;
	}//getValeur

	/**
     * getCouleur - Consultation de la couleur de la carte courante.
     * @return la couleur de la carte courante.
     */
	public Couleur getCouleur(){
	return this.couleur;
	}//getCouleur

	/**
     * compareTo - Comparaison des valeurs entre deux instances Cartes.
     * @param c La carte avec laquelle on compare l'instance Carte courante.
     * @return un entier positif si la valeur de la carte courante est superieur a la carte en parametre.
     * 		   un entier negatif si la valeur de la carte courante est inferieur a la carte en parametre.
     */
	public int compareTo(Carte c){
	return this.valeur.compareValeur(c.valeur); 
	}//compareTo

	/**
     * equals - Predicat qui teste si deux objets Cartes sont egaux.
     * @param o L'objet avec lequelle on teste le predicat.
     * @return VRAI si les deux cartes ont la meme valeur, FAUX sinon.
     */	
	public boolean equals(Object o){
	if (o instanceof Carte){
	Carte x = (Carte)o;
	return x.valeur == this.valeur;
	}else return false;
	}//equals

	/**
     * toString - Affichage de la valeur et de la couleur de la carte courante.
     * @return Une chaine de caractere decrivant la valeur et la couleur de la carte courante.
     */
	public String toString(){
	return this.valeur.name()+" de "+this.couleur.name();
	}//toString

}// class Carte
