import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//Pruebas para el correcto funcionamiento de los metodos de Curandero.
class CuranderoTest {

    @Test
        // Devuelve el costo de la unidad correctamente.
    void getCosto() {
        Curandero curandero = new Curandero();
        assertEquals(2,curandero.getCosto());
    }

    @Test
        // Devuelve la vida de la unidad correctamente.
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
        // Los curanderos no tienen danio entonces no pueden curar.
    void getDanioDist() throws NoPuedeAtacarException {
        Curandero curandero = new Curandero();
        try {
            curandero.getDanio();
        }catch (NoPuedeAtacarException e){
            assertEquals("El curandero no puede atacar.",e.getMessage());
        }
    }

    @Test
        // Se modifica correctamente la vida del curandero al recibir danio.
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
    @Test
        // Prueba que si la unidad llega a 0 de vida esta muerta.
    void matarUnidad(){
        Curandero curandero = new Curandero();
        curandero.recibirDanio(100);
        Assertions.assertEquals(false,curandero.estaVivo());
    }
}