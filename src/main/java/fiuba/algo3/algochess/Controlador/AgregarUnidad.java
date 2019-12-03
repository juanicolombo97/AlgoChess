package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Vista.MensajesAJugador;
import fiuba.algo3.algochess.Vista.TableroInterfaz;
import fiuba.algo3.algochess.Vista.UnidadInterfaz;
import javafx.scene.input.MouseEvent;

public class AgregarUnidad {
    public AgregarUnidad(TableroInterfaz tablero, Jugador jugador, MouseEvent e, String soldado) {

        Tablero tablero1 = tablero.getTableroJuego();
        int x = (int) e.getX() / TableroInterfaz.tamanioCasillero;
        int y = (int) e.getY() / TableroInterfaz.tamanioCasillero;
        Posicion posicion = new Posicion(x,y);
        try {
            Unidad unidad = tablero1.crearUnidad(jugador,posicion,soldado);
            UnidadInterfaz unidadInterfaz = new UnidadInterfaz(unidad);
            tablero.agregarUnidad(unidadInterfaz);
            MensajesAJugador.setPuntos(jugador.getPuntosDisponibles());
        }catch (Exception error){
            MensajesAJugador.setMensaje(error.getMessage());
        }
    }
}
