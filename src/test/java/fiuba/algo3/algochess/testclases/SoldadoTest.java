package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Direccion;
import fiuba.algo3.algochess.unidades.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Pruebas realizadas a la clase Soldado.

class SoldadoTest {

    @Test
        //El soldado puede atacar de cerca.
    void soldadoPuedeAtacarDeCerca() throws NoPuedeAtacarException, UnidadNulaException {
        Soldado soldado = new Soldado(1,1);
        soldado.atacarDistanciaCerca(soldado);
        Assertions.assertEquals(90,soldado.getVidaUnidad());
    }
    @Test
        //El soldado no puede atacar a distancia media.
    void soldadoNoPuedeAtacarDistanciaMedia() throws NoPuedeAtacarException {
        Soldado soldado = new Soldado(1, 1);
        try {
            soldado.atacarDistanciaLejana(soldado);
        } catch (NoPuedeAtacarException e) {
            Assertions.assertEquals("El soldado solo ataca distancia cercana", e.getMessage());
        }
    }
    @Test
        //El soldado no puede atacar a distancia lejana.
    void soldadoNoPuedeAtacarDistanciaLejana() throws NoPuedeAtacarException {
        Soldado soldado = new Soldado(1,1);
        try {
            soldado.atacarDistanciaLejana(soldado);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El soldado solo ataca distancia cercana",e.getMessage());
        }
    }
    @Test
        //El jinete se cura correctamente
    void soldadoSeCuraCorrectamente() throws CurarException {
        Soldado soldado = new Soldado(1,1);
        soldado.curarse(30);
        Assertions.assertEquals(130,soldado.getVidaUnidad());
    }
    @Test
        // Soldado se puede mover de a un casillero
    void moverUnSoldadoNoTiraError() throws UnidadNulaException, MovimientoInvalidoException {
        Soldado soldado = new Soldado(1,1);
        Direccion direccion= new Direccion("noreste");
        soldado.moverUnidad(direccion);
    }

    /*@Test
        // Soldado no se puede mover mas de un casillero
    void movimientoInvalidoSoldado(){
        Soldado soldado = new Soldado(1,1);
        try {
            soldado.moverUnidad(3,2);
        } catch (MovimientoInvalidoException | UnidadNulaException e) {
            Assertions.assertEquals("La unidad solo se mueve de a un casillero",e.getMessage());
        }
    }*/
}

