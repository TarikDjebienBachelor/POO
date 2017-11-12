package image;

import java.awt.Color;
import java.util.*;

public class Image {

	private Color[][] lesPoints;
	
	public Image(int hauteur, int largeur) {
		this.lesPoints = new Color[hauteur][largeur];
		for(int i=0; i < hauteur; i++) {
				for (int j=0; j < largeur; j++) {	
					this.lesPoints[i][j] = Color.BLACK;
				}
		}
	}
	
	public void init(String nomFichier) {
		//
	}
	
	public Color getColorAt(int x, int y) {
		return this.lesPoints[x][y];
	}
	
	public int getHauteur() {
		return this.lesPoints.length;
	}
	public int getLargeur() {
		return this.lesPoints[0].length;
	}
	
	public List compresse() {
		List lesCouples = new ArrayList();
		int compteur = 1;
		Color couleur = this.lesPoints[0][0];
		for(int i = 1; i < this.getLargeur()*this.getHauteur(); i++) {
			if (this.lesPoints[i/this.getLargeur()][i%this.getLargeur()].equals(couleur)) {
				compteur = compteur + 1;
			} else {
				lesCouples.add(new Couple(compteur, couleur));
				compteur = 1;
				couleur = this.lesPoints[i/this.getLargeur()][i%this.getLargeur()];
			}
		}
		lesCouples.add(new Couple(compteur, couleur));
		return lesCouples;
	}
	
	public static Image decompresse(List lesCouples, int hauteur, int largeur) {
		Image img = new Image(hauteur, largeur);
		Iterator it = lesCouples.iterator();
		int indice = 0;
		while(it.hasNext() && indice < largeur*hauteur) {
			Couple c = (Couple) it.next();
			for (int i = 0; i<c.getNombre() && indice < largeur*hauteur; i++) {
				img.lesPoints[indice/largeur][indice%largeur] = c.getColor();
				indice = indice + 1;
			}
		}
		return img;
	}
	
	public void affiche() { //(int x0, int y0) {
		for(int i=0; i < this.getHauteur(); i++) {
			for (int j=0; j < this.getLargeur(); j++) {	
				System.out.print(this.lesPoints[i][j]);     // !!! c'est juste pour pouvoir tester !!!
				//Ecran.affichePoint(x0+i,y0+i,this.lesPoints[i][j]); // !! c'est la "bonne" ligne !!!
			}
			System.out.println();
		}	
	}
	
	public static void main(String[] args) {
		Image img = new Image(8,7);
		img.lesPoints[0][0] = Color.BLUE;img.lesPoints[0][1] = Color.BLUE;
		img.lesPoints[0][2] = Color.RED;img.lesPoints[0][3] = Color.RED;img.lesPoints[0][4] = Color.RED;
		img.lesPoints[0][5] = Color.BLUE;img.lesPoints[0][6] = Color.BLUE;
		
		img.lesPoints[1][0] = Color.BLUE;img.lesPoints[1][1] = Color.RED;
		img.lesPoints[1][2] = Color.RED;img.lesPoints[1][3] = Color.RED;img.lesPoints[1][4] = Color.RED;
		img.lesPoints[1][5] = Color.RED;img.lesPoints[1][6] = Color.BLUE;
		
		img.lesPoints[2][0] = Color.BLUE;img.lesPoints[2][1] = Color.RED;
		img.lesPoints[2][2] = Color.RED;img.lesPoints[2][3] = Color.RED;img.lesPoints[2][4] = Color.RED;
		img.lesPoints[2][5] = Color.RED;img.lesPoints[2][6] = Color.BLUE;
	
		img.lesPoints[3][0] = Color.BLUE;img.lesPoints[3][1] = Color.BLUE;
		img.lesPoints[3][2] = Color.RED;img.lesPoints[3][3] = Color.RED;img.lesPoints[3][4] = Color.RED;
		img.lesPoints[3][5] = Color.BLUE;img.lesPoints[3][6] = Color.BLUE;
	
		img.lesPoints[4][0] = Color.YELLOW;img.lesPoints[4][1] = Color.YELLOW;img.lesPoints[4][2] = Color.YELLOW;img.lesPoints[4][3] = Color.YELLOW;
		img.lesPoints[4][4] = Color.YELLOW;img.lesPoints[4][5] = Color.YELLOW;img.lesPoints[4][6] = Color.YELLOW;
		
		img.lesPoints[5][0] = Color.YELLOW;img.lesPoints[5][1] = Color.YELLOW;img.lesPoints[5][2] = Color.YELLOW;img.lesPoints[5][3] = Color.YELLOW;
		img.lesPoints[5][4] = Color.YELLOW;img.lesPoints[5][5] = Color.YELLOW;img.lesPoints[5][6] = Color.YELLOW;
		
		img.lesPoints[6][0] = Color.YELLOW;img.lesPoints[6][1] = Color.YELLOW;img.lesPoints[6][2] = Color.YELLOW;img.lesPoints[6][3] = Color.YELLOW;
		img.lesPoints[6][4] = Color.YELLOW;img.lesPoints[6][5] = Color.YELLOW;img.lesPoints[6][6] = Color.YELLOW;
		
		img.lesPoints[7][0] = Color.YELLOW;img.lesPoints[7][1] = Color.YELLOW;img.lesPoints[7][2] = Color.YELLOW;img.lesPoints[7][3] = Color.YELLOW;
		img.lesPoints[7][4] = Color.YELLOW;img.lesPoints[7][5] = Color.YELLOW;img.lesPoints[7][6] = Color.YELLOW;
		
		img.affiche(); // bon pas très lisible, ok
		List lc = img.compresse();
		System.out.println(lc);
		Image img2 = Image.decompresse(lc,8,7);
		img2.affiche();
	}
}
