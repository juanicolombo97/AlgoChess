package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.juego.Puntos;
import fiuba.algo3.algochess.juego.Tablero;
import fiuba.algo3.algochess.unidades.Batallon;
import fiuba.algo3.algochess.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.ArrayList;

public class BatallonTest {

    @Test
    public void seFormaBatallonDeUnidadesCercanasCorrectamente() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CasilleroVacioExcepcion {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador,jugador1);

        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);

        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador,posicion1,"catapulta");
        tablero.crearUnidad(jugador,posicion2,"curandero");
        tablero.crearUnidad(jugador,posicion3,"jinete");

        Batallon batallon = new Batallon();
        Unidad unidad = jugador.getUnidadesDisponibles().get(0);

        ArrayList unidadesCercanas = batallon.calcularBatallon(unidad,tablero.getTablero());

        Assertions.assertEquals(4,unidadesCercanas.size());

    }

    @Test
    public void seFormaBatallonConUnidadesEnemigasTambien() throws CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException, CasilleroVacioExcepcion {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador,jugador1);

        Posicion posicion = new Posicion(8,8);
        Posicion posicion1 = new Posicion(9,9);
        Posicion posicion2 = new Posicion(10,10);
        Posicion posicion3 = new Posicion(11,11);

        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador,posicion1,"soldado");
        tablero.crearUnidad(jugador1,posicion2,"soldado");
        tablero.crearUnidad(jugador1,posicion3,"soldado");

        Batallon batallon = new Batallon();
        Unidad unidad = jugador.getUnidadesDisponibles().get(0);

        ArrayList unidadesCercanas = batallon.calcularBatallon(unidad,tablero.getTablero());

        Assertions.assertEquals(4,unidadesCercanas.size());
    }

    @Test
    public void seFormaBatallonDeSoldadosSinUnidadesEnemigas() throws CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException, CasilleroVacioExcepcion {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador,jugador1);

        Posicion posicion = new Posicion(9,9);
        Posicion posicion1 = new Posicion(12,12);
        Posicion posicion2 = new Posicion(10,10);
        Posicion posicion3 = new Posicion(11,11);

        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador1,posicion1,"soldado");
        tablero.crearUnidad(jugador1,posicion2,"soldado");
        tablero.crearUnidad(jugador1,posicion3,"soldado");

        Batallon batallon = new Batallon();
        ArrayList listaUnidadesAliadas = jugador1.getUnidadesDisponibles();
        Unidad unidad = (Unidad) listaUnidadesAliadas.get(0);
        ArrayList listaUnidades = batallon.calcularBatallonDeSoldados(unidad,tablero.getTablero(),listaUnidadesAliadas);
        Assertions.assertEquals(3,listaUnidades.size());
    }

    @Test
    public void seFormaBatallonSoloDeSoldados() throws CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException, CasilleroVacioExcepcion {
        Jugador jugador1 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador1,jugador1);

        Posicion posicion = new Posicion(9,9);
        Posicion posicion1 = new Posicion(12,12);
        Posicion posicion2 = new Posicion(10,10);
        Posicion posicion3 = new Posicion(11,11);
        Posicion posicion4 = new Posicion(13,12);
        Posicion posicion5 = new Posicion(11,10);
        Posicion posicion6 = new Posicion(12,11);

        tablero.crearUnidad(jugador1,posicion,"soldado");
        tablero.crearUnidad(jugador1,posicion1,"soldado");
        tablero.crearUnidad(jugador1,posicion2,"soldado");
        tablero.crearUnidad(jugador1,posicion3,"soldado");
        tablero.crearUnidad(jugador1,posicion4,"jinete");
        tablero.crearUnidad(jugador1,posicion5,"catapulta");
        tablero.crearUnidad(jugador1,posicion6,"curandero");


        Batallon batallon = new Batallon();
        ArrayList listaUnidadesAliadas = jugador1.getUnidadesDisponibles();
        Unidad unidad = (Unidad) listaUnidadesAliadas.get(0);
        ArrayList listaUnidades = batallon.calcularBatallonDeSoldados(unidad,tablero.getTablero(),listaUnidadesAliadas);
        Assertions.assertEquals(4,listaUnidades.size());
    }
}
