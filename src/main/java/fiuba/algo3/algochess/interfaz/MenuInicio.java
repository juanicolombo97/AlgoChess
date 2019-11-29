package fiuba.algo3.algochess.interfaz;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.media.Media;

import java.io.File;


public class MenuInicio extends Application {

    Scene scene;
    Stage ventana;

    @Override
    public void start(Stage primaryStage) throws UnidadInvalidaException,CasilleroOcupadoException {

        //Configuro el nombre del juego y hago la ventana.
        ventana = primaryStage;
        ventana.setTitle("AlgoChess");

        StackPane stackPane = new StackPane();

        VBox layout = new VBox(40);
        Button botonJugar = new Button("Jugar");
        Button botonSalir = new Button("Salir");

        //Setteo sonido click.


        scene = new Scene(stackPane, 800,600);
       // Creo imagen y la establesco para que se mueva con la ventana.
        final ImageView imagen = new ImageView("fiuba/algo3/algochess/imagenes/fondomenu.jpg");
        imagen.fitHeightProperty().bind(ventana.heightProperty());
        imagen.fitWidthProperty().bind(ventana.widthProperty());


        botonJugar.setOnAction(e -> {

            try {
                FaseInicial.display();
            } catch (CasilleroOcupadoException ex) {
                ex.printStackTrace();
            } catch (UnidadInvalidaException ex) {
                ex.printStackTrace();
            }
            ventana.close();
        });

        ventana.setOnCloseRequest( e -> {
            e.consume();
            cerrarPrograma();

        });

        botonSalir.setOnAction(e -> {
            e.consume();
            cerrarPrograma();
        });

        //Agrego las imagen y botones ala primaryStage.

        layout.getChildren().addAll(botonJugar,botonSalir);
        layout.setAlignment(Pos.CENTER);
        stackPane.getChildren().addAll(imagen,layout);
        ventana.setScene(scene);
        ventana.show();
    }

    private void cerrarPrograma() {
        boolean respuesta = DeseaSalirAlerta.display("AlgoChess","Seguro quiere salir?");
        if(respuesta){ventana.close();}
    }

    public static void main(String[] args) {
        launch(args);
    }

}
