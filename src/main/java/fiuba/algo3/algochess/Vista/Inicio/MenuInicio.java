package fiuba.algo3.algochess.Vista.Inicio;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.Vista.FaseJuego;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.scene.control.Button;


import javafx.scene.media.AudioClip;


import java.io.File;

public class MenuInicio extends Application {

    Scene scene;
    Stage ventana;


    @Override
    public void start(Stage primaryStage) throws UnidadInvalidaException, CasilleroOcupadoException {

        //Configuro el nombre del juego y hago la ventana.
        ventana = primaryStage;
        ventana.setTitle("AlgoChess");
        StackPane stackPane = new StackPane();

        VBox layout = new VBox(40);
        Button botonJugar = new Button("Jugar");
        Button botonSalir = new Button("Salir");

        //Imagen

        final ImageView imagen = new ImageView("imagenes/fondomenu.jpg");
        
        scene = new Scene(stackPane, 800,600);
        imagen.fitHeightProperty().bind(scene.heightProperty());
        imagen.fitWidthProperty().bind(scene.widthProperty());


        botonJugar.setOnAction(e -> {
            FaseJuego faseJuego = new FaseJuego();
            faseJuego.display(ventana);
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
