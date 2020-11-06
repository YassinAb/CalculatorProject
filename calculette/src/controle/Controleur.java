package controle;


import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import calculatrice.Accumulateur;
import javafx.event.ActionEvent;
import vue.VueInterface;

public class Controleur  {
	
	Accumulateur accumulateur = new Accumulateur();
	
	

	
	
	private String nombreChoisi="" ;
	
	String[] affichage = {"","",""};
	List<String> stockageTemporaire = new ArrayList<>();
	
	public void placerAffichage(String nombreChoisi) {
		
		if (affichage[2]=="") {
			
			affichage[2]= nombreChoisi;
	
		}
	
		else if (affichage[1]=="") {
			
			affichage[1]= nombreChoisi;
			
		}
			                                                  //maybe after we can put the ifs
		else if (affichage[0]=="") {
			
			affichage[0]= nombreChoisi;
	
		}
		
		else if (affichage[0]!="" && affichage[1]!="" && affichage[2]!="") {
			stockageTemporaire.add(affichage[2]);
			affichage[2]= affichage[1];
			affichage[1]= affichage[0];
			affichage[0]= nombreChoisi;
		}
	}
	
	
	public void handleZero(ActionEvent event) {
		nombreChoisi += "0";
		//accumulateur.push(0.0);
		VueInterface.setEcranAffichage(nombreChoisi);
		
	}
	

	public void handleUn(ActionEvent event) {
		nombreChoisi+="1";
		//accumulateur.push(1.0);
		VueInterface.setEcranAffichage(nombreChoisi);
		
	}
	
	public void handleDeux(ActionEvent event) {
		
		nombreChoisi+="2";
		//accumulateur.push(2.0);
		VueInterface.setEcranAffichage(nombreChoisi);

	}
	
	public void handleTrois(ActionEvent event) {
		nombreChoisi+="3";
		//accumulateur.push(3.0);
		//VueInterface.rafraichirVue(nombreChoisi);
		VueInterface.setEcranAffichage(nombreChoisi);
		
	}
	
	public void handleQuatre(ActionEvent event) {
		nombreChoisi+="4";
		//accumulateur.push(4.0);
		VueInterface.setEcranAffichage(nombreChoisi);
		//VueInterface.rafraicheVue(nombreChoisi)
		
	}
	
	public void handleCinq(ActionEvent event) {
		nombreChoisi+=5;
		//accumulateur.push(5.0);
		VueInterface.setEcranAffichage(nombreChoisi);
		
	}
	
	public void handleSix(ActionEvent event) {
		nombreChoisi+="6";
		//accumulateur.push(6.0);
		VueInterface.setEcranAffichage(nombreChoisi);
		
	}
	
	public void handleSept(ActionEvent event) {
		nombreChoisi+="7";
		//accumulateur.push(7.0);
		VueInterface.setEcranAffichage(nombreChoisi);
		
	}
	
	public void handleHuit(ActionEvent event) {
		nombreChoisi+="8";
		//accumulateur.push(8.0);
		VueInterface.setEcranAffichage(nombreChoisi);
		
	}
	
	public void handleNeuf(ActionEvent event) {
		nombreChoisi+=9;
		//accumulateur.push(9.0);
		VueInterface.setEcranAffichage(nombreChoisi);
		
	}
	
	
	
	
	public void actualiserPlacementAffichage (String string) {
		if (affichage[0]!="") {
			if (! stockageTemporaire.isEmpty()) {
				
				int taille= stockageTemporaire.size();
				affichage[0]=string;
				affichage[1]= affichage[2];
				affichage[2]=stockageTemporaire.get(taille-1);
				stockageTemporaire.remove(taille-1);
				
			}
			
			else {
				affichage[1]=string;
				affichage[0]="";
			}
		

		}
		else if (affichage[1]!="") {
			affichage[1]="";
			affichage[2]=string;
			

		}
	}
	
	
	
	
	public void handleAddition(ActionEvent event) {
		try {
			accumulateur.add();
		double a = accumulateur.peek();
		String string = String.valueOf(a);
		//placerAffichage(string);
		
		actualiserPlacementAffichage( string);
		
		VueInterface.refreshView(affichage);
		VueInterface.setEcranAffichage(string);

		
		}
		
		catch (EmptyStackException e) {
			VueInterface.setEcranAffichage("Veuillez inserer un chiffre");
			
		}
		
	}
	
	
	//à modifier...
	
