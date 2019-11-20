package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.acciones.AccionJugador;
import fiuba.algo3.algochess.unidades.Curandero;
import fiuba.algo3.algochess.unidades.Jinete;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccionesJineteTest {

    // Prueba de fiuba.algo3.algochess.unidades.Jinete ataca fiuba.algo3.algochess.unidades.Curandero.
    @Test
    //Prueba con ataque de cerca.
    public void jineteAtacaUnidadDeCerca() throws Exception {
        Jinete jinete = new Jinete(1,1);
        Curandero curandero = new Curandero(1,1);
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(jinete,curandero, 0.05);
        //Compruebo que el curandero se le halla restado la vida correctamente.
        assertEquals(69.75,curandero.getVidaUnidad());
    }
    @Test
        //Prueba con ataque de distancia media.
    public void jineteAtacaUnidadDeDistanciaMedia() throws Exception {
        Jinete jinete = new Jinete(1,1);
        Curandero curandero = new Curandero(3,4);
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(jinete,curandero, 0.05);
        //Compruebo que el curandero se le halla restado la vida correctamente.
        assertEquals(59.25,curandero.getVidaUnidad());
    }
    @Test
        //Prueba con ataque de distancia lejana.
    public void jineteAtacaUnidadDeDistanciaLejana() throws Exception {
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
