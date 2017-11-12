/** 
 * Classe  Marchandise
 * @author Djebien Tarik
 * @version fevrier 2010
 */

 public class Marchandise{
     
    /* Attributs */
     private float value;
     private String name;
     
    /* Constructeurs */
     
     /**
      * Constructor for objects of class Marchandise.
      * param Nom Le nom à affecter à l'objet construit.
      */
     
    public Marchandise(String Nom){
        this.name = Nom ;
        this.value = 0.0f;
    }// Constructeur par default

     /**
      * Constructor of initialization for objects of class Marchandise.
      * param Nom Le nom à affecter à l'objet construit.
      * param Valeur La Valeur à affecter à l'objet construit.
      */
     
    public Marchandise(String pNom, float pValeur){
        this.name = pNom ;
        this.value = pValeur ;
    }// Constructeur d'initialisation
    
    /* Accesseurs et Mutateurs */
    
    /**
     * getValue - Consultation de la valeur de l'instance courante.
     * @return La valeur de l'instance courante.
     */
    public float getValue(){
        return this.value;
    }// getValue

    
    /**
     * setValue - Modification de la valeur de l'instance courante.
     * @param val La nouvelle Valeur de l'instance courante.
     */
    public void setValue(float val){
        this.value = val;
    }// setValue
    
    /**
     * getName - Consultation du nom de l'instance courante.
     * @return Le nom de l'instance courante.
     */    
    public String getName(){
        return this.name;
    }// getName
    
    
    /* Methodes */
    
    /**
     * toString - description de l'instance courante.
     * @return  "La marchandise <name> vaut <value> "
     */
    public String toString(){
        return "La marchandise " + this.name + " vaut " + this.value + " euros.";
    }// toString    

    /**
     * valTTC - transformation de la valeur HTC vers TTC de l'instance courante.
     * @return  valeur Toute Taxe Comprise de l'instance courante.
     */
    public float valTTC(){
        return this.value + 19.6f * (this.value / 100);
    }// valTTC

}// class  Marchandise