package fiuba.algo3.algochess.interfaz;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.juego.Jugador;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

public class InicioJuego {

    static ArrayList listaJugadores = new ArrayList();
    public void comenzarJuego(MediaPlayer mediaMenuIncio) throws CasilleroOcupadoException, UnidadInvalidaException {

        String nombreJugador1 = VentanaLogear.display("Jugador1");
        String nombreJugador2 = VentanaLogear.display("Jugador2");

        //Creo los jugadores y les seteo nombre.
        Jugador jugador1 = new Jugador();
        jugador1.setNombreJugador(nombreJugador1);
        Jugador jugador2 = new Jugador();
        jugador2.setNombreJugador(nombreJugador2);
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        mediaMenuIncio.pause();
        TableroInterfaz interfazJuego = new TableroInterfaz();
        interfazJuego.crearTablero(listaJugadores);


    }
}
