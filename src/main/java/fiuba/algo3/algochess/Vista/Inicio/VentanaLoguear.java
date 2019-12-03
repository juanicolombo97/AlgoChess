package fiuba.algo3.algochess.Vista.Inicio;

import fiuba.algo3.algochess.Vista.Inicio.DeseaSalirAlerta;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class VentanaLoguear {

    static String nombreJugador;

    public static String display(String titulo) {
        Stage ventana = new Stage();
        ventana.setTitle(titulo);
        ventana.initModality(Modality.APPLICATION_MODAL);
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
        botonCrearJugador.setOnAction(e -> {
            nombreJugador = usuarioInput.getText();
            ventana.close();

        });
        //Caso de que le de a enter
        usuarioInput.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER){
                nombreJugador = usuarioInput.getText();
                ventana.close();
            }
        });
        GridPane.setConstraints(botonCrearJugador,1,2);

        ventana.setOnCloseRequest( e -> {
            e.consume();
            cerrarPrograma(ventana);

        });

        pane.getChildren().addAll(usuario,usuarioInput,botonCrearJugador);

        Scene scene = new Scene(pane,300,100);
        ventana.setScene(scene);
        ventana.showAndWait();
        return nombreJugador;

    }
    private static void cerrarPrograma(Stage ventana) {
        boolean respuesta = DeseaSalirAlerta.display("AlgoChess","Seguro quiere salir?");
        if(respuesta){ventana.close();}
    }
}
