package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Jugador;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MensajesAJugador {

    private static Label mensajeNuevo = new Label();

    public static VBox mensajesJugador(Jugador jugador) {
        VBox vBox = new VBox(20);

        Label nombreJugadorActual = new Label(jugador.getNombreJugador() + " coloque sus unidades");

        Label puntosJugador = new Label("Puntos disponibles: " + jugador.getPuntosDisponibles());
        vBox.getChildren().addAll(nombreJugadorActual, puntosJugador,mensajeNuevo);
        return vBox;
    }

    public static void setMensaje(String mensaje){
        mensajeNuevo.setText(mensaje);
    }
}
