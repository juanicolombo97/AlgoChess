package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Modelo.unidades.UnidadNula;
import fiuba.algo3.algochess.Vista.*;
import javafx.scene.input.MouseEvent;

public class AgregarUnidad {
    public AgregarUnidad(TableroInterfaz tablero, Jugador jugador, MouseEvent e, String nombreUnidad, Tablero tableroJuego) {

        int x = (int) e.getX() / TableroInterfaz.tamanioCasillero;
        int y = (int) e.getY() / TableroInterfaz.tamanioCasillero;
        Posicion posicion = new Posicion(x,y);
        try {
            Unidad unidad = tableroJuego.crearUnidad(jugador,posicion,nombreUnidad);
            if (!unidad.getClass().equals(UnidadNula.class)){
                CasilleroInterfaz casilleroInterfaz = tablero.getCasillero(posicion);
                UnidadInterfaz unidadInterfaz = new UnidadInterfaz(unidad,casilleroInterfaz.casilleroAliado(),nombreUnidad);
                casilleroInterfaz.setUnidad(unidadInterfaz);
                MensajesAJugador.setPuntos(jugador.getPuntosDisponibles());
            }
        }catch (Exception error){
            MensajesAJugador.setMensaje(error.getMessage());
        }
    }
}
