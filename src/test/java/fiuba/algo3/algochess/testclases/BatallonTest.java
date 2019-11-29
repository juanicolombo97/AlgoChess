package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.juego.Tablero;
import fiuba.algo3.algochess.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BatallonTest {

    @Test
    void pruebasBatallonCatapultaAtacaTodasUnidades() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CurarException, UnidadNulaException, NoPuedeAtacarException, CasilleroVacioExcepcion {
        Jugador jugador1 = new Jugador("juan");
        Jugador jugador2 = new Jugador("pedro");
        // Establezco posiciones de los soldados aliados
        Posicion posicionSoldado1 = new Posicion(1, 1);
        Posicion posicionSoldado2 = new Posicion(2, 1);
        Posicion posicionSoldado3 = new Posicion(3, 1);
        Posicion posicionSoldado4 = new Posicion(4, 1);
        Posicion posicionSoldado5 = new Posicion(5, 1);
        Tablero tablero = new Tablero(jugador1, jugador2);
        // Creo los soldados aliados
        tablero.crearUnidad(jugador1, posicionSoldado1, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado2, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado3, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado4, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado5, "soldado");
        // Establezco posicion de catapulta enemiga y la creo
        Posicion posicionCatapulta = new Posicion(19, 19);
        tablero.crearUnidad(jugador2, posicionCatapulta, "catapulta");
        // Ataco a los soldados con la catapulta
        tablero.atacar(posicionCatapulta, posicionSoldado2, jugador2);
        // Verifico que se le saca vida a todas las unidades del batallon
        ArrayList listaUnidades = jugador1.getUnidadesDisponibles();

        for (Object unidadActual : listaUnidades) {
            Unidad unidad = (Unidad) unidadActual;
            Assertions.assertEquals(80, unidad.getVidaUnidad());
        }
    }

    @Test
    void catapultaAtacaUnidadesCercanasAliadasTambien() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CurarException, UnidadNulaException, NoPuedeAtacarException, CasilleroVacioExcepcion {
        Jugador jugador1 = new Jugador("juan");
        Jugador jugador2 = new Jugador("pedro");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Posicion posicionSoldado1 = new Posicion(12, 12);
        Posicion posicionSoldado2 = new Posicion(13, 11);
        Posicion posicionSoldado3 = new Posicion(12, 10);
        Posicion posicionSoldado4 = new Posicion(11, 10);
        Posicion posicionSoldado5 = new Posicion(11, 11);

        tablero.crearUnidad(jugador2, posicionSoldado1,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado2,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado3,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado4,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado5,"soldado");

        Posicion posicionCatapulta = new Posicion(19,19);
        tablero.crearUnidad(jugador2, posicionCatapulta,"catapulta");

        tablero.atacar(posicionCatapulta, posicionSoldado1, jugador2);

        // Verifico que le saca vida a las unidades

        ArrayList listaUnidades = jugador2.getUnidadesDisponibles();

        for (Object unidadActual : listaUnidades) {
            Unidad unidad = (Unidad) unidadActual;
            Assertions.assertEquals(true, unidad.getVidaUnidad() < 100);
        }
    }

    @Test
    void moverBatallonSoldados() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException, CasilleroVacioExcepcion {
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
        // Al mover el batallón, todas las unidades deben moverse (1, 1)
        tablero.moverUnidad(posicionSoldado1, posicionSoldado2, jugador2);
        ArrayList unidades = jugador2.getUnidadesDisponibles();
        // Obtengo dicho soldado
        Unidad unidad = (Unidad) unidades.get(1);
        Assertions.assertEquals(14, unidad.getPosicion().getPosicionX());
        Assertions.assertEquals(14, unidad.getPosicion().getPosicionY());
    }

    @Test
    void moverBatallonSoldadosConObstaculo() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException, CasilleroVacioExcepcion {
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
        ArrayList unidades = jugador2.getUnidadesDisponibles();
        Unidad unidad = (Unidad) unidades.get(1);
        Assertions.assertEquals(13,unidad.getPosicion().getPosicionX());
        Assertions.assertEquals(12,unidad.getPosicion().getPosicionY());
    }

    @Test
    void seDisuelveBatallonCorrectamente() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException, CasilleroVacioExcepcion {
        Jugador jugador1 = new Jugador("juan");
        Jugador jugador2 = new Jugador("pedro");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Posicion posicionSoldado1 = new Posicion(15, 15);
        Posicion posicionSoldado2 = new Posicion(14, 14);
        Posicion posicionSoldado3 = new Posicion(14, 13);
        Posicion posicionCatapulta = new Posicion(15, 14);
        tablero.crearUnidad(jugador2, posicionSoldado1,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado2,"soldado");
        tablero.crearUnidad(jugador2, posicionSoldado3,"soldado");
        tablero.crearUnidad(jugador2, posicionCatapulta,"catapulta");

        // Muevo la unidad y un obstáculo bloquea al soldado de la posición (14, 13)
        Posicion posicion1616 = new Posicion(16,16);
        Posicion posicion1717 = new Posicion(17,17);
        Posicion posicion1818 = new Posicion(18,18);
        tablero.moverUnidad(posicionSoldado1, posicion1616, jugador2);
        tablero.moverUnidad(posicion1616, posicion1717, jugador2);

        // Ahora al mover la unidad en 17,17 la de 16,16 no se deberia mover ya que se disolvió el batallon

        tablero.moverUnidad(posicion1717, posicion1818, jugador2);

        ArrayList unidades = jugador2.getUnidadesDisponibles();

        // La unidad de la pos 16,16 se queda ahi, ya que no es mas un batallon.
        Unidad unidad = (Unidad) unidades.get(1);

        Assertions.assertEquals(16,unidad.getPosicion().getPosicionX());
        Assertions.assertEquals(16,unidad.getPosicion().getPosicionY());


    }

    @Test
    void moverBatallonDe4SoloMueve3Unidades() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException, CasilleroVacioExcepcion {
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

        ArrayList unidades = jugador2.getUnidadesDisponibles();

        // La unidad de la pos 16,16 se queda ahi, ya que no es mas un batallon.
        Unidad unidad = (Unidad) unidades.get(3);

        Assertions.assertEquals(12, unidad.getPosicion().getPosicionX());
        Assertions.assertEquals(12, unidad.getPosicion().getPosicionY());
    }
}