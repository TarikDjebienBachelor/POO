package PierrePapierCiseaux;

/** 
 * <p style= "font-size: 170%;" >  Classe  PierrePapierCiseaux.Joueur </p>
 * @author Djebien Tarik
 * @version avril 2010
 */

public class Joueur{
	
	/* Attributs */
	private int nbPoints;
	private String nom;
	private Strategie strategie;
	
	/* Constructeurs */
     
     /**
      * Constructor of initialization for objects of class Joueur.
      * @param playerStrategie  La strategie de jeu du joueur.
      * @param name Le nom du joueur.
      */
    
	public Joueur(Strategie playerStrategie,String name){
	this.nom = name;
	this.strategie = playerStrategie;
	this.nbPoints = 0;
	}// Constructeur d'initialisation Joueur

	/* Accesseurs et Mutateurs */
	
    /**
     * getNbPoints - Consultation du nombre de points du joueur.
     * @return le nombre de points du joueur courant.
     */
	public int getNbPoints(){
	return this.nbPoints;
	}// getNbPoints

    /**
     * getName - Consultation du nom du joueur.
     * @return le nom du joueur courant.
     */
	public String getName(){
	return this.nom;
	}// getName

    /**
     * getStrategie - Consultation de la strategie adopte par le joueur.
     * @return la strategie du joueur courant.
     */
	public Strategie getStrategie(){
	return this.strategie;
	}// getStrategie

	/**
	 * setNbPoints - Modification du nombre de points du joueur.
	 * @param t le nouveau nombre de points de l'instance Joueur courante.
	 */
	public void setNbPoints(int t){
	this.nbPoints = t;
	}//setNbPoints

	/**
	 * setName - Modification du nom du joueur.
	 * @param s le nouveau nom de l'instance Joueur courante.
	 */
	public void setName(String s){
	this.nom = s;
	}//setName

	/**
	 * setStrategie - Modification de la strategie actuelle du joueur.
	 * @param strat la nouvelle strategie de l'instance Joueur courante.
	 */
	public void setStrategie(Strategie strat){
	this.strategie = strat;
	}//setStrategie
	
	/* Methodes */
	
	/**
	 * ajouterPoints - Ajouter des points au joueur.
	 * @param n le nombre de point a ajouter a l'instance Joueur courante.
	 */
	public void ajouterPoints(int n){
	this.nbPoints += n;
	}// ajouterPoints
	
	/**
	 * joue - Retourne le coup jouer par le joueur.
	 * @return le coup joue par l'instance Joueur courante.
	 */
	public Coup joue(){
	return this.strategie.getCoup();
	}// joue
	
}// class Joueur
