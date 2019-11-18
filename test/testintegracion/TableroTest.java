import Excepciones.*;
import excepciones.UnidadInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TableroTest {

    @Test
        // Prueba que se inicializa el tablero y coloca pieza correctamente

    void tableroNuevoAgregoUnidadCorrectamente() throws CasilleroOcupadoException, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroEnemigoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);
        //Creo la unidad y no lanza error.
        tablero.crearUnidad(jugador1,1,1,"soldado");
    }
    @Test
        // Prueba que se inicializa el tablero y coloca pieza cen casillero ocupado lanza error

    void colocarPiezaEnCasilleroOcupadoLanzaError() throws excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroEnemigoException, CasilleroOcupadoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);
        //Creo la unidad y no lanza error.
        tablero.crearUnidad(jugador1,1,1,"soldado");
        try {
            tablero.crearUnidad(jugador1,1,1,"catapulta");
        }catch (CasilleroOcupadoException e){
            Assertions.assertEquals("El casillero esta ocupado",e.getMessage());
        }
    }
    @Test
        // Prueba que se inicializa el tablero y coloca pieza en sector enemigo lanza excepcion

    void tableroNuevoAgregoUnidadPosicionEnemiga() throws CasilleroOcupadoException, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroEnemigoException {
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
    void moverUnidadAPosicionVacia() throws CasilleroOcupadoException, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        //Creo las unidades
        tablero.crearUnidad(jugador1,1,1,"soldado");

        tablero.moverUnidad(1,1,2,2,jugador1);

    }

    @Test
        //Muevo unidad a posicion ocupada y  lanza error.
    void moverUnidadAPosicionOcupada() throws CasilleroOcupadoException, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        //Creo las unidades
        tablero.crearUnidad(jugador1,1,1,"soldado");
        tablero.crearUnidad(jugador1,3,3,"soldado");
        try {
            tablero.moverUnidad(1,1,3,3,jugador1);
        }catch (CasilleroOcupadoException e){
            Assertions.assertEquals("El casillero esta ocupado",e.getMessage());
        }

    }

    @Test
        //Mover unidad enemigo lanza error
    void moverUnidadEnemigo() throws CasilleroOcupadoException, excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
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

    @Test
    void moverUnidadDistanciaIncorrecta() throws CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException,UnidadNulaException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        //Creo las unidades
        tablero.crearUnidad(jugador1,1,1,"soldado");
        try {
            tablero.moverUnidad(1,1,3,3,jugador1);
        }catch (MovimientoInvalidoException e){
            Assertions.assertEquals("La unidad solo se mueve de a un casillero",e.getMessage());
        }
    }

    @Test
    // Intentar mover una posicion vacia lanza error
    void moverCasilleroVacio() throws CasilleroOcupadoException, UnidadInvalidaException, MovimientoInvalidoException{
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        try {
            tablero.moverUnidad(1,1,2,2,jugador1);
        } catch (UnidadNulaException e) {
            Assertions.assertEquals("Unidad invalida",e.getMessage());
        }

    }
    @Test
        //Prueba de ataque
    void catapultaAtacaJineteADistancia() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        tablero.crearUnidad(jugador1,1,1,"Catapulta");
        tablero.crearUnidad(jugador2,11,11,"soldado");
    }

}
