import Excepciones.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class JugadorTest {

    @Test
        //Jugador recien creado no tiene unidades
    void jugadorNoPoseeUnidades(){
        Jugador jugador = new Jugador();
        Assertions.assertEquals(false,jugador.puedeSeguirJugando());
    }

    @Test
        //Jugador puede poner hasta 20 puntos
    void jugadorSoloPuedePoner20Puntos() throws CasilleroOcupadoException, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException {
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

    @Test
        // Jugador no puede atacar a unidad aliada, salvo que sea catapulta.
    void atacarUnidadAliadaError() throws CasilleroOcupadoException, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CurarException, UnidadNulaException, NoPuedeAtacarException {
        Jugador jugador = new Jugador();
        Tablero tablero = new Tablero(jugador,jugador);
        tablero.crearUnidad(jugador,1,1,"soldado");
        tablero.crearUnidad(jugador,2,2,"soldado");
        try {
            tablero.atacar(1,1,2,2,jugador);
        }catch (excepciones.UnidadInvalidaException e){
            Assertions.assertEquals("La unidad es aliada",e.getMessage());
        }
    }

    @Test
        // La catapulta si puede atacar unidades aliadas y no lanza error.
    void catapultaAtacaUnidadAliada() throws CasilleroOcupadoException, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CurarException, UnidadNulaException, NoPuedeAtacarException {
        Jugador jugador = new Jugador();
        Tablero tablero = new Tablero(jugador,jugador);
        tablero.crearUnidad(jugador,1,1,"catapulta");
        tablero.crearUnidad(jugador,9,9,"soldado");
        tablero.atacar(1,1,9,9,jugador);

    }

    @Test
        // Atacar unidad enemiga en territorio aliado genera mas danio.
    void unidadAtacaMasFuerte() throws CasilleroOcupadoException, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CurarException, UnidadNulaException, NoPuedeAtacarException, MovimientoInvalidoException {
        Jugador jugador = new Jugador();
        Jugador jugador1 = new Jugador();
        Tablero tablero = new Tablero(jugador,jugador1);
        tablero.crearUnidad(jugador,1,1,"catapulta");
        tablero.crearUnidad(jugador1,11,11,"soldado");

        tablero.moverUnidad(11,11,10,10,jugador1);
        tablero.moverUnidad(10,10,9,9,jugador1);

        tablero.atacar(1,1,9,9,jugador);
        ArrayList unidades = jugador1.getUnidadesDisponibles();
        Soldado unidad = (Soldado) unidades.get(0);
        Assertions.assertEquals(79,unidad.getVidaUnidad());
    }
}

