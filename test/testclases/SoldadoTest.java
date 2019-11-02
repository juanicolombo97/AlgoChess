import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas realizadas a la clase Soldado.
// Las clases Jinete y catapulta no se prueban ya que tienen las mismas funciones que Soldado.
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
    void getDanioDist() throws Exception{
        Soldado solda3 = new Soldado();
        Assertions.assertEquals(0,solda3.getDanioDist());
    }

    @Test
        // Le saco vida al soldado.
    void sacarVida() throws  Exception {
        Soldado solda4 = new Soldado();

        solda4.modificarVida(-10);

        Assertions.assertEquals(90,solda4.getVida());
    }
    @Test
        // Lo curo al soldado.
    void sumarVida() throws Exception {
        Soldado solda5 = new Soldado();

        solda5.modificarVida(10);

        Assertions.assertEquals(110,solda5.getVida());
    }
}