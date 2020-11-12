package controle;



import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import javafx.event.ActionEvent;
import modèle.Accumulateur;
import modèle.IAccumulateur;
import vue.GUI;


public class Controleur  {
	
	
	IAccumulateur accumulateur = new Accumulateur();   		 // Instanciation de la classe accumulateur
	
	private String nombreChoisi="" ;               		    // Chiffre séléctionné et retourner dans les méthodes handleNuméro
	String[] affichage = {"","",""};						// liste des trois derniers chiffres accumulés
	List<String> stockageTemporaire = new ArrayList<>();	/* Lorsque affichage est pleine et que l'on accumule un nouveau chiffre
															   alors le premier élément accumulé dans affichage se retrouve dans cette liste*/
	public Controleur() {}
	
	
// Création des méthodes handle liées aux actions sur les boutons *********************************************************************************************************************************************************
	
	public void handleZero(ActionEvent event) {
		nombreChoisi+="0";                       
		GUI.setEcranAffichage(nombreChoisi);        // affiche sur l'écran la valeur liée à la méthode
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
	
	/* On place la valeur accumulée dans les trois affichage possible 
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
	
	/* On actualise le placement après chaque accumulation ou opération.Lorsqu'un emplacement d'affichage
	 se libère, si une valeur est cachée dans stockageTemporaire alors actualise le placement*/
	
	public void actualiserPlacementAffichage (String string) {
		if (affichage[2]!="") {
			if (! stockageTemporaire.isEmpty()) {                 //valeur cachée: on décale l'affiche
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
	
	
//Les méthodes pour les opérations********************************************************************************
	
	
	public void handleAddition(ActionEvent event) {
		if (accumulateur.taille()>=2) {	
			accumulateur.add();
			Double a = accumulateur.peek();
			String string = String.valueOf(a);      // On a des listes de String donc on transforme le double récuperé dans la pile
			actualiserPlacementAffichage(string);							
			GUI.nouvelleVue(affichage);
			GUI.setEcranAffichage(""); 
		}		
		else {															
			GUI.setEcranAffichage("Accumuler au moins deux chiffres");
			nombreChoisi="";  //Permet d'effacer la valeur qui était affichée avant le message "Accumuler au moins deux chiffres"
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
			if (affichage[2]!="")      affichage[2]=string;    // On change le signe de la dernière valeur accumulée
			else if (affichage[1]!="") affichage[1]=string;
			else if (affichage[0]!="") affichage[0]=string;
			GUI.nouvelleVue(affichage);
			GUI.setEcranAffichage("");
			
		}catch (EmptyStackException e) {                       // On catch le fait qu'il n'y est aucune valeur accumulée 
			GUI.setEcranAffichage("Aucun chiffre accumulé") ;
			nombreChoisi="";
		}
		
	}
	
	
	
	public void handleDivision(ActionEvent event) {
		if (accumulateur.taille() >=2) {	
				Double a = accumulateur.peek();          /* On récupère la dernière valeur de la pile 
														correspondant au dénominteur pour vérifier l'erreur de division par zéro*/
				if (a!=0) {
					accumulateur.div();			
					Double c = accumulateur.peek();
					String string2 = String.valueOf(c);
					actualiserPlacementAffichage( string2);			
					GUI.nouvelleVue(affichage);
					GUI.setEcranAffichage("");
				}
				else {
					GUI.setEcranAffichage("Division par zéro impossible");
				}
		}		
		else {
			GUI.setEcranAffichage("Accumuler au moins deux chiffres");
			nombreChoisi="";
		}				
	}
	
	
	
	public void handleEffacer(ActionEvent event) {
		try {
			if (GUI.getEcranAffichage().length() > 0 && !GUI.getEcranAffichage().contains("e")) { 												//S'il y a des éléments dans l'écran d'affichage alors on backspace le dernier caractère
				nombreChoisi=GUI.getEcranAffichage().substring(0, GUI.getEcranAffichage().length() - 1);
				GUI.setEcranAffichage(nombreChoisi);
			}
			else {                                                //Dans ce cas, on supprime le dernier élément accumulé
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
			
		}catch (ArrayIndexOutOfBoundsException e) {						//Aucune valeur dans l'écran d'affiche et dans les 3 stockages de valeurs accumulées 
			GUI.setEcranAffichage("");
		}
	}
	
	
	
	public void handleReset(ActionEvent event) {    //On efface tout à l'aide de clear puis on acualise l'affichage
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
			GUI.setEcranAffichage(nombreChoisi);   		//On le supprime de l'écran d'affichage
			
		}catch (NumberFormatException e) {
			GUI.setEcranAffichage("Veuillez sélectionner un chiffre");	
		}	
	}
	
	public void handleVirgule(ActionEvent event) {
		nombreChoisi+=".";
		GUI.setEcranAffichage(nombreChoisi);			
	}
}
	


