package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Vista.MensajesAJugador;
import fiuba.algo3.algochess.Vista.TableroInterfaz;
import javafx.scene.layout.GridPane;

public class CrearJinete {

    public static void crear(Jugador jugador, TableroInterfaz tablero){
        MensajesAJugador.setMensaje("Coloque el Jinete");
        tablero.getTableroInterfaz().setOnMouseClicked(e -> new AgregarUnidad(tablero,jugador,e,"jinete"));
    }
}
