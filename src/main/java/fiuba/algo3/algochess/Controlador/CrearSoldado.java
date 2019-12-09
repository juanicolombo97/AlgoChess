package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Vista.MensajesAJugador;
import fiuba.algo3.algochess.Vista.TableroInterfaz;

public class CrearSoldado {

    public static void crear(Jugador jugador, TableroInterfaz tablero, Tablero tableroJuego){
        MensajesAJugador.setMensaje("Coloque el Soldado");
        tablero.getTableroInterfaz().setOnMouseClicked(e -> new AgregarUnidad( tablero,jugador,e,"soldado", tableroJuego));
    }
}
