package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.JugadorReal;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Vista.Inicio.VentanaLoguear;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FaseInicial {

    private static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private static InterfazJuego interfazJuego = new InterfazJuego();

    public static void display(Stage ventana) {
        //Inicializo Jugadores y Juego
        listaJugadores.add(new JugadorReal(VentanaLoguear.display("Registro Jugador 1")));
        listaJugadores.add(new JugadorReal(VentanaLoguear.display("Registro Jugador 2")));
        Jugador jugador1 = listaJugadores.get(0);
        Jugador jugador2 = listaJugadores.get(1);
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tablero = juego.comenzarJuego();
        etapaColocarFichas(listaJugadores, juego, tablero);
    }



    public static void etapaColocarFichas(ArrayList listaJugadores, Juego juego, Tablero tablero) {
        Stage ventana = new Stage();
        ventana.setTitle("AlgoChess");
        TableroInterfaz tableroInterfaz = new TableroInterfaz();
        tableroInterfaz.crearTablero(tablero);
        for (Object jugador : listaJugadores){
            Jugador jugadorActual = (Jugador) jugador;

            VBox ladoIzq = MensajesAJugador.mensajesJugador(jugadorActual);

            VBox ladoDer = TiendaUnidades.crearUnidades(jugadorActual, tableroInterfaz, juego, ventana);

            BorderPane interfaz = InterfazJuego.crearInterfaz(tableroInterfaz.getTableroInterfaz(), ladoIzq, ladoDer);
            Scene scene = new Scene(interfaz);
            ventana.setScene(scene);
            ventana.showAndWait();
            }
        FaseJuego faseJuego = new FaseJuego(tableroInterfaz,tablero, juego,listaJugadores,ventana);
        faseJuego.comenzarJuego();
    }


}

