/**
 * @(#)Principal.java
 * La classe charg� d'afficher l'application en mode graphique. 
 * @author SMIMITE Badr-Eddine
 * @version 1.00 
 */ 

package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

public class Principal extends JFrame{
	
	ImageIcon joker = new ImageIcon("img/joker.gif");
	ImageIcon vide  = new ImageIcon("img/vide.gif");
	
	JButton Csuivant  = new JButton("Coup Suivant");
	JButton Psuivante = new JButton("Pas Suivante");
	JButton Charger   = new JButton("Charger une parite");
	JButton Stop      = new JButton("Arr�ter le jeu");
	JButton Npartie   = new JButton("Nouvelle Partie");
	JButton ChFichier = new JButton("Charger un fichier");
	
	javax.swing.Timer T;
	
	JButton Jp1 = new JButton(joker);
	JButton Jp2 = new JButton(joker);
	JButton Tj1 = new JButton(vide);
	JButton Tj2 = new JButton(vide);
	
	JLabel Lj1 = new JLabel("                                          + Vous :");
	JLabel Lj2 = new JLabel("                                          + Ordinateur :");
	
	JTextArea Detail = new JTextArea(4,5);
    
	
	Jeu J;
	Player P1;
	Player P2;
	Carte C1;
	Carte C2;
	Hand H1 = new Hand();
	Hand H2 = new Hand();
	
	int numetape;
	int type;
	boolean d;
	
