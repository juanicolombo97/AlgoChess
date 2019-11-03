import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuranderoTest {

    @Test
    void getCosto() {
        Curandero curandero = new Curandero();
        assertEquals(2,curandero.getCosto());
    }

    @Test
    void getVida() {
        Curandero curandero = new Curandero();
        assertEquals(75,curandero.getVida());
    }

    @Test
    // Los curanderos no tienen danio de ataque, entonces danio tiene que ser igual a 0.
    void getDanio() throws NoPuedeAtacarException{
        Curandero curandero = new Curandero();
        try {
            curandero.getDanio();
        }catch (NoPuedeAtacarException e){
            assertEquals("El curandero no puede atacar.",e.getMessage());
        }
    }

    @Test
    void getDanioDist() throws NoPuedeAtacarException {
        Curandero curandero = new Curandero();
        try {
            curandero.getDanio();
        }catch (NoPuedeAtacarException e){
            assertEquals("El curandero no puede atacar.",e.getMessage());
        }
    }

    @Test
    void modificarVida() {
        Curandero curandero = new Curandero();

        curandero.recibirDanio(30);
        assertEquals(45,curandero.getVida());
    }

    @Test
    // Auto curamos al curandero.
    void curar() throws CurarCatapultaException {
        Curandero curandero = new Curandero();
        curandero.curarse(curandero.getCuracion());
        assertEquals(90,curandero.getVida());
    }
}