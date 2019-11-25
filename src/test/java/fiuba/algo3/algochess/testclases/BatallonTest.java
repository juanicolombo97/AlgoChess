package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Tablero;
import fiuba.algo3.algochess.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BatallonTest {

    @Test
    void pruebasBatallonCatapultaAtacaTodasUnidades() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CurarException, UnidadNulaException, NoPuedeAtacarException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        tablero.crearUnidad(jugador1,1,1,"soldado");
        tablero.crearUnidad(jugador1,2,1,"soldado");
        tablero.crearUnidad(jugador1,3,1,"soldado");
        tablero.crearUnidad(jugador1,4,1,"soldado");
        tablero.crearUnidad(jugador1,5,1,"soldado");



        tablero.crearUnidad(jugador2,20,20,"catapulta");

        tablero.atacar(20,20,2,1,jugador2);

        //Verifico que se le saca el danio a las undiades

        ArrayList listaUnidades = jugador1.getUnidadesDisponibles();

        for (int x = 0; x< listaUnidades.size() ; x++){
            Unidad unidad = (Unidad) listaUnidades.get(x);
            Assertions.assertEquals(80,unidad.getVidaUnidad());
        }
    }
    @Test
    void catapultaAtacaUnidadesCercanasAliadasTambien() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CurarException, UnidadNulaException, NoPuedeAtacarException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        tablero.crearUnidad(jugador2,12,12,"soldado");
        tablero.crearUnidad(jugador2,13,11,"soldado");
        tablero.crearUnidad(jugador2,12,10,"soldado");
        tablero.crearUnidad(jugador2,11,10,"soldado");
        tablero.crearUnidad(jugador2,11,11,"soldado");



        tablero.crearUnidad(jugador2,20,20,"catapulta");

        tablero.atacar(20,20,12,12,jugador2);

        //Verifico que se le saca el danio a las undiades

        ArrayList listaUnidades = jugador2.getUnidadesDisponibles();

        for (int x = 0; x< listaUnidades.size() ; x++){
            Unidad unidad = (Unidad) listaUnidades.get(x);
            Assertions.assertEquals(true,unidad.getVidaUnidad() < 100);
        }
    }

    @Test
    void moverBatallonSoldados() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        tablero.crearUnidad(jugador2,12,12,"soldado");
        tablero.crearUnidad(jugador2,13,13,"soldado");
        tablero.crearUnidad(jugador2,11,11,"soldado");

        tablero.moverUnidad(12,12,13,13,jugador2);

        ArrayList unidades = jugador2.getUnidadesDisponibles();

        // La unidad 2 de la lista es la de la pos 13,13 y al mover el batallon debe terminar en 14,14.

        Unidad unidad = (Unidad) unidades.get(1);

        Assertions.assertEquals(14,unidad.getPosicion().getPosicionX());
        Assertions.assertEquals(14,unidad.getPosicion().getPosicionY());
    }
    @Test
    void moverBatallonSoldadosConObstaculo() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        tablero.crearUnidad(jugador2,12,12,"soldado");
        tablero.crearUnidad(jugador2,13,12,"soldado");
        tablero.crearUnidad(jugador2,11,11,"soldado");
        tablero.crearUnidad(jugador2,14,13,"catapulta");

        tablero.moverUnidad(12,12,13,13,jugador2);

        // La unidad de la pos 13 , 12 se quedo ahi debido al obstaculo esta esta en la pos 1 de la lista unidades.
        ArrayList unidades = jugador2.getUnidadesDisponibles();
        Unidad unidad = (Unidad) unidades.get(1);

        Assertions.assertEquals(13,unidad.getPosicion().getPosicionX());
        Assertions.assertEquals(12,unidad.getPosicion().getPosicionY());
    }

    @Test
    void seDisuelveBatallonCorrectamente() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        tablero.crearUnidad(jugador2,15,15,"soldado");
        tablero.crearUnidad(jugador2,14,14,"soldado");
        tablero.crearUnidad(jugador2,14,13,"soldado");
        tablero.crearUnidad(jugador2,15,14,"catapulta");

        //Muevo la unidad y un objetivo bloquea a el soldado de 14,13.

        tablero.moverUnidad(15,15,16,16,jugador2);
        tablero.moverUnidad(16,16,17,17,jugador2);

        //Ahora al mover la unidad en 17,17 la de 16,16 no se deberia mover ya que se disolvio el batallon

        tablero.moverUnidad(17,17,18,18,jugador2);

        ArrayList unidades = jugador2.getUnidadesDisponibles();

        // La unidad de la pos 16,16 se queda ahi, ya que no es mas un batallon.
        Unidad unidad = (Unidad) unidades.get(1);

        Assertions.assertEquals(16,unidad.getPosicion().getPosicionX());
        Assertions.assertEquals(16,unidad.getPosicion().getPosicionY());


    }

    @Test
    void moverBatallonDe4SoloMueve3Unidades() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);

        tablero.crearUnidad(jugador2, 15, 15, "soldado");
        tablero.crearUnidad(jugador2, 14, 14, "soldado");
        tablero.crearUnidad(jugador2, 13, 13, "soldado");
        tablero.crearUnidad(jugador2, 12, 12, "soldado");

        tablero.moverUnidad(15, 15, 16, 16, jugador2);

        //La unidad de la pos 12,12 al ser la mas lejana y ya haber 3 soldados no se mueve

        ArrayList unidades = jugador2.getUnidadesDisponibles();

        // La unidad de la pos 16,16 se queda ahi, ya que no es mas un batallon.
        Unidad unidad = (Unidad) unidades.get(3);

        Assertions.assertEquals(12, unidad.getPosicion().getPosicionX());
        Assertions.assertEquals(12, unidad.getPosicion().getPosicionY());
    }

}