    public Principal(int type, String S){
    	
    	super("  ::jeu de carte - bataille::");
    	setSize(700,700);
    	move(200,15);
    	
    	//positionnement des composants
    	GridBagLayout Gridbag = new GridBagLayout();
    	GridBagConstraints Constraints = new GridBagConstraints();
    	JPanel pane = new JPanel();
    	pane.setLayout(Gridbag);
    	
    	Color bg = new Color(255,255,255);
    	pane.setBackground(bg);
    	
    	buildConstraints(Constraints,0,0,1,1,50,30);
        Constraints.fill = GridBagConstraints.NONE;
        Jp1.setBorder(new LineBorder(Color.black));
        Gridbag.setConstraints(Jp1, Constraints);
        pane.add(Jp1);
    	
    	buildConstraints(Constraints,1,0,1,1,50,0);
        Constraints.fill = GridBagConstraints.NONE;
        Jp2.setBorder(new LineBorder(Color.black));
        Gridbag.setConstraints(Jp2, Constraints);
        pane.add(Jp2);
        
        buildConstraints(Constraints,0,1,1,1,0,5);
        Constraints.fill = GridBagConstraints.BOTH;
        Gridbag.setConstraints(Lj1, Constraints);
        pane.add(Lj1);
        
        buildConstraints(Constraints,1,1,1,1,0,0);
        Constraints.fill = GridBagConstraints.BOTH;
        Gridbag.setConstraints(Lj2, Constraints);
        pane.add(Lj2);
        
        buildConstraints(Constraints,0,2,1,1,0,30);
        Constraints.fill = GridBagConstraints.NONE;
        Tj1.setBorder(new LineBorder(Color.black));
        Gridbag.setConstraints(Tj1, Constraints);
        pane.add(Tj1);
        
        buildConstraints(Constraints,1,2,1,1,0,0);
        Constraints.fill = GridBagConstraints.NONE;
        Tj2.setBorder(new LineBorder(Color.black));
        Gridbag.setConstraints(Tj2, Constraints);
        pane.add(Tj2);
        
        buildConstraints(Constraints,0,3,1,1,0,5);
        Constraints.fill = GridBagConstraints.BOTH;
        Constraints.anchor = GridBagConstraints.CENTER;
        Csuivant.setBorder(new LineBorder(Color.black));
        Gridbag.setConstraints(Csuivant, Constraints);
        pane.add(Csuivant);
        
        buildConstraints(Constraints,1,3,1,1,0,0);
        Constraints.fill = GridBagConstraints.BOTH;
        Constraints.anchor = GridBagConstraints.CENTER;
        Psuivante.setBorder(new LineBorder(Color.black));
        Gridbag.setConstraints(Psuivante, Constraints);
        pane.add(Psuivante);
        
        buildConstraints(Constraints,0,4,1,1,0,5);
        Constraints.fill = GridBagConstraints.BOTH;
        Constraints.anchor = GridBagConstraints.CENTER;
        Charger.setBorder(new LineBorder(Color.black));
        Gridbag.setConstraints(Charger, Constraints);
        pane.add(Charger);
        
        buildConstraints(Constraints,1,4,1,1,0,0);
        Constraints.fill = GridBagConstraints.BOTH;
        Constraints.anchor = GridBagConstraints.CENTER;
        Stop.setBorder(new LineBorder(Color.black));
        Gridbag.setConstraints(Stop, Constraints);
        pane.add(Stop);
        
        buildConstraints(Constraints,0,5,2,1,0,2);
        Constraints.fill = GridBagConstraints.BOTH;
        Constraints.anchor = GridBagConstraints.CENTER;
        Npartie.setBorder(new LineBorder(Color.black));
        Gridbag.setConstraints(Npartie, Constraints);
        pane.add(Npartie);
        
        buildConstraints(Constraints,0,6,2,1,0,21);
        Constraints.fill = GridBagConstraints.BOTH;
        JScrollPane scroll = new JScrollPane(Detail, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Gridbag.setConstraints(scroll, Constraints);
        pane.add(scroll);
    	this.setContentPane(pane);
    	
    	buildConstraints(Constraints,0,7,2,1,0,2);
        Constraints.fill = GridBagConstraints.BOTH;
        Constraints.anchor = GridBagConstraints.CENTER;
        ChFichier.setBorder(new LineBorder(Color.black));
        Gridbag.setConstraints(ChFichier, Constraints);
        pane.add(ChFichier);
    	
    	Detail.setFont(new Font("DialogInput",Font.BOLD,12));
    	Detail.setText("la partie va commencer :\n");
    	
    	
    	//gestion du jeu
    	this.type = type;
    	d = false;
        J = new Jeu();
        
        if(S != null){
        	Carte[] C = J.Chargerjeu(S);
        	if(C == null){
        		 JOptionPane.showMessageDialog(null,"le jeu choisi n'est pas valid");
        		 J.distribuer(J.battre(J.init()));
        	} 
        	else {
        		J.distribuer(C);
        	}
        }
        else{
        	J.distribuer(J.battre(J.init()));
        }
               
        P1 = J.getPlayer(1);
        P2 = J.getPlayer(2);
        J.initFichier();
        P1.addHand();
        P2.addHand();
               
        Detail.setText(Detail.getText()+"la partie : ");
        Detail.setText(Detail.getText()+J.getFichier());
        
        //gestion du timer
        ActionListener taskPerformer = new ActionListener() {
      		public void actionPerformed(ActionEvent evt) {
        		  Button_on_click(evt);;
      		}
  		};
        
        
    	switch(type){
    		case 1:
    			Csuivant.setEnabled(false);
    			numetape = 1;
    			break;
    		case 2:
    			Psuivante.setEnabled(false);
    			break;
    		case 3:
    			    
    			    Csuivant.setEnabled(false);
    			    Psuivante.setEnabled(false);
    			    T = new javax.swing.Timer(1000,taskPerformer);
    			    numetape = 1;
    			    T.start();
    			
    			break;		
    	}
    	
    	
    	
    	
    	//gestion des evenement sur les composant
    	Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_on_click(e);
            }
        });
        Npartie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_on_click(e);
            }
        });
        Charger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_on_click(e);
            }
        });
        Psuivante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_on_click(e);
            }
        });
        Csuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_on_click(e);
            }
        });
        
        ChFichier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_on_click(e);
            }
        });
    	//gestion des �v�nements sur la fen�tre
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                dispose();
            }
            public void windowClosed(WindowEvent evt) {
                
            }
        });
        
        
    }
     
    void buildConstraints(GridBagConstraints gbc, int gx, int gy,int gw, int gh, int wx, int wy){
    	gbc.gridx = gx;
    	gbc.gridy = gy;
    	gbc.gridwidth = gw;
    	gbc.gridheight = gh;
    	gbc.weightx = wx;
    	gbc.weighty = wy;
    }
    
    void Button_on_click(ActionEvent e){
    	Object source = e.getSource();
    	if(source == Stop){
    		int reponse = JOptionPane.showConfirmDialog(null,"voulez-vous quitter le jeu?");
    		if(reponse == 0){
    			this.setVisible(false);   
    			this.dispose();
    		}	
    	}
    	if(source == Npartie){
    		this.setVisible(false);   
    		this.dispose();
    		Debut D = new Debut();
    		D.setVisible(true);
    	}
    	if(source == Charger){
    		String S = JOptionPane.showInputDialog(null,"Entrez votre partie sous forme 11112222....(au min 20 chiffre 1-5)");
    		if(S != null){
        		Carte[] C = J.Chargerjeu(S);
        		if(C == null){
        			 JOptionPane.showMessageDialog(null,"le jeu choisi n'est pas valid");
        		} 
        		else {
        			if(T != null) T.stop();
        			this.setVisible(false);   
    		        this.dispose();
    		        Principal P = new Principal(this.type, S);
    		        P.setVisible(true); 
        		}
        	}
    	}
    	if(source == Psuivante){
    		
    		switch(this.numetape){
    			case 1 : //vous jouer
    				if(P1.aperdu()|| P2.aperdu()|| d){
    					this.numetape = 4;
    				}
    				else{
    				    
    				    C1 = new Carte(J.play1());			    
    				    H1.insertCard(C1);
    				    d = P1.findHand() && P2.findHand();
    				    Tj1.setIcon(new ImageIcon(C1.getImg()));	
    				    this.Detail.setText(this.Detail.getText()+"\n vous avez pose :"+C1.toString());
    				    this.numetape = 2;
    				}
    				break;
    			case 2 ://l'ordi joue
    				if(P2.aperdu() || d){
    					this.numetape = 4;
    				}
    				else{
    				    C2 = new Carte(J.play2());			    
    				    H2.insertCard(C2);
    				    d = P1.findHand() && P2.findHand();
    				    Tj2.setIcon(new ImageIcon(C2.getImg()));	
    				    this.Detail.setText(this.Detail.getText()+"\n l'ordinateur a pose :"+C2.toString());
    				    this.numetape = 3;
    				} 
    				break;
    			case 3 :
    					if(C1.CompareTo(C2) > 0){
    						Detail.setText(Detail.getText()+"\n vous avez gagne "+H2.toString2());
    						P1.ramasser(J.getTable());
    						H1.clearHand();
    						H2.clearHand();
    						Tj2.setIcon(vide);
    						Tj1.setIcon(vide);
    		 			}
    					if(C2.CompareTo(C1) > 0){
    						Detail.setText(Detail.getText()+"\nvous avez perdu "+H1.toString2());
    						P2.ramasser(J.getTable());
    						H1.clearHand();
    						H2.clearHand();
    						Tj2.setIcon(vide);
    						Tj1.setIcon(vide);
    					}
    					if(C1.CompareTo(C2) == 0){
    						Detail.setText(Detail.getText()+"\n Bataille!!");
    					}
    					P1.addHand();
                        P2.addHand();
    					Detail.setText(Detail.getText()+"\n vous   : "+P1.toString2());
    					Detail.setText(Detail.getText()+"\n L'ordi : "+P2.toString2());
    					Detail.setText(Detail.getText()+"\n++++++++++++++++++++++++++++++++++++++++++\n");
    					this.numetape = 1;
    					break;
    			case 4 :
    				if(P1.aperdu() && P2.aperdu()){
    					Jp2.setIcon(vide);
    					Jp1.setIcon(vide);
    					JOptionPane.showMessageDialog(null,"match null");
        				Detail.setText(Detail.getText()+"\n +++++++++++++match null!!++++++++++");
        			}
        			else if(P1.aperdu()){
        				Jp1.setIcon(vide);
        				JOptionPane.showMessageDialog(null,"Dommage!! vous avez perdu");
        				Detail.setText(Detail.getText()+"\n +++++++++++vous avez perdu++++++++++");
        			}
        			else if(P2.aperdu()){
        				Jp2.setIcon(vide);
        				JOptionPane.showMessageDialog(null,"Felicitation!! vous avez gagn�");
        				Detail.setText(Detail.getText()+"\n  ++++++++++vous avez gagn�++++++++");
        			}
        			if(d){
        				JOptionPane.showMessageDialog(null,"Partie infinie");
        				Detail.setText(Detail.getText()+"\n  ++++++++++ Partie infinie ++++++++");
        			}
        			this.EnregisterPartie();
        			Detail.setText(Detail.getText()+"    \n  +++++++++Fin de la partie+++++++");
        			this.setVisible(false);   
    				this.dispose();
    				Debut D = new Debut();
    				D.setVisible(true);	
    				break;			
    		}
    	}
    	
    	if(source == Csuivant){
    		if(!P1.aperdu() && !P2.aperdu() && !d && this.numetape != 4){
    			C1 = new Carte(J.play1());
        	    H1.insertCard(C1);
        	    C2 = new Carte(J.play2());
        		H2.insertCard(C2);
        		Tj1.setIcon(new ImageIcon(C1.getImg()));	
    		    this.Detail.setText(this.Detail.getText()+"\n vous avez pose :"+C1.toString());
    		    Tj2.setIcon(new ImageIcon(C2.getImg()));	
    		 	this.Detail.setText(this.Detail.getText()+"\n L'ordi  a pose :"+C2.toString());
                
    		 	if(C1.CompareTo(C2) > 0){
    				Detail.setText(Detail.getText()+"\n vous avez gagne "+H2.toString2());
    				P1.ramasser(J.getTable());
    				H1.clearHand();
    				H2.clearHand();
    		 	}
    			if(C2.CompareTo(C1) > 0){
    				Detail.setText(Detail.getText()+"\nvous avez perdu "+H1.toString2());
    				P2.ramasser(J.getTable());
    				H1.clearHand();
    				H2.clearHand();
    				
    			}
    			if(C1.CompareTo(C2) == 0){
    				Detail.setText(Detail.getText()+"\n Bataille!!");
    			}
    			P1.addHand();
                P2.addHand();
    			Detail.setText(Detail.getText()+"\n vous   : "+P1.toString2());
    			Detail.setText(Detail.getText()+"\n L'ordi : "+P2.toString2());
    			Detail.setText(Detail.getText()+"\n++++++++++++++++++++++++++++++++++++++++++\n");
    		}
    		else{
    			if(P1.aperdu() && P2.aperdu()){
    					Jp2.setIcon(vide);
    					Jp1.setIcon(vide);
    					JOptionPane.showMessageDialog(null,"match null");
        				Detail.setText(Detail.getText()+"\n +++++++++++++match null!!++++++++++");
        				this.EnregisterPartie();
        		}
        		else if(P1.aperdu()){
        				Jp1.setIcon(vide);
        				JOptionPane.showMessageDialog(null,"Dommage!! vous avez perdu");
        				Detail.setText(Detail.getText()+"\n +++++++++++vous avez perdu++++++++++");
        				this.EnregisterPartie();
        		}
        		else if(P2.aperdu()){
        				Jp2.setIcon(vide);
        				JOptionPane.showMessageDialog(null,"Felicitation!! vous avez gagn�");
        				Detail.setText(Detail.getText()+"\n  ++++++++++vous avez gagne++++++++");
        				this.EnregisterPartie();
        		}
        		if(d){
        				JOptionPane.showMessageDialog(null,"Partie infinie");
        				Detail.setText(Detail.getText()+"\n  ++++++++++ Partie infinie ++++++++");
        				this.EnregisterPartie();
        		}
        		if(this.numetape == 4){
        			JOptionPane.showMessageDialog(null,"Partie termin�e");
        		}
        		Detail.setText(Detail.getText()+"    \n  +++++++++Fin de la partie+++++++");
        		this.setVisible(false);   
    			this.dispose();
    			Debut D = new Debut();
    			D.setVisible(true);
    		}
    	}
    	if(source == T){
    		switch(this.numetape){
    			case 1 : //vous jouer
    				if(P1.aperdu()|| P2.aperdu()|| d){
    					this.numetape = 4;
    				}
    				else{
    				    
    				    C1 = new Carte(J.play1());			    
    				    H1.insertCard(C1);
    				    d = P1.findHand() && P2.findHand();
    				    Tj1.setIcon(new ImageIcon(C1.getImg()));	
    				    this.Detail.setText(this.Detail.getText()+"\n vous avez pose :"+C1.toString());
    				    this.numetape = 2;
    				}
    				break;
    			case 2 ://l'ordi joue
    				if(P2.aperdu() || d){
    					this.numetape = 4;
    				}
    				else{
    				    C2 = new Carte(J.play2());			    
    				    H2.insertCard(C2);
    				    d = P1.findHand() && P2.findHand();
    				    Tj2.setIcon(new ImageIcon(C2.getImg()));	
    				    this.Detail.setText(this.Detail.getText()+"\n l'ordinateur a pose :"+C2.toString());
    				    this.numetape = 3;
    				} 
    				break;
    			case 3 :
    					if(C1.CompareTo(C2) > 0){
    						Detail.setText(Detail.getText()+"\n vous avez gagne "+H2.toString2());
    						P1.ramasser(J.getTable());
    						H1.clearHand();
    						H2.clearHand();
    						Tj2.setIcon(vide);
    						Tj1.setIcon(vide);
    		 			}
    					if(C2.CompareTo(C1) > 0){
    						Detail.setText(Detail.getText()+"\nvous avez perdu "+H1.toString2());
    						P2.ramasser(J.getTable());
    						H1.clearHand();
    						H2.clearHand();
    						Tj2.setIcon(vide);
    						Tj1.setIcon(vide);
    					}
    					if(C1.CompareTo(C2) == 0){
    						Detail.setText(Detail.getText()+"\n Bataille!!");
    					}
    					P1.addHand();
                        P2.addHand();
    					Detail.setText(Detail.getText()+"\n vous   : "+P1.toString2());
    					Detail.setText(Detail.getText()+"\n L'ordi : "+P2.toString2());
    					Detail.setText(Detail.getText()+"\n++++++++++++++++++++++++++++++++++++++++++\n");
    					this.numetape = 1;
    					break;
    			case 4 :
    				if(P1.aperdu() && P2.aperdu()){
    					Jp2.setIcon(vide);
    					Jp1.setIcon(vide);
    					JOptionPane.showMessageDialog(null,"match null");
        				Detail.setText(Detail.getText()+"\n +++++++++++++match null!!++++++++++");
        			}
        			else if(P1.aperdu()){
        				Jp1.setIcon(vide);
        				JOptionPane.showMessageDialog(null,"Dommage!! vous avez perdu");
        				Detail.setText(Detail.getText()+"\n +++++++++++vous avez perdu++++++++++");
        			}
        			else if(P2.aperdu()){
        				Jp2.setIcon(vide);
        				JOptionPane.showMessageDialog(null,"Felicitation!! vous avez gang�");
        				Detail.setText(Detail.getText()+"\n  ++++++++++vous avez gagn�++++++++");
        			}
        			if(d){
        				JOptionPane.showMessageDialog(null,"Partie infinie");
        				Detail.setText(Detail.getText()+"\n  ++++++++++ Partie infinie ++++++++");
        			}
        			Detail.setText(Detail.getText()+"    \n  +++++++++Fin de la partie+++++++");
        			this.EnregisterPartie();
        			this.setVisible(false);   
    				this.dispose();
    				T.stop();
    				Debut D = new Debut();
    				D.setVisible(true);	
    				break;			
    		}
    		
    	  }
    	  if(source == this.ChFichier){
    	  	    
    	  	    String S = JOptionPane.showInputDialog(null,"Entrez votre partie sous forme 11112222....(au min 20 chiffre 1-5)");
    	  	    String St = this.LirePartie(S);
    	  	    if(St != null){
    			   this.numetape = 4; 
    			   if(T != null) T.stop();
    			   Psuivante.setEnabled(false);
    			   Csuivant.setEnabled(false);
    			   Detail.setText("");
    			   Detail.setText(St);
    	  	    }
    	  	    else{
    	  	       JOptionPane.showMessageDialog(null,"cette partie n'exite pas.");	
    	  	    }  
    	  }
    	
    }
     
    /**
     * enregistre une partie dans un fichier. 
     */
    public void EnregisterPartie(){
    	try{
    		File f = new File("save/"+J.getFichier());
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Detail.getText());
            bw.close();
            fw.close();
    	}catch(IOException e){
	
    	}
    }
    /**
     * lire une partie.
     * S est une chaine quelconque.
     * renvois null si save/S.bjc n'existe pas.
     */
    public String LirePartie(String S){
    	    String S1 = new String();
    	    try{
    		File f = new File("save/"+S+".bjc");
    		if(f.exists()){
            	FileReader fr = new FileReader(f);
            	BufferedReader br = new BufferedReader(fr);
            	  String St = new String("");
            	  while(St != null){
            	  	S1 = S1 + St +"\n";
            	  	St = br.readLine();
            	  }
            	br.close();
            	fr.close();	
    		}
    		else{
             	S1 = null;
            }	
    	}catch(IOException e){
    		System.out.println(e.toString());
    		S1 = null;
    	}
    	return S1;
    } 
    public static void main(String arg[]){	
    	
    }
}