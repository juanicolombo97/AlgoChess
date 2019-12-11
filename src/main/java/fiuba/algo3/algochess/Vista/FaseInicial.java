package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Controlador.CrearUnidad;
import fiuba.algo3.algochess.Controlador.ManejadorTurnoColocacionFichas;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Vista.Inicio.VentanaLoguear;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.List;

public class FaseInicial {


    private static GridPane tableroInterfaz;
    private static VBox ladoDerecho;
    private static VBox ladoIzquierdo;
    private static HBox infoUnidad;
    public static Label nombreUnidad;
    public static Label vidaUnidad;
    public static Label turnoDe;
    public static  Label puntosDisponibles;
    public static Label mensajeDeError;
    public static Stage ventana;
    private static BorderPane interfasJuego;

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
        infoUnidad = crearInfoUnidad(juego);

        interfasJuego = new BorderPane();

        interfasJuego.setCenter(tableroInterfaz);
        BorderPane.setMargin(tableroInterfaz,new Insets(10));


        interfasJuego.setBottom(infoUnidad);
        BorderPane.setAlignment(infoUnidad, Pos.BOTTOM_CENTER);
        cambiarLadoDerechoInterfaz(ladoDerecho);
        cambiarLadoIzquierdoInterfaz(ladoIzquierdo);

        interfasJuego.setPrefSize(600,600);
        Scene scene = new Scene(interfasJuego);

        ventana.setScene(scene);
        ventana.show();
    }

    private static HBox crearInfoUnidad(Juego juego) {
        HBox hBox = new HBox(10);

        nombreUnidad = new Label();
        vidaUnidad = new Label();

        hBox.getChildren().addAll(nombreUnidad,vidaUnidad);
        return hBox;
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
        unidadesDisponibles.setTextFill(Color.web("#ff0000", 0.8));

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

    public static void cambiarLadoDerechoInterfaz(VBox ladoDerecho){
        interfasJuego.setRight(ladoDerecho);
        BorderPane.setMargin(ladoDerecho,new Insets(10,40,10,10));
    }

    private static void cambiarLadoIzquierdoInterfaz(VBox ladoIzquierdo) {
        interfasJuego.setLeft(ladoIzquierdo);
    }


}

