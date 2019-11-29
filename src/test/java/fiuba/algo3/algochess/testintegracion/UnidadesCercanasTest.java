package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.juego.Tablero;
import fiuba.algo3.algochess.unidades.Soldado;
import fiuba.algo3.algochess.unidades.Unidad;
import org.junit.Test;

import java.util.ArrayList;

public class UnidadesCercanasTest {

    @Test
    public void unidadesCercanas() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CasilleroVacioExcepcion {
        Jugador jugador1 = new Jugador("juan");
        Jugador jugador2 = new Jugador("pedro");
        Tablero tablero = new Tablero(jugador1, jugador2);
        Posicion posicionSoldado1 = new Posicion(4,4);
        Posicion posicionSoldado2 = new Posicion(4,3);
        Posicion posicionSoldado3 = new Posicion(4,2);
        Posicion posicionSoldado4 = new Posicion(4,1);
        Posicion posicionSoldado5 = new Posicion(4,5);
        Posicion posicionSoldado6 = new Posicion(4,6);
        Posicion posicionSoldado7 = new Posicion(4,7);
        Posicion posicionSoldado8 = new Posicion(5,3);
        Posicion posicionSoldado9 = new Posicion(5,5);
        Posicion posicionSoldado10 = new Posicion(5,6);
        Posicion posicionSoldado11 = new Posicion(6,2);
        Posicion posicionSoldado12 = new Posicion(6,4);
        Posicion posicionSoldado13 = new Posicion(6,6);
        Posicion posicionSoldadoEnemigo1 = new Posicion(11,11);
        tablero.crearUnidad(jugador1, posicionSoldado1, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado2, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado3, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado4, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado5, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado6, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado7, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado8, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado9, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado10, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado11, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado12, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado13, "soldado");
        tablero.crearUnidad(jugador2, posicionSoldadoEnemigo1, "soldado");
        Soldado soldado1 = (Soldado) jugador1.getUnidadesDisponibles().get(0);
        Soldado soldado2 = (Soldado) jugador1.getUnidadesDisponibles().get(1);
        Soldado soldado3 = (Soldado) jugador1.getUnidadesDisponibles().get(2);
        ArrayList posiblesUnidadesCercanas = new ArrayList();
        posiblesUnidadesCercanas.add(soldado2);
        for (Object unidadActual: tablero.unidadesCercanasADistancia1y2(soldado1)){
            Unidad unidad = (Unidad) unidadActual;
            System.out.print(unidad.getPosicion().getPosicionY());
        }
    }
}