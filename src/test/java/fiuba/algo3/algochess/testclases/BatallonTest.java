package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Tablero;
import org.junit.jupiter.api.Test;

public class BatallonTest {

    @Test
    void pruebasBatallon() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CurarException, UnidadNulaException, NoPuedeAtacarException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        tablero.crearUnidad(jugador1,1,1,"soldado");
        tablero.crearUnidad(jugador1,2,1,"soldado");
        tablero.crearUnidad(jugador1,3,1,"soldado");
        tablero.crearUnidad(jugador1,4,1,"soldado");


        tablero.crearUnidad(jugador2,11,11,"catapulta");

        tablero.atacar(11,11,2,1,jugador2);
    }
}
