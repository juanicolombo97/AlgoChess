package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.juego.Puntos;
import fiuba.algo3.algochess.unidades.Jinete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class JineteTest {

    @Test
    public void jineteRecienCreadoTieneVidaLlena() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Jinete jinete = new Jinete(puntos,posicion);
        Assertions.assertEquals(100, jinete.getVidaUnidad());
    }

    @Test
    public void jineteRecienCreadoCuestaLosPuntosCorrectos() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Jinete jinete = new Jinete(puntos,posicion);
        Assertions.assertEquals(3, jinete.cuantoCuesta());
    }

    @Test
    public void jineteRecibeDanioCorrectamente() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Jinete jinete = new Jinete(puntos,posicion);
        jinete.recibirDanio(20);
        Assertions.assertEquals(80, jinete.getVidaUnidad());
    }
    @Test
    public void jineteSeCuraCorrectamente() throws NoAlcanzanLosPuntosException, CurarException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Jinete jinete = new Jinete(puntos,posicion);
        jinete.curarse(20);
        Assertions.assertEquals(120, jinete.getVidaUnidad());
    }
    @Test
    public void jineteAtacaCorrectamenteADistanciaCercana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Jinete jinete = new Jinete(puntos,posicion);
        Jinete jinete1 = new Jinete(puntos,posicion1);
        jinete.atacarDistanciaCerca(jinete1,false,tablero);
        Assertions.assertEquals(95,jinete1.getVidaUnidad());
    }
    @Test
    public void jineteAtacaCorrectamenteADistanciaMediana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Jinete jinete = new Jinete(puntos,posicion);
        Jinete jinete1 = new Jinete(puntos,posicion1);
        jinete.atacarDistanciaMediana(jinete1,false,tablero);
        Assertions.assertEquals(85,jinete1.getVidaUnidad());
    }
    @Test
    public void jineteNoPuedeAtacarCorrectamenteADistanciaLejana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Jinete jinete = new Jinete(puntos,posicion);
        Jinete jinete1 = new Jinete(puntos,posicion1);
        try {
            jinete.atacarDistanciaLejana(jinete1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete arquero no puede atacar a distancias lejanas",e.getMessage());
        }
    }

    @Test
    public void jineteNoPuedeAtacarCorrectamenteAUnidadAliada() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Jinete jinete = new Jinete(puntos,posicion);
        Jinete jinete1 = new Jinete(puntos,posicion1);
        try {
            jinete.atacarDistanciaMediana(jinete1,true,tablero);
        }catch (UnidadInvalidaException e){
            Assertions.assertEquals("La unidad que quieres atacar es aliada",e.getMessage());
        }
    }


}
