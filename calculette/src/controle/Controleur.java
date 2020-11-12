package controle;



import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import javafx.event.ActionEvent;
import mod�le.Accumulateur;
import mod�le.IAccumulateur;
import vue.GUI;


public class Controleur  {
	
	
	IAccumulateur accumulateur = new Accumulateur();   		 // Instanciation de la classe accumulateur
	
	private String nombreChoisi="" ;               		    // Chiffre s�l�ctionn� et retourner dans les m�thodes handleNum�ro
	String[] affichage = {"","",""};						// liste des trois derniers chiffres accumul�s
	List<String> stockageTemporaire = new ArrayList<>();	/* Lorsque affichage est pleine et que l'on accumule un nouveau chiffre
															   alors le premier �l�ment accumul� dans affichage se retrouve dans cette liste*/
	public Controleur() {}
	
	
// Cr�ation des m�thodes handle li�es aux actions sur les boutons *********************************************************************************************************************************************************
	
	public void handleZero(ActionEvent event) {
		nombreChoisi+="0";                       
		GUI.setEcranAffichage(nombreChoisi);        // affiche sur l'�cran la valeur li�e � la m�thode
	}
	

	public void handleUn(ActionEvent event) {
		nombreChoisi+="1";
		GUI.setEcranAffichage(nombreChoisi);
	}
	
	
	public void handleDeux(ActionEvent event) {
		nombreChoisi+="2";
		GUI.setEcranAffichage(nombreChoisi);
	}
	
	
	public void handleTrois(ActionEvent event) {
		nombreChoisi+="3";
		GUI.setEcranAffichage(nombreChoisi);	
	}
	
	
	public void handleQuatre(ActionEvent event) {
		nombreChoisi+="4";
		GUI.setEcranAffichage(nombreChoisi);
	}
	
	
	public void handleCinq(ActionEvent event) {
		nombreChoisi+="5";
		GUI.setEcranAffichage(nombreChoisi);
	}
	
	
	public void handleSix(ActionEvent event) {
		nombreChoisi+="6";
		GUI.setEcranAffichage(nombreChoisi);
	}
	
	
	public void handleSept(ActionEvent event) {
		nombreChoisi+="7";
		GUI.setEcranAffichage(nombreChoisi);
	}
	
	
	public void handleHuit(ActionEvent event) {
		nombreChoisi+="8";
		GUI.setEcranAffichage(nombreChoisi);
	}
	
	
	public void handleNeuf(ActionEvent event) {
		nombreChoisi+="9";
		GUI.setEcranAffichage(nombreChoisi);	
	}
	
	/* On place la valeur accumul�e dans les trois affichage possible 
	   en fonction de l'emplacement disponible */
	
	public void placerAffichage(String nombreChoisi) {
		
		if (affichage[0]=="") {	
			affichage[0]= nombreChoisi;
		}
	
		else if (affichage[1]=="") {
			affichage[1]= nombreChoisi;
		}
			                                                  
		else if (affichage[2]=="") {
			affichage[2]= nombreChoisi;
		}
		
		/* On stocke les elements de la pile dans une ArrayList 
		   temporaire lorsque l'on accumule un nombre mais qu'il n'y a plus de place*/
		
		else if (affichage[2]!="" && affichage[1]!="" && affichage[0]!="") {
			stockageTemporaire.add(affichage[0]);
			affichage[0]= affichage[1];
			affichage[1]= affichage[2];
			affichage[2]= nombreChoisi;
		}
	}
	
	/* On actualise le placement apr�s chaque accumulation ou op�ration.Lorsqu'un emplacement d'affichage
	 se lib�re, si une valeur est cach�e dans stockageTemporaire alors actualise le placement*/
	
	public void actualiserPlacementAffichage (String string) {
		if (affichage[2]!="") {
			if (! stockageTemporaire.isEmpty()) {                 //valeur cach�e: on d�cale l'affiche
				int taille= stockageTemporaire.size();
				affichage[2]=string;
				affichage[1]= affichage[0];
				affichage[0]=stockageTemporaire.get(taille-1);
				stockageTemporaire.remove(taille-1);	
			}
			
			else {
				affichage[1]=string;
				affichage[2]="";
			}
		}
		
		else if (affichage[1]!="") {
			affichage[1]="";
			affichage[0]=string;
		}
	}
	
	
//Les m�thodes pour les op�rations********************************************************************************
	
	
	public void handleAddition(ActionEvent event) {
		if (accumulateur.taille()>=2) {	
			accumulateur.add();
			Double a = accumulateur.peek();
			String string = String.valueOf(a);      // On a des listes de String donc on transforme le double r�cuper� dans la pile
			actualiserPlacementAffichage(string);							
			GUI.nouvelleVue(affichage);
			GUI.setEcranAffichage(""); 
		}		
		else {															
			GUI.setEcranAffichage("Accumuler au moins deux chiffres");
			nombreChoisi="";  //Permet d'effacer la valeur qui �tait affich�e avant le message "Accumuler au moins deux chiffres"
		}
	}
	
	

	
	public void handleSoustraction(ActionEvent event) {
		if(accumulateur.taille()>=2) {	
			accumulateur.sub();
			Double a = accumulateur.peek();
			String string = String.valueOf(a);
			actualiserPlacementAffichage( string);			
			GUI.nouvelleVue(affichage);			
			GUI.setEcranAffichage("");
		}		
		else {
			GUI.setEcranAffichage("Accumuler au moins deux chiffres");
			nombreChoisi="";
		}
		
	}
	
