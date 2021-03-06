package it.polito.tdp.corsi;
	
import it.polito.tdp.corsi.model.GestioneCorsi;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GestoreCorsi.fxml"));
			
			BorderPane root = loader.load();
			
			Scene scene = new Scene(root,500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			GestioneCorsi model = new GestioneCorsi();
			GestoreCorsiController controller = loader.getController();
			controller.setModel(model);
			
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
