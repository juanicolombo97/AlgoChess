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
        Posicion posicionSoldado2 = new Posicion(4,7);
        Posicion posicionSoldado3 = new Posicion(4,6);
        Posicion posicionSoldado4 = new Posicion(4,3);
        Posicion posicionSoldadoEnemigo1 = new Posicion(11,11);
        tablero.crearUnidad(jugador1, posicionSoldado1, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado2, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado3, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado4, "soldado");
        tablero.crearUnidad(jugador2, posicionSoldadoEnemigo1, "soldado");
        Soldado soldado1 = (Soldado) jugador1.getUnidadesDisponibles().get(0);
        Soldado soldado2 = (Soldado) jugador1.getUnidadesDisponibles().get(1);
        Soldado soldado3 = (Soldado) jugador1.getUnidadesDisponibles().get(2);
        ArrayList posiblesUnidadesCercanas = new ArrayList();
        posiblesUnidadesCercanas.add(soldado2);
        for (Object unidadActual: tablero.unidadesCercanasA(soldado1)){
            Unidad unidad = (Unidad) unidadActual;
            System.out.print(unidad.getPosicion().getPosicionY());
        }
    }
}