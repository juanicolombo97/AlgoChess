package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.HashMap;


public class TableroInterfaz {

    public static int tamanioCasillero = 38;
    public static int filas = 20;
    public static int columnas = 20;
    private static Group grupoCasilleros = new Group();
    private static Group grupoUnidades = new Group();
    private static HashMap<Posicion,CasilleroInterfaz> tableroInterfaz = new HashMap<>();
    private GridPane tablero;
    private Tablero tableroJuego;


    public  void crearTablero(Tablero tablero){
        GridPane pane = new GridPane();
        tableroJuego = tablero;
        pane.setPrefSize(filas * tamanioCasillero,columnas * tamanioCasillero);
        for (Object casillero : tableroJuego.getTablero().values() ){
            CasilleroInterfaz casilleroNuevo = new CasilleroInterfaz((Casillero) casillero);
            tableroInterfaz.put(casilleroNuevo.getPosicion(),casilleroNuevo);
            grupoCasilleros.getChildren().add(casilleroNuevo);
        }
        pane.getChildren().addAll(grupoCasilleros,grupoUnidades);
        this.tablero = pane;
    }

    public Tablero getTableroJuego(){
        return tableroJuego;
    }

    public GridPane getTableroInterfaz(){
        return tablero;
    }

    public CasilleroInterfaz getCasillero(Posicion posicion){
        return tableroInterfaz.get(posicion);
    }


}
