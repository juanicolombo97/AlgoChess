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
    void pruebasBatallon() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CurarException, UnidadNulaException, NoPuedeAtacarException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        tablero.crearUnidad(jugador1,1,1,"soldado");
        tablero.crearUnidad(jugador1,2,1,"soldado");
        tablero.crearUnidad(jugador1,3,1,"soldado");
        tablero.crearUnidad(jugador1,4,1,"soldado");
        tablero.crearUnidad(jugador1,4,2,"soldado");
        tablero.crearUnidad(jugador1,4,3,"soldado");
        tablero.crearUnidad(jugador1,5,4,"soldado");


        tablero.crearUnidad(jugador2,11,11,"catapulta");

        tablero.atacar(11,11,2,1,jugador2);

        //Verifico que se le saca el danio a las undiades

        ArrayList listaUnidades = jugador1.getUnidadesDisponibles();

        for (int x = 0; x< listaUnidades.size() ; x++){
            Unidad unidad = (Unidad) listaUnidades.get(x);
            Assertions.assertEquals(80,unidad.getVidaUnidad());
        }
    }
}
