package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import org.testng.junit.JUnit3TestClass;

import java.util.ArrayList;

public class FaseJuego {

    private TableroInterfaz tableroInterfaz;
    private Tablero tablero;
    private ArrayList listaJugadores;
    private Stage ventana;
    private static Label turnoDe = new Label();
    private static Label errores = new Label();

    public FaseJuego(TableroInterfaz tableroInterfaz, Tablero tablero, ArrayList listaJugadores,Stage ventana){
        this.tableroInterfaz = tableroInterfaz;
        this.tablero = tablero;
        this.listaJugadores = listaJugadores;
        this.ventana = ventana;
    }

    public void comenzarJuego(){
        VBox acciones = crearBotonesAccion();
        VBox mensajes = mensajesJugadores((Jugador) listaJugadores.get(0));
        BorderPane interfaz = InterfazJuego.crearInterfaz(tableroInterfaz.getTableroInterfaz(),mensajes,acciones);

        Scene scene = new Scene(interfaz);
        ventana.setScene(scene);
        ventana.show();


    }

    public VBox crearBotonesAccion(){
        VBox vBox = new VBox();

        Button botonAtaque = new Button("Atacar/Curar");
        Button botonMover = new Button("Mover");

        vBox.getChildren().addAll(botonAtaque,botonMover);
        return vBox;
    }

    public VBox mensajesJugadores(Jugador jugador){

        VBox vBox = new VBox();

        turnoDe.setText("Turno de: " + jugador.getNombreJugador());

        errores.setText("");

        vBox.getChildren().addAll(turnoDe,errores);
        return vBox;
    }

    public static void setError(String error){
        errores.setText(error);
    }
}
