import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//Pruebas para el correcto funcionamiento de los metodos de Curandero.
class CuranderoTest {

    @Test
        //Curandero recien creado esta vivo
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

