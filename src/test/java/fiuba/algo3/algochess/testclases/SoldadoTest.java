package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.unidades.EmisarioNulo;
import fiuba.algo3.algochess.Modelo.unidades.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SoldadoTest {
    @Test
    public void soldadoRecienCreadoTieneVidaLlena() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        Assertions.assertEquals(100, soldado.getVidaUnidad());
    }

    @Test
    public void soldadoRecienCreadoCuestaLosPuntosCorrectos() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        Assertions.assertEquals(1, soldado.costoDeUnidad());
    }

    @Test
    public void soldadoRecibeDanioCorrectamente() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        soldado.recibirDanio(20);
        Assertions.assertEquals(80, soldado.getVidaUnidad());
    }
    @Test
    public void soldadoSeCuraCorrectamente() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        soldado.curarse(20);
        Assertions.assertEquals(120, soldado.getVidaUnidad());
    }
    @Test
    public void soldadoAtacaCorrectamenteADistanciaCercana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        Soldado soldado1 = new Soldado(puntos,posicion1, new EmisarioNulo());
        soldado.atacarDistanciaCerca(soldado1,false,tablero);
        Assertions.assertEquals(90,soldado1.getVidaUnidad());
    }
    @Test
    public void soldadoNoPuedeAtacarCorrectamenteADistanciaMediana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        Soldado soldado1 = new Soldado(puntos,posicion1, new EmisarioNulo());
        try {
           soldado.atacarDistanciaMediana(soldado1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El soldado solo ataca distancia cercana",e.getMessage());
        }

    }
    @Test
    public void soldadoeNoPuedeAtacarCorrectamenteADistanciaLejana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        Soldado soldado1 = new Soldado(puntos,posicion1, new EmisarioNulo());
        try {
            soldado.atacarDistanciaLejana(soldado1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El soldado solo ataca distancia cercana",e.getMessage());
        }
    }

    @Test
    public void soldadoNoPuedeAtacarCorrectamenteAUnidadAliada() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        Soldado soldado1 = new Soldado(puntos,posicion1, new EmisarioNulo());
        try {
            soldado.atacarDistanciaCerca(soldado1,true,tablero);
        }catch (UnidadInvalidaException e){
            Assertions.assertEquals("La unidad que quieres atacar es aliada",e.getMessage());
        }
    }

}
