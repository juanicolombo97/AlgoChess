package interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.Stack;


public class MenuInicio extends Application {

    Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Configuro el nombre del juego y hago la ventana.
        primaryStage.setTitle("AlgoChess");
        StackPane layout = new StackPane();
        Button botonJugar = new Button("Jugar");
        Button botonSalir = new Button("Salir");
        scene = new Scene(layout, 800,600);

        // Creo imagen y la establesco para que se mueva con la ventana.
        final ImageView imagen = new ImageView("imagenes/fondomenu.jpg");
        imagen.fitHeightProperty().bind(scene.heightProperty());
        imagen.fitWidthProperty().bind(scene.widthProperty());


        // Accion al apretar boton.
        botonJugar.setOnAction(e ->VentanaQuiereSalir.display("AlgoChess"));

        //Agrego las imagen y botones ala primaryStage.
        layout.getChildren().addAll(imagen,botonJugar);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
