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

public class CrearUnidad {

    public CrearUnidad(String nombreUnidad, Juego juego, TableroInterfaz tableroInterfaz, FaseJuego faseJuego) {
        tableroInterfaz.getTablero() .setOnMouseClicked(e -> {

            int x = (int) e.getX() / tableroInterfaz.tamanioCasillero;
            int y = (int) e.getY() / tableroInterfaz.tamanioCasillero;
            Posicion posicion = new Posicion(x,y);
            try{
               Casillero casillero = juego.tablero.getTablero().get(posicion);
               juego.crearUnidad(nombreUnidad,posicion);
               Unidad unidad = casillero.obtenerUnidad();
               if (!unidad.getClass().equals(UnidadNula.class)) {
                   CasilleroInterfaz casilleroInterfaz = tableroInterfaz.getCasillero(posicion);
                   UnidadInterfaz unidadInterfaz = new UnidadInterfaz(unidad, casilleroInterfaz.casilleroAliado(), nombreUnidad,faseJuego,tableroInterfaz.tamanioCasillero);
                   casilleroInterfaz.setUnidad(unidadInterfaz);
                   faseJuego.puntosDisponibles.setText("Puntos disponibles: " + juego.jugadorActual().getPuntosDisponibles());
                   faseJuego.cambiarJugadorActual(juego.jugadorActual().getNombreJugador());
                   faseJuego.cambiarMensajeError("");
                   tableroInterfaz.agregarUnidad(unidadInterfaz);

               }
            }catch (Exception error){
                faseJuego.cambiarMensajeError(error.getMessage());
            }
        });
    }
}
