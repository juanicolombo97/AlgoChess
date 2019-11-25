package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.acciones.AccionJugador;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.unidades.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccionesCuranderoTest {
    private Casillero[][] arrayCasillero;
    @Test
        //fiuba.algo3.algochess.unidades.Curandero cura a soldado a distancia cercana
    public void curanderoCuraSoldado() throws Exception {
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(1,1);
        AccionJugador accion = new AccionJugador();

        // fiuba.algo3.algochess.unidades.Curandero cura a fiuba.algo3.algochess.unidades.Soldado.
        accion.accionNueva(curandero, soldado, 0.05, arrayCasillero);

        // Curacion curandero: 15 ---  Vida soldado: 100 // VidaFinalSoldado: 115
        assertEquals(115, soldado.getVidaUnidad());
    }
    @Test
    // El curandero cura correctamente a un Jinete
    public void curanderoCuraJinete(){
        Jinete jinete = new Jinete(1, 1);
        Curandero curandero = new Curandero(2, 2);
        AccionJugador accion = new AccionJugador();
        accion.accionNueva(curandero, jinete, 0, arrayCasillero);
        Assertions.assertEquals(115, jinete.getVidaUnidad());
    }
    @Test
    // El curandero cura correctamente a un Jinete
    public void curanderoCuraJinete(){
        Curandero curandero1 = new Curandero(1, 1);
        Curandero curandero2 = new Curandero(2, 2);
        AccionJugador accion = new AccionJugador();
        accion.accionNueva(curandero1, curandero2, 0, arrayCasillero);
        Assertions.assertEquals(115, curandero2.getVidaUnidad());
    }
    @Test
        //fiuba.algo3.algochess.unidades.Curandero no puede curar a soldado a distancia media
    public void curanderoNoCuraUnidadMediaDistancia(){
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(4,4);
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(curandero,soldado, 0.05, arrayCasillero);
        } catch (CurarException | NoPuedeAtacarException | UnidadNulaException e) {
            assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }
    @Test
        //fiuba.algo3.algochess.unidades.Curandero no puede curar a soldado a distancia lejana
    public void curanderoNoCuraUnidadLejanaDistancia(){
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(7,7);
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(curandero,soldado, 0.05, arrayCasillero);
        } catch (CurarException | NoPuedeAtacarException | UnidadNulaException e) {
            assertEquals("El curandero solo puede curar a distancia cercana",e.getMessage());
        }
    }
    @Test
        //El curandero no puede curar a la catapulta.
    public void noPuedeCurarALaCatapulta(){
        Catapulta catapulta = new Catapulta(1,1);
        Curandero curandero = new Curandero(2,2);
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(curandero,catapulta, 0.05, arrayCasillero);
        } catch (CurarException | NoPuedeAtacarException | UnidadNulaException e) {
            assertEquals("La catapulta no puede ser curada",e.getMessage());
        }
    }
    @Test
        // El curandero no puede curar a una UnidadNula
    public void noPuedeCurarAUnidadNula(){
        UnidadNula unidadNula = new UnidadNula(1, 1);
        Curandero curandero = new Curandero(2, 2);
        AccionJugador accion = new AccionJugador();
        try {
            accion.accionNueva(curandero, unidadNula, 0, arrayCasillero);
        } catch(UnidadNulaException e) {
            assertEquals("No se encuentra una unidad", e.getMessage());
        }
    }
}

