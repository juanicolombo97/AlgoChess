import Excepciones.CasilleroEnemigoException;
import Excepciones.CasilleroOcupadoExcenption;
import Excepciones.NoAlcanzanLosPuntosException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JugadorTest {

    @Test
        //Jugador recien creado no tiene unidades
    void jugadorNoPoseeUnidades(){
        Jugador jugador = new Jugador();
        Assertions.assertEquals(false,jugador.puedeSeguirJugando());
    }

    @Test
        //Jugador puede poner hasta 20 puntos
    void jugadorSoloPuedePoner20Puntos() throws CasilleroOcupadoExcenption, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException {
        Jugador jugador = new Jugador();
        Tablero tablero = new Tablero(jugador,jugador);

        //Creo 4 catapultas de coste 5 puntos.
        tablero.crearUnidad(jugador,1,1,"catapulta");
        tablero.crearUnidad(jugador,2,1,"catapulta");
        tablero.crearUnidad(jugador,3,1,"catapulta");
        tablero.crearUnidad(jugador,4,1,"catapulta");

        try {
            tablero.crearUnidad(jugador,5,1,"catapulta");
        }catch (NoAlcanzanLosPuntosException e){
            Assertions.assertEquals("Puntos no disponibles",e.getMessage());
        }
    }
}

