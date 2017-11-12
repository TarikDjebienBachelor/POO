 
/**
 * @(#)Hand.java
 * La classe Carte est une classe dédier à présenter la main 
 * d'un joueur 
 * @author SMIMITE Badr-Eddine
 * @version 1.00
 */ 
package game;     
     
public class Hand{
   
    private Carte ListeCard[];
    private int NCard;
   
   /**
    * constructeur par initialisation
    */ 
    public Hand(){
        this.ListeCard = new Carte[20];
        this.NCard = 0;
    }
   
    /**
    * constructeur par copie.
    */
    public Hand(Hand H){
	this.ListeCard = new Carte[20];
        for(int i=0;i<H.NCard;i++){
            this.ListeCard[i]=new Carte(H.ListeCard[i]);
        }
	this.NCard = H.NCard;
	
    }
    
   /**
    * renvoie si une main est vide ou non.
    */
    public boolean estVide(){
	return this.NCard == 0;
    }
    
    /**
     * renvoie le nombre de carte dans une main.
     */
    public int getNCard(){
    	return this.NCard;
    }
   
   /**
    * insert une carte à la fin de la main
    * <br>Renvoie Vrai si l'insertion est appliqué
    */
    public boolean insertCard(Carte C){
        if(this.NCard < 20){
            this.ListeCard[this.NCard] = new Carte(C);
            this.NCard++;
            return true;
	}
        else{
	    return false;
	}
    }
   
   /**
    * supprime la dernière carte de la main
    * Renvoie V si la suppression se passe bien.
    */
    public boolean deletHead(){
        if(this.NCard > 0){
			this.ListeCard[this.NCard-1]=null;
			this.NCard--;
			return true;
		}
		else{
			return false;
        }
    }
   
   /**
    * supprime la première carte de la main
    * Renvoie V si la suppression se passe bien.
    */
    public boolean deletFirst(){
        if(this.NCard > 0){
        	for(int i=1; i<this.NCard
        		;i++){
        		this.ListeCard[i-1]= this.ListeCard[i];
        	}
	    	this.ListeCard[this.NCard-1]=null;
		 	this.NCard--;
			return true;
		}
		else{
			return false;
        }
    }
   
   
   /**
    * renvoie la dernière carte de la main
    * <br>Renvoie <b>null</b> si ce n'est pas possible.
    */
    public Carte getHead(){
      if(this.NCard != 0){
		return this.ListeCard[this.NCard-1];
      }
      else{
		return null;
      }
    }
    /**
     * renvoie la premiere carte de la main
     * <br>Renvoie <b>null</b> si ce n'est pas possible.
     */
    public Carte getFirstCard(){
    	if(this.NCard != 0){
    		return this.ListeCard[0];	
    	}
    	else{
    		return null;
    	}
    }
    
    /**
     * Compare deux main si elles contiennet les même carte dans le même ordre.
    */
    public boolean CompareTo(Hand H){
       boolean d = (this.NCard == H.NCard);
       int i=0;
       while(i<this.NCard && d==true){
            if(this.ListeCard[i].CompareTo(H.ListeCard[i]) != 0){
                  d = false;
            }
            else{
                 i++;
            }
	}
       return d;
    }
    
    /**
     * affiche une main
     */
    public void afficher(){
      for(int i=0; i<this.NCard;i++){
         this.ListeCard[i].afficher();
      }
      System.out.println("");
    }
    
    /**
     * renvoie une chaine de caractéres avec les numeros dans l'ordre des cartes de la main.
     */
    public String toString(){
    	String S = new String("");
    	for(int i=0; i<this.NCard; i++){
    		S = S + this.ListeCard[i].getNum();
    	}
    	return S;
    }
  
    /**
     * renvoie une chaine de caractére avec les cartes de la main.
     */
    public String toString2(){
    	String S = new String("");
    	for(int i=0; i<this.NCard; i++){
    		S = S + this.ListeCard[i].toString();
    		S = S + " ";
    	}
    	return S;
    }
  
    /**
     * initialise la main à 0 carte.
     */
    public void clearHand(){
    	this.NCard = 0;
    	this.ListeCard = new Carte[20];
    }
  
    public static void main(String arg[]){
	Hand H = new Hand();
        Carte C = new Carte(1,'C');
        H.afficher();
        if(H.insertCard(C)){
         H.afficher();
        }
        Hand Hp = new Hand(H);
        Hp.afficher();
	if(Hp.CompareTo(H)) System.out.println("1");
        for(int i=0;i<22;i++){
		if(H.insertCard(C)){
         	   H.afficher();
        	}	
        }
	for(int i=0;i<22;i++){
		if(H.deletHead()){
         	   H.afficher();
        	}	
        }
	if(Hp.CompareTo(H)) System.out.println("2");
        C = new Carte(2,'D');
        Hp.insertCard(C);
        System.out.println(Hp.toString());
        System.out.println(Hp.toString2());
   }
  
}
