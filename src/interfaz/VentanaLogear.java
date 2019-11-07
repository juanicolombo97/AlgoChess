package interfaz;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class VentanaLogear {

    public static void display(String titulo) {
        Stage ventana = new Stage();
        ventana.setTitle(titulo);
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(8);
        pane.setHgap(10);

        Label usuario = new Label("Nombre jugador: ");
        GridPane.setConstraints(usuario,0,1);

        TextField usuarioInput = new TextField();
        usuarioInput.setPromptText("Jugador");
        GridPane.setConstraints(usuarioInput,1,1);

        Button botonCrearJugador = new Button("Crear Jugador");
        botonCrearJugador.setOnAction(e ->VentanaLogear.display("jugador2"));
        GridPane.setConstraints(botonCrearJugador,1,2);

        pane.getChildren().addAll(usuario,usuarioInput,botonCrearJugador);

        Scene scene = new Scene(pane,300,100);
        ventana.setScene(scene);
        ventana.show();


    }
}
