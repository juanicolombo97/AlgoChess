package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.juego.*;
import fiuba.algo3.algochess.Modelo.unidades.EmisarioNulo;
import fiuba.algo3.algochess.Modelo.unidades.Soldado;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JugadorTest {

    @Test
    public void jugadorRecienCreadoCuentaNoTieneUnidades(){
        Jugador jugador = new Jugador("Juani");
        Assertions.assertEquals(0,jugador.getUnidadesDisponibles().size());
    }

    @Test
    public void jugadorPuedeCrearUnidad() {
        Jugador jugador = new Jugador("juani");
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion);
        List<Casillero> lista = new ArrayList<>();
        lista.add(casillero);
        jugador.setCasillerosDeJugador(lista);
        Unidad unidad = jugador.crearUnidad(casillero,"soldado",posicion, new EmisarioNulo());
    }

    @Test
    public void jugadorAtacaCorrectamenteUnidad() {
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion = new Posicion(2,2);
        Distancia distancia = new Distancia(1,1);
        Jugador jugador = new Jugador("juani");


        Casillero casillero = new Casillero(posicion);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Puntos puntos = new Puntos(20);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        jugador.getUnidadesDisponibles().add(soldado);
        Soldado soldado1 = new Soldado(puntos,posicion1, new EmisarioNulo());
        jugador.atacar(soldado,soldado1,casillero,tablero,distancia);
    }
}
