package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Vista.FaseInicial;

import javafx.scene.control.*;

public class ManejadorTurnoColocacionFichas{

    public ManejadorTurnoColocacionFichas(Juego juego, Label mensajeDeError) {
        {
            if (juego.jugadorActual().getPuntosDisponibles() > 0) {
                mensajeDeError.setText("Todavia dispone de puntos");
            } else {
                FaseInicial.inicioJuego();
            }

        }
    }
}
