import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas realizadas a la clase Soldado.

class JineteTest {

    @Test
        //Devuelve el costo correcto de la unidad.
    void getCosto() throws Exception{
      Jinete jinete = new Jinete();
      Assertions.assertEquals(3,jinete.getCosto());
    }

    @Test
        // Devuelve la vida correcta de la unidad.
    void getVida() throws  Exception{
        Jinete jinete = new Jinete();
        Assertions.assertEquals(100,jinete.getVida());
    }

    @Test
        // Devuelve el danio de la unidad correctamente
    void getDanio() throws Exception{
        Jinete jinete = new Jinete();
        Assertions.assertEquals(5,jinete.getDanio());
    }

    @Test
        // Devuelve correctamente el danio  a distancia correctamente.
    void getDanioDist() throws NoPuedeAtacarException {
        Jinete jinete = new Jinete();
        Assertions.assertEquals(15,jinete.getDanioDist());
    }

    @Test
        // Le saco vida al soldado.
    void sacarVida() throws  Exception {
        Soldado solda4 = new Soldado();

        solda4.recibirDanio(10);

        Assertions.assertEquals(90,solda4.getVida());
    }
    @Test
        // Lo curo al soldado.
    void sumarVida() throws Exception {
        Soldado solda5 = new Soldado();

        solda5.curarse(10);

        Assertions.assertEquals(110,solda5.getVida());
    }
    @Test
        // Prueba que si la unidad llega a 0 de vida esta muerta.
    void matarUnidad(){
        Jinete jinete = new Jinete();
        jinete.recibirDanio(100);
        Assertions.assertEquals(false,jinete.estaVivo());
    }
}