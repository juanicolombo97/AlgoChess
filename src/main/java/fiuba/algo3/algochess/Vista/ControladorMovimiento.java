package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Posicion;
import javafx.scene.layout.GridPane;

public class ControladorMovimiento {

    private FaseJuego faseJuego;
    private GridPane tablero;
    private Posicion posicionInicial;
    private Posicion posicionFinal;
    private TableroInterfaz tableroInterfaz;
    private CasilleroInterfaz casilleroInicial;
    private CasilleroInterfaz casilleroFinal;
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
            casilleroInicial = tableroInterfaz.getCasillero(posicionInicial);
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
                casilleroFinal = tableroInterfaz.getCasillero(posicionFinal);
                try {
                    faseJuego.juego.mover(posicionInicial,posicionFinal);
                    UnidadInterfaz unidadAMover = casilleroInicial.getUnidad();
                    casilleroFinal.setUnidad(unidadAMover);
                    casilleroInicial.eliminarUnidad();
                    faseJuego.cambiarMensajeError("");
                    faseJuego.cambiarJugadorActual(faseJuego.juego.jugadorActual().getNombreJugador());
                    tableroInterfaz.actualizarPosiciones();
                }catch (Exception error){
                    faseJuego.cambiarMensajeError(error.getMessage());
                }
            }
        });


    }

}
