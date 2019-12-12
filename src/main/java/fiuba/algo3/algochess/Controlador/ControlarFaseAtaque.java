package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Vista.CasilleroInterfaz;
import fiuba.algo3.algochess.Vista.FaseJuego;
import fiuba.algo3.algochess.Vista.TableroInterfaz;
import javafx.scene.layout.GridPane;

import java.util.Scanner;

public class ControlarFaseAtaque {
    public static Juego juego;
    public static GridPane tableroInterfaz;

    public ControlarFaseAtaque(Juego juego, GridPane tableroInterfaz){
        ControlarFaseAtaque.juego = juego;
        ControlarFaseAtaque.tableroInterfaz = tableroInterfaz;
        seleccionarUnidadAtacante();
    }

    public static void seleccionarUnidadAtacante(){
        Scanner inputLn = new Scanner(System.in);
        System.out.println("enter the command:");
        String command = inputLn.nextLine();
        if (command.equals("1 1")){
            Posicion posicion = new Posicion(1,1);
            Casillero casillero = juego.tablero.getTablero().get(posicion);
            Unidad unidadAtacante = casillero.obtenerUnidad();
            seleccionarUnidadAtacada(unidadAtacante);
        }
    }

    public static void seleccionarUnidadAtacada(Unidad unidadAtacante){
        Scanner inputLn = new Scanner(System.in);
        System.out.println("enter the command:");
        String command = inputLn.nextLine();
        if (command.equals("10 10")){
            Posicion posicion = new Posicion(10,10);
            Casillero casillero = juego.tablero.getTablero().get(posicion);
            Unidad unidadAtacada = casillero.obtenerUnidad();
            realizarAtaque(unidadAtacante,unidadAtacada);
        }
    }

    public static void realizarAtaque(Unidad unidadAtacante, Unidad unidadAtacada){
        Posicion posicionAtacante = unidadAtacante.getPosicion();
        Posicion posicionAtacada = unidadAtacada.getPosicion();
        try{
            CasilleroInterfaz casilleroAtacado = TableroInterfaz.getCasillero(posicionAtacada);
            juego.atacar(posicionAtacante,posicionAtacada);
            //TableroInterfaz.actualizarVistaUnidades();
           // FaseJuego.turnoDe.setText(juego.jugadorActual().getNombreJugador());
        }catch(Exception error){
            //FaseJuego.mensajeDeError.setText(error.getMessage());
            System.out.print(error.getMessage());
        }
    }
}
