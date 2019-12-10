package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Vista.Inicio.VentanaLoguear;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FaseInicial {

    private static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private static InterfazJuego interfazJuego = new InterfazJuego();

    public static void display(Stage ventana) {
        //Inicializo Jugadores y Juego
        String jugador1 = VentanaLoguear.display("Registro Jugador 1");
        String jugador2 = VentanaLoguear.display("Registro Jugador 2");
        Juego juego = new Juego(jugador1,jugador2);
        etapaColocarFichas(juego);
    }



    public static void etapaColocarFichas(Juego juego) {
        Stage ventana = new Stage();
        ventana.setTitle("AlgoChess");
        TableroInterfaz tableroInterfaz = new TableroInterfaz();
        tableroInterfaz.crearTablero(juego.tablero);
        for (Jugador jugadorActual : listaJugadores){

            VBox ladoIzq = MensajesAJugador.mensajesJugador(jugadorActual);

            VBox ladoDer = TiendaUnidades.crearUnidades(jugadorActual, tableroInterfaz, ventana,juego.tablero);

            BorderPane interfaz = InterfazJuego.crearInterfaz(tableroInterfaz.getTableroInterfaz(), ladoIzq, ladoDer);
            Scene scene = new Scene(interfaz);
            ventana.setScene(scene);
            ventana.showAndWait();
            }
        FaseJuego faseJuego = new FaseJuego(tableroInterfaz,juego.tablero,listaJugadores,ventana);
        faseJuego.comenzarJuego();
    }


}

