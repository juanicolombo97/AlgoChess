package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Tablero;
import org.junit.jupiter.api.Test;

public class MovimientoBatallonTest {

    @Test
        // Se mueve una unidad y se mueven 2 continuas
    public void moverBatallon() throws CasilleroOcupadoException, fiuba.algo3.algochess.excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador1);

        tablero.crearUnidad(jugador1,1,1,"soldado");
        tablero.crearUnidad(jugador1,1,2,"soldado");
        tablero.crearUnidad(jugador1,2,2,"soldado");
        tablero.moverUnidad(2,2,3,3,jugador1);
        
    }
}