	public void handleMultiplication(ActionEvent event) {
		if(accumulateur.taille()>=2) {	
			accumulateur.mult();
			Double a = accumulateur.peek();
			String string = String.valueOf(a);
			actualiserPlacementAffichage( string);			
			GUI.nouvelleVue(affichage);
			GUI.setEcranAffichage("");
		}		
		else {
			GUI.setEcranAffichage("Accumuler au moins deux chiffres");
			nombreChoisi="";
		}
		
	}
	
	
	public void handleNeg(ActionEvent event) {
		try{
			accumulateur.neg();		
			Double a = accumulateur.peek();
			String string = String.valueOf(a);
			if (affichage[2]!="")      affichage[2]=string;    // On change le signe de la derni�re valeur accumul�e
			else if (affichage[1]!="") affichage[1]=string;
			else if (affichage[0]!="") affichage[0]=string;
			GUI.nouvelleVue(affichage);
			GUI.setEcranAffichage("");
			
		}catch (EmptyStackException e) {                       // On catch le fait qu'il n'y est aucune valeur accumul�e 
			GUI.setEcranAffichage("Aucun chiffre accumul�") ;
			nombreChoisi="";
		}
		
	}
	
	
	
	public void handleDivision(ActionEvent event) {
		if (accumulateur.taille() >=2) {	
				Double a = accumulateur.peek();          /* On r�cup�re la derni�re valeur de la pile 
														correspondant au d�nominteur pour v�rifier l'erreur de division par z�ro*/
				if (a!=0) {
					accumulateur.div();			
					Double c = accumulateur.peek();
					String string2 = String.valueOf(c);
					actualiserPlacementAffichage( string2);			
					GUI.nouvelleVue(affichage);
					GUI.setEcranAffichage("");
				}
				else {
					GUI.setEcranAffichage("Division par z�ro impossible");
				}
		}		
		else {
			GUI.setEcranAffichage("Accumuler au moins deux chiffres");
			nombreChoisi="";
		}				
	}
	
	
	
	public void handleEffacer(ActionEvent event) {
		try {
			if (GUI.getEcranAffichage().length() > 0 && !GUI.getEcranAffichage().contains("e")) { 												//S'il y a des �l�ments dans l'�cran d'affichage alors on backspace le dernier caract�re
				nombreChoisi=GUI.getEcranAffichage().substring(0, GUI.getEcranAffichage().length() - 1);
				GUI.setEcranAffichage(nombreChoisi);
			}
			else {                                                //Dans ce cas, on supprime le dernier �l�ment accumul�
				accumulateur.backspace();
				if (affichage[2]!="") {
					if (! stockageTemporaire.isEmpty()) {
						int taille= stockageTemporaire.size();
						affichage[2]= affichage[1];
						affichage[1]= affichage[0];
						affichage[0]= stockageTemporaire.get(taille-1);
						stockageTemporaire.remove(taille-1);
					}
					else affichage[2]="";
				}
				else if (affichage[1]!="") affichage[1]="";
				else if (affichage[0]!="") affichage[0]="";
				GUI.nouvelleVue(affichage);
				GUI.setEcranAffichage("");
			}
			
		}catch (ArrayIndexOutOfBoundsException e) {						//Aucune valeur dans l'�cran d'affiche et dans les 3 stockages de valeurs accumul�es 
			GUI.setEcranAffichage("");
		}
	}
	
	
	
	public void handleReset(ActionEvent event) {    //On efface tout � l'aide de clear puis on acualise l'affichage
		accumulateur.reset();
		affichage[0]="";
		affichage[1]="";
		affichage[2]="";
		nombreChoisi="";
		stockageTemporaire.clear();
		GUI.nouvelleVue(affichage);
		GUI.setEcranAffichage(nombreChoisi);
		
	}
	
	public void handleAccumuler(ActionEvent event) {
		
		try {                                                 
			accumulateur.accumuler(nombreChoisi);                                                                                               
			placerAffichage(nombreChoisi);              //On place le double dans le stock d'affichage                                                           
			GUI.nouvelleVue(affichage);
			nombreChoisi="";                            
			GUI.setEcranAffichage(nombreChoisi);   		//On le supprime de l'�cran d'affichage
			
		}catch (NumberFormatException e) {
			GUI.setEcranAffichage("Veuillez s�lectionner un chiffre");	
		}	
	}
	
	public void handleVirgule(ActionEvent event) {
		nombreChoisi+=".";
		GUI.setEcranAffichage(nombreChoisi);			
	}
}
	


