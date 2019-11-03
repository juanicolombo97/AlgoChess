import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


// Prueba el correcto funcionamiento de los metodos de la  clase Catapulta.

public class CatapultaTest {

    @Test
        // Prueba que el costo de la Unidad es el correcto.
    void getCosto() {
        Catapulta catapulta = new Catapulta();
        Assertions.assertEquals(5,catapulta.getCosto());
    }

    @Test
        // Prueba que la vida sea la correcta.
    void getVida() {
        Catapulta catapulta = new Catapulta();
        Assertions.assertEquals(50,catapulta.getVida());
    }

    @Test
        //Prueba que la catapulta no puede atacar cuerpo a cuerpo.
    void getDanio() throws NoPuedeAtacarException{
        Catapulta catapulta = new Catapulta();
        try {
            catapulta.getDanio();
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("La catapulta no puede atacar cuerpo a cuerpo",e.getMessage());
        }
    }

    @Test
        // Prueba que la catapulta tiene el danio a distancia correcta.
    void getDanioDist() throws NoPuedeAtacarException {
        Catapulta catapulta = new Catapulta();
        Assertions.assertEquals(20,catapulta.getDanioDist());
    }

    @Test
        // Prueba que la catapulta recibe danio y se modifica correctamente su vida.
    void atacar() {
        Catapulta catapulta = new Catapulta();
        catapulta.recibirDanio(50);
        Assertions.assertEquals(0,catapulta.getVida());
    }

    @Test
        // Probamos que no se pueda curar a la catapulta.
    void curar() throws CurarCatapultaException {
        Catapulta catapulta = new Catapulta();
        try {
            catapulta.curarse(20);
        }catch (CurarCatapultaException e) {
            Assertions.assertEquals("No se puede curar a una catapulta", e.getMessage());
        }
    }
    @Test
        // Prueba que si la unidad llega a 0 de vida esta muerta.
    void matarUnidad(){
        Catapulta catapulta = new Catapulta();
        catapulta.recibirDanio(100);
        Assertions.assertEquals(false,catapulta.estaVivo());
    }
}

