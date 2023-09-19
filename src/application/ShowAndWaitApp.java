package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowAndWaitApp extends Application{
	//contador para llevar la cuenta de la ventana
	protected static int counter = 0;
	
	//se guarda la ultima ventana creada
    protected Stage lastOpenStage;

    //funcion principal
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) {
    	//creacion de elementos
    	//caja vertical
        VBox root = new VBox();
        //elemento boton
        Button openButton = new Button("Open");
        //escuchador de accion del boton; llama a la funcion open()
        openButton.setOnAction(e -> open(++counter));
        
        //aniadir el boton al contenedor
        root.getChildren().add(openButton);
        
        //creacion de escena
        Scene scene = new Scene(root, 400, 400);
        
        //steage contiene escena (ventana) y se le pasa aqui
        stage.setScene(scene);
        //titulo de la ventana
        stage.setTitle("The Primary Stage");
        //se muestra graficamente la aplicacion
        stage.show();
        //se establece la ventana principal como la ultima abierta
        this.lastOpenStage = stage;
    }

    private void open(int stageNumber) {
    	//Se crea una nueva ventana
        Stage stage = new Stage();
        //se nombra la nueva ventana con su numero correspondiente (previamente se ha incrementado)
        stage.setTitle("#" + stageNumber);
        //nuevo elemento boton que escribe por terminal 'hola desde la pantalla [contador de ventana]'
        Button sayHelloButton = new Button("Say Hello");
        //escuchador para escribir por terminal
        sayHelloButton.setOnAction(e -> System.out.println("Hello from #" + stageNumber));
        //nuevo boton para abrir otra ventana mas; se llama a esta misma funcion
        Button openButton = new Button("Open");
        //se le anade el escuchador al boton para ejecutar la funcion de abrir ventana
        openButton.setOnAction(e -> open(++counter));
        //nueva caja vertical
        VBox root = new VBox();
        //se anaden los dos nuevos botones a la caja vertical
        root.getChildren().addAll(sayHelloButton, openButton);
        //se crea una nueva ventana
        Scene scene = new Scene(root, 200, 200);
        //la nueva ventana se le anade a la aplicacion
        stage.setScene(scene);
        //establecemos las coordenadas de la nueva ventana (se anade 50 px en ambos ejes respecto a la ultima creada)
        stage.setX(this.lastOpenStage.getX() + 50);
        stage.setY(this.lastOpenStage.getY() + 50);
        //establecemos esta nueva ventana como la ultima abierta
        this.lastOpenStage = stage;
        System.out.println("Before stage.showAndWait(): " + stageNumber);
        // Show the stage and wait for it to close
        //Va esperando a que finalice la ejecucion de la vetana que se acaba de crear. Cuando se cierra, continua y escribe el 'after'
        stage.showAndWait();
        System.out.println("After stage.showAndWait(): " + stageNumber);
    }
}
