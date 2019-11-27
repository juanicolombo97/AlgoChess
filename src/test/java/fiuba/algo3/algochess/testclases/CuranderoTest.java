package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.unidades.Curandero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas para el correcto funcionamiento de los metodos de fiuba.algo3.algochess.unidades.Curandero.
class CuranderoTest {

    private Casillero[][] arrayCasillero;
    @Test
        //El curandero puede curar de cerca y cura correctamente.

    void curanderoPuedeCurarDeCerca() throws CurarException, NoPuedeAtacarException, UnidadNulaException {
        Curandero curandero = new Curandero(1,1, new EmisarioNulo());
        curandero.atacarDistanciaCerca(curandero, 0, tablero);
        Assertions.assertEquals(90,curandero.getVidaUnidad());
    }

    @Test
        //El curandero no puede curar a distancia media
    void curanderoNoPuedeCurarDistanciaMedia() throws CurarException{
        Curandero curandero = new Curandero(1,1, new EmisarioNulo());
        try {
            curandero.atacarDistanciaMediana(curandero, 0, tablero);
        } catch (CurarException | NoPuedeAtacarException e) {
            Assertions.assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }
    @Test
        //El curandero no puede curar a distancia lejana
    void curanderoNoPuedeCurarDistanciaLejana() throws CurarException{
        Curandero curandero = new Curandero(1,1, new EmisarioNulo());
        try {
            curandero.atacarDistanciaLejana(curandero, 0, arrayCasillero);
        } catch (CurarException | NoPuedeAtacarException e) {
            Assertions.assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }

    @Test
        // fiuba.algo3.algochess.unidades.Curandero se puede mover de a un casillero
    void moverUnCuranderoNoTiraError() throws UnidadNulaException, MovimientoInvalidoException {
        Curandero curandero = new Curandero(1,1, new EmisarioNulo());
        curandero.moverUnidad(1,1);
    }

    @Test
        // fiuba.algo3.algochess.unidades.Curandero no se puede mover mas de un casillero
    void movimientoInvalidoCurandero(){
        Curandero curandero = new Curandero(1,1, new EmisarioNulo());
        try {
            curandero.moverUnidad(3,2);
        } catch (MovimientoInvalidoException | UnidadNulaException e) {
            Assertions.assertEquals("La unidad solo se mueve de a un casillero",e.getMessage());
        }
    }
}

