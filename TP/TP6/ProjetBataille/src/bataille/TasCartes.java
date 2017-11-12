package bataille;

/** 
 * <p style= "font-size: 170%;" >  Classe  bataille.TasCartes </p>
 * @author Djebien Tarik
 * @version mars 2010
 */

public class TasCartes{
	
	/* Constantes */
	
	public static final int NB_MAX = 32;
	
	/* Attributs */
	
	private int nbCartes;
	private int debut;
	private int fin;
	private Carte[] lesCartes;

	/* Constructeurs */
     
    /**
     * Constructor of initialization for objects of class TasCartes.
     */
	public TasCartes(){
	this.nbCartes = 0;
	this.lesCartes = new Carte[NB_MAX];
	this.debut = 0;
	this.fin = 0;
	}// Constructeur d'initialisation Bataille

	/* Accesseurs et Mutateurs */
	
	/**
     * getNbCartes - Consultation du nombres de cartes du tas de cartes courant.
     * @return le nombre de cartes de l'instance tas de cartes courante.
     */
	public int getNbCartes(){
	return this.nbCartes;
	}// getNbCartes
	
	/**
     * setNbCartes - Modification du nombres de cartes du tas de cartes courant.
     * @param n le nouveau nombre de cartes a affecter a l'instance tas de cartes courante.
     */
	public void setNbCartes(int n){
	this.nbCartes = n;
	}//setNbCartes

	/**
     * getDebut - Consultation de l'indice de debut du tas de cartes courant.
     * @return l'indice de debut de l'instance tas de cartes courante.
     */
	public int getDebut(){
	return this.debut;
	}//getDebut

	/**
     * setDebut - Modification de l'indice de debut du tas de cartes courant.
     * @param n le nouvel indice de debut a affecter a l'instance tas de cartes courante.
     */
	public void setDebut(int n){
	this.debut = n;
	}//setDebut

	/**
     * getFin - Consultation de l'indice de fin du tas de cartes courant.
     * @return l'indice de fin de l'instance tas de cartes courante.
     */	
	public int getFin(){
	return this.fin;
	}//getFin
	
	/**
     * setFin - Modification de l'indice de fin du tas de cartes courant.
     * @param n le nouvel indice de fin a affecter a l'instance tas de cartes courante.
     */
	public void setFin(int n){
	this.fin = n;
	}//setFin

	/**
     * getLesCartes - Consultation du tas de cartes de l'instance courante.
     * @return le tas de cartes de l'instance tas de cartes courante.
     */
	public Carte[] getLesCartes(){
	return this.lesCartes;
	}// getLesCartes

	/**
     * setLesCartes - Modification du tas de cartes de l'instance courante.
     * @param newTas le nouveau tas de cartes a affecter a l'instance tas de cartes courante.
     */	
	public void setLesCartes(Carte[] newTas){
	this.lesCartes = newTas;
	}// setLesCartes
	
	// incrementation avec modulo pour parcours de la file(FIFO) circulaire.
	private int inc(int i){
	return (i+1)% this.getLesCartes().length;
	}//inc

	// incrementation avec modulo pour parcours de la file(FIFO) circulaire.
	// Surcharge de methode.	
	private int inc(int i,TasCartes p){
	return (i+1)% p.getLesCartes().length;
	}//inc surchargé

	/**
     * enleveCarteEnTete - Retirer la carte au sommet du tas de cartes de l'instance courante.
     * @return la carte que l'on a retire.
     * @throws TasVideException 
     * 		   Si jamais le tas de cartes est vide.
     */
	public Carte enleveCarteEnTete() throws TasVideException{
	if (this.estVide()){
	throw new TasVideException();
	}else{
	Carte sommet = this.getLesCartes()[this.getDebut()];
	this.debut = this.inc(this.debut);
	this.nbCartes--;
	return sommet;
	}
	}//enleveCarteEnTete

