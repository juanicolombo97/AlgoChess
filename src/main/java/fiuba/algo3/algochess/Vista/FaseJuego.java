package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Tablero;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FaseJuego {

    private TableroInterfaz tableroInterfaz;
    private Tablero tablero;
    private ArrayList listaJugadores;

    public FaseJuego(TableroInterfaz tableroInterfaz, Tablero tablero, ArrayList listaJugadores){
        this.tableroInterfaz = tableroInterfaz;
        this.tablero = tablero;
        this.listaJugadores = listaJugadores;
    }

    public void comenzarJuego(){
        Stage ventana = new Stage();
        ventana.setTitle("AlgoChess");
        Scene scene = new Scene(tableroInterfaz.getTableroInterfaz());
        ventana.setScene(scene);
        ventana.show();

    }
}
