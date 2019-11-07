import Excepciones.CasilleroOcupadoExcenption;
import Excepciones.CurarException;
import Excepciones.NoAlcanzanLosPuntosException;
import Excepciones.NoPuedeAtacarException;

public class Juego {
    // Clase que empieza el juego.
    public static void main(String[] args) throws NoAlcanzanLosPuntosException, excepciones.UnidadInvalidaException, NoPuedeAtacarException, CurarException, CasilleroOcupadoExcenption {
        IniciarJuego juego = new IniciarJuego();
        juego.iniciarJuego();

    }
}


