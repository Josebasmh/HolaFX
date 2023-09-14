package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application{

	public void start(Stage stage) {
	stage.setTitle("Stage with a Button in the Scene"); 
	Group root = new Group(new Button("Hello"));
	Scene scene = new Scene(root); 
	stage.setScene(scene);
	stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
