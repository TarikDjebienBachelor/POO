package hanoi.util;


/** 
 * <p style= "font-size: 170%;" > Classe  hanoi.util.Tour </p>
 * @author Djebien Tarik
 * @version mars 2010
 */

 public class Tour{
     
    /* Attributs */
     private int numero;
     private int hauteur;
     private int nbDisques;
     private Disque[] lesDisques;
     
    /* Constructeurs */
     
     /**
      * Constructor of initialization for objects of class Tour.
      * @param n numero a affecter a l'objet Tour construit.
      * 		 (1 -> tour1 , 2 -> tour2, 3 -> tour3).
      * @param h hauteur de l'objet tour construit. 
      *          (nombre de disques maximal que la tour peut contenir).
      */
     
    public Tour(int n,int h){
        this.numero  = n;
        this.hauteur = h;
        this.lesDisques = new Disque[h];
        this.nbDisques = 0;
    }// Constructeur d'initialisation
    
    /* Accesseurs et Mutateurs */

    /**
     * getNumero - Consultation du numero de la tour courante.
     * @return le numero de l'instance tour courante.
     */
    public int getNumero(){
        return this.numero;
    }// getNumero
    
    /**
     * getSommet - Consultation du disque au sommet de la tour courante.
     * @return le disque situe au sommet de l'instance tour courante.
     * @throws IllegalStateException 
     * 		   Si jamais la Tour est vide.
     */
    public Disque getSommet() throws IllegalStateException{
       if (!this.estVide()){ 
        return this.lesDisques[this.nbDisques -1];
	   }else
	   { throw new IllegalStateException("La Tour "+this.getNumero()+" est Vide");
		}
    }// getSommet
    
    /**
     * getLesDisques - Consultation des disques de la tour courante.
     * @return les disques situes sur l'instance tour courante.
     */
    public Disque[] getLesDisques(){
        return this.lesDisques;
    }// getLesDisques
    
    /**
     * getNbDisque - Consultation du nombre de disque de la tour courante.
     * @return le nombre de disque situe sur l'instance tour courante.
     */
    public int getNbDisques(){
        return this.nbDisques;
    }// getNbDisques

    /**
     * getHauteur - Consultation de la hauteur de la tour courante.
     * @return le nombre de disque maximal pouvant etre poses sur la tour courante.
     */
    public int getHauteur(){
        return this.hauteur;
    }// getHauteur
    
    /* Methodes */
    
    /**
     * estVide - predicat qui teste si la tour courante est vide.
     * @return TRUE si la tour courante est vide, FALSE sinon.
     */
    public boolean estVide(){
        return (this.nbDisques == 0);
    }// estVide

    /**
     * estPleine - predicat qui teste si la tour courante est pleine.
     * @return TRUE si la tour courante est pleine, FALSE sinon.
     */
    public boolean estPleine(){
        return (this.nbDisques == this.hauteur);
    }// estPleine
 
    /**
     * empiler - deposer un disque au sommet de la tour courante.
     * @param d le disque a deposer.
     * @throws IllegalStateException 
     * 		   Si jamais la Tour est deja pleine.
     */    
    public void empiler(Disque d) throws IllegalStateException{
        if (!this.estPleine()){
		this.lesDisques[this.nbDisques] = d;
		this.nbDisques = this.nbDisques + 1;	
			}
	    else{ throw new IllegalStateException("La Tour "+this.getNumero()+" est Pleine");
			}
    }// empiler    
    
    /**
     * depiler - retirer un disque au sommet de la tour courante.
     * @throws IllegalStateException 
     * 		   Si jamais la Tour est vide.
     */    
    public void depiler() throws IllegalStateException{
        if (!this.estVide()){
		this.lesDisques[this.nbDisques -1] = null;
		this.nbDisques = this.nbDisques - 1;
			}
	    else{ throw new IllegalStateException("La Tour "+this.getNumero()+" est Vide");
			}
    }// depiler

}// class Tour
