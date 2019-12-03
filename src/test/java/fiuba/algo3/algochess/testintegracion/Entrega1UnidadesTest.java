package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.*;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Entrega1UnidadesTest {

    @Test
    public void unidadSePuedeMoverEnTodasLasDirecciones() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CasilleroVacioExcepcion, UnidadNulaException, MovimientoInvalidoException {
        Direccion direccion = new Direccion(0,0);
        ArrayList listaDirecciones = direccion.direccionesMovimiento();
        Jugador jugador = new Jugador("juani");
        Tablero tablero = new Tablero(jugador,jugador);
        Posicion posicion = new Posicion(2,2);
        tablero.crearUnidad(jugador,posicion,"soldado");

        for (int x = 0; x < listaDirecciones.size(); x++){
            Direccion direccion1 = (Direccion) listaDirecciones.get(x);
            Unidad unidad = jugador.getUnidadesDisponibles().get(0);
            Posicion posicion1 = unidad.getPosicion();
            tablero.moverUnidad(posicion1, posicion1.posicionNueva(direccion1),jugador);
        }

    }
    @Test
    public void unidadMovivleNoSePuedeMoverACasilleroOcupado() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, MovimientoInvalidoException, CasilleroVacioExcepcion {
        Direccion direccion = new Direccion(0,0);
        ArrayList listaDirecciones = direccion.direccionesMovimiento();
        Jugador jugador = new Jugador("juani");
        Tablero tablero = new Tablero(jugador,jugador);
        Posicion posicion = new Posicion(2,2);
        Posicion posicion1 = new Posicion(3,3);
        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador,posicion1,"soldado");
        try {
            tablero.moverUnidad(posicion1,posicion,jugador);
        }catch (CasilleroOcupadoException | UnidadNulaException | MovimientoInvalidoException | CasilleroVacioExcepcion e){
            Assertions.assertEquals("El casillero se encuentra ocupado",e.getMessage());
        }
    }
    @Test
    public void soldadoAtacaAUnidadEnemigaConExito() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, CasilleroVacioExcepcion, CurarException, NoPuedeAtacarException, MovimientoInvalidoException {
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("juan");
        Tablero tablero = new Tablero(jugador,jugador2);
        Posicion posicion = new Posicion(9,9);
        Posicion posicion2 = new Posicion(10,10);
        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador2,posicion2,"soldado");
        tablero.atacar(posicion2,posicion,jugador2);

        Unidad unidadAtacada = jugador.getUnidadesDisponibles().get(0);

        Assertions.assertEquals(90,unidadAtacada.getVidaUnidad());

    }
    @Test
    public void jineteAtacaAUnidadEnemigaConExito() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, CasilleroVacioExcepcion, CurarException, NoPuedeAtacarException, MovimientoInvalidoException {
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("juan");
        Tablero tablero = new Tablero(jugador,jugador2);
        Posicion posicion = new Posicion(9,9);
        Posicion posicion2 = new Posicion(13,13);
        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador2,posicion2,"jinete");
        tablero.atacar(posicion2,posicion,jugador2);

        Unidad unidadAtacada = jugador.getUnidadesDisponibles().get(0);

        Assertions.assertEquals(85,unidadAtacada.getVidaUnidad());

    }
    @Test
    public void catapultaAtacaAUnidadEnemigaConExito() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, CasilleroVacioExcepcion, CurarException, NoPuedeAtacarException, MovimientoInvalidoException {
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("juan");
        Tablero tablero = new Tablero(jugador,jugador2);
        Posicion posicion = new Posicion(9,9);
        Posicion posicion2 = new Posicion(15,15);
        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador2,posicion2,"catapulta");
        tablero.atacar(posicion2,posicion,jugador2);

        Unidad unidadAtacada = jugador.getUnidadesDisponibles().get(0);

        Assertions.assertEquals(80,unidadAtacada.getVidaUnidad());

    }
    @Test
    public void catapultaAtacaAUnidadAliadaConExito() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, CasilleroVacioExcepcion, CurarException, NoPuedeAtacarException, MovimientoInvalidoException {
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("juan");
        Tablero tablero = new Tablero(jugador,jugador2);
        Posicion posicion = new Posicion(10,10);
        Posicion posicion2 = new Posicion(17,17);
        tablero.crearUnidad(jugador2,posicion,"soldado");
        tablero.crearUnidad(jugador2,posicion2,"catapulta");
        tablero.atacar(posicion2,posicion,jugador2);

        Unidad unidadAtacada = jugador2.getUnidadesDisponibles().get(0);

        Assertions.assertEquals(80,unidadAtacada.getVidaUnidad());
    }


    @Test
    public void curanderoCuraPiezaAliadaConExito() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, CasilleroVacioExcepcion, CurarException, NoPuedeAtacarException, MovimientoInvalidoException {
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("juan");
        Tablero tablero = new Tablero(jugador,jugador2);
        Posicion posicion = new Posicion(11,11);
        Posicion posicion2 = new Posicion(10,10);
        tablero.crearUnidad(jugador2,posicion,"curandero");
        tablero.crearUnidad(jugador2,posicion2,"soldado");
        tablero.atacar(posicion,posicion2,jugador2);

        Unidad unidadAtacada = jugador2.getUnidadesDisponibles().get(1);

        Assertions.assertEquals(115,unidadAtacada.getVidaUnidad());
    }
    @Test
    public void curanderoNoCuraUnidadEnemiga() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, CasilleroVacioExcepcion, CurarException, NoPuedeAtacarException, MovimientoInvalidoException {
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("juan");
        Tablero tablero = new Tablero(jugador,jugador2);
        Posicion posicion = new Posicion(10,10);
        Posicion posicion2 = new Posicion(9,9);
        tablero.crearUnidad(jugador2,posicion,"curandero");
        tablero.crearUnidad(jugador,posicion2,"soldado");
        try {
            tablero.atacar(posicion,posicion2,jugador2);
        }catch (CurarException e){
            Assertions.assertEquals("No se puede curar un enemigo",e.getMessage());
        }


    }

}
