package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Jinete;
import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas realizadas a la clase fiuba.algochess.Soldado.

class JineteTest {

    @Test
        //fiuba.algochess.Jinete recien creado esta vivo.
    void JineteRecienCreadoEstaVivo(){
        Jinete jinete = new Jinete(1,1);
        Assertions.assertEquals(true,jinete.estaVivo());
    }
    @Test
        //El jinete puede atacar de cerca.
    void jinetePuedeAtacarDeCerca() throws NoPuedeAtacarException {
        Jinete jinete = new Jinete(1,1);
        jinete.atacarDistanciaCerca(jinete);
        Assertions.assertEquals(95,jinete.getVidaUnidad());
    }
    @Test
        //El jinete puede atacar a distancia media.
    void jinetePuedeAtacarDistanciaMediana() throws NoPuedeAtacarException {
        Jinete jinete = new Jinete(1,1);
        jinete.atacarDistanciaMediana(jinete);
        Assertions.assertEquals(85,jinete.getVidaUnidad());
    }
    @Test
        //El jinete no puede atacar a distancia lejana.
    void jinetePuedeAtacarDistanciaLejana() throws NoPuedeAtacarException {
        Jinete jinete = new Jinete(1,1);
        try {
            jinete.atacarDistanciaLejana(jinete);
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
}

