package fiuba.algo3.algochess.interfaz;

import fiuba.algo3.algochess.excepciones.CasilleroEnemigoException;
import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Tablero;
import javafx.geometry.Insets;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;


import java.io.File;
import java.util.ArrayList;


public class TableroInterfaz {

    private Tablero tablero;
    private static final int tamanioCasillero = 35;
    private static final int filas = 20;
    private static final int columnas = 20;
    private Group grupoCasillero = new Group();
    private Stage ventana;
    static Media media = new Media(new File("/Users/juanicolombo/Desktop/GitHub/AlgoChess/src/main/java/fiuba/algo3/algochess/sonidos/Click2-Sebastian-759472264.wav").toURI().toString());
    static MediaPlayer mediaPlayer = new MediaPlayer(media);


    public void crearTablero(ArrayList listaJugadores) throws CasilleroOcupadoException, UnidadInvalidaException {
        Pane tableroInterfaz = new Pane();
        tableroInterfaz.setPrefSize(filas * tamanioCasillero,columnas * tamanioCasillero);
        Jugador jugador1 = (Jugador) listaJugadores.get(0);
        Jugador jugadro2 = (Jugador) listaJugadores.get(1);
        tablero = new Tablero(jugador1, jugadro2);
        //Agrego los casillero al grupoCasilleros.
        agregarCasilleros(listaJugadores);
        tableroInterfaz.getChildren().addAll(grupoCasillero);
        mostrarTablero(tableroInterfaz);
        iniciarAgregadoDeFichas(listaJugadores);

    }

    private void agregarCasilleros(ArrayList listaJugadores) {
        for (int x = 0; x < listaJugadores.size(); x++) {
            Jugador jugador = (Jugador) listaJugadores.get(x);
            ArrayList listaCasilleros = jugador.casilleroJugador;
            for (int y = 0; y < listaCasilleros.size(); y++) {
                grupoCasillero.getChildren().add((Casillero)listaCasilleros.get(y));
            }
        }
    }

    private void mostrarTablero(Pane tablero) {
        Scene scene = new Scene(tablero);
        ventana = new Stage();
        ventana.setTitle("AlgoChess");
        ventana.setScene(scene);
        ventana.show();
    }

    private void iniciarAgregadoDeFichas(ArrayList listaJugadores) {

        for (int x = 0; x < listaJugadores.size(); x++){
            Jugador jugadorActual = (Jugador) listaJugadores.get(x);
            ventanaCrearFichas(jugadorActual);

        }
    }

    private void ventanaCrearFichas(Jugador jugador){
        Stage ventana = new Stage();
        ventana.setTitle("Turno de " + jugador.getNombreJugador());
        StackPane pane = new StackPane();

        CheckBox soldado = new CheckBox("Soldado -- 1 Pto");
        CheckBox jinete = new CheckBox("Jinete -- 3 Ptos");
        CheckBox catapulta = new CheckBox("Catapulta -- 5 Ptos");
        CheckBox curandero = new CheckBox("Curandero -- 2 Ptos");

        Button crearUnidad = new Button("Crear Unidad");

        Label posicionX = new Label("Posicion X: ");
        TextField usuarioInputX = new TextField();
        usuarioInputX.setPromptText("posicion X");

        Label posicionY = new Label("Posicion Y: ");
        TextField usuarioInputY = new TextField();
        usuarioInputY.setPromptText("posicion Y");

        int puntos = jugador.puntosDisponibles();
        Label puntosDisponibles = new Label("Puntos disponibles: " + puntos);

        crearUnidad.setOnAction(e -> {
            manejoOpciones(soldado,catapulta,curandero,jinete,usuarioInputX.getText(),usuarioInputY.getText(),puntos);
            mediaPlayer.setAutoPlay(true);
        });
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(soldado,curandero,jinete,catapulta,posicionX,usuarioInputX,posicionY,usuarioInputY,crearUnidad);

        VBox layout2 = new VBox(10);
        layout2.setPadding(new Insets(20,20,20,150));


        layout2.getChildren().add(puntosDisponibles);
        pane.getChildren().addAll(layout2,layout);
        Scene scene = new Scene(pane,300,300);
        ventana.setScene(scene);
        ventana.show();



    }

    public void manejoOpciones(CheckBox soldado, CheckBox catapulta, CheckBox curandero, CheckBox jinete,String posicionX, String posicionY,int puntos){
        if (soldado.isSelected()){
            //Crear unidad soldado

            puntos = puntos -1;
        }
    }


}

