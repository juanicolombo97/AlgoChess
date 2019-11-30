package fiuba.algo3.algochess.interfaz;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.scene.control.Label;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.HashMap;

public class FaseInicial {
    public static int tamanioCasillero = 38;
    public static int filas = 20;
    public static int columnas = 20;
    private static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private static Group grupoCasilleros = new Group();
    private static BorderPane interfazJuego;

    public static void display() throws CasilleroOcupadoException, UnidadInvalidaException {
        //Inicializo Jugadores
        listaJugadores.add(new Jugador(VentanaLoguear.display("Registro Jugador 1")));
        listaJugadores.add(new Jugador(VentanaLoguear.display("Registro Jugador 2")));

        Tablero tablero = new Tablero(listaJugadores.get(0),listaJugadores.get(1));

        etapaColocarFichas(listaJugadores,tablero);

    }



    public static Pane crearTablero(HashMap casilleros){
        Pane pane = new Pane();
        pane.setPrefSize(filas * tamanioCasillero,columnas * tamanioCasillero);
        for (Object casillero : casilleros.values()){
            CasilleroInterfaz casilleroNuevo = new CasilleroInterfaz((Casillero) casillero);
            grupoCasilleros.getChildren().add(casilleroNuevo);
        }
        pane.getChildren().add(grupoCasilleros);
        return pane;
    }

    public static BorderPane crearInterfaz(Tablero tablero, VBox ladoIzq, VBox ladoDer){
        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(crearTablero(tablero.getTablero()));
        BorderPane.setMargin(ladoIzq,new Insets(10));
        BorderPane.setMargin(ladoDer,new Insets(10));
        borderPane.setLeft(ladoIzq);
        borderPane.setRight(ladoDer);

        return borderPane;
    }

    public static void etapaColocarFichas(ArrayList listaJugadores,Tablero tablero){
        Stage ventana = new Stage();
        ventana.setTitle("AlgoChess");
        for (Object jugador : listaJugadores){
            Jugador jugadorActual = (Jugador) jugador;
            while (jugadorActual.getPuntosDisponibles() != 0){

                VBox ladoIzq = new VBox(10);
                Label nombreJugadorActual = new Label(jugadorActual.getNombreJugador() + " coloque sus unidades");
                Label puntosJugador = new Label("Puntos disponibles: " + jugadorActual.getPuntosDisponibles());
                ladoIzq.getChildren().addAll(nombreJugadorActual,puntosJugador);

                VBox ladoDer = new VBox(10);
                Label unidades = new Label("Unidades disponibles");
                Button botonCrearUnidad = new Button("Crear Unidad");
                ladoDer.getChildren().addAll(unidades,botonCrearUnidad);
                Scene scene = new Scene(crearInterfaz(tablero,ladoIzq,ladoDer));

                ventana.setScene(scene);
                ventana.showAndWait();
            }
        }

    }
}
