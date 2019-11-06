import Excepciones.CurarException;
import Excepciones.NoAlcanzanLosPuntosException;
import Excepciones.NoPuedeAtacarException;
import excepciones.UnidadInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//TODO: si se siguen añadiendo, siguen bajando los puntos, y sigue incrementando cantidad unidades (agrega unidades)
//TODO: (integracion) si puedo seguir jugando el juego no termina,
//TODO: si al jugador le quedan unidades, sigue el juego (size != 0)
//TODO: si se elimina una unidad, el contador de unidades baja
//TODO: si el jugador se queda sin puntos y quiere agregar unidades, se atrapa a excepcion adecuada

public class JugadorTest {

    @Test
        // Creo un jugador y no tiene unidades.
    void jugadorRecienCreadoPuedeJugar(){
        Jugador jugador = new Jugador("Juani");
        Assertions.assertEquals(false,jugador.puedeSeguirJugando());
    }

    @Test
        // Jugador agrega unidad

    void jugadorPuedeAgregarUnidad() throws NoAlcanzanLosPuntosException, UnidadInvalidaException {
        Jugador jugador = new Jugador("Juani");
        jugador.crearUnidad(1,1,"soldado");
        Assertions.assertEquals(true,jugador.puedeSeguirJugando());
    }

    @Test
        //Jugador puede atacar correctamente
    void jugadorPuedeAtacarCorrectamente() throws NoPuedeAtacarException, CurarException {
        Jugador jugador = new Jugador("Juani");
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(1,1);

        jugador.atacar(soldado,curandero);
        Assertions.assertEquals(65,curandero.getVidaUnidad());
    }

    @Test
        //Se verifica que no puede tomar mas de los puntos que le corresponden

    void crearUnidadesDeMasLanzaError() throws NoAlcanzanLosPuntosException, UnidadInvalidaException {
        Jugador jugador = new Jugador("Juani");
        //Agrego 4 catapultas de valor 5, puntos jugador = 20;
        jugador.crearUnidad(1,1,"catapulta");
        jugador.crearUnidad(1,1,"catapulta");
        jugador.crearUnidad(1,1,"catapulta");
        jugador.crearUnidad(1,1,"catapulta");
        //Agregar soldado genera error.
        try {
            jugador.crearUnidad(1,1,"soldado");
        }catch (NoAlcanzanLosPuntosException e){
            Assertions.assertEquals("Puntos insuficientes",e.getMessage());
        }

    }
}


