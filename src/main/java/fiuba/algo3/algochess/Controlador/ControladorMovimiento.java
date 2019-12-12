package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Vista.CasilleroInterfaz;
import fiuba.algo3.algochess.Vista.FaseJuego;
import fiuba.algo3.algochess.Vista.TableroInterfaz;
import javafx.scene.layout.GridPane;

public class ControladorMovimiento {

    private FaseJuego faseJuego;
    private GridPane tablero;
    private Posicion posicionInicial;
    private Posicion posicionFinal;
    private TableroInterfaz tableroInterfaz;
    private boolean seleccionoUnidad = false;

    public ControladorMovimiento(FaseJuego faseJuego, GridPane tablero) {
        this.faseJuego = faseJuego;
        this.tablero = tablero;
        this.tableroInterfaz = faseJuego.tableroInterfaz;
        unidadAMover();
    }

    public void unidadAMover(){

        tablero.setOnMouseClicked( mouse1 -> {
            seleccionoUnidad =true;
            int posicionMouseX = (int) mouse1.getX() / tableroInterfaz.tamanioCasillero;
            int posicionMouseY = (int) mouse1.getY() / tableroInterfaz.tamanioCasillero;
            posicionInicial = new Posicion(posicionMouseX,posicionMouseY);

            casilleroDestino();
        });

    }

    private void casilleroDestino() {

        tablero.setOnMouseClicked(mouse2 -> {
            if (seleccionoUnidad) {
                seleccionoUnidad = false;
                int posicionMouseX = (int) mouse2.getX() / tableroInterfaz.tamanioCasillero;
                int posicionMouseY = (int) mouse2.getY() / tableroInterfaz.tamanioCasillero;
                posicionFinal = new Posicion(posicionMouseX, posicionMouseY);
                try {
                    faseJuego.juego.mover(posicionInicial,posicionFinal);
                    tableroInterfaz.actualizarPosiciones();
                    faseJuego.cambiarMensajeError("");
                    faseJuego.cambiarJugadorActual(faseJuego.juego.jugadorActual().getNombreJugador());

                }catch (Exception error){
                    faseJuego.cambiarMensajeError(error.getMessage());
                }
            }
        });


    }

}
