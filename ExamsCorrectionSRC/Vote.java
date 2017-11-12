package scrutin;

public class Vote {
	private final String nom;
	
	public static final Vote BLANC = new Vote("blanc");
	public static final Vote NUL = new Vote("nul");
	public static final Vote OUI = new Vote("oui");
	public static final Vote NON = new Vote("non");

	
	public Vote(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String toString() {
		return this.nom;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Vote) {
			return this.nom.equals(((Vote) o).nom);
		} 
		else {
			return false;
		}
	}
	
	public int hashCode()  {
		return this.nom.hashCode();
	}
}
