package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{

	public void start(Stage stage) {
	stage.setTitle("HolaFX"); 
	Group root = new Group(new Button("Botón"));
	VBox vb = new VBox();
	Text msg= new Text("Ejercicio A");
	vb.getChildren().add(msg);
	Scene scene = new Scene(vb,300,200); 
	stage.setScene(scene);
	stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
