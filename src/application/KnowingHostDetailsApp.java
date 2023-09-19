package application;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KnowingHostDetailsApp extends Application{
	
    public static void main(String[] args) {
        Application.launch(args);
    }
	
	@Override
	public void start(Stage stage) throws Exception {
        String yahooURL = "http://www.yahoo.com";
        //Creamos el boton para abrir la url
        Button botonAbrirURL = new Button("Ir a Yahoo!");
        //Escuchador de la accion
        botonAbrirURL.setOnAction(e -> getHostServices().showDocument(yahooURL));
        //Boton para mostar alerta
        Button mostrarAlerta = new Button("Mostrar alerta");
        //Escuchador que llama a la funcion que lanza la alerta
        mostrarAlerta.setOnAction(e -> mostrarAlerta());
        //Creamos una caja con alineacion vertical
        VBox root = new VBox();
        // Anadimos los botones a la caja
        root.getChildren().addAll(botonAbrirURL, mostrarAlerta);
        //Mapa que contiene la informacion requerida
        Map<String, String> hostdetails = getHostDetails();
        //Recorremos las entradas del mapa y vamos anadiendo labels al padre con la descripcion creada a partir del nombre de la propiedad y su valor
        for (Map.Entry<String, String> entry : hostdetails.entrySet()) {
            String desc = entry.getKey() + ": " + entry.getValue();
            root.getChildren().add(new Label(desc));
        }
        //creamos la ventana
        Scene scene = new Scene(root);
        //le anadimos la ventana a la aplicacion
        stage.setScene(scene);
        //
        stage.setTitle("Knowing the Host");
        stage.show();
	}
	
    protected Map<String, String> getHostDetails() {
    	//Instanciamos un hashmap y le añadismos las propiedades de HostService que necesitamos
        Map<String, String> map = new HashMap<>();
        HostServices host = this.getHostServices();
        String codeBase = host.getCodeBase();
        map.put("CodeBase", codeBase);
        String documentBase = host.getDocumentBase();
        map.put("DocumentBase", documentBase);
        String splashImageURI = host.resolveURI(documentBase, "splash.jpg");
        map.put("Splash Image URI", splashImageURI);
        //devolvemos el mapa creado
        return map;
    }

    protected void mostrarAlerta() {
    	
        Stage s = new Stage(StageStyle.UTILITY);
        s.initModality(Modality.APPLICATION_MODAL);
        Label msgLabel = new Label("This is an FX alert!");
        Group root = new Group(msgLabel);
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.setTitle("FX Alert");
        s.show();
    }
	
}
