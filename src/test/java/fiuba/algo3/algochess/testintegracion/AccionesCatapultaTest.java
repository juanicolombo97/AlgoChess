package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.AccionJugador;
import fiuba.algo3.algochess.Catapulta;
import fiuba.algo3.algochess.Curandero;
import fiuba.algo3.algochess.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccionesCatapultaTest {
    // Prueba de fiuba.algochess.Catapulta atacando soldado.

    @Test
    //Prueba con ataque de cerca.
    void catapultaAtacaDeCerca() throws Exception {
        Soldado soldado = new Soldado(1,1);
        Catapulta catapulta = new Catapulta(1,1);
        AccionJugador accion = new AccionJugador();
        try {
            accion.accionNueva(catapulta,soldado);
        }catch (NoPuedeAtacarException e){
            assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }

    }
    @Test
    //Prueba con ataque distancia media.
    void catapultaAtacaDeDistanciaMedia() throws Exception {
        Soldado soldado = new Soldado(1,1);
        Catapulta catapulta = new Catapulta(4,4);
        AccionJugador accion = new AccionJugador();
        try {
            accion.accionNueva(catapulta,soldado);
        }catch (NoPuedeAtacarException e){
            assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }

    }
    @Test
        //Prueba con ataque de distancia lejana.
    void catapultaAtacaUnidadDeDistanciaLejana() throws Exception {
        Curandero curandero = new Curandero(9,7);
        Catapulta catapulta = new Catapulta(1,1);
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(catapulta,curandero);
        assertEquals(55,curandero.getVidaUnidad());
    }


}
