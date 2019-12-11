package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;

import java.util.HashMap;


public class TableroInterfaz {

    public static int tamanioCasillero = 30;
    public static int filas = 20;
    public static int columnas = 20;
    private static Group grupoCasilleros = new Group();
    private static Group grupoUnidades = new Group();
    private static HashMap<Posicion,CasilleroInterfaz> tableroInterfaz = new HashMap<>();



    public static GridPane crearTablero(Tablero tablero, boolean juegoHaComenzado){
        GridPane pane = new GridPane();
        pane.setPrefSize(filas * tamanioCasillero,columnas * tamanioCasillero);
        for (Casillero casilleroActual : tablero.getTablero().values() ){
            CasilleroInterfaz casilleroNuevo = new CasilleroInterfaz(casilleroActual,juegoHaComenzado);
            tableroInterfaz.put(casilleroNuevo.getPosicion(),casilleroNuevo);
            grupoCasilleros.getChildren().add(casilleroNuevo);
        }
        pane.getChildren().addAll(grupoCasilleros,grupoUnidades);
        return pane;
    }

    public static GridPane convertirCasillerosAClickeables(Tablero tablero, boolean juegoHaComenzado){
        GridPane pane = new GridPane();
        pane.setPrefSize(filas * tamanioCasillero,columnas * tamanioCasillero);
        for (Casillero casilleroActual : tablero.getTablero().values() ){
            UnidadInterfaz unidadInterfazActual = tableroInterfaz.get(casilleroActual.getPosicionCasillero()).getUnidad();
            CasilleroInterfaz casilleroNuevo = new CasilleroInterfaz(casilleroActual,juegoHaComenzado);
            casilleroNuevo.setUnidad(unidadInterfazActual);
            tableroInterfaz.put(casilleroNuevo.getPosicion(),casilleroNuevo);
            grupoCasilleros.getChildren().add(casilleroNuevo);
        }
        pane.getChildren().addAll(grupoCasilleros,grupoUnidades);
        return pane;
    }

    public static CasilleroInterfaz getCasillero(Posicion posicion){
        return tableroInterfaz.get(posicion);
    }

    public static void actualizarPosicionUnidades(){
    for (int x = 0; x < grupoUnidades.getChildren().size(); x++){
        UnidadInterfaz unidadInterfaz = (UnidadInterfaz) grupoUnidades.getChildren().get(x);
        unidadInterfaz.actualizarPosicion();
        }
    }

}
