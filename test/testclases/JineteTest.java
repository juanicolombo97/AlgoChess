import excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas realizadas a la clase Soldado.

class JineteTest {

    @Test
    void getCosto() throws Exception{
      Jinete jinete = new Jinete();
      Assertions.assertEquals(3,jinete.getCosto());
    }

    @Test
    void getVida() throws  Exception{
        Jinete jinete = new Jinete();
        Assertions.assertEquals(100,jinete.getVida());
    }

    @Test
    void getDanio() throws Exception{
        Jinete jinete = new Jinete();
        Assertions.assertEquals(5,jinete.getDanio());
    }

    @Test
    void getDanioDist() throws NoPuedeAtacarException {
        Jinete jinete = new Jinete();
        Assertions.assertEquals(15,jinete.getDanioDist());
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