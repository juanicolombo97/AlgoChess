package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.excepciones.JugadorPerdioException;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Vista.CasilleroInterfaz;
import fiuba.algo3.algochess.Vista.FaseJuego;
import fiuba.algo3.algochess.Vista.UnidadInterfaz;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

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
                CasilleroInterfaz casilleroInterfazAtacado = faseJuego.tableroInterfaz.getCasillero(posicionAtacado);
                UnidadInterfaz unidadAAtacar = casilleroInterfazAtacado.getUnidad();
                try {
                    faseJuego.juego.atacar(posicionAtacante,posicionAtacado);
                    Media media = new Media(new File("src/main/resources/sonidos/attack.mp3").toURI().toString());
                    MediaPlayer sonidoAtaque = new MediaPlayer(media);
                    sonidoAtaque.play();
                    faseJuego.cambiarMensajeError("");
                    faseJuego.cambiarJugadorActual(faseJuego.juego.jugadorActual().getNombreJugador());
                    faseJuego.cambiarVidaUnidad(unidadAAtacar.getUnidad().getVidaUnidad());
                    faseJuego.cambiarNombreUnidad("(Atacada) " + unidadAAtacar.nombre);
                    faseJuego.tableroInterfaz.actualizarVidaUnidades();

                }catch (JugadorPerdioException e) {
                    new ControladorGanador(faseJuego,e.getMessage());
                }catch (Exception error){
                    faseJuego.cambiarMensajeError(error.getMessage());
                }
            }
        });
    }

}
