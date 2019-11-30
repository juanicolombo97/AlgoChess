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

public class Entrega1TableroTests {

    @Test
    public void seColocaPiezaAliadaEnSectorAliadaVaciaConExito() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("juani");
        Tablero tablero = new Tablero(jugador,jugador1);
        Posicion posicion = new Posicion(1,1);
        tablero.crearUnidad(jugador,posicion,"soldado");

    }
    @Test
    public void noSeColocaPiezaAliadaEnSectorAliadaOcupada() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException {
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
    public void seColocaPiezaAliadaEnSectorEnemigoSinExito() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException {
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
}
