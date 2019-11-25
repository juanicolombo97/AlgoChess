package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.unidades.Catapulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


// Prueba el correcto funcionamiento de los metodos de la  clase fiuba.algo3.algochess.unidades.Catapulta.

public class CatapultaTest {

    private Casillero[][] arrayCasillero;

    @Test
        // La catapulta no puede ser curada
    public void catapultaNoPuedeSerCurada() throws CurarException {
        Catapulta catapulta = new Catapulta(0,0);
        try {
            catapulta.curarse(10);
        }catch (CurarException e){
            Assertions.assertEquals("La catapulta no puede ser curada",e.getMessage());
        }
    }
    @Test
        // La catapulta no puede atacar de cerca.
    public void catapultaNoAtacaDeCerca(){
        Catapulta catapulta = new Catapulta(0,0);
        try {
            catapulta.atacarDistanciaCerca(catapulta, 0);
        } catch (NoPuedeAtacarException e) {
            Assertions.assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }
    }
    @Test
        // La catapulta no puede atacar a distancia media.
    public void catapultaNoAtacarADistanciaMedia(){
        Catapulta catapulta = new Catapulta(0,0);
        try {
            catapulta.atacarDistanciaMediana(catapulta, 0);
        } catch (NoPuedeAtacarException e) {
            Assertions.assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }
    }
    @Test
        // La catapulta ataca de manera exitosa a distancia larga.
    public void catapultaAtacaADistanciaLarga() throws NoPuedeAtacarException, UnidadNulaException {
        Catapulta catapulta = new Catapulta(1, 1);
        Catapulta catapultaEnemiga = new Catapulta(19,19);
        catapulta.atacarDistanciaLejana(catapultaEnemiga, 0,arrayCasillero);
        Assertions.assertEquals(30, catapultaEnemiga.getVidaUnidad());
    }

    @Test
        // Verifico que la cataputa no se puede mover

    public void catapultaNoSePuedeMover(){
        Catapulta catapulta = new Catapulta(0, 0);
        try {
            catapulta.moverUnidad(1,1);
        } catch (MovimientoInvalidoException | UnidadNulaException e) {
            Assertions.assertEquals("La catapulta no se puede mover",e.getMessage());
        }
    }
}

