package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.acciones.AccionJugador;
import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Distancia;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.unidades.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class AccionesTest {

    @Test
    public void seAtacaUnaUnidadADistanciaCercanaCorrectamente() throws NoAlcanzanLosPuntosException, UnidadNulaException, CasilleroVacioExcepcion, UnidadInvalidaException, CurarException, NoPuedeAtacarException, MovimientoInvalidoException {
        HashMap tablero = new HashMap();
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Distancia distancia = new Distancia(1,1);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        Soldado soldado1 = new Soldado(puntos,posicion, new EmisarioNulo());

        AccionJugador accion = new AccionJugador();
        accion.accionNueva(soldado,soldado1,tablero,false,distancia);

        Assertions.assertEquals(90, soldado1.getVidaUnidad());

    }
    @Test
    public void seAtacaUnaUnidadADistanciaMedianaCorrectamente() throws NoAlcanzanLosPuntosException, UnidadNulaException, CasilleroVacioExcepcion, UnidadInvalidaException, CurarException, NoPuedeAtacarException, MovimientoInvalidoException {
        HashMap tablero = new HashMap();
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Distancia distancia = new Distancia(3,3);
        Jinete jinete = new Jinete(puntos,posicion1, new EmisarioNulo());
        Soldado soldado1 = new Soldado(puntos,posicion, new EmisarioNulo());

        AccionJugador accion = new AccionJugador();
        accion.accionNueva(jinete,soldado1,tablero,false,distancia);

        Assertions.assertEquals(85, soldado1.getVidaUnidad());

    }
    @Test
    public void seAtacaUnaUnidadADistanciaLejanaCorrectamente() throws NoAlcanzanLosPuntosException, UnidadNulaException, CasilleroVacioExcepcion, UnidadInvalidaException, CurarException, NoPuedeAtacarException, MovimientoInvalidoException {
        HashMap tablero = new HashMap();
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(8,8);
        Distancia distancia = new Distancia(7,7);
        Catapulta catapulta = new Catapulta(puntos,posicion, new EmisarioNulo());
        Soldado soldado1 = new Soldado(puntos,posicion, new EmisarioNulo());

        AccionJugador accion = new AccionJugador();
        accion.accionNueva(catapulta,soldado1,tablero,false,distancia);

        Assertions.assertEquals(80, soldado1.getVidaUnidad());

    }

    @Test
    public void seCuraUnaUnidadADistanciaCercanaCorrectamente() throws NoAlcanzanLosPuntosException, UnidadNulaException, CasilleroVacioExcepcion, UnidadInvalidaException, CurarException, NoPuedeAtacarException, MovimientoInvalidoException {
        HashMap tablero = new HashMap();
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Distancia distancia = new Distancia(1,1);
        Curandero curandero = new Curandero(puntos,posicion, new EmisarioNulo());
        Soldado soldado1 = new Soldado(puntos,posicion, new EmisarioNulo());

        AccionJugador accion = new AccionJugador();
        accion.accionNueva(curandero,soldado1,tablero,true,distancia);

        Assertions.assertEquals(115, soldado1.getVidaUnidad());

    }
}



