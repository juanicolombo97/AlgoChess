package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Vista.CasilleroInterfaz;
import fiuba.algo3.algochess.Vista.FaseJuego;
import javafx.scene.layout.GridPane;

public class ControladorAtaque {

    private FaseJuego faseJuego;
    private GridPane tablero;
    private boolean seleccionoUnidad = false;
    private Posicion posicionAtacante;
    private Posicion posicionAtacado;

    public ControladorAtaque(FaseJuego faseJuego, GridPane tablero) {
        this.faseJuego = faseJuego;
        this.tablero = tablero;
        manejarAtaque();
    }

    private void manejarAtaque() {
        tablero.setOnMouseClicked(unidadAtacante -> {
            seleccionoUnidad =true;
            int posicionMouseX = (int) unidadAtacante.getX() / faseJuego.tableroInterfaz.tamanioCasillero;
            int posicionMouseY = (int) unidadAtacante.getY() / faseJuego.tableroInterfaz.tamanioCasillero;
            posicionAtacante = new Posicion(posicionMouseX,posicionMouseY);
            selecccionUnidadAtacada();
        });
    }

    private void selecccionUnidadAtacada() {
        tablero.setOnMouseClicked( unidadAtacada -> {
            if (seleccionoUnidad) {
                seleccionoUnidad = false;
                int posicionAtacadoX = (int) unidadAtacada.getX() / faseJuego.tableroInterfaz.tamanioCasillero;
                int posicionAtacadoY = (int) unidadAtacada.getY() / faseJuego.tableroInterfaz.tamanioCasillero;
                posicionAtacado = new Posicion(posicionAtacadoX, posicionAtacadoY);
                try {

                    faseJuego.juego.atacar(posicionAtacante,posicionAtacado);
                    faseJuego.cambiarMensajeError("");
                    faseJuego.cambiarJugadorActual(faseJuego.juego.jugadorActual().getNombreJugador());
                }catch (Exception error){
                    faseJuego.cambiarMensajeError(error.getMessage());
                }
            }
        });
    }

}
