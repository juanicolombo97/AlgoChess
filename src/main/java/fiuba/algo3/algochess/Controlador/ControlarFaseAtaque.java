package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Vista.CasilleroInterfaz;
import fiuba.algo3.algochess.Vista.FaseJuego;
import fiuba.algo3.algochess.Vista.TableroInterfaz;
import javafx.scene.layout.GridPane;

public class ControlarFaseAtaque {
    public static Juego juego;
    public static GridPane tableroInterfaz;

    public ControlarFaseAtaque(Juego juego, GridPane tableroInterfaz){
        ControlarFaseAtaque.juego = juego;
        ControlarFaseAtaque.tableroInterfaz = tableroInterfaz;
        seleccionarUnidadAtacante();
    }

    public static void seleccionarUnidadAtacante(){
        tableroInterfaz.setOnMouseClicked(e -> {
            int x = (int) e.getX() / TableroInterfaz.tamanioCasillero;
            int y = (int) e.getY() / TableroInterfaz.tamanioCasillero;
            Posicion posicion = new Posicion(x,y);
            Casillero casillero = juego.tablero.getTablero().get(posicion);
            Unidad unidadAtacante = casillero.obtenerUnidad();
            seleccionarUnidadAtacada(unidadAtacante);
        });
    }

    public static void seleccionarUnidadAtacada(Unidad unidadAtacante){
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
        try{
            CasilleroInterfaz casilleroAtacado = TableroInterfaz.getCasillero(posicionAtacada);
            juego.atacar(posicionAtacante,posicionAtacada);
            TableroInterfaz.actualizarVistaUnidades();
            FaseJuego.turnoDe.setText(juego.jugadorActual().getNombreJugador());
            FaseJuego.mensajeDeError.setText("");
        }catch(Exception error){
            FaseJuego.mensajeDeError.setText(error.getMessage());
        }
    }
}
