import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccionesJineteTest {

    // Prueba de Jinete ataca Curandero.
    @Test
    //Prueba con ataque de cerca.
    void jineteAtacaUnidadDeCerca() throws Exception {
        Jinete jinete = new Jinete(1,1);
        Curandero curandero = new Curandero(1,1);
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(jinete,curandero, 0.05);
        //Compruebo que el curandero se le halla restado la vida correctamente.
        assertEquals(69.75,curandero.getVidaUnidad());
    }
    @Test
        //Prueba con ataque de distancia media.
    void jineteAtacaUnidadDeDistanciaMedia() throws Exception {
        Jinete jinete = new Jinete(1,1);
        Curandero curandero = new Curandero(3,4);
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(jinete,curandero, 0.05);
        //Compruebo que el curandero se le halla restado la vida correctamente.
        assertEquals(59.25,curandero.getVidaUnidad());
    }
    @Test
        //Prueba con ataque de distancia lejana.
    void jineteAtacaUnidadDeDistanciaLejana() throws Exception {
        Jinete jinete = new Jinete(1,1);
        Curandero curandero = new Curandero(7,7);
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(jinete,curandero, 0.05);
        }catch (NoPuedeAtacarException e){
            assertEquals("El jinete no puede atacar distancias lejanas",e.getMessage());
        }
    }

}
