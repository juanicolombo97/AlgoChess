package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.unidades.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas realizadas a la clase fiuba.algo3.algochess.unidades.Soldado.

class SoldadoTest {

    private Casillero[][] arrayCasillero;
    @Test
        //El soldado puede atacar de cerca.
    public void soldadoPuedeAtacarDeCerca() throws NoPuedeAtacarException, UnidadNulaException {
        Soldado soldado = new Soldado(1,1, new EmisarioNulo());
        soldado.atacarDistanciaCerca(soldado, 0, tablero);
        Assertions.assertEquals(90,soldado.getVidaUnidad());
    }
    @Test
        //El soldado no puede atacar a distancia media.
    public void soldadoNoPuedeAtacarDistanciaMedia() throws NoPuedeAtacarException {
        Soldado soldado = new Soldado(1, 1, new EmisarioNulo());
        try {
            soldado.atacarDistanciaLejana(soldado, 0, arrayCasillero);
        } catch (NoPuedeAtacarException e) {
            Assertions.assertEquals("El soldado solo ataca distancia cercana", e.getMessage());
        }
    }
    @Test
        //El soldado no puede atacar a distancia lejana.
    public void soldadoNoPuedeAtacarDistanciaLejana() throws NoPuedeAtacarException {
        Soldado soldado = new Soldado(1,1, new EmisarioNulo());
        try {
            soldado.atacarDistanciaLejana(soldado, 0, arrayCasillero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El soldado solo ataca distancia cercana",e.getMessage());
        }
    }
    @Test
        //El jinete se cura correctamente
    public void soldadoSeCuraCorrectamente() throws CurarException {
        Soldado soldado = new Soldado(1,1, new EmisarioNulo());
        soldado.curarse(30);
        Assertions.assertEquals(130,soldado.getVidaUnidad());
    }
    @Test
        // fiuba.algo3.algochess.unidades.Soldado se puede mover de a un casillero
    public void moverUnSoldadoNoTiraError() throws UnidadNulaException, MovimientoInvalidoException {
        Soldado soldado = new Soldado(1,1, new EmisarioNulo());
        soldado.moverUnidad(1,1);
    }

    @Test
        // fiuba.algo3.algochess.unidades.Soldado no se puede mover mas de un casillero
    public void movimientoInvalidoSoldado(){
        Soldado soldado = new Soldado(1,1, new EmisarioNulo());
        try {
            soldado.moverUnidad(3,2);
        } catch (MovimientoInvalidoException | UnidadNulaException e) {
            Assertions.assertEquals("La unidad solo se mueve de a un casillero",e.getMessage());
        }
    }
}

