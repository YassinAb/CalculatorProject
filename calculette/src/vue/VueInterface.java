package vue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



import controle.Controleur;


public class VueInterface extends Application  {
	
	
	// test 
	

	private Controleur controleur = new Controleur();

	Button toucheDeux = new Button("2");
	Button toucheZero = new Button("0");
	
	
	
	Button toucheAddition = new Button("+");
	
	public VueInterface(){
		//toucheDeux.setMinSize(40, 40);
		//toucheDeux.setOnAction(controleur::handle2);
		
		

		toucheZero.setMinSize(40, 40);
		toucheZero.setOnAction(controleur::handleZero);

		
		toucheAddition.setMinSize(40, 40);
		toucheAddition.setOnAction(controleur::handleAddition);

	}	
	
	 static Label ecranAffichage = new Label("");
	 static Label pileDeux = new Label("pile[1]");
	 static Label pileTrois = new Label("pile[2]");

		
	
	//création affichage de la pile
	


	
	private static String texteDansAffichage;
	
	public static  void setTexteDansAffichage(String  _texteDansAffichage) {
		
		texteDansAffichage = _texteDansAffichage;
	}

	 
	
	public void start(Stage primaryStage) throws Exception {
			
		primaryStage.setTitle("calculatrice Polonaise");
		
		
		

		
		
		// Architecture de la calculatrice
		
		VBox root = new VBox();
		root.setPadding(new Insets(150)); // espace entre les VBox
		root.setAlignment(Pos.CENTER_RIGHT);
		


		
		
		// création du clavier
		
		GridPane plageNombres = new GridPane();	
		
		//affichage 

		 
		 
		
		
		
		
		// création de tous les bouttons
		
		
		
		
		Button toucheUn = new Button("1");
		toucheUn.setMinSize(40, 40);
		toucheUn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				
				ecranAffichage.setText(texteDansAffichage);
			}
		});
				
		
		//toucheDeux.setMinSize(40, 40);
		

				
		
		/*toucheDeux.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				ecranAffichage.setText(Controleur.toucheDeux());
			}
			
		}); */
		
		Button toucheTrois = new Button("3");
		toucheTrois.setMinSize(40, 40);
		
		
		Button toucheQuatre = new Button("4");
		toucheQuatre.setMinSize(40, 40);
		toucheQuatre.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				texteDansAffichage +=4 ;
				ecranAffichage.setText(texteDansAffichage);
						
			}
		});	
		
		Button toucheCinq = new Button("5");
		toucheCinq.setMinSize(40, 40);
		toucheCinq.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				setTexteDansAffichage("5");
				ecranAffichage.setText(texteDansAffichage);
						
			}
		});		
		
		Button toucheSix = new Button("6");
		toucheSix.setMinSize(40, 40);
		toucheSix.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				setTexteDansAffichage("6");
				ecranAffichage.setText(texteDansAffichage);			
			}
		});
		Button toucheSept = new Button("7");
		toucheSept.setMinSize(40, 40);
		toucheSept.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				setTexteDansAffichage("7");
				ecranAffichage.setText(texteDansAffichage);		
			}
		});


		Button toucheHuit = new Button("8");
		toucheHuit.setMinSize(40, 40);
		toucheHuit.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				setTexteDansAffichage("8");
				ecranAffichage.setText(texteDansAffichage);	
			}
		});
		
		Button toucheNeuf = new Button("9");
		toucheNeuf.setMinSize(40, 40);
		toucheNeuf.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				setTexteDansAffichage("9");
				ecranAffichage.setText(texteDansAffichage);			
			}
		});
				

		
		Button toucheSoustraction = new Button("-");
		toucheSoustraction.setMinSize(40, 40);
		toucheSoustraction.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("Vous avez additionné");	
			}
		});		
		
		Button toucheMultiplication = new Button("x");
		toucheMultiplication.setMinSize(40, 40);
		toucheMultiplication.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("Vous avez additionné");			
			}
		});
		
		Button toucheDivision = new Button("/");
		toucheDivision.setMinSize(40, 40);
		toucheDivision.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("Vous avez additionné");	
			}
		});		
		
		Button toucheEffacer = new Button("C");
		toucheEffacer.setMinSize(40, 40);
		toucheEffacer.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("Vous avez additionné");	
			}
		});
		
		Button toucheVirgule = new Button(",");
		toucheVirgule.setMinSize(40, 40);
		toucheVirgule.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("Vous avez additionné");	
			}
		});

		
		//espacement des touches

		plageNombres.setPadding(new Insets(10,10,10,10));
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
		plageNombres.add(toucheTrois,3 , 2, 1, 1);                     //(element, placementButton, place occupée)
		plageNombres.add(toucheVirgule, 1, 3, 1, 1);
		plageNombres.add(toucheZero,2, 3, 1, 1);
		plageNombres.add(toucheEffacer, 3, 3, 1, 1);
		plageNombres.add(toucheAddition,4,0,1,1);
		plageNombres.add(toucheSoustraction,4,1,1,1);
		plageNombres.add(toucheMultiplication,4,2,1,1);
		plageNombres.add(toucheDivision,4,3,1,1);
		

		// affichage de la fenêtre; avec création d'une scène et choix de ses dimentions
		
		root.getChildren().addAll(ecranAffichage,pileDeux, pileTrois, plageNombres);

		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}