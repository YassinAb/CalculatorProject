package vue;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class VueInterface extends Application {
	
	private String texteDansAffichage ; //peut etre on va le transformer en public
	
	public void start(Stage primaryStage) throws Exception {
		
		
		
		
		primaryStage.setTitle("calculatrice Polonaise");
		
		
		// dispositif pour la calculatrice Flowpane
		
		
		
		FlowPane root = new FlowPane();
		root.setPadding(new Insets(50));   // espace entre les flowpane
		
		
		
		//cr�action de l'�cran
		
		Label  ecranAffichage = new Label("ecran d'affichage");
		
		
		
		
		// cr�ation de tous les bouttons
		
		Button toucheEgal = new Button("=");
		toucheEgal.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
			}
		});
		
		
		Button toucheUn = new Button("1");
		toucheUn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				texteDansAffichage += "1";
				ecranAffichage.setText(texteDansAffichage);
				
				// pile.push(1)  ---> controleur ---> mod�le
					
			}
		});
		
		
		
		Button toucheAddition = new Button("+");
		toucheAddition.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				texteDansAffichage += "+";
				ecranAffichage.setText(texteDansAffichage);
				
				//pile.add() ---> controleur----> mod�le
				
			}
		});
		
		Button toucheZero = new Button("0");
		toucheZero.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				texteDansAffichage += "0";
				ecranAffichage.setText(texteDansAffichage);
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		// affichage de la fen�tre; avec cr�ation d'une sc�ne et choix de ses dimentions
		
		
		root.getChildren().addAll(ecranAffichage, toucheEgal, toucheZero, toucheUn, toucheAddition);
		
		
		
		
		
		Scene scene = new Scene(root,800,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	
	public static void main(String[] args) {
		Application.launch();
	}

}
