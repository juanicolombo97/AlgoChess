package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.*;
import fiuba.algo3.algochess.unidades.Soldado;
import fiuba.algo3.algochess.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;

public class JugadorTest {

    @Test
    public void jugadorRecienCreadoCuentaNoTieneUnidades(){
        Jugador jugador = new Jugador("Juani");
        Assertions.assertEquals(0,jugador.getUnidadesDisponibles().size());
    }

    @Test
    public void jugadorPuedeCrearUnidad() throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException {
        Jugador jugador = new Jugador("juani");
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion);
        jugador.agregarCasillero(casillero);
        Unidad unidad = jugador.crearUnidad(casillero,"soldado",posicion);


    }

    @Test
    public void jugadorAtacaCorrectamenteUnidad() throws NoAlcanzanLosPuntosException, CasilleroOcupadoException, UnidadInvalidaException, UnidadNulaException, CasilleroVacioExcepcion, CurarException, NoPuedeAtacarException {
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion = new Posicion(2,2);
        Distancia distancia = new Distancia(1,1);
        Casillero casillero = new Casillero(posicion);
        Jugador jugador = new Jugador("juani");
        HashMap tablero = new HashMap();
        Puntos puntos = new Puntos(20);
        Soldado soldado = new Soldado(puntos,posicion);
        Soldado soldado1 = new Soldado(puntos,posicion1);
        jugador.atacar(soldado,soldado1,casillero,tablero,distancia);
    }
}
