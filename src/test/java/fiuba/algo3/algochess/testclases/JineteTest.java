package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Direccion;
import fiuba.algo3.algochess.unidades.Jinete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Pruebas realizadas a la clase Soldado.

class JineteTest {

    @Test
        //El jinete puede atacar de cerca.
    void jinetePuedeAtacarDeCerca() throws NoPuedeAtacarException, UnidadNulaException {
        Jinete jinete = new Jinete(1,1);
        jinete.atacarDistanciaCerca(jinete, 0);
        Assertions.assertEquals(95,jinete.getVidaUnidad());
    }
    @Test
        //El jinete puede atacar a distancia media.
    void jinetePuedeAtacarDistanciaMediana() throws NoPuedeAtacarException, UnidadNulaException {
        Jinete jinete = new Jinete(1,1);
        jinete.atacarDistanciaMediana(jinete, 0);
        Assertions.assertEquals(85,jinete.getVidaUnidad());
    }
    @Test
        //El jinete no puede atacar a distancia lejana.
    void jinetePuedeAtacarDistanciaLejana() throws NoPuedeAtacarException {
        Jinete jinete = new Jinete(1,1);
        try {
            jinete.atacarDistanciaLejana(jinete, 0);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete no puede atacar distancias lejanas",e.getMessage());
        }
    }
    @Test
        //El jinete se cura correctamente
    void jineteSeCuraCorrectamente() throws CurarException {
        Jinete jinete = new Jinete(1,1);
        jinete.curarse(30);
        Assertions.assertEquals(130,jinete.getVidaUnidad());
    }
    @Test
        // Jinete se puede mover de a un casillero
    void moverUnJineteNoTiraError() throws UnidadNulaException, MovimientoInvalidoException {
        Jinete jinete = new Jinete(1,1);
        Direccion direccion = new Direccion(-1,-1);
        jinete.moverUnidad(direccion);
    }

    @Test
        // Jinete no se puede mover mas de un casillero
    void movimientoInvalidoJinete(){
        Jinete jinete = new Jinete(1,1);
        try {
            Direccion direccion = new Direccion(3,2);
            jinete.moverUnidad(direccion);
        } catch (MovimientoInvalidoException | UnidadNulaException e) {
            Assertions.assertEquals("La unidad solo se mueve de a un casillero",e.getMessage());
        }
    }
}


