package interfaz;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class VentanaLogear {


    private static boolean iniciarJuego = false;
    private static AlgoChess algoChess = new AlgoChess();
    private static Stage ventana = new Stage();

    private static String nombreJugador1;

    public static void display(String titulo, JugadoresRegistro jugadoresRegistro) {

        ventana.setTitle(titulo);
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(8);
        pane.setHgap(10);

        Label usuario = new Label("Nombre jugador: ");
        GridPane.setConstraints(usuario,0,1);

        TextField usuarioInput = new TextField();
        usuarioInput.setPromptText("Jugador1");
        GridPane.setConstraints(usuarioInput,1,1);

        //Accion boton
        Button botonCrearJugador = new Button("Crear Jugador");
        if (!iniciarJuego) {
            botonCrearJugador.setOnAction(e -> {
                VentanaLogear.display("jugador2",jugadoresRegistro);
                jugadoresRegistro.agregarJugador(usuarioInput.getText());
                System.out.println(usuarioInput.getText());

            });
            iniciarJuego = true;

        }else {
            jugadoresRegistro.agregarJugador(usuarioInput.getText());
            botonCrearJugador.setOnAction(e -> algoChess.displayAlgoChess(jugadoresRegistro));
            System.out.println(usuarioInput.getText());
        }

        ventana.setOnCloseRequest( e -> {
            e.consume();
            cerrarPrograma();

        });

        GridPane.setConstraints(botonCrearJugador, 1, 2);
        pane.getChildren().addAll(usuario,usuarioInput,botonCrearJugador);

        Scene scene = new Scene(pane,300,100);
        ventana.setScene(scene);
        ventana.show();


    }

    private static void cerrarPrograma() {
        boolean respuesta = DeseaSalirAlerta.display("AlgoChess","Seguro quiere salir?");
        if(respuesta){ventana.close();}
    }

}
