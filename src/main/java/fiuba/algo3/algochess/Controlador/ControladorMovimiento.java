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

    private Juego juegoActual;
    private Posicion posicionInicial;
    private Posicion posicionFinal;
    private GridPane tablero;
    private FaseJuego faseJuego;
    private TableroInterfaz tableroInterfaz;

    public ControladorMovimiento(Juego juego, GridPane tableroInterfaz, FaseJuego faseJuego, TableroInterfaz interfaz) {
        tablero = tableroInterfaz;
        this.juegoActual = juego;
        this.faseJuego = faseJuego;
        this.tableroInterfaz = interfaz;
        accionMover();
    }

    public void accionMover(){
        tablero.setOnMouseClicked( e -> {

            int posXInicial = (int) e.getX() / TableroInterfaz.tamanioCasillero;
            int posYInicial = (int) e.getY() / TableroInterfaz.tamanioCasillero;
            posicionInicial = new Posicion(posXInicial,posYInicial);
            tablero.setOnMouseClicked( mouse -> {
                int posXFinal = (int) mouse.getX() / TableroInterfaz.tamanioCasillero;
                int poYFinal = (int) mouse.getY() / TableroInterfaz.tamanioCasillero;
                posicionFinal = new Posicion(posXFinal,poYFinal);
                System.out.println("Posicion FINAL x:" +posicionFinal.posicionX);
                System.out.println("Posicion FINAL Y:" +posicionFinal.posicionY);
                try {
                    juegoActual.mover(posicionInicial,posicionFinal);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                CasilleroInterfaz casilleroInicial = tableroInterfaz.getCasillero(posicionInicial);
                CasilleroInterfaz casilleroFinal = tableroInterfaz.getCasillero(posicionFinal);
                UnidadInterfaz unidad = casilleroInicial.getUnidad();
                casilleroInicial.removeUnidad();
                casilleroFinal.setUnidad(unidad);
                unidad.actualizarPosicion();
                faseJuego.cambiarJugadorActual(juegoActual.jugadorActual().getNombreJugador());
                faseJuego.cambiarMensajeError("");

            });

        });
    }
}
