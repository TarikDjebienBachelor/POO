/**
 * Input.java
 *
 *
 * @author <a href="mailto:routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
package hanoi.io ;

public class Input {

    public static String readString() throws java.io.IOException {
    	return new java.io.BufferedReader(new java.io.InputStreamReader(System.in)).readLine();
    }
	
	// lire un entier sur l'entree standard
	// celui ci a ete caste de String to Int
    public static int readInt() throws java.io.IOException {
    	int n;
    	try {
    		n=Integer.parseInt(readString());
    	} catch(NumberFormatException e) {
    		throw new java.io.IOException();
    	}
    	return n;
    }

}// Input
