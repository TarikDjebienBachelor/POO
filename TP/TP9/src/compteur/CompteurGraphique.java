package compteur;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CompteurGraphique{
    
    /** le compteur
     */
    private Compteur c;

    // les composants graphiques
    private JFrame frame;
    private JButton init;
    private JButton increment;
    private JTextField saisie;
    private JLabel affichage;
    
    /**
     * Cree, Initialise et affiche un compteur controle via cette IHM
     * @param counter le compteur lie a ce GraphicalCounter
     */
    public CompteurGraphique( Compteur counter ){
	this.c = counter;
	this.frame = new JFrame("Compteur Graphique");
	this.frame.add( this.init() );
	this.frame.pack();
	this.frame.addWindowListener( new CloseWindowEvent() );
	this.frame.setVisible( true );
    }

    /**
     * Initialise et retourne un panel contenant les composants
     * @return JPanel le panel du GraphicalCounter
     */
    private JPanel init(){

	this.init = new JButton("Initialiser");
	this.init.addActionListener( new InitButtonActionListener() );

	this.increment = new JButton("Incrementer");
	this.increment.addActionListener( new IncrementButtonActionListener() );
	this.increment.setEnabled(false);

	this.saisie = new JTextField(3);
	JPanel p = new JPanel();
	p.setLayout( new FlowLayout() );
	p.add( this.saisie );
	p.add( this.init );

	this.affichage = new JLabel("Valeur : ");

	JPanel pane = new JPanel();
	pane.setLayout( new BorderLayout() );
	pane.add( p, BorderLayout.NORTH );
	pane.add( this.affichage, BorderLayout.CENTER );
	pane.add( this.increment, BorderLayout.SOUTH );

	return pane;
    }

    /**
     * Rafraichit l'affichage de la valeur du compteur
     */
    private void refresh(){
	this.affichage.setText( "Valeur : " + c.getCurrentValue() );
    }


    /**
     * Listener pour le bouton init
     */
    private class InitButtonActionListener implements ActionListener{
	public void actionPerformed( ActionEvent e ){
	    try { 
		int i = Integer.parseInt( CompteurGraphique.this.saisie.getText() );
		CompteurGraphique.this.c.init( i );
		CompteurGraphique.this.refresh();
		CompteurGraphique.this.init.setEnabled(false);
		CompteurGraphique.this.saisie.setEnabled(false);
		CompteurGraphique.this.increment.setEnabled(true);
	    } catch (NumberFormatException ex) {
		CompteurGraphique.this.saisie.setText("");
	    }
	}
    }

    /**
     * Listener pour le bouton increment
     */
    private class IncrementButtonActionListener implements ActionListener{
	public void actionPerformed( ActionEvent e ){
	    CompteurGraphique.this.c.increment();
	    CompteurGraphique.this.refresh();
	}
    }

    /**
     * Listener pour la fermeture des JFrame
     */
    private class CloseWindowEvent extends WindowAdapter{
	public void windowClosing( WindowEvent e){
	    System.exit(0);
	}
    }

}
