package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.juego.Tablero;
import fiuba.algo3.algochess.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Entrega2SoldadoTests {

    @Test
    public void seVerificaQueTresSoldadosContiguosSeMuevenAlMismoTiempo() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CasilleroVacioExcepcion, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador,jugador1);

        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);

        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador,posicion2,"soldado");
        tablero.crearUnidad(jugador,posicion1,"soldado");

        tablero.moverUnidad(posicion2,posicion3,jugador);

        ArrayList listaUnidades = jugador.getUnidadesDisponibles();
        //Agarro la unidad en la posicion 0 , que es la que estaba en la pos 1,1.
        Unidad unidad = (Unidad) listaUnidades.get(0);
        Posicion posicionFinal = unidad.getPosicion();

        Assertions.assertEquals(posicion1,posicionFinal);

    }

    @Test
    public void teniendo3SoldadosYUnoObstruidoSeMuevenLosOtrosMenos1() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CasilleroVacioExcepcion, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador,jugador1);

        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(1,2);
        Posicion posicion4 = new Posicion(3,4);

        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador,posicion1,"soldado");
        tablero.crearUnidad(jugador,posicion2,"soldado");
        tablero.crearUnidad(jugador,posicion3,"catapulta");

        tablero.moverUnidad(posicion2,posicion4,jugador);

        ArrayList listaUnidades = jugador.getUnidadesDisponibles();
        //Agarro la unidad en la posicion 0 , que es la que estaba en la pos 1,1.
        Unidad unidad = (Unidad) listaUnidades.get(0);
        Unidad unidad1 = (Unidad) listaUnidades.get(1);
        Posicion posicion6 = unidad1.getPosicion();
        Posicion posicion5 = unidad.getPosicion();
        Posicion posicion7 = new Posicion(2,3);

        //La unidad obstruida se queda quieta y las otras se mueven
        boolean movimientoCorrecto = ((posicion5.equals(posicion)) && (posicion6.equals(posicion7)));

        Assertions.assertTrue(movimientoCorrecto);

    }
    @Test
    public void batallonSeDisuelveCorrectamenteAlDejarDeExistir() throws CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException, CasilleroVacioExcepcion, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador,jugador1);

        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(1,2);
        Posicion posicion4 = new Posicion(3,4);
        Posicion posicion5 = new Posicion(3,5);
        Posicion posicion6 = new Posicion(3,6);

        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador,posicion1,"soldado");
        tablero.crearUnidad(jugador,posicion2,"soldado");
        tablero.crearUnidad(jugador,posicion3,"catapulta");

        tablero.moverUnidad(posicion2,posicion4,jugador);
        tablero.moverUnidad(posicion4,posicion5,jugador);
        tablero.moverUnidad(posicion5,posicion6,jugador);

        ArrayList listaUnidades = jugador.getUnidadesDisponibles();
        //Agarro la unidad en la posicion 0 , que es la que estaba en la pos 1,1.
        Unidad unidad = (Unidad) listaUnidades.get(0);
        Unidad unidad1 = (Unidad) listaUnidades.get(1);
        Unidad unidad2 = (Unidad) listaUnidades.get(2);
        Posicion posicion7 = unidad1.getPosicion();
        Posicion posicion8 = unidad.getPosicion();
        Posicion posicion9 = unidad2.getPosicion();
        Posicion posicion10 = new Posicion(2,4);

        //La unidad obstruida se queda quieta y se disuelve el batallon, entonces solo se mueve la unidad2.
        boolean movimientoCorrecto = ((posicion8.equals(posicion)) && (posicion7.equals(posicion10)) && (posicion9.equals(posicion6)));

        Assertions.assertTrue(movimientoCorrecto);
    }

    @Test
    public void habiendo4SoldadosSoloSeMueven3() throws CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException, CasilleroVacioExcepcion, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador = new Jugador("juani");
        Jugador jugador1 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador,jugador1);

        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);
        Posicion posicion4 = new Posicion(5,5);

        tablero.crearUnidad(jugador,posicion,"soldado");
        tablero.crearUnidad(jugador,posicion1,"soldado");
        tablero.crearUnidad(jugador,posicion2,"soldado");
        tablero.crearUnidad(jugador,posicion3,"soldado");

        tablero.moverUnidad(posicion3,posicion4,jugador);

        ArrayList listaUnidades = jugador.getUnidadesDisponibles();

        Unidad unidadInmovil = (Unidad) listaUnidades.get(0);
        Unidad unidadMovil1 = (Unidad) listaUnidades.get(1);
        Unidad unidadMovil2= (Unidad) listaUnidades.get(2);
        Unidad unidadMovil3 = (Unidad) listaUnidades.get(3);

        boolean movimientoCorrecto1 = ((unidadInmovil.getPosicion().equals(posicion)) && (unidadMovil1.getPosicion().equals(posicion2)));

        boolean movimientoCorrecto2 = (unidadMovil2.getPosicion().equals(posicion3) && (unidadMovil3.getPosicion().equals(posicion4)));

        boolean movimientos = movimientoCorrecto1 && movimientoCorrecto2;
        Assertions.assertTrue(movimientos);
    }

}
