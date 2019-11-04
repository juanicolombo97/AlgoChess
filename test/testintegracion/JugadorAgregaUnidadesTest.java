import Excepciones.NoAlcanzanLosPuntosException;
import excepciones.UnidadInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JugadorAgregaUnidadesTest {

    @Test
        // Agrego un soldado y se modifican correctamente los puntos.
    public void agregarUnidadesAJugadorSoldado() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Jugador jugador = new Jugador("juan");
        jugador.crearUnidad("Soldado");
        Assertions.assertEquals(19,jugador.getPuntos());
    }

    @Test
        // Agrego Jinete y se modifican correctamente.
    public void agregarUnidadesAJugadorJinete() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Jugador jugador = new Jugador("juan");
        jugador.crearUnidad("Jinete");
        Assertions.assertEquals(17,jugador.getPuntos());
    }

    @Test
        // Agrego catapulta y se modifican los puntos.
    public void agregarUnidadesAJugadorCatapulta() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Jugador jugador = new Jugador("juan");
        jugador.crearUnidad("Catapulta");
        Assertions.assertEquals(15,jugador.getPuntos());
    }

    @Test
        // Agrego curandero y se modifican los puntos correctamente.
    public void agregarUnidadesAJugador() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Jugador jugador = new Jugador("juan");
        jugador.crearUnidad("Curandero");
        Assertions.assertEquals(18,jugador.getPuntos());
    }

    @Test
        //El jugador crea correctamente a pesar de pasar el nombre en minuscula.
    public void agregarUnidadMinuscula() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Jugador jugador = new Jugador("juan");
        jugador.crearUnidad("curandero");
        Assertions.assertEquals(18,jugador.getPuntos());
    }

    @Test
        //Ingresar un nombre incorrecto genera un error.
    public void unidadIncorrectaLanzaError() throws UnidadInvalidaException {
        Jugador jugador = new Jugador("juan");
        try {
            jugador.crearUnidad("Minion");
        } catch (UnidadInvalidaException | NoAlcanzanLosPuntosException e) {
            Assertions.assertEquals("La unidad es invalida", e.getMessage());
        }
    }
}
