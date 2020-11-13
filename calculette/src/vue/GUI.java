package vue;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;



import controle.Controleur;


public class GUI extends Application {
	
	Controleur controleur = new Controleur();
	
	// création de tous les boutons
	
	Button toucheZero = new Button("0");
	Button toucheUn = new Button("1");
	Button toucheDeux = new Button("2");
	Button toucheTrois = new Button("3");
	Button toucheQuatre = new Button("4");
	Button toucheCinq = new Button("5");
	Button toucheSix = new Button("6");
	Button toucheSept = new Button("7");
	Button toucheHuit = new Button("8");
	Button toucheNeuf = new Button("9");
	
	Button toucheSoustraction = new Button("-");
	Button toucheMultiplication = new Button("*");
	Button toucheDivision = new Button("/");
	Button toucheAccumuler = new Button("<>");
	Button toucheVirgule = new Button(".");
	Button toucheReset = new Button("AC");	
	Button toucheAddition = new Button("+");
	Button toucheEffacer = new Button("C");
	Button toucheNeg = new Button("+/-");
	
	
	public GUI(){
		toucheDeux.setMinSize(40, 40);
		toucheDeux.setOnAction(controleur::handleDeux);
		
		
		toucheUn.setMinSize(40, 40);
		toucheUn.setOnAction(controleur::handleUn);
		
		toucheZero.setMinSize(40, 40);
		toucheZero.setOnAction(controleur::handleZero);
		
		toucheTrois.setMinSize(40, 40);
		toucheTrois.setOnAction(controleur::handleTrois);
		
		toucheQuatre.setMinSize(40, 40);
		toucheQuatre.setOnAction(controleur::handleQuatre);
		
		toucheCinq.setMinSize(40, 40);
		toucheCinq.setOnAction(controleur::handleCinq);
		
		toucheSix.setMinSize(40, 40);
		toucheSix.setOnAction(controleur::handleSix);
		
		
		toucheSept.setMinSize(40, 40);
		toucheSept.setOnAction(controleur::handleSept);
		
		
		toucheHuit.setMinSize(40, 40);
		toucheHuit.setOnAction(controleur::handleHuit);
		
		toucheNeuf.setMinSize(40, 40);
		toucheNeuf.setOnAction(controleur::handleNeuf);
		
		toucheSoustraction.setMinSize(40, 40);
		toucheSoustraction.setOnAction(controleur::handleSoustraction);
		
		toucheDivision.setMinSize(40, 40);
		toucheDivision.setOnAction(controleur::handleDivision);
		
		toucheMultiplication.setMinSize(40, 40);
		toucheMultiplication.setOnAction(controleur::handleMultiplication);
		
		toucheAddition.setMinSize(40, 40);
		toucheAddition.setOnAction(controleur::handleAddition);

		toucheVirgule.setMinSize(40, 40);
		toucheVirgule.setOnAction(controleur::handleVirgule);
		
		toucheEffacer.setMinSize(40, 40);
		toucheEffacer.setOnAction(controleur::handleEffacer);
		
		toucheAccumuler.setMinSize(40, 40);
		toucheAccumuler.setOnAction(controleur::handleAccumuler);
		
		toucheReset.setMinSize(40, 40);
		toucheReset.setOnAction(controleur::handleReset);
		
		toucheNeg.setMinSize(40, 40);
		toucheNeg.setOnAction(controleur::handleNeg);
		
		
		
	}	
	
	//création affichage de la pile
	
	
	static Label pileUn = new Label("");
	static Label pileDeux = new Label("");
	static Label pileTrois = new Label("");
	static Label ecranAffichage = new Label("");
	Line line0 = new Line(300,150,500,150);
	Line line1 = new Line(300,150,500,150);
	Line line2 = new Line(300,150,500,150);



	
	public static String getEcranAffichage() {
		return ecranAffichage.getText();
	}

	public static void setEcranAffichage(String nombreChoisi) {   
		ecranAffichage.setText(nombreChoisi);                                      
	}
	

	
	
	public static void nouvelleVue(String[] affichage) {
		
			
			pileUn.setText(affichage[2]);	
		
			pileDeux.setText(affichage[1]);
			                                                  
			pileTrois.setText(affichage[0]);
	

	}

	


	public void start(Stage primaryStage) throws Exception {
			
		primaryStage.setTitle("calculatrice Polonaise");
		
		
		
		// Architecture de la calculatrice
		
		VBox root = new VBox();
		root.setPadding(new Insets(40,10,10,10)); // espace entre les VBox
		root.setAlignment(Pos.CENTER);
		
		// création du clavier
		
		GridPane plageNombres = new GridPane();	 

		//espacement des touches

		plageNombres.setPadding(new Insets(10,10,10,10));
		plageNombres.setAlignment(Pos.CENTER);
		plageNombres.setHgap(10);
		plageNombres.setVgap(10);
		
		//PLacer les boutons dans le clavier
		
		plageNombres.add(toucheSept, 1, 0,1,1);
		plageNombres.add(toucheNeuf, 3, 0,1,1);
		plageNombres.add(toucheHuit, 2,0 ,1,1);
		plageNombres.add(toucheQuatre, 1, 1, 1, 1);
		plageNombres.add(toucheCinq, 2, 1, 1, 1);
		plageNombres.add(toucheSix, 3, 1, 1, 1);
		plageNombres.add(toucheUn,1 , 2, 1, 1); 
		plageNombres.add(toucheDeux,2 , 2, 1, 1);
		plageNombres.add(toucheTrois,3 , 2, 1, 1);                  
		plageNombres.add(toucheVirgule, 1, 3, 1, 1);
		plageNombres.add(toucheZero,2, 3, 1, 1);
		plageNombres.add(toucheEffacer, 3, 3, 1, 1);
		plageNombres.add(toucheAddition,4,0,1,1);
		plageNombres.add(toucheSoustraction,4,1,1,1);
		plageNombres.add(toucheMultiplication,4,2,1,1);
		plageNombres.add(toucheDivision,4,3,1,1); 
		plageNombres.add(toucheAccumuler, 4,4,1,1);
		plageNombres.add(toucheReset, 3,4,1,1 );
		plageNombres.add(toucheNeg, 2, 4,1,1);
		
		// affichage de la fenêtre; avec création d'une scène et choix de ses dimentions
		
		root.getChildren().addAll(pileUn,line1,pileDeux,line2, pileTrois,line0,ecranAffichage, plageNombres);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}








}