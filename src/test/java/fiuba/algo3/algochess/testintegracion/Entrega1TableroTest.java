package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Entrega1TableroTest {

    @Test
    public void seColocaPiezaAliadaEnSectorAliadaVaciaConExito() {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("juani");
        Tablero tablero = new Tablero(jugador,jugador1);
        Posicion posicion = new Posicion(1,1);
        tablero.crearUnidad(jugador,posicion,"soldado");

    }
    @Test
    public void noSeColocaPiezaAliadaEnSectorAliadaOcupada() {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("juani");
        Tablero tablero = new Tablero(jugador,jugador1);
        Posicion posicion = new Posicion(1,1);
        tablero.crearUnidad(jugador,posicion,"soldado");
        try {
            tablero.crearUnidad(jugador,posicion,"jinete");
        }catch (CasilleroOcupadoException e){
            Assertions.assertEquals("El casillero se encuentra ocupado",e.getMessage());
        }
    }

    @Test
    public void seColocaPiezaAliadaEnSectorEnemigoSinExito() {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("juani");
        Tablero tablero = new Tablero(jugador,jugador1);
        Posicion posicion = new Posicion(10,10);
        try {
            tablero.crearUnidad(jugador,posicion,"soldado");
        }catch (CasilleroEnemigoException e){
            Assertions.assertEquals("El casillero pertenece al enemigo",e.getMessage());
        }

    }
    @Test
    public void seModificanPuntosJugadorCorrectamenteConSoldado() {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("juani");
        Tablero tablero = new Tablero(jugador,jugador1);
        Posicion posicion = new Posicion(10,10);
        tablero.crearUnidad(jugador1,posicion,"soldado");

        Assertions.assertEquals(19,jugador1.getPuntosDisponibles());
    }
    @Test
    public void seModificanPuntosJugadorCorrectamenteConSJinete() {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("juani");
        Tablero tablero = new Tablero(jugador,jugador1);
        Posicion posicion = new Posicion(10,10);
        tablero.crearUnidad(jugador1,posicion,"jinete");

        Assertions.assertEquals(17,jugador1.getPuntosDisponibles());
    }
    @Test
    public void seModificanPuntosJugadorCorrectamenteConCatapulta() {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("juani");
        Tablero tablero = new Tablero(jugador,jugador1);
        Posicion posicion = new Posicion(10,10);
        tablero.crearUnidad(jugador1,posicion,"catapulta");

        Assertions.assertEquals(15,jugador1.getPuntosDisponibles());
    }
    @Test
    public void seModificanPuntosJugadorCorrectamenteConCurandero() {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("juani");
        Tablero tablero = new Tablero(jugador,jugador1);
        Posicion posicion = new Posicion(10,10);
        tablero.crearUnidad(jugador1,posicion,"curandero");

        Assertions.assertEquals(18,jugador1.getPuntosDisponibles());
    }
}
