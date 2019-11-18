import Excepciones.CurarException;
import Excepciones.MovimientoInvalidoException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas para el correcto funcionamiento de los metodos de Curandero.
class CuranderoTest {

    @Test
        //El curandero puede curar de cerca y cura correctamente.

    void curanderoPuedeCurarDeCerca() throws CurarException, NoPuedeAtacarException, UnidadNulaException {
        Curandero curandero = new Curandero(1,1);
        curandero.atacarDistanciaCerca(curandero, 0);
        Assertions.assertEquals(90,curandero.getVidaUnidad());
    }

    @Test
        //El curandero no puede curar a distancia media
    void curanderoNoPuedeCurarDistanciaMedia() throws CurarException{
        Curandero curandero = new Curandero(1,1);
        try {
            curandero.atacarDistanciaMediana(curandero, 0);
        } catch (CurarException | NoPuedeAtacarException e) {
            Assertions.assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }
    @Test
        //El curandero no puede curar a distancia lejana
    void curanderoNoPuedeCurarDistanciaLejana() throws CurarException{
        Curandero curandero = new Curandero(1,1);
        try {
            curandero.atacarDistanciaLejana(curandero, 0);
        } catch (CurarException | NoPuedeAtacarException e) {
            Assertions.assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }

    @Test
        // Curandero se puede mover de a un casillero
    void moverUnCuranderoNoTiraError() throws UnidadNulaException, MovimientoInvalidoException {
        Curandero curandero = new Curandero(1,1);
        curandero.moverUnidad(2,2);
    }

    @Test
        // Curandero no se puede mover mas de un casillero
    void movimientoInvalidoCurandero(){
        Curandero curandero = new Curandero(1,1);
        try {
            curandero.moverUnidad(3,2);
        } catch (MovimientoInvalidoException | UnidadNulaException e) {
            Assertions.assertEquals("La unidad solo se mueve de a un casillero",e.getMessage());
        }
    }
}

