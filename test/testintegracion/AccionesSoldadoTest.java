import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AccionesSoldadoTest {


        // Prueba de Soldado ataca Curandero.
    @Test
    //Prueba con ataque de cerca.
    void soldadoAtacaUnidadDeCerca() throws Exception {
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(1,1);
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(soldado,curandero);
        //Compruebo que el curandero se le halla restado la vida correctamente.
        assertEquals(65,curandero.getVidaUnidad());
    }
    @Test
        //Prueba con ataque de distancia media.
    void soldadoAtacaUnidadDeDistanciaMedia() throws Exception {
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(4,4);
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(soldado,curandero);
        }catch (NoPuedeAtacarException e){
            assertEquals("El soldado solo ataca distancia cercana",e.getMessage());
        }
    }
    @Test
        //Prueba con ataque de distancia lejana.
    void soldadoAtacaUnidadDeDistanciaLejana() throws Exception {
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(7,7);
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(soldado,curandero);
        }catch (NoPuedeAtacarException e){
            assertEquals("El soldado solo ataca distancia cercana",e.getMessage());
        }
    }


}

