package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Botones extends Application{
	public void start(Stage stage) {
//		Iniciar estructura ventana
		stage.setTitle("HolaFX");
		VBox vb = new VBox();
		Text msg= new Text("Ejercicio A");
		
//		Creación de botones
		Button hola = new Button("Hola");
		Button adios = new Button("Adios");
		vb.getChildren().addAll(msg,hola,adios);
		Scene scene = new Scene(vb,300,200);
		stage.setScene(scene);
		stage.show();
		
//		Eventos de los botones
		hola.setOnAction(e -> {
			msg.setText("Hola");
		});
		adios.setOnAction(e -> {
			msg.setText("Adios");
		});
	}
	public static void main(String[] args) {
		launch(args);
	}
}
