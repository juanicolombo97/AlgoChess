import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


// Prueba el correcto funcionamiento de los metodos de la  clase Catapulta.

public class CatapultaTest {

    @Test
        //Pruebo que la catapulta este viva al crearla.
    void catapultaRecienCreadaEstaViva() {
        Catapulta catapulta = new Catapulta(0,0);
        Assertions.assertEquals(true,catapulta.estaVivo());
    }

    @Test
        // La catapulta no puede ser curada
    void catapultaNoPuedeSerCurada() throws CurarException {
        Catapulta catapulta = new Catapulta(0,0);
        try {
            catapulta.curarse(10);
        }catch (CurarException e){
            Assertions.assertEquals("La catapulta no puede ser curada",e.getMessage());
        }
    }
    @Test
        // La catapulta no puede atacar de cerca.
    void catapultaNoAtacaDeCerca(){
        Catapulta catapulta = new Catapulta(0,0);
        try {
            catapulta.atacarDistanciaCerca(catapulta);
        } catch (NoPuedeAtacarException e) {
            Assertions.assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }
    }
    @Test
        // La catapulta no puede atacar a distancia media.
    void catapultaNoAtacarADistanciaMedia(){
        Catapulta catapulta = new Catapulta(0,0);
        try {
            catapulta.atacarDistanciaMediana(catapulta);
        } catch (NoPuedeAtacarException e) {
            Assertions.assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }
    }
    @Test
        // La catapulta ataca correctamente de lejos.
    void catapultaAtacaCorrectamenteDeLejos() throws NoPuedeAtacarException {
        Catapulta catapulta = new Catapulta(0, 0);
        catapulta.atacarDistanciaLejana(catapulta);
        Assertions.assertEquals(30,catapulta.getVidaUnidad());
    }
}

