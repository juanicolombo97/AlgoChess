package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.HashMap;


public class TableroInterfaz {

    public static int tamanioCasillero = 38;
    public static int filas = 20;
    public static int columnas = 20;
    private static Group grupoCasilleros = new Group();
    private static HashMap<Posicion,CasilleroInterfaz> tableroInterfaz = new HashMap<>();


    public static GridPane crearTablero(HashMap tablero){
        GridPane pane = new GridPane();
        pane.setPrefSize(filas * tamanioCasillero,columnas * tamanioCasillero);
        for (Object casillero : tablero.values() ){
            CasilleroInterfaz casilleroNuevo = new CasilleroInterfaz((Casillero) casillero);
            tableroInterfaz.put(casilleroNuevo.getPosicion(),casilleroNuevo);
            grupoCasilleros.getChildren().add(casilleroNuevo);
        }
        pane.getChildren().add(grupoCasilleros);
        return pane;
    }
}
