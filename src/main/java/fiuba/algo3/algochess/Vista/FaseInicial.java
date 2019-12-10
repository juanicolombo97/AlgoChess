package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Controlador.CrearUnidad;
import fiuba.algo3.algochess.Controlador.ManejadorTurnoColocacionFichas;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Vista.Inicio.VentanaLoguear;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.List;

public class FaseInicial {


    private static GridPane tableroInterfaz;
    private static VBox ladoDerecho;
    private static VBox ladoIzquierdo;
    public static Label turnoDe;
    public static  Label puntosDisponibles;
    public static Label mensajeDeError;
    public static Stage ventana;

    public static void display(Stage ventana) {
        //Inicializo Jugadores y Juego
        String jugador1 = VentanaLoguear.display("Registro Jugador 1");
        String jugador2 = VentanaLoguear.display("Registro Jugador 2");
        Juego juego = new Juego(jugador1,jugador2);
        etapaColocarFichas(juego);
    }



    public static void etapaColocarFichas(Juego juego) {
        ventana = new Stage();
        ventana.setTitle("AlgoChess");

        tableroInterfaz = TableroInterfaz.crearTablero(juego.tablero);
        ladoDerecho = crearUnidadesVbox(juego);
        ladoIzquierdo = crearMensajesJugador(juego);


        BorderPane interfasJuego = new BorderPane();

        interfasJuego.setCenter(tableroInterfaz);
        BorderPane.setMargin(tableroInterfaz,new Insets(10));
        interfasJuego.setLeft(ladoIzquierdo);
        interfasJuego.setRight(ladoDerecho);

        Scene scene = new Scene(interfasJuego);

        ventana.setScene(scene);
        ventana.show();
    }

    private static VBox crearMensajesJugador(Juego juego) {
        VBox vBox = new VBox(10);

        turnoDe = new Label("Turno de " + juego.jugadorActual().getNombreJugador());

        puntosDisponibles = new Label("Puntos disponibles: " + juego.jugadorActual().getPuntosDisponibles());

        mensajeDeError = new Label();
        vBox.getChildren().addAll(turnoDe,puntosDisponibles,mensajeDeError);
        return vBox;
    }

    private static VBox crearUnidadesVbox(Juego juego) {
        VBox vBox = new VBox(10);

        Label unidadesDisponibles = new Label("Unidades: ");

        Button crearSoldado = new Button("Crear Soldado");
        crearSoldado.setOnAction( e -> new CrearUnidad("soldado",juego,tableroInterfaz));

        Button crearJinete = new Button("Crear Jinete");
        crearJinete.setOnAction( e -> new CrearUnidad("jinete",juego,tableroInterfaz));

        Button crearCurandero = new Button("Crear Curandero");
        crearCurandero.setOnAction( e -> new CrearUnidad("curandero",juego,tableroInterfaz));

        Button crearCatapulta = new Button("Crear Catapulta");
        crearCatapulta.setOnAction( e -> new CrearUnidad("catapulta",juego,tableroInterfaz));

        Button terminarTurno = new Button("Terminar Turnos");
        terminarTurno.setOnAction(e -> new ManejadorTurnoColocacionFichas(juego,mensajeDeError));
        
        vBox.getChildren().addAll(unidadesDisponibles,crearSoldado,crearCurandero,crearJinete,crearCatapulta,terminarTurno);
        return vBox;
    }

    public static void inicioJuego(){
        mensajeDeError.setText("Comienzo etapa juego");
    }

}

