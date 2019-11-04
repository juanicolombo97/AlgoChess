import Excepciones.NoAlcanzanLosPuntosException;
import excepciones.UnidadInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JugadorAgregaUnidadesTest {

    @Test
        // Agrego un soldado y se modifican correctamente los puntos.
    public void jugadorAgregaUnidadSoldadoYSuCantidadDePuntosDecreceEn1() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Jugador jugador = new Jugador("Juan");
        jugador.crearUnidad("Soldado");
        Assertions.assertEquals(19,jugador.getPuntos());
    }

    @Test
        // Agrego Jinete y se modifican correctamente.
    public void jugadorAgregaUnidadJineteYSuCantidadDePuntosDecreceEn3() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Jugador jugador = new Jugador("Juan");
        jugador.crearUnidad("Jinete");
        Assertions.assertEquals(17,jugador.getPuntos());
    }

    @Test
        // Agrego catapulta y se modifican los puntos.
    public void jugadorAgregaUnidadCatapultaYSuCantidadDePuntosDecreceEn5() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Jugador jugador = new Jugador("Juan");
        jugador.crearUnidad("Catapulta");
        Assertions.assertEquals(15,jugador.getPuntos());
    }

    @Test
        // Agrego curandero y se modifican los puntos correctamente.
    public void jugadorAgregaUnidadCuranderoYSuCantidadDePuntosDecreceEn2() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Jugador jugador = new Jugador("Juan");
        jugador.crearUnidad("Curandero");
        Assertions.assertEquals(18,jugador.getPuntos());
    }

    @Test
        //El jugador crea correctamente a pesar de pasar el nombre en minuscula.
    public void jugadorAgregaUnidadCuranderoEnMinusculaYSeCreaNormalmente() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Jugador jugador = new Jugador("Juan");
        jugador.crearUnidad("curandero");
        Assertions.assertEquals(18,jugador.getPuntos());
    }

    @Test
        //Ingresar un nombre incorrecto genera un error.
    public void jugadorAgregaUnidadInvalidaYSeLevantaLaExcepcion() throws UnidadInvalidaException {
        Jugador jugador = new Jugador("Juan");
        try {
            jugador.crearUnidad("Lancero");
        } catch (UnidadInvalidaException | NoAlcanzanLosPuntosException e) {
            Assertions.assertEquals("La unidad es invalida", e.getMessage());
        }
    }
}
