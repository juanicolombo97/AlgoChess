package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.JugadorReal;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Entrega2CatapultaTest {

    @Test
    public void catapultaAtacaABatallonUnidades() {
        Jugador jugador = new JugadorReal("JUAN");
        Jugador jugador1 = new JugadorReal("Juani");
        Tablero tablero = new Tablero(jugador,jugador1);


        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);
        Posicion posicion4 = new Posicion(11,11);

        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador,posicion1,"soldado");
        tablero.crearUnidad(jugador,posicion2,"soldado");
        tablero.crearUnidad(jugador,posicion3,"soldado");
        tablero.crearUnidad(jugador1,posicion4,"catapulta");

        tablero.atacar(posicion4,posicion3,jugador);

        List<Unidad> listaUnidades = jugador.getUnidadesDisponibles();

        Unidad unidad = listaUnidades.get(0);
        Unidad unidad1 = listaUnidades.get(1);
        Unidad unidad2 = listaUnidades.get(2);
        Unidad unidad3 = listaUnidades.get(3);

        boolean vidaCorrectaUnidad1 = unidad.getVidaUnidad() == 80;
        boolean vidaCorrectaUnidad2 = unidad1.getVidaUnidad() == 80;
        boolean vidaCorrectaUnidad3 = unidad2.getVidaUnidad() == 80;
        boolean vidaCorrectaUnidad4 = unidad3.getVidaUnidad() == 80;

        boolean vidaCorrecta = vidaCorrectaUnidad1 && vidaCorrectaUnidad2 && vidaCorrectaUnidad3 && vidaCorrectaUnidad4;

        Assertions.assertTrue(vidaCorrecta);
    }

    @Test
    public void catapultaTambienAtacaBatallonUnidadesQueContienenAliadas() {
        Jugador jugador = new JugadorReal("JUAN");
        Jugador jugador1 = new JugadorReal("JUAN");

        Tablero tablero = new Tablero(jugador,jugador1);


        Posicion posicion = new Posicion(7,7);
        Posicion posicion1 = new Posicion(8,8);
        Posicion posicion2 = new Posicion(9,9);
        Posicion posicion3 = new Posicion(10,10);
        Posicion posicion4 = new Posicion(19,19);

        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador,posicion1,"soldado");
        tablero.crearUnidad(jugador,posicion2,"soldado");
        tablero.crearUnidad(jugador1,posicion3,"soldado");
        tablero.crearUnidad(jugador1,posicion4,"catapulta");

        tablero.atacar(posicion4,posicion3,jugador);

        List<Unidad> listaUnidades = jugador.getUnidadesDisponibles();
        List<Unidad> listaUnidades2 = jugador1.getUnidadesDisponibles();

        Unidad unidad = listaUnidades.get(0);
        Unidad unidad1 = listaUnidades.get(1);
        Unidad unidad2 = listaUnidades.get(2);
        Unidad unidad3 = listaUnidades2.get(0);

        boolean vidaCorrectaUnidad1 = unidad.getVidaUnidad() == 80;
        boolean vidaCorrectaUnidad2 = unidad1.getVidaUnidad() == 80;
        boolean vidaCorrectaUnidad3 = unidad2.getVidaUnidad() == 80;
        boolean vidaCorrectaUnidad4 = unidad3.getVidaUnidad() == 80;

        boolean vidaCorrecta = vidaCorrectaUnidad1 && vidaCorrectaUnidad2 && vidaCorrectaUnidad3 && vidaCorrectaUnidad4;

        Assertions.assertTrue(vidaCorrecta);
    }
    @Test
    public void catapultaAtacaUnidadEnemigaSinUnidadeCerca() {
        Jugador jugador = new JugadorReal("JUAN");
        Jugador jugador1 = new JugadorReal("JUAN");

        Tablero tablero = new Tablero(jugador,jugador1);


        Posicion posicion = new Posicion(6,6);
        Posicion posicion1 = new Posicion(8,8);
        Posicion posicion2 = new Posicion(15,15);


        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador,posicion1,"soldado");
        tablero.crearUnidad(jugador1,posicion2,"catapulta");

        tablero.atacar(posicion2,posicion,jugador1);

        List<Unidad> listaUnidades = jugador.getUnidadesDisponibles();

        Unidad unidad = listaUnidades.get(0);
        Unidad unidad1 = listaUnidades.get(1);

        boolean vidaCorrectaUnidad1 = unidad.getVidaUnidad() == 80;
        boolean vidaCorrectaUnidad2 = unidad1.getVidaUnidad() == 100;
        boolean vidaCorrecta = vidaCorrectaUnidad1 && vidaCorrectaUnidad2;
        Assertions.assertTrue(vidaCorrecta);
    }
}
