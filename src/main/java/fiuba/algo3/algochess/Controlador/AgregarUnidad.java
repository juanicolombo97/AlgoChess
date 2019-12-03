package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Vista.*;
import javafx.scene.input.MouseEvent;

public class AgregarUnidad {
    public AgregarUnidad(TableroInterfaz tablero, Jugador jugador, MouseEvent e, String nombreUnidad) {

        Tablero tablero1 = tablero.getTableroJuego();
        int x = (int) e.getX() / TableroInterfaz.tamanioCasillero;
        int y = (int) e.getY() / TableroInterfaz.tamanioCasillero;
        Posicion posicion = new Posicion(x,y);
        try {
            Unidad unidad = tablero1.crearUnidad(jugador,posicion,nombreUnidad);

            CasilleroInterfaz casilleroInterfaz = tablero.getCasillero(posicion);
            UnidadInterfaz unidadInterfaz = new UnidadInterfaz(unidad,casilleroInterfaz.casilleroAliado(),nombreUnidad);
            casilleroInterfaz.setUnidad(unidadInterfaz);
            MensajesAJugador.setPuntos(jugador.getPuntosDisponibles());
        }catch (Exception error){
            MensajesAJugador.setMensaje(error.getMessage());
        }
    }
}
