import excepciones.UnidadInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JugadorAgregaUnidadesTest {

    @Test
        // Agrego un soldado y se modifican correctamente los puntos.
    public void agregarUnidadesAJugadorSoldado() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("Soldado");
        Assertions.assertEquals(19,jugador.getPuntos());
    }

    @Test
        // Agrego Jinete y se modifican correctamente.
    public void agregarUnidadesAJugadorJinete() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("Jinete");
        Assertions.assertEquals(17,jugador.getPuntos());
    }

    @Test
        // Agrego catapulta y se modifican los puntos.
    public void agregarUnidadesAJugadorCatapulta() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("Catapulta");
        Assertions.assertEquals(15,jugador.getPuntos());
    }

    @Test
        // Agrego curandero y se modifican los puntos correctamente.
    public void agregarUnidadesAJugador() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("Curandero");
        Assertions.assertEquals(18,jugador.getPuntos());
    }

    @Test
        //El jugador crea correctamente a pesar de pasar el nombre en minuscula.
    public void agregarUnidadMinuscula() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("curandero");
        Assertions.assertEquals(18,jugador.getPuntos());
    }

    @Test
        //Ingresar un nombre incorrecto genera un error.
    public void unidadIncorrectaLanzaError() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        try {
            jugador.crearUnidad("Minion");
        } catch (UnidadInvalidaException e) {
            Assertions.assertEquals("La unidad es invalida", e.getMessage());
        }
    }
}