	/**
     * ajouteCarteEnFin - Ajouter la carte sous le tas de cartes de l'instance courante.
     * @param carte la carte que l'on doit ajouter.
     * @throws TasPleinException 
     * 		   Si jamais le tas de cartes est plein.
     */	
	public void ajouteCarteEnFin(Carte carte) throws TasPleinException{
	if (this.estPleine()){
	this.redimensionnerTasCartes();
	throw new TasPleinException();
	}
	this.lesCartes[this.fin]= carte;
	this.fin = this.inc(this.fin);
	this.nbCartes++;
	}//ajouteCarteEnFin
	
	/**
     * ajouteDesCartesEnFin - Ajouter plusieurs cartes sous le tas de cartes de l'instance courante.
     * @param file le tas de cartes que l'on doit ajouter.
     */	
	public void ajouteDesCartesEnFin(TasCartes file){
	try{
	if (file.getNbCartes() > 0) {
      int i = file.getDebut();
      while (i != file.getFin()){
        this.ajouteCarteEnFin(file.getLesCartes()[i]);
        i = this.inc(i,file);
      }
    }
	}catch (TasPleinException g){
	 //g.printStackTrace();
	}
	}//ajouteDesCartesEnFin
	
	/**
	 * estVide - predicat qui teste si le tas de cartes courant est vide.
	 * @return VRAI si le tas de cartes est vide, FAUX sinon.
	 */
	public boolean estVide(){
	return this.nbCartes == 0;
	}//estVide

	/**
	 * estPleine - predicat qui teste si le tas de cartes courant est plein.
	 * @return VRAI si le tas de cartes est plein, FAUX sinon.
	 */
	public boolean estPleine(){
	return this.nbCartes+1 > this.getLesCartes().length;
	}//estPleine
	
	/**
	 * initialiserTasCartes - initialisation avec les 32 cartes du tas de cartes courant.
	 */
	public void initialiserTasCartes(){
	for (Couleur c : Couleur.values()){
		for (Valeur v : Valeur.values()){
		try{
		   this.ajouteCarteEnFin(new Carte(v,c));
		}catch(TasPleinException e){
		//e.printStackTrace();
		}
		}
	}
	}//initialiserTasCartes

	/**
	 * melangerTasCartes - melange aleatoire des 32 cartes du tas de cartes courant.
	 */
	public void melangerTasCartes(){
	for (int k = this.getLesCartes().length; k >= 2;k--){
	java.util.Random r = new java.util.Random(); 
	int i= r.nextInt(k); //nbr aleatoire de [0,k[ 
	Carte temp = this.getLesCartes()[i];
	this.getLesCartes()[i] = this.getLesCartes()[k-1];
	this.getLesCartes()[k-1] = temp;
	}
	}//melangerTasCartes
	
	/**
	 * redimensionnerTasCartes - redimenssionnement de la taille du tas de cartes courant.
	 */
	private void redimensionnerTasCartes(){
	Carte[] nouveauTas = new Carte[1 + this.getLesCartes().length];
    int i = this.debut;
    for (int k = 0 ; k < this.getNbCartes() ; k++) {
      nouveauTas[k] = this.getLesCartes()[i] ;
      i = this.inc(i) ;
    }
    this.setLesCartes(nouveauTas);
    this.setDebut(0);
    this.setFin(this.getNbCartes());
	}//redimensionnerTasCartes
	
	/**
	 * afficherTasCartes - affichage des 32 cartes du tas de cartes courant.
	 * @return une chaine de caractere representant le tas de cartes.
	 */
	public String afficherTasCartes(){
	String s = new String("") ;
    s = s.concat("[");
    if (this.nbCartes > 0) {
      int i = this.debut;
      s = s.concat(this.getLesCartes()[i].toString());
      i = this.inc(i) ;
      while (i != this.fin){
        s = s.concat(",\n " + this.getLesCartes()[i].toString());
        i = this.inc(i);
      }
    }
    s = s.concat("]");
    return s;
  	}//afficherTasCartes
  	
}// class TasCartes
