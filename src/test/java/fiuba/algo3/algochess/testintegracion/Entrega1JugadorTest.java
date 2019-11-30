package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroEnemigoException;
import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Entrega1JugadorTest {

    @Test
    public void jugadorNoPuedeCrearMasUnidadesQuePuntosDisponibles() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException {
        Jugador jugador = new Jugador("Juani");
        Tablero tablero = new Tablero(jugador,jugador);

        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(1,12);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(1,4);
        Posicion posicion4 = new Posicion(1,5);

        tablero.crearUnidad(jugador,posicion,"catapulta");
        tablero.crearUnidad(jugador,posicion1,"catapulta");
        tablero.crearUnidad(jugador,posicion2,"catapulta");
        tablero.crearUnidad(jugador,posicion3,"catapulta");
        try {
            tablero.crearUnidad(jugador,posicion4,"soldado");
        }catch (NoAlcanzanLosPuntosException e){
            Assertions.assertEquals("Puntos insuficientes, dispone de: 0",e.getMessage());
        }
    }

    @Test
    public void jugadorRecienCreadoAlNoTenerUnidadesSeLoConsideraPerdedor(){
        Jugador jugador = new Jugador("Juani");
        Assertions.assertEquals(false,jugador.puedeSeguirJugando());
    }
}
