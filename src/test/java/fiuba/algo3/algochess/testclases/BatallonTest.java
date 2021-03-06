package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Batallon;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BatallonTest {

    @Test
    public void seFormaBatallonDeSoldadosSinUnidadesEnemigas() {
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
        List<Unidad> listaUnidadesAliadas = jugador1.getUnidadesDisponibles();
        Unidad unidad = listaUnidadesAliadas.get(0);
        List<Unidad> listaUnidades = batallon.batallonDeSoldados(unidad,tablero.getTablero(),listaUnidadesAliadas);
        Assertions.assertEquals(3,listaUnidades.size());
    }

    @Test
    public void seFormaBatallonSoloDeSoldados() {
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador = new Jugador("Juani");
        Tablero tablero = new Tablero(jugador,jugador1);


        Posicion posicion1 = new Posicion(12,12);
        Posicion posicion2 = new Posicion(10,10);
        Posicion posicion3 = new Posicion(11,11);
        Posicion posicion4 = new Posicion(13,12);
        Posicion posicion5 = new Posicion(11,10);
        Posicion posicion6 = new Posicion(12,11);


        tablero.crearUnidad(jugador1,posicion1,"soldado");
        tablero.crearUnidad(jugador1,posicion2,"soldado");
        tablero.crearUnidad(jugador1,posicion3,"soldado");
        tablero.crearUnidad(jugador1,posicion4,"jinete");
        tablero.crearUnidad(jugador1,posicion5,"catapulta");
        tablero.crearUnidad(jugador1,posicion6,"curandero");


        Batallon batallon = new Batallon();
        List<Unidad> listaUnidadesAliadas = jugador1.getUnidadesDisponibles();
        Unidad unidad = listaUnidadesAliadas.get(0);
        List<Unidad> listaUnidades = batallon.batallonDeSoldados(unidad,tablero.getTablero(),listaUnidadesAliadas);
        Assertions.assertEquals(3,listaUnidades.size());
    }

    @Test
    void moverBatallonSoldados() {
        Jugador jugador1 = new Jugador("juan");
        Jugador jugador2 = new Jugador("pedro");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Posicion posicionSoldado1 = new Posicion(12, 12);
        Posicion posicionSoldado2 = new Posicion(13, 13);
        Posicion posicionSoldado3 = new Posicion(11, 11);
        tablero.crearUnidad(jugador2, posicionSoldado1,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado2,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado3,"soldado");
        // Muevo el soldado del (12, 12) al (13, 13)
        Posicion posicionFinal = new Posicion(14, 14);
        // Al mover el batallón, todas las unidades deben moverse (1, 1)
        tablero.moverUnidad(posicionSoldado2, posicionFinal, jugador2);
        List<Unidad> unidades = jugador2.getUnidadesDisponibles();
        // Obtengo dicho soldado
        Unidad unidad = unidades.get(1);
        Posicion posicionEsperada = new Posicion(14,14);
        Assertions.assertTrue(posicionEsperada.equals(unidad.getPosicion()));
    }

    @Test
    void moverBatallonSoldadosConObstaculo() {
        Jugador jugador1 = new Jugador("juan");
        Jugador jugador2 = new Jugador("pedro");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Posicion posicionSoldado1 = new Posicion(12, 12);
        Posicion posicionSoldado2 = new Posicion(13, 12);
        Posicion posicionSoldado3 = new Posicion(11, 11);
        Posicion posicionCatapulta = new Posicion(14, 13);
        tablero.crearUnidad(jugador2, posicionSoldado1,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado2,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado3,"soldado");
        tablero.crearUnidad(jugador2, posicionCatapulta,"catapulta");
        Posicion posicionFinal = new Posicion(13, 13);
        tablero.moverUnidad(posicionSoldado1, posicionFinal, jugador2);
        // La unidad en la posicion (13, 12) permaneció en la misma posición a causa del obstáculo.
        // Obtengo dicha unidad para comprobarlo
        List<Unidad> unidades = jugador2.getUnidadesDisponibles();

        Unidad unidad = unidades.get(1);
        Posicion posicionEsperada = new Posicion(13,12);
        Assertions.assertTrue(posicionEsperada.equals(unidad.getPosicion()));
    }

    @Test
    void seDisuelveBatallonCorrectamente() {
        Jugador jugador1 = new Jugador("juan");
        Jugador jugador2 = new Jugador("pedro");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Posicion posicionSoldado1 = new Posicion(15, 14);
        Posicion posicionSoldado2 = new Posicion(14, 14);
        Posicion posicionSoldado3 = new Posicion(13, 14);
        Posicion posicionCatapulta = new Posicion(15, 15);
        tablero.crearUnidad(jugador2, posicionSoldado1,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado2,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado3,"soldado");
        tablero.crearUnidad(jugador2, posicionCatapulta,"catapulta");

        // Muevo la unidad y un obstáculo bloquea al soldado de la posición (14, 13)
        Posicion posicion1415 = new Posicion(14,15);
        Posicion posicion1416 = new Posicion(14,16);
        Posicion posicion1417 = new Posicion(14,17);
        tablero.moverUnidad(posicionSoldado2, posicion1415, jugador2);
        tablero.moverUnidad(posicion1415, posicion1416, jugador2);

        // Ahora al mover la unidad en 14,16 a la de 14,17 no se deberia mover ya que se disolvio el batallon

        tablero.moverUnidad(posicion1416, posicion1417, jugador2);

        List<Unidad> unidades = jugador2.getUnidadesDisponibles();

        // La unidad de la pos 16,16 se queda ahi, ya que no es mas un batallon.
        Unidad unidad = unidades.get(0);
        Posicion posicionEsperada = new Posicion(15,14);
        Assertions.assertTrue(posicionEsperada.equals(unidad.getPosicion()));
    }

    @Test
    void moverBatallonDe4SoloMueve3Unidades() {
        Jugador jugador1 = new Jugador("juan");
        Jugador jugador2 = new Jugador("pedro");
        Tablero tablero = new Tablero(jugador1, jugador2);
        Posicion posicionSoldado1 = new Posicion(15, 15);
        Posicion posicionSoldado2 = new Posicion(14, 14);
        Posicion posicionSoldado3 = new Posicion(13, 13);
        Posicion posicionSoldado4 = new Posicion(12, 12);
        tablero.crearUnidad(jugador2, posicionSoldado1, "soldado");
        tablero.crearUnidad(jugador2, posicionSoldado2, "soldado");
        tablero.crearUnidad(jugador2, posicionSoldado3, "soldado");
        tablero.crearUnidad(jugador2, posicionSoldado4, "soldado");
        Posicion posicion1616 = new Posicion(16,16);
        tablero.moverUnidad(posicionSoldado1, posicion1616, jugador2);

        //La unidad de la pos 12,12 al ser la mas lejana y ya haber 3 soldados no se mueve

        List<Unidad> unidades = jugador2.getUnidadesDisponibles();

        // La unidad de la pos 16,16 se queda ahi, ya que no es mas un batallon.
        Unidad unidad = unidades.get(3);
        Posicion posicionEsperada = new Posicion(12,12);
        Assertions.assertTrue(posicionEsperada.equals(unidad.getPosicion()));
    }
}
