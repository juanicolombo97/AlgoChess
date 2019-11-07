import Excepciones.CasilleroOcupadoExcenption;
import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasilleroTest {

    @Test
    void esta_vacio() {
        Casillero casillero = new Casillero();
        Assertions.assertEquals(true,casillero.esta_vacio());
    }

    @Test
    void mover_unidad_a() throws CasilleroOcupadoExcenption {
        Soldado soldado = new Soldado(1,1);
        Casillero casilleroorigen = new Casillero();
        Casillero casillerodestino = new Casillero();
        casilleroorigen.recibir_unidad(soldado);
        casilleroorigen.mover_unidad_a(casillerodestino);
        Assertions.assertEquals(true, casilleroorigen.esta_vacio());
        Assertions.assertEquals(false, casillerodestino.esta_vacio());
    }

    @Test
    void recibir_unidad() throws CasilleroOcupadoExcenption{
        Jinete jinete = new Jinete(1,1);
        Casillero casillero = new Casillero();
        casillero.recibir_unidad(jinete);
        Assertions.assertEquals(false, casillero.esta_vacio());
    }

    @Test
        // No se puede mover unidad a casillero ocupado.
    void noSeMueveUnidadACasilleroOcupado() throws CasilleroOcupadoExcenption {
        Soldado soldado = new Soldado(1,1);
        Casillero casilleroorigen = new Casillero();
        casilleroorigen.recibir_unidad(soldado);
        try {
            casilleroorigen.recibir_unidad(soldado);
        }catch (CasilleroOcupadoExcenption e){
            Assertions.assertEquals("El casillero esta ocupado",e.getMessage());
        }
    }
}