	public void handleSoustraction(ActionEvent event) {
		
		try {
			accumulateur.sub();
			double a = accumulateur.peek();
			String string = String.valueOf(a);
			actualiserPlacementAffichage( string);			
			VueInterface.refreshView(affichage);			
			VueInterface.setEcranAffichage(string);
			
			
			}
		
		catch (EmptyStackException e) {
			
			VueInterface.setEcranAffichage("Veuillez inserer un chiffre");
		}
	}
	
	public void handleMultiplication(ActionEvent event) {
		
		try {
			accumulateur.mult();
			double a = accumulateur.peek();
			String string = String.valueOf(a);
			actualiserPlacementAffichage( string);			
			VueInterface.refreshView(affichage);
			VueInterface.setEcranAffichage(string);}
		
		catch (EmptyStackException e) {
			
			VueInterface.setEcranAffichage("Veuillez inserer un chiffre");
		}
	}
	
	
	public void handleNeg(ActionEvent event) {
		try{
			accumulateur.neg();
		
		double a = accumulateur.peek();
		String string = String.valueOf(a);
		if (affichage[0]!="")      affichage[0]=string;
		else if (affichage[1]!="") affichage[1]=string;
		else if (affichage[2]!="") affichage[2]=string;
		VueInterface.refreshView(affichage);
		VueInterface.setEcranAffichage(string);
		}
		catch (EmptyStackException e) {
			VueInterface.setEcranAffichage("Aucun chiffre inseré") ;
		}
		
	}
	
	
	
	public void handleDivision(ActionEvent event) {
		
		try {
			
			
			try{
				accumulateur.div();
			
			double a = accumulateur.peek();
			String string = String.valueOf(a);
			actualiserPlacementAffichage( string);			
			VueInterface.refreshView(affichage);
			VueInterface.setEcranAffichage(string);}
			catch (ArithmeticException e) {
				System.out.println("Division par 0 impossible");
			}
			}
		
		catch (EmptyStackException e) {
			
			VueInterface.setEcranAffichage("Veuillez inserer un chiffre");
		}
		
		
		//...
	}
	
	public void handleEffacer(ActionEvent event) {
		try {
			accumulateur.backspace();
			if (affichage[0]!="") {
				if (! stockageTemporaire.isEmpty()) {
					int taille= stockageTemporaire.size();
					affichage[0]= affichage[1];
					affichage[1]= affichage[2];
					affichage[2]= stockageTemporaire.get(taille-1);
					stockageTemporaire.remove(taille-1);
				
				}
				else affichage[0]="";

			}
			else if (affichage[1]!="") affichage[1]="";
			else if (affichage[2]!="") affichage[2]="";
			VueInterface.refreshView(affichage);
			VueInterface.setEcranAffichage("");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			VueInterface.setEcranAffichage("Veuillez inserer un chiffre");
		}
	}
	
	public void handleReset(ActionEvent event) {
		accumulateur.reset();
		affichage[0]="";
		affichage[1]="";
		affichage[2]="";
		nombreChoisi="";
		stockageTemporaire.clear();
		VueInterface.refreshView(affichage);
		VueInterface.setEcranAffichage(nombreChoisi);
		
	}
	
	public void handleAccumuler(ActionEvent event) {
		
		try {
			accumulateur.accumuler(nombreChoisi);                                                                                               
			placerAffichage(nombreChoisi);                                                                        
			VueInterface.refreshView(affichage);
			nombreChoisi="";
			
		}
		catch (NumberFormatException e) {
			VueInterface.setEcranAffichage("veuillez sélectionner un chiffre");
			
		}
		
		
	}
	
	public void handleVirgule(ActionEvent event) {
		nombreChoisi+=".";
		VueInterface.setEcranAffichage(nombreChoisi);
				
	}


}
	


