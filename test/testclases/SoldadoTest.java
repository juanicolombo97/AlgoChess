import excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas realizadas a la clase Soldado.

class SoldadoTest {

    @Test
    void getCosto() throws Exception{
        Soldado soldado = new Soldado();
        Assertions.assertEquals(1,soldado.getCosto());
    }

    @Test
    void getVida() throws  Exception{
        Soldado soldado1 = new Soldado();
        Assertions.assertEquals(100,soldado1.getVida());
    }

    @Test
    void getDanio() throws Exception{
        Soldado soldado2 = new Soldado();
        Assertions.assertEquals(10,soldado2.getDanio());
    }

    @Test
    void getDanioDist() throws NoPuedeAtacarException {
        Soldado solda3 = new Soldado();
        try {
            solda3.getDanio();
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El soldado solo ataca cuerpo a cuerpo",e.getMessage());
        }
    }

    @Test
        // Le saco vida al soldado.
    void sacarVida() throws  Exception {
        Soldado solda4 = new Soldado();

        solda4.atacado(10);

        Assertions.assertEquals(90,solda4.getVida());
    }
    @Test
        // Lo curo al soldado.
    void sumarVida() throws Exception {
        Soldado solda5 = new Soldado();

        solda5.curar(10);

        Assertions.assertEquals(110,solda5.getVida());
    }
}