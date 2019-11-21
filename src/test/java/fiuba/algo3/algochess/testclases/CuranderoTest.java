package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Direccion;
import fiuba.algo3.algochess.unidades.Curandero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Pruebas para el correcto funcionamiento de los metodos de Curandero.
class CuranderoTest {

    @Test
        //El curandero puede curar de cerca y cura correctamente.

    void curanderoPuedeCurarDeCerca() throws CurarException, NoPuedeAtacarException, UnidadNulaException {
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

    @Test
        // Curandero se puede mover de a un casillero
    void moverUnCuranderoNoTiraError() throws UnidadNulaException, MovimientoInvalidoException {
        Curandero curandero = new Curandero(1,1);
<<<<<<< HEAD
        Direccion direccion = new Direccion("norte");
        curandero.moverUnidad(direccion);
    }

    /*@Test
        // Curandero no se puede mover mas de un casillero
=======
        Direccion direccion = new Direccion(1, 1);
        curandero.moverUnidad(direccion);
    }
/*
    @Test
        // fiuba.algo3.algochess.unidades.Curandero no se puede mover mas de un casillero
>>>>>>> TableroRefactorDirectorios
    void movimientoInvalidoCurandero(){
        Curandero curandero = new Curandero(1,1);
        Direccion direccion = new Direccion(3, 2);
        try {
            curandero.moverUnidad(direccion);
        } catch (MovimientoInvalidoException | UnidadNulaException e) {
            Assertions.assertEquals("La unidad solo se mueve de a un casillero",e.getMessage());
        }
<<<<<<< HEAD
    }
    */
=======
    }POR NUEVA IMPLEMENTACIÓN DE DIRECCION NO HAY FORMA DE INICIALIZAR UNA DIRECCIÓN DE MOVIMIENTO INVÁLIDA*/
>>>>>>> TableroRefactorDirectorios
}

