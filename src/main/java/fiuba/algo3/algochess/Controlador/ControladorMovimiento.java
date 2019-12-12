package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Vista.CasilleroInterfaz;
import fiuba.algo3.algochess.Vista.FaseJuego;
import fiuba.algo3.algochess.Vista.TableroInterfaz;
import fiuba.algo3.algochess.Vista.UnidadInterfaz;
import javafx.scene.layout.GridPane;

public class ControladorMovimiento {

    private Juego juego;

    public ControladorMovimiento(Juego juego, GridPane tableroInterfaz, FaseJuego faseJuego) {
       tableroInterfaz.setOnMouseClicked( e -> {
           int posXInicial = (int) e.getX() / TableroInterfaz.tamanioCasillero;
           int posYInicial = (int) e.getY() / TableroInterfaz.tamanioCasillero;
           Posicion posicionInicial = new Posicion(posXInicial,posYInicial);
           tableroInterfaz.setOnMouseClicked( mouse -> {
               int posXFinal = (int) mouse.getX() / TableroInterfaz.tamanioCasillero;
               int poYFinal = (int) mouse.getY() / TableroInterfaz.tamanioCasillero;
               Posicion posicionFinal = new Posicion(posXFinal,poYFinal);
               try {
                   juego.mover(posicionInicial,posicionFinal);
                   CasilleroInterfaz casilleroInicial = TableroInterfaz.getCasillero(posicionInicial);
                   CasilleroInterfaz casilleroFinal = TableroInterfaz.getCasillero(posicionFinal);
                   UnidadInterfaz unidad = casilleroInicial.getUnidad();
                   casilleroInicial.removeUnidad();
                   casilleroFinal.setUnidad(unidad);
                   unidad.actualizarPosicion();
                   faseJuego.cambiarJugadorActual(juego.jugadorActual().getNombreJugador());
                   faseJuego.cambiarMensajeError("");
               }catch (Exception error){
                   faseJuego.cambiarMensajeError(error.getMessage());
               }
           });

       });
    }
}
