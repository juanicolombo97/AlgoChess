package interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class MenuInicio extends Application {

    Button boton;
    Button boton2;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Configuro el nombre del juego y hago la ventana.
        primaryStage.setTitle("AlgoChess");
        Pane layout = new Pane();
        Scene scene = new Scene(layout, 800,600);

        //Creo botones.
        boton = new Button("Play");
        boton.setStyle("-fx-background-image: url('/imagenes/botonPlay.png')");
        boton2 = new Button("Salir");

        // Creo imagen y la establesco para que se mueva con la ventana.
        final ImageView imagen = new ImageView("imagenes/fondomenu.jpg");
        imagen.fitHeightProperty().bind(scene.heightProperty());
        imagen.fitWidthProperty().bind(scene.widthProperty());

        //Agrego las imagen y botones a la primaryStage.
        layout.getChildren().add(imagen);
        layout.getChildren().add(boton);
        layout.getChildren().add(boton2);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
