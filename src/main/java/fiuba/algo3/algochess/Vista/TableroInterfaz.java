package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.HashMap;


public class TableroInterfaz {

    public int tamanioCasillero = 30;
    public  int filas = 20;
    public  int columnas = 20;
    private  Group grupoCasilleros = new Group();
    private  Group grupoUnidades = new Group();
    private  HashMap<Posicion,CasilleroInterfaz> tableroInterfaz = new HashMap<>();
    private Juego juego;

    private GridPane tablero;

    public  TableroInterfaz(Juego juego){
        this.juego = juego;
    }

    public  GridPane crearTablero( ){
        GridPane pane = new GridPane();
        pane.setPrefSize(filas * tamanioCasillero,columnas * tamanioCasillero);
        for (Casillero casilleroActual : juego.tablero.getTablero().values() ){
            CasilleroInterfaz casilleroNuevo = new CasilleroInterfaz(casilleroActual,tamanioCasillero);
            tableroInterfaz.put(casilleroNuevo.getPosicion(),casilleroNuevo);
            grupoCasilleros.getChildren().add(casilleroNuevo);
        }
        pane.getChildren().addAll(grupoCasilleros,grupoUnidades);
        tablero = pane;
        return pane;
    }
    public  CasilleroInterfaz getCasillero(Posicion posicion){
        return tableroInterfaz.get(posicion);
    }


    public GridPane getTablero(){
        return tablero;
    }

}
