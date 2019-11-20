import Excepciones.CurarException;
import Excepciones.MovimientoInvalidoException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas realizadas a la clase Soldado.

class SoldadoTest {

    @Test
        //El soldado puede atacar de cerca.
    void soldadoPuedeAtacarDeCerca() throws NoPuedeAtacarException, UnidadNulaException {
        Soldado soldado = new Soldado(1,1);
        soldado.atacarDistanciaCerca(soldado, 0);
        Assertions.assertEquals(90,soldado.getVidaUnidad());
    }
    @Test
        //El soldado no puede atacar a distancia media.
    void soldadoNoPuedeAtacarDistanciaMedia() throws NoPuedeAtacarException {
        Soldado soldado = new Soldado(1, 1);
        try {
            soldado.atacarDistanciaLejana(soldado, 0);
        } catch (NoPuedeAtacarException e) {
            Assertions.assertEquals("El soldado solo ataca distancia cercana", e.getMessage());
        }
    }
    @Test
        //El soldado no puede atacar a distancia lejana.
    void soldadoNoPuedeAtacarDistanciaLejana() throws NoPuedeAtacarException {
        Soldado soldado = new Soldado(1,1);
        try {
            soldado.atacarDistanciaLejana(soldado, 0);
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
        soldado.moverUnidad(1,1);
    }

    @Test
        // Soldado no se puede mover mas de un casillero
    void movimientoInvalidoSoldado(){
        Soldado soldado = new Soldado(1,1);
        try {
            soldado.moverUnidad(3,2);
        } catch (MovimientoInvalidoException | UnidadNulaException e) {
            Assertions.assertEquals("La unidad solo se mueve de a un casillero",e.getMessage());
        }
    }
}

