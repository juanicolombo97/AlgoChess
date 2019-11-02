import excepciones.CurarCatapultaException;
import excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


// Pruebas de la clase Catapulta.

public class CatapultaTest {

    @Test
    void getCosto() {
        Catapulta catapulta = new Catapulta();
        Assertions.assertEquals(5,catapulta.getCosto());
    }

    @Test
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
    void getDanioDist() throws NoPuedeAtacarException {
        Catapulta catapulta = new Catapulta();
        Assertions.assertEquals(20,catapulta.getDanioDist());
    }

    @Test
    void atacar() {
        Catapulta catapulta = new Catapulta();
        catapulta.atacado(50);
        Assertions.assertEquals(0,catapulta.getVida());
    }

    @Test
        // Auto curamos al curandero.
    void curar() throws CurarCatapultaException {
        Catapulta catapulta = new Catapulta();
        try {
            catapulta.curar(20);
        }catch (CurarCatapultaException e) {
            Assertions.assertEquals("No se puede curar a una catapulta", e.getMessage());
        }
    }
}

