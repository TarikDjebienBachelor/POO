/** 
 * Classe  <ClassName>
 * @author Djebien Tarik
 * @version fevrier 2010
 */

 public class <ClassName>{
     
    /* Attributs */
     private <Typeattribut> <attributname>;
     
    /* Constructeurs */
     
     /**
      * Constructor for objects of class <ClassName>.
      */
     
    public <ClassName>(){
        this. = ;
    }// Constructeur par default

     /**
      * Constructor of initialization for objects of class <ClassName>.
      * @param n ....... à affecter à l'objet construit.
      */
     
    public <ClassName>(<typeN> N){
        this. = N;
    }// Constructeur d'initialisation
    
    /* Accesseurs et Mutateurs */
    
    /**
     * get<attributname> - Consultation de ....... de l'instance courante.
     * @return ....... de l'instance courante.
     */
    
    public <Typeattribut> get<attributname>(){
        return this.<attributname>;
    }// get<attributname>
    
    /**
     * set<attributname> - Modification de ....... de l'instance courante.
     * @param ....... de l'instance courante à modifier.
     */
    
    public void set<attributname>(<TypeAttributModifié> P){
        this.<attributname> = P;
    }// set<attributname
    
    /* Methodes */
    
    /**
     * nameMethod - description.
     * @param <param> description.
     * @return  description 
     */
    
    public <TypeRetourMethode | void > nameMethod(<Typeparam> <param>){
        <implementation de la methode> ;
    }// nameMethod    
    
    //etc ...

}// class  <ClassName>
