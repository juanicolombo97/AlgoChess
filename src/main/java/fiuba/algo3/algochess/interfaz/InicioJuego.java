package fiuba.algo3.algochess.interfaz;

import fiuba.algo3.algochess.juego.Jugador;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

public class InicioJuego {

    static ArrayList listaJugadores = new ArrayList();
    public void comenzarJuego(MediaPlayer mediaMenuIncio){

        listaJugadores.add(VentanaLogear.display("Jugador1"));
        listaJugadores.add(VentanaLogear.display("Jugador2"));

        //Creo los jugadores y les seteo nombre.
        Jugador jugador1 = new Jugador();
        jugador1.setNombreJugador((String) listaJugadores.get(0));
        Jugador jugador2 = new Jugador();
        jugador2.setNombreJugador((String)listaJugadores.get(1));
        mediaMenuIncio.pause();
    }
}
