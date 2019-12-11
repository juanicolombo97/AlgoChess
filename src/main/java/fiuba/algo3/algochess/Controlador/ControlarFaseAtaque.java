package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Vista.TableroInterfaz;
import javafx.scene.layout.GridPane;


public class ControlarFaseAtaque {
    public static Juego juego;
    public static GridPane tableroInterfaz;

    public ControlarFaseAtaque(Juego juego, GridPane tableroInterfaz){
        this.juego = juego;
        this.tableroInterfaz = tableroInterfaz;
        seleccionarUnidadAtacante();
    }

    public static void seleccionarUnidadAtacante(){
        tableroInterfaz.setOnMouseClicked(e -> {
            int x = (int) e.getX() / TableroInterfaz.tamanioCasillero;
            int y = (int) e.getY() / TableroInterfaz.tamanioCasillero;
            Posicion posicion = new Posicion(x,y);
                Casillero casillero = juego.tablero.getTablero().get(posicion);
                Unidad unidadAtacante = casillero.obtenerUnidad();
                seleccionarUniddadAtacada(unidadAtacante);
        });
    }

    public static void seleccionarUniddadAtacada(Unidad unidadAtacante){
        tableroInterfaz.setOnMouseClicked(e -> {
            int x = (int) e.getX() / TableroInterfaz.tamanioCasillero;
            int y = (int) e.getY() / TableroInterfaz.tamanioCasillero;
            Posicion posicion = new Posicion(x,y);
            Casillero casillero = juego.tablero.getTablero().get(posicion);
            Unidad unidadAtacada = casillero.obtenerUnidad();
            realizarAtaque(unidadAtacante,unidadAtacada);
        });
    }

    public static void realizarAtaque(Unidad unidadAtacante, Unidad unidadAtacada){
        Posicion posicionAtacante = unidadAtacante.getPosicion();
        Posicion posicionAtacada = unidadAtacada.getPosicion();
        juego.atacar(posicionAtacante,posicionAtacada);
        //actualizar vista?
    }
}
