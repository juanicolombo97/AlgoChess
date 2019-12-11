package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Modelo.unidades.UnidadNula;
import fiuba.algo3.algochess.Vista.CasilleroInterfaz;
import fiuba.algo3.algochess.Vista.FaseJuego;
import fiuba.algo3.algochess.Vista.TableroInterfaz;
import fiuba.algo3.algochess.Vista.UnidadInterfaz;
import javafx.scene.layout.GridPane;

public class CrearUnidad {

    public CrearUnidad(String nombreUnidad, Juego juego, GridPane tableroInterfaz) {
        tableroInterfaz.setOnMouseClicked(e -> {
            int x = (int) e.getX() / TableroInterfaz.tamanioCasillero;
            int y = (int) e.getY() / TableroInterfaz.tamanioCasillero;
            Posicion posicion = new Posicion(x,y);
            try{
               Casillero casillero = juego.tablero.getTablero().get(posicion);
               juego.crearUnidad(nombreUnidad,posicion);
               Unidad unidad = casillero.obtenerUnidad();
               if (!unidad.getClass().equals(UnidadNula.class)) {
                   CasilleroInterfaz casilleroInterfaz = TableroInterfaz.getCasillero(posicion);
                   UnidadInterfaz unidadInterfaz = new UnidadInterfaz(unidad, casilleroInterfaz.casilleroAliado(), nombreUnidad);
                   casilleroInterfaz.setUnidad(unidadInterfaz);
                   FaseJuego.puntosDisponibles.setText("Puntos disponibles: " + juego.jugadorActual().getPuntosDisponibles());
                   FaseJuego.turnoDe.setText("Turno de " + juego.jugadorActual().getNombreJugador());
                   FaseJuego.mensajeDeError.setText("");
               }
            }catch (Exception error){
                FaseJuego.mensajeDeError.setText(error.getMessage());
            }
        });
    }
}
