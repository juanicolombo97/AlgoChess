import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas realizadas a la clase Soldado.

class SoldadoTest {

    @Test
        //Soldado recien creado esta vivo.
    void soldadoRecienCreadoEstaVivo(){
        Soldado soldado = new Soldado(1,1);
        Assertions.assertEquals(true,soldado.estaVivo());
    }
    @Test
        //El soldado puede atacar de cerca.
    void soldadoPuedeAtacarDeCerca() throws NoPuedeAtacarException {
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
}

