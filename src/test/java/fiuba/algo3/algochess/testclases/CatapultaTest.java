package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.unidades.Catapulta;
import fiuba.algo3.algochess.Modelo.unidades.EmisarioNulo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class CatapultaTest {

    @Test
    public void catapultaRecienCreadoTieneVidaLlena() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Catapulta catapulta = new Catapulta(puntos,posicion, new EmisarioNulo());
        Assertions.assertEquals(50, catapulta.getVidaUnidad());
    }

    @Test
    public void catapultaRecienCreadoCuestaLosPuntosCorrectos() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Catapulta catapulta = new Catapulta(puntos,posicion, new EmisarioNulo());
        Assertions.assertEquals(5, catapulta.cuantoCuesta());
    }

    @Test
    public void catapultaRecibeDanioCorrectamente() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Catapulta catapulta = new Catapulta(puntos,posicion, new EmisarioNulo());
        catapulta.recibirDanio(20);
        Assertions.assertEquals(30, catapulta.getVidaUnidad());
    }
    @Test
    public void catapultaNoSePuedeCurarCorrectamente() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Catapulta catapulta = new Catapulta(puntos,posicion, new EmisarioNulo());
        try {
            catapulta.curarse(20);
        }catch (CurarException e){
            Assertions.assertEquals("La catapulta no puede ser curada",e.getMessage());
        }

    }
    @Test
    public void catapultaNoPuedeAtacarDistanciaCercana() {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Catapulta catapulta = new Catapulta(puntos,posicion, new EmisarioNulo());
        Catapulta catapulta1 = new Catapulta(puntos,posicion, new EmisarioNulo());
        try {
            catapulta.atacarDistanciaCerca(catapulta1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }
    }
    @Test
    public void catapultaNoPuedeAtacarCorrectamenteADistanciaMediana() {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Catapulta catapulta = new Catapulta(puntos,posicion, new EmisarioNulo());
        Catapulta catapulta1 = new Catapulta(puntos,posicion, new EmisarioNulo());
        try {
            catapulta.atacarDistanciaMediana(catapulta1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }

    }
    @Test
    public void catapultaPuedeAtacarCorrectamenteADistanciaLejana() {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Catapulta catapulta = new Catapulta(puntos,posicion, new EmisarioNulo());
        Catapulta catapulta1 = new Catapulta(puntos,posicion, new EmisarioNulo());
        catapulta.atacarDistanciaLejana(catapulta1,false,tablero);
        Assertions.assertEquals(30,catapulta1.getVidaUnidad());
    }
    @Test
    public void catapultaPuedeAtacarUnidadAliada() {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Catapulta catapulta = new Catapulta(puntos,posicion, new EmisarioNulo());
        Catapulta catapulta1 = new Catapulta(puntos,posicion, new EmisarioNulo());
        catapulta.atacarDistanciaLejana(catapulta1,true,tablero);
        Assertions.assertEquals(30,catapulta1.getVidaUnidad());
    }
}
