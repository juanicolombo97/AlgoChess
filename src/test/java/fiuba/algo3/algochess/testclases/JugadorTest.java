package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.*;
import fiuba.algo3.algochess.Modelo.unidades.EmisarioNulo;
import fiuba.algo3.algochess.Modelo.unidades.Soldado;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class JugadorTest {

    @Test
    public void jugadorRecienCreadoCuentaNoTieneUnidades(){
        Jugador jugador = new Jugador("Juani");
        Assertions.assertEquals(0,jugador.getUnidadesDisponibles().size());
    }

    @Test
    public void jugadorPuedeCrearUnidad() throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException, MovimientoInvalidoException, CasilleroVacioExcepcion {
        Jugador jugador = new Jugador("juani");
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion,true, jugador);
        jugador.agregarCasillero(casillero);
        Unidad unidad = jugador.crearUnidad(casillero,"soldado",posicion, new EmisarioNulo());


    }

    @Test
    public void jugadorAtacaCorrectamenteUnidad() throws NoAlcanzanLosPuntosException, CasilleroOcupadoException, UnidadInvalidaException, UnidadNulaException, CasilleroVacioExcepcion, CurarException, NoPuedeAtacarException, MovimientoInvalidoException {
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion = new Posicion(2,2);
        Distancia distancia = new Distancia(1,1);
        Jugador jugador = new Jugador("juani");
        Casillero casillero = new Casillero(posicion,true, jugador);
        HashMap tablero = new HashMap();
        Puntos puntos = new Puntos(20);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        Soldado soldado1 = new Soldado(puntos,posicion1, new EmisarioNulo());
        jugador.atacar(soldado,soldado1,casillero,tablero,distancia);
    }
}
