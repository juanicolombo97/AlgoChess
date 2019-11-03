import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas realizadas a la clase Soldado.

class SoldadoTest {

    @Test
        // Devuelve el costo correcto.
    void getCosto() throws Exception{
        Soldado soldado = new Soldado();
        Assertions.assertEquals(1,soldado.getCosto());
    }

    @Test
        // Devuelve la vida de la unidad.
    void getVida() throws  Exception{
        Soldado soldado1 = new Soldado();
        Assertions.assertEquals(100,soldado1.getVida());
    }

    @Test
        // Devuelve el danio a corta dista correcto.
    void getDanio() throws Exception{
        Soldado soldado2 = new Soldado();
        Assertions.assertEquals(10,soldado2.getDanio());
    }

    @Test
        // Tira error ya que el soldado no ataca a distancia.
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
        Soldado soldado = new Soldado();
        soldado.recibirDanio(100);
        Assertions.assertEquals(false,soldado.estaVivo());
    }
}