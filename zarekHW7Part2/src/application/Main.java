/*
Nicholas Zarek
CSCV 335
Observer Calculator Main
*/

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("zarekHW7Part2.fxml"));
			Scene scene = new Scene(root,275,150); 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Observer Calculator");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
