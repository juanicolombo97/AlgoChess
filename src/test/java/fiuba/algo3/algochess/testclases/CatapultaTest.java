package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.unidades.Catapulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class CatapultaTest {

    @Test
    public void catapultaRecienCreadoTieneVidaLlena() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Catapulta catapulta = new Catapulta(puntos,posicion);
        Assertions.assertEquals(50, catapulta.getVidaUnidad());
    }

    @Test
    public void catapultaRecienCreadoCuestaLosPuntosCorrectos() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Catapulta catapulta = new Catapulta(puntos,posicion);
        Assertions.assertEquals(5, catapulta.cuantoCuesta());
    }

    @Test
    public void catapultaRecibeDanioCorrectamente() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Catapulta catapulta = new Catapulta(puntos,posicion);
        catapulta.recibirDanio(20);
        Assertions.assertEquals(30, catapulta.getVidaUnidad());
    }
    @Test
    public void catapultaNoSePuedeCurarCorrectamente() throws NoAlcanzanLosPuntosException, CurarException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Catapulta catapulta = new Catapulta(puntos,posicion);
        try {
            catapulta.curarse(20);
        }catch (CurarException e){
            Assertions.assertEquals("La catapulta no puede ser curada",e.getMessage());
        }

    }
    @Test
    public void catapultaNoPuedeAtacarDistanciaCercana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException, CurarException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Catapulta catapulta = new Catapulta(puntos,posicion);
        Catapulta catapulta1 = new Catapulta(puntos,posicion);
        try {
            catapulta.atacarDistanciaCerca(catapulta1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }
    }
    @Test
    public void catapultaNoPuedeAtacarCorrectamenteADistanciaMediana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Catapulta catapulta = new Catapulta(puntos,posicion);
        Catapulta catapulta1 = new Catapulta(puntos,posicion);
        try {
            catapulta.atacarDistanciaMediana(catapulta1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }

    }
    @Test
    public void catapultaPuedeAtacarCorrectamenteADistanciaLejana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException, CasilleroVacioExcepcion {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Catapulta catapulta = new Catapulta(puntos,posicion);
        Catapulta catapulta1 = new Catapulta(puntos,posicion);
        catapulta.atacarDistanciaLejana(catapulta1,false,tablero);
        Assertions.assertEquals(30,catapulta1.getVidaUnidad());
    }
    @Test
    public void catapultaPuedeAtacarUnidadAliada() throws CasilleroVacioExcepcion, UnidadNulaException, NoPuedeAtacarException, NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Catapulta catapulta = new Catapulta(puntos,posicion);
        Catapulta catapulta1 = new Catapulta(puntos,posicion);
        catapulta.atacarDistanciaLejana(catapulta1,true,tablero);
        Assertions.assertEquals(30,catapulta1.getVidaUnidad());
    }
}
