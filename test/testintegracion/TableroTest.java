import Excepciones.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TableroTest {

    @Test
        // Prueba que se inicializa el tablero y coloca pieza correctamente

    void tableroNuevoAgregoUnidadCorrectamente() throws CasilleroOcupadoExcenption, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroEnemigoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);
        //Creo la unidad y no lanza error.
        tablero.crearUnidad(jugador1,1,1,"soldado");
    }
    @Test
        // Prueba que se inicializa el tablero y coloca pieza cen casillero ocupado lanza error

    void colocarPiezaEnCasilleroOcupadoLanzaError() throws excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroEnemigoException, CasilleroOcupadoExcenption {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);
        //Creo la unidad y no lanza error.
        tablero.crearUnidad(jugador1,1,1,"soldado");
        try {
            tablero.crearUnidad(jugador1,1,1,"catapulta");
        }catch (CasilleroOcupadoExcenption e){
            Assertions.assertEquals("El casillero esta ocupado",e.getMessage());
        }
    }
    @Test
        // Prueba que se inicializa el tablero y coloca pieza en sector enemigo lanza excepcion

    void tableroNuevoAgregoUnidadPosicionEnemiga() throws CasilleroOcupadoExcenption, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroEnemigoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);
        //Creo la unidad y no lanza error.
        try {
            tablero.crearUnidad(jugador1,11,11,"soldado");
        }catch (CasilleroEnemigoException e){
            Assertions.assertEquals("El casillero pertenece al enemigo",e.getMessage());
        }

    }

    @Test
        //Muevo unidad a posicion vacia correctamente y no lanza error.
    void moverUnidadAPosicionVacia() throws CasilleroOcupadoExcenption, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        //Creo las unidades
        tablero.crearUnidad(jugador1,1,1,"soldado");

        tablero.moverUnidad(1,1,2,2,jugador1);

    }

    @Test
        //Muevo unidad a posicion ocupada y  lanza error.
    void moverUnidadAPosicionOcupada() throws CasilleroOcupadoExcenption, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        //Creo las unidades
        tablero.crearUnidad(jugador1,1,1,"soldado");
        tablero.crearUnidad(jugador1,3,3,"soldado");
        try {
            tablero.moverUnidad(1,1,3,3,jugador1);
        }catch (CasilleroOcupadoExcenption e){
            Assertions.assertEquals("El casillero esta ocupado",e.getMessage());
        }

    }

    @Test
        //Mover unidad enemigo lanza error
    void moverUnidadEnemigo() throws CasilleroOcupadoExcenption, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        //Creo las unidades
        tablero.crearUnidad(jugador1,1,1,"soldado");
        try {
            tablero.moverUnidad(1,1,3,3,jugador2);
        }catch (excepciones.UnidadInvalidaException e){
            Assertions.assertEquals("La unidad pertenece al enemigo",e.getMessage());
        }

    }

}
