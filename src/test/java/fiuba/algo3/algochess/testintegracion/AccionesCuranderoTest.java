package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.AccionJugador;
import fiuba.algo3.algochess.Catapulta;
import fiuba.algo3.algochess.Curandero;
import fiuba.algo3.algochess.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccionesCuranderoTest {

    @Test
        //fiuba.algochess.Curandero cura a soldado a distancia cercana
    void curanderoCuraSoldado() throws Exception {
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(1,1);
        AccionJugador accion = new AccionJugador();

        // fiuba.algochess.Curandero cura a fiuba.algochess.Soldado.
        accion.accionNueva(curandero, soldado);

        // Curacion curandero: 15 ---  Vida soldado: 100 // VidaFinalSoldado: 115
        assertEquals(115, soldado.getVidaUnidad());
    }
    @Test
        //fiuba.algochess.Curandero no puede curar a soldado a distancia media
    void curanderoNoCuraUnidadMediaDistancia(){
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(4,4);
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(curandero,soldado);
        } catch (CurarException | NoPuedeAtacarException e) {
            assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }
    @Test
        //fiuba.algochess.Curandero no puede curar a soldado a distancia lejana
    void curanderoNoCuraUnidadLejanaDistancia(){
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(7,7);
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(curandero,soldado);
        } catch (CurarException | NoPuedeAtacarException e) {
            assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }
    @Test
        //El curandero no puede curar a la catapulta.
    void noPuedeCurarALaCatapulta(){
        Catapulta catapulta = new Catapulta(1,1);
        Curandero curandero = new Curandero(2,2);
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(curandero,catapulta);
        } catch (CurarException | NoPuedeAtacarException e) {
            assertEquals("La catapulta no puede ser curada",e.getMessage());
        }
    }

}

