import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CasilleroTest {

    @Test
    void esta_vacio() {
        Casillero casillero = new Casillero();
        Assertions.assertEquals(true,casillero.esta_vacio());
    }

    @Test
    void mover_unidad_a() {
    }

    @Test
    void recibir_unidad() {
    }
}