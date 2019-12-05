package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Vista.MensajesAJugador;
import fiuba.algo3.algochess.Vista.TableroInterfaz;
import javafx.scene.layout.GridPane;

public class CrearSoldado {

    public static void crear(Jugador jugador, TableroInterfaz tablero, Juego juego){
        MensajesAJugador.setMensaje("Coloque el Soldado");
        tablero.getTableroInterfaz().setOnMouseClicked(e -> new AgregarUnidad(juego, tablero,jugador,e,"soldado"));
    }
}
