package PierrePapierCiseaux;
import java.util.*;

/** 
 * <p style= "font-size: 170%;" >  Classe  PierrePapierCiseaux.Coup </p>
 * @author Djebien Tarik
 * @version avril 2010
 */

public enum Coup{
	pierre, papier, ciseaux;
	
	/**
	 * coupSuivant - renvoie le coup suivant selon l'ordre suivant PIERRE puis PAPIER et enfin CISEAUX.
	 * @return le coup suivant du coup courant.
	 */
	public Coup coupSuivant(){
	Coup[] tab = Coup.values();   
	return tab[((this.ordinal()+1)%(tab.length))];
	}// coupSuivant

	/**
	 * compareCoup - comparaison qui determine lequel des deux coups prend le dessus.
	 * @param c le coup avec lequel on va tester la comparaison sur l'instance Coup courante.
	 * @return    0 , si il y a egalite.
	 *            1 , si le coup courant gagne sur le coup en parametre.
	 *	     -1 , si le coup courant perd sur le coup en parametre.
	 */
	public int compareCoup(Coup c){
	int res=0;
	
	// CAS OU THIS.name() = PIERRE
	   if (this.name().equals("pierre")){
	      // PIERRE VS PIERRE
	      if (c.name().equals("pierre")){
	      res = 0;
	      }
	      // PIERRE VS PAPIER
	      if (c.name().equals("papier")){
	      res = -1;
	      }
	      // PIERRE VS CISEAUX
	      if (c.name().equals("ciseaux")){
	      res =  1;
	      }
	   }	
	// CAS OU THIS.name() = PAPIER
	   if (this.name().equals("papier")){
	      // PAPIER VS PIERRE
	      if (c.name().equals("pierre")){
	      res = 1;
	      }
	      // PAPIER VS PAPIER
	      if (c.name().equals("papier")){
	      res = 0;
	      }
	      // PAPIER VS CISEAUX
	      if (c.name().equals("ciseaux")){
	      res = -1;
	      }
	   }
	// CAS OU THIS.name() = CISEAUX
	   if (this.name().equals("ciseaux")){
	      // CISEAUX VS PIERRE
	      if (c.name().equals("pierre")){
	      res = -1;
	      }
	      // CISEAUX VS PAPIER
	      if (c.name().equals("papier")){
	      res = 1;
	      }
	      // CISEAUX VS CISEAUX
	      if (c.name().equals("ciseaux")){
	      res =  0;
	      }
	   }
	return res;   
	}// compareCoup

							/* TEST DE LA CLASSE COUP */

	public static void main(String[] args){
	   System.out.println("PROGRAMME TEST DE L'ENUMERATION COUP\n");
	   Coup pierre = Coup.pierre;
	   Coup papier = Coup.papier;
	   Coup ciseaux = Coup.ciseaux;
	   //PIERRE
	   System.out.println(pierre.name()+" VS "+pierre.name()+" = "+pierre.compareCoup(pierre));
	   System.out.println(pierre.name()+" VS "+papier.name()+" = "+pierre.compareCoup(papier));
	   System.out.println(pierre.name()+" VS "+ciseaux.name()+" = "+pierre.compareCoup(ciseaux));
	   System.out.println();
	   //PAPIER
	   System.out.println(papier.name()+" VS "+pierre.name()+" = "+papier.compareCoup(pierre));
	   System.out.println(papier.name()+" VS "+papier.name()+" = "+papier.compareCoup(papier));
	   System.out.println(papier.name()+" VS "+ciseaux.name()+" = "+papier.compareCoup(ciseaux));
	   System.out.println();
	   //CISEAUX
	   System.out.println(ciseaux.name()+" VS "+pierre.name()+" = "+ciseaux.compareCoup(pierre));
	   System.out.println(ciseaux.name()+" VS "+papier.name()+" = "+ciseaux.compareCoup(papier));
	   System.out.println(ciseaux.name()+" VS "+ciseaux.name()+" = "+ciseaux.compareCoup(ciseaux));
	   System.out.println();
	   //coupSuivant()
	   System.out.println("succ("+pierre.name()+")= "+pierre.coupSuivant().name());
	   System.out.println("succ("+papier.name()+")= "+papier.coupSuivant().name());
	   System.out.println("succ("+ciseaux.name()+")= "+ciseaux.coupSuivant().name());
	   System.out.println();
	}// main

}// Coup
