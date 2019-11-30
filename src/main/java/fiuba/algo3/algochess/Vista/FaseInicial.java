package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FaseInicial {

    private static ArrayList<Jugador> listaJugadores = new ArrayList<>();
     private static InterfazJuego interfazJuego = new InterfazJuego();

    public static void display() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException {
        //Inicializo Jugadores
        listaJugadores.add(new Jugador(VentanaLoguear.display("Registro Jugador 1")));
        listaJugadores.add(new Jugador(VentanaLoguear.display("Registro Jugador 2")));

        Tablero tablero = new Tablero(listaJugadores.get(0),listaJugadores.get(1));
        etapaColocarFichas(listaJugadores,tablero);

    }



    public static void etapaColocarFichas(ArrayList listaJugadores,Tablero tablero) throws NoAlcanzanLosPuntosException {
        Stage ventana = new Stage();
        ventana.setTitle("AlgoChess");
        for (Object jugador : listaJugadores){
            Jugador jugadorActual = (Jugador) jugador;
            while (jugadorActual.getPuntosDisponibles() != 0){

                VBox ladoIzq = MensajesAJugador.mensajesJugador(jugadorActual);
                VBox ladoDer = TiendaUnidades.crearUnidades();
                Pane tableroInterfaz = TableroInterfaz.crearTablero(tablero.getTablero());

                BorderPane interfaz = InterfazJuego.crearInterfaz(tableroInterfaz,ladoIzq,ladoDer);

                Scene scene = new Scene(interfaz);

                ventana.setScene(scene);
                ventana.showAndWait();
            }
        }

    }
}
