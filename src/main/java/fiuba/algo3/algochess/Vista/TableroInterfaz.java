package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.util.HashMap;


public class TableroInterfaz {

    public static int tamanioCasillero = 38;
    public static int filas = 20;
    public static int columnas = 20;
    private static Group grupoCasilleros = new Group();


    public static Pane crearTablero(HashMap tablero){
        Pane pane = new Pane();
        pane.setPrefSize(filas * tamanioCasillero,columnas * tamanioCasillero);
        for (Object casillero : tablero.values() ){
            CasilleroInterfaz casilleroNuevo = new CasilleroInterfaz((Casillero) casillero);
            grupoCasilleros.getChildren().add(casilleroNuevo);
        }
        pane.getChildren().add(grupoCasilleros);
        return pane;
    }
}
