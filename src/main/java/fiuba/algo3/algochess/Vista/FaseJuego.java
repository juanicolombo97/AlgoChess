package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Controlador.ControlarFaseAtaque;
import fiuba.algo3.algochess.Controlador.ControladorMovimiento;
import fiuba.algo3.algochess.Controlador.CrearUnidad;
import fiuba.algo3.algochess.Controlador.ManejadorTurnoColocacionFichas;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Vista.Inicio.VentanaLoguear;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FaseJuego {


    public static GridPane tableroInterfaz;
    public static Unidad unidadSeleccionada = null;
    private static VBox ladoDerecho;
    private static VBox ladoIzquierdo;
    private static VBox infoUnidad;
    public static Label nombreUnidad;
    public static Label vidaUnidad;
    public static Label turnoDe;
    public static  Label puntosDisponibles;
    public static Label mensajeDeError;
    public static Stage ventana;
    private static BorderPane interfazJuego;
    public static Juego juego;
    public static boolean comienzoJuego = false;
    public static Unidad unidadAtacanteSeleccionada = null;
    public static Unidad unidadAtacadaSeleccionada = null;

    public static void display(Stage ventana) {
        //Inicializo Jugadores y Juego
        String jugador1 = VentanaLoguear.display("Registro Jugador 1");
        String jugador2 = VentanaLoguear.display("Registro Jugador 2");
        juego = new Juego(jugador1,jugador2);
        etapaColocarFichas(juego);
    }



    public static void etapaColocarFichas(Juego juego) {
        ventana = new Stage();
        ventana.setTitle("AlgoChess");

        tableroInterfaz = TableroInterfaz.crearTablero(juego.tablero,comienzoJuego);
        ladoDerecho = crearUnidadesVbox(juego);
        ladoIzquierdo = crearMensajesJugador(juego);

        interfazJuego = new BorderPane();

        interfazJuego.setCenter(tableroInterfaz);
        BorderPane.setMargin(tableroInterfaz,new Insets(10));
        interfasJuego.setStyle("-fx-background-color: #45647e;");
        cambiarLadoDerechoInterfaz(ladoDerecho);
        cambiarLadoIzquierdoInterfaz(ladoIzquierdo);

        Scene scene = new Scene(interfasJuego,950,700);

        ventana.setScene(scene);
        ventana.show();
    }

    private static VBox crearInfoUnidad(Juego juego) {
        VBox hBox = new VBox(10);
        hBox.setStyle("-fx-background-color: #7a7e31;");
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

    public static void cambiarLadoDerechoInterfaz(VBox ladoDerecho){
        interfazJuego.setRight(ladoDerecho);
    }

    private static void cambiarLadoIzquierdoInterfaz(VBox ladoIzquierdo) {
        interfazJuego.setLeft(ladoIzquierdo);
    }


    public static void inicioJuego(){
        comienzoJuego = true;
        mensajeDeError.setText("Comienzo etapa juego");
        puntosDisponibles.setText("");
        infoUnidad = crearInfoUnidad(juego);

        VBox botonesAccionar = acciones(comienzoJuego);
        VBox conjuntoAcciones = new VBox(10);
        conjuntoAcciones.getChildren().addAll(botonesAccionar,infoUnidad);

        cambiarLadoDerechoInterfaz(conjuntoAcciones);
        //hacer que lado izquierdo de indicaciones de como atacar y mover?

    }

    private static VBox acciones(boolean juegoHaComenzado /* es comienzoJuego */) {
        VBox vBox = new VBox(10);

        Button botonMover = new Button("Mover");
        botonMover.setOnAction( e -> new ControladorMovimiento(juego,tableroInterfaz));
        Button botonAtaque = new Button("Atacar/Curar");

        botonAtaque.setOnAction(e -> new ControlarFaseAtaque(juego,tableroInterfaz));
        //botonMover.setOnAction(e -> new ControlarFaseMovimiento(juego,tableroInterfaz));

        vBox.getChildren().addAll(botonAtaque,botonMover);
        return vBox;
    }
}

