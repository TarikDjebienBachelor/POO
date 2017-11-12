/**
 * @(#)Carte.java
 * La classe Carte est une classe dédier à présenter une carte <br> de jeu. 
 * @author SMIMITE Badr-Eddine
 * @version 1.00 
 */

package game;
     
public class Carte{

    private int num;
    private char type;
    private String img;

    /**
     *  c'est un constructeur a partir 
     *  d'un entier qui présentra <b>num</b>
     *  et un caractére qui présentra <b>type</b> 
     */
    public Carte(int a, char b){
	this.num = a;
        this.type = b;
        this.img = "img/"+a+b+".GIF";
    }
    
    /**
     * un constructeur d'un objet carte par copie d'un autre objet carte
     */
    public Carte(Carte C){
		this.num = C.num;
        this.type = C.type;
  		this.img = C.img;
    }
    /**
     * renvoie num
     */
    public int getNum(){
        return this.num;
    }
    
    /**
     * renvoie type
     */
    public char getType(){
	return this.type;
    }
    
    /**
     * renvoie img (le nom du fichier qui contiens l'image de la carte)
     */
    public String getImg(){
	return this.img;
    }
    
    /**
     * compare deux cartes   <br>
     * Renvoie this.num-C.num <br>
     *               =0 si this.num = C.num
     *         <br>  >0 si this.num > C.num
     *         <br>  <0 si this.num < C.num
     *                   
     */
    public int CompareTo(Carte C){
		return this.num - C.num;
    }

    /**
     * affiche une carte
     */
    public void afficher(){
	System.out.print(this.num+""+this.type+" ");
    }
    
    /**
     * renvoie une chaine de caractéres avec les paramétres de 
     * la carte.
     */
    public String toString(){
    	String S = ""+this.num+this.getType();
    	return S;
    }


    public static void main(String arg[]){

	    Carte C1 = new Carte(1, 'C');
        System.out.println(C1.num+" "+C1.type+" "+C1.img);
        System.out.println(C1.getNum()+" "+C1.getType()+" "+C1.getImg());
        C1.afficher();
        Carte C3 = new Carte(C1);
        C3.afficher();
        C3.num = 2;
        System.out.printf(""+C1.CompareTo(C3));
    } 
}
