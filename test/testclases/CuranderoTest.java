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
    void getDanio() {
        Curandero curandero = new Curandero();
        assertEquals(0,curandero.getDanio());
    }

    @Test
    void getDanioDist() {
        Curandero curandero = new Curandero();
        assertEquals(0,curandero.getDanioDist());
    }

    @Test
    void modificarVida() {
        Curandero curandero = new Curandero();

        curandero.modificarVida(-30);
        assertEquals(45,curandero.getVida());
    }

    @Test
    // Auto curamos al curandero.
    void curar() {
        Curandero curandero = new Curandero();
        curandero.modificarVida(curandero.curar());
        assertEquals(90,curandero.getVida());
    }
}