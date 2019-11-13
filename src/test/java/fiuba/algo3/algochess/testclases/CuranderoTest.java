package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Curandero;
import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas para el correcto funcionamiento de los metodos de fiuba.algochess.Curandero.
class CuranderoTest {

    @Test
        //fiuba.algochess.Curandero recien creado esta vivo
    void curanderoRecienCreadoEstaVivo(){
        Curandero curandero = new Curandero(1,1);
        Assertions.assertEquals(true,curandero.estaVivo());
    }
    @Test
        //El curandero puede curar de cerca y cura correctamente.

    void curanderoPuedeCurarDeCerca() throws CurarException, NoPuedeAtacarException {
        Curandero curandero = new Curandero(1,1);
        curandero.atacarDistanciaCerca(curandero);
        Assertions.assertEquals(90,curandero.getVidaUnidad());
    }

    @Test
        //El curandero no puede curar a distancia media
    void curanderoNoPuedeCurarDistanciaMedia() throws CurarException{
        Curandero curandero = new Curandero(1,1);
        try {
            curandero.atacarDistanciaMediana(curandero);
        } catch (CurarException | NoPuedeAtacarException e) {
            Assertions.assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }
    @Test
        //El curandero no puede curar a distancia lejana
    void curanderoNoPuedeCurarDistanciaLejana() throws CurarException{
        Curandero curandero = new Curandero(1,1);
        try {
            curandero.atacarDistanciaLejana(curandero);
        } catch (CurarException | NoPuedeAtacarException e) {
            Assertions.assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }

}

