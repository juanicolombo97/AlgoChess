import Excepciones.CasilleroEnemigoException;
import Excepciones.CasilleroOcupadoExcenption;
import Excepciones.MovimientoInvalidoException;
import Excepciones.NoAlcanzanLosPuntosException;
import org.junit.jupiter.api.Test;

class TableroTest {

    @Test
        // Prueba que se inicializa el tablero y coloca pieza correctamente

    void tableroNuevoAgregoUnidadCorrectamente() throws CasilleroOcupadoExcenption, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroEnemigoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);
        //Creo la unidad y no lanza error.
        tablero.crearUnidad(jugador1,1,1,"soldado");
    }
}
