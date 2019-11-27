package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.juego.Puntos;
import fiuba.algo3.algochess.unidades.Curandero;
import fiuba.algo3.algochess.unidades.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class CuranderoTest {

    @Test
    public void curanderoRecienCreadoTieneVidaLlena() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Curandero curandero = new Curandero(puntos,posicion);
        Assertions.assertEquals(75, curandero.getVidaUnidad());
    }

    @Test
    public void curanderoRecienCreadoCuestaLosPuntosCorrectos() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Curandero curandero = new Curandero(puntos,posicion);
        Assertions.assertEquals(2, curandero.cuantoCuesta());
    }

    @Test
    public void curanderoRecibeDanioCorrectamente() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Curandero curandero = new Curandero(puntos,posicion);
        curandero.recibirDanio(20);
        Assertions.assertEquals(55, curandero.getVidaUnidad());
    }
    @Test
    public void curanderoSeCuraCorrectamente() throws NoAlcanzanLosPuntosException, CurarException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Curandero curandero = new Curandero(puntos,posicion);
        curandero.curarse(20);
        Assertions.assertEquals(95, curandero.getVidaUnidad());
    }
    @Test
    public void curanderoCuraCorrectamenteADistanciaCercana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException, CurarException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Curandero curandero = new Curandero(puntos,posicion);
        Curandero curandero1 = new Curandero(puntos,posicion1);
        curandero.atacarDistanciaCerca(curandero1,false,tablero);
        Assertions.assertEquals(90,curandero1.getVidaUnidad());
    }
    @Test
    public void curanderoNoPuedeAtacarCorrectamenteADistanciaMediana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Curandero curandero = new Curandero(puntos,posicion);
        Curandero curandero1 = new Curandero(puntos,posicion1);
        try {
            curandero.atacarDistanciaMediana(curandero1,false,tablero);
        }catch (NoPuedeAtacarException | CurarException e){
            Assertions.assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }

    }
    @Test
    public void curanderoNoPuedeAtacarCorrectamenteADistanciaLejana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Curandero curandero = new Curandero(puntos,posicion);
        Curandero curandero1 = new Curandero(puntos,posicion1);
        try {
            curandero.atacarDistanciaLejana(curandero1,false,tablero);
        }catch (NoPuedeAtacarException | CurarException e){
            Assertions.assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }

}
