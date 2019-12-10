package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.unidades.Curandero;
import fiuba.algo3.algochess.Modelo.unidades.EmisarioNulo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CuranderoTest {

    @Test
    public void curanderoRecienCreadoTieneVidaLlena() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Curandero curandero = new Curandero(puntos,posicion, new EmisarioNulo());
        Assertions.assertEquals(75, curandero.getVidaUnidad());
    }

    @Test
    public void curanderoRecienCreadoCuestaLosPuntosCorrectos() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Curandero curandero = new Curandero(puntos,posicion, new EmisarioNulo());
        Assertions.assertEquals(2, curandero.cuantoCuesta());
    }

    @Test
    public void curanderoRecibeDanioCorrectamente() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Curandero curandero = new Curandero(puntos,posicion, new EmisarioNulo());
        curandero.recibirDanio(20);
        Assertions.assertEquals(55, curandero.getVidaUnidad());
    }
    @Test
    public void curanderoSeCuraCorrectamente() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Curandero curandero = new Curandero(puntos,posicion, new EmisarioNulo());
        curandero.curarse(20);
        Assertions.assertEquals(95, curandero.getVidaUnidad());
    }
    @Test
    public void curanderoCuraCorrectamenteADistanciaCercana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Curandero curandero = new Curandero(puntos,posicion, new EmisarioNulo());
        Curandero curandero1 = new Curandero(puntos,posicion1, new EmisarioNulo());
        curandero.atacarDistanciaCerca(curandero1,true,tablero);
        Assertions.assertEquals(90,curandero1.getVidaUnidad());
    }
    @Test
    public void curanderoNoPuedeAtacarCorrectamenteADistanciaMediana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Curandero curandero = new Curandero(puntos,posicion, new EmisarioNulo());
        Curandero curandero1 = new Curandero(puntos,posicion1, new EmisarioNulo());
        try {
            curandero.atacarDistanciaMediana(curandero1,false,tablero);
        }catch (NoPuedeAtacarException | CurarException e){
            Assertions.assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }

    }
    @Test
    public void curanderoNoPuedeAtacarCorrectamenteADistanciaLejana() {
        Puntos puntos = new Puntos(20);
        Map<Posicion, Casillero> tablero = new HashMap<>();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Curandero curandero = new Curandero(puntos,posicion, new EmisarioNulo());
        Curandero curandero1 = new Curandero(puntos,posicion1, new EmisarioNulo());
        try {
            curandero.atacarDistanciaLejana(curandero1,false,tablero);
        }catch (NoPuedeAtacarException | CurarException e){
            Assertions.assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }

}
