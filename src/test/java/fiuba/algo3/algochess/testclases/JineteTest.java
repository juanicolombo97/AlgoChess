package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.unidades.EmisarioNulo;
import fiuba.algo3.algochess.Modelo.unidades.Jinete;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class JineteTest {

    @Test
    public void jineteRecienCreadoTieneVidaLlena() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        Assertions.assertEquals(100, jinete.getVidaUnidad());
    }

    @Test
    public void jineteRecienCreadoCuestaLosPuntosCorrectos() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        Assertions.assertEquals(3, jinete.costoDeUnidad());
    }

    @Test
    public void jineteRecibeDanioCorrectamente() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        jinete.recibirDanio(20);
        Assertions.assertEquals(80, jinete.getVidaUnidad());
    }
    @Test
    public void jineteSeCuraCorrectamente() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        jinete.curarse(20);
        Assertions.assertEquals(120, jinete.getVidaUnidad());
    }
    @Test
    public void jineteEspadachinAtacaCorrectamenteADistanciaCercana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        jinete.setEstadoJinete("espadachin");
        Jinete jinete1 = new Jinete(puntos,posicion1, new EmisarioNulo());
        jinete.atacarDistanciaCerca(jinete1,false,tablero);
        Assertions.assertEquals(95,jinete1.getVidaUnidad());
    }

    @Test
    public void jineteEspadachinNoAtacaCorrectamenteADistanciaMediana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        jinete.setEstadoJinete("espadachin");
        Jinete jinete1 = new Jinete(puntos,posicion1, new EmisarioNulo());
        try{
            jinete.atacarDistanciaMediana(jinete1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assert.assertEquals("El jinete espadachin no puede atacar a distancias medianas",e.getMessage());
        }
    }

    @Test
    public void jineteEspadachinNoPuedeAtacarCorrectamenteADistanciaLejana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        jinete.setEstadoJinete("espadachin");
        Jinete jinete1 = new Jinete(puntos,posicion1, new EmisarioNulo());
        try {
            jinete.atacarDistanciaLejana(jinete1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete espadachin no puede atacar a distancias lejanas",e.getMessage());
        }
    }

    @Test
    public void jineteArqueroNoAtacaCorrectamenteADistanciaCercana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        jinete.setEstadoJinete("arquero");
        Jinete jinete1 = new Jinete(puntos,posicion1, new EmisarioNulo());
        try {
            jinete.atacarDistanciaCerca(jinete1, false, tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete arquero no puede atacar a distancias cortas",e.getMessage());
        }
    }

    @Test
    public void jineteArqueroAtacaCorrectamenteADistanciaMediana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        Jinete jinete1 = new Jinete(puntos,posicion1, new EmisarioNulo());
        jinete.setEstadoJinete("arquero");
        jinete.atacarDistanciaMediana(jinete1,false,tablero);
        Assertions.assertEquals(85,jinete1.getVidaUnidad());
    }
    @Test
    public void jineteArqueroNoPuedeAtacarCorrectamenteADistanciaLejana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        jinete.setEstadoJinete("arquero");
        Jinete jinete1 = new Jinete(puntos,posicion1, new EmisarioNulo());
        try {
            jinete.atacarDistanciaLejana(jinete1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete arquero no puede atacar a distancias lejanas",e.getMessage());
        }
    }

    @Test
    public void jineteArqueroNoPuedeAtacarCorrectamenteAUnidadAliada() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        jinete.setEstadoJinete("arquero");
        Jinete jinete1 = new Jinete(puntos,posicion1, new EmisarioNulo());
        try {
            jinete.atacarDistanciaMediana(jinete1,true,tablero);
        }catch (UnidadInvalidaException e){
            Assertions.assertEquals("La unidad que quieres atacar es aliada",e.getMessage());
        }
    }

    @Test
    public void jineteEspadachinNoPuedeAtacarCorrectamenteAUnidadAliada() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Jinete jinete = new Jinete(puntos,posicion, new EmisarioNulo());
        jinete.setEstadoJinete("espadachin");
        Jinete jinete1 = new Jinete(puntos,posicion1, new EmisarioNulo());
        try {
            jinete.atacarDistanciaMediana(jinete1,true,tablero);
        }catch (UnidadInvalidaException e){
            Assertions.assertEquals("La unidad que quieres atacar es aliada",e.getMessage());
        }
    }

}
