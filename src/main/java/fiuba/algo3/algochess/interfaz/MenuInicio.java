package fiuba.algo3.algochess.interfaz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class MenuInicio extends Application {

    Scene scene;
    Stage ventana;
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Configuro el nombre del juego y hago la ventana.
        ventana = primaryStage;
        ventana.setTitle("AlgoChess");
        StackPane layout = new StackPane();
        layout.setPadding(new Insets(25,0,0,0));
        Button botonJugar = new Button("Jugar");
        Button botonSalir = new Button("Salir");

        scene = new Scene(layout, 800,600);

        /*// Creo imagen y la establesco para que se mueva con la ventana.
        final ImageView imagen = new ImageView("imagenes/fondomenu.jpg");
        imagen.fitHeightProperty().bind(scene.heightProperty());
        imagen.fitWidthProperty().bind(scene.widthProperty());


         */

        // Accion al apretar boton.
        botonJugar.setOnAction(e -> VentanaLogear.display("jugador1"));
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
        layout.setAlignment(botonSalir,Pos.BOTTOM_CENTER);
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
