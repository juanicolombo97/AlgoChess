package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Soldado;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UnidadesCercanasTest {

    @Test
    public void unidadesCercanasADistancia1y2() {
        Jugador jugador = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("tobias");
        Tablero tablero = new Tablero(jugador, jugador2);
        Posicion posicionSoldado1 = new Posicion(4,4);
        Posicion posicionSoldado2 = new Posicion(6,6);
        Posicion posicionSoldado3 = new Posicion(2,2);
        Posicion posicionSoldado4 = new Posicion(3,3);
        Posicion posicionSoldado5 = new Posicion(5,5);
        Posicion posicionSoldado6 = new Posicion(4,5);
        Posicion posicionSoldado7 = new Posicion(4,6);
        Posicion posicionSoldado8 = new Posicion(5,4);
        Posicion posicionSoldado9 = new Posicion(6,4);
        Posicion posicionSoldado10 = new Posicion(4,7); // No cercana
        tablero.crearUnidad(jugador, posicionSoldado1, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado2, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado3, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado4, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado5, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado6, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado7, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado8, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado9, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado10, "soldado"); // No cercana
        Soldado soldado1 = (Soldado) jugador.getUnidadesDisponibles().get(0);
        Assertions.assertEquals(8, tablero.unidadesCercanasADistancia1y2(soldado1).size());
    }

    @Test
    public void unidadesAliadasCercanas() {
        Jugador jugador = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("tobias");
        Tablero tablero = new Tablero(jugador, jugador2);
        Posicion posicionSoldado1 = new Posicion(9,9);
        Posicion posicionSoldado2 = new Posicion(9,8);
        Posicion posicionSoldado3 = new Posicion(9,7);
        Posicion posicionSoldadoEnemigo1 = new Posicion(10,10); // unidad enemiga
        Posicion posicionSoldadoEnemigo2 = new Posicion(11,11); // unidad enemiga
        tablero.crearUnidad(jugador, posicionSoldado1, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado2, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado3, "soldado");
        tablero.crearUnidad(jugador2, posicionSoldadoEnemigo1, "soldado"); // unidad enemiga
        tablero.crearUnidad(jugador2, posicionSoldadoEnemigo2, "soldado"); // unidad enemiga
        Soldado soldado1 = (Soldado) jugador.getUnidadesDisponibles().get(0);
        Assertions.assertEquals(2, tablero.unidadesAliadasCercanas(soldado1).size());
    }

    @Test
    public void cantidadSoldadosAliadosCercanos() {
        Jugador jugador = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("tobias");
        Tablero tablero = new Tablero(jugador, jugador2);
        Posicion posicionSoldado1 = new Posicion(9,9);
        Posicion posicionCurandero = new Posicion(9,8);
        Posicion posicionSoldado2 = new Posicion(9,7);
        Posicion posicionJineteEnemigo = new Posicion(10,10); // unidad enemiga
        Posicion posicionSoldadoEnemigo = new Posicion(11,11); // unidad enemiga
        tablero.crearUnidad(jugador, posicionSoldado1, "soldado");
        tablero.crearUnidad(jugador, posicionCurandero, "curandero");
        tablero.crearUnidad(jugador, posicionSoldado2, "soldado");
        tablero.crearUnidad(jugador2, posicionJineteEnemigo, "jinete"); // unidad enemiga
        tablero.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado"); // unidad enemiga
        Soldado soldado1 = (Soldado) jugador.getUnidadesDisponibles().get(0);
        Assertions.assertEquals(1, tablero.cantidadSoldadosAliadosCercanos(soldado1));
    }

    @Test
    public void unidadesEnemigasCercanas() {
        Jugador jugador = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("tobias");
        Tablero tablero = new Tablero(jugador, jugador2);
        Posicion posicionSoldado1 = new Posicion(9,9);
        Posicion posicionSoldado2 = new Posicion(9,8); // unidad aliada
        Posicion posicionSoldadoEnemigo1 = new Posicion(10,10);
        Posicion posicionSoldadoEnemigo2 = new Posicion(11,11);
        tablero.crearUnidad(jugador, posicionSoldado1, "soldado");
        tablero.crearUnidad(jugador, posicionSoldado2, "soldado"); // unidad aliada
        tablero.crearUnidad(jugador2, posicionSoldadoEnemigo1, "soldado");
        tablero.crearUnidad(jugador2, posicionSoldadoEnemigo2, "soldado");
        Soldado soldado1 = (Soldado) jugador.getUnidadesDisponibles().get(0);
        Assertions.assertEquals(2, tablero.unidadesEnemigasCercanas(soldado1).size());
    }
}