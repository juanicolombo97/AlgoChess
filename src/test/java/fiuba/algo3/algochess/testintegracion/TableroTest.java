package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Tablero;
import fiuba.algo3.algochess.unidades.Soldado;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableroTest {

    @Test
        // Prueba que se inicializa el tablero y coloca pieza correctamente

    public void tableroNuevoAgregoUnidadCorrectamente() throws CasilleroOcupadoException, fiuba.algo3.algochess.excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroEnemigoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);
        //Creo la unidad y no lanza error.
        tablero.crearUnidad(jugador1,1,1,"soldado");
    }
    @Test
        // Prueba que se inicializa el tablero y coloca pieza cen casillero ocupado lanza error

    public void colocarPiezaEnCasilleroOcupadoLanzaError() throws fiuba.algo3.algochess.excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroEnemigoException, CasilleroOcupadoException {
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

    public void tableroNuevoAgregoUnidadPosicionEnemiga() throws CasilleroOcupadoException, fiuba.algo3.algochess.excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroEnemigoException {
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
    public void moverUnidadAPosicionVacia() throws CasilleroOcupadoException, fiuba.algo3.algochess.excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        //Creo las unidades
        tablero.crearUnidad(jugador1,1,1,"soldado");

        tablero.moverUnidad(1,1,2,2,jugador1);

    }

    @Test
        //Muevo unidad a posicion ocupada y  lanza error.
    public void moverUnidadAPosicionOcupada() throws CasilleroOcupadoException, fiuba.algo3.algochess.excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
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
    public void moverUnidadEnemigo() throws CasilleroOcupadoException, fiuba.algo3.algochess.excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, UnidadNulaException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        //Creo las unidades
        tablero.crearUnidad(jugador1,1,1,"soldado");
        try {
            tablero.moverUnidad(1,1,3,3,jugador2);
        }catch (fiuba.algo3.algochess.excepciones.UnidadInvalidaException e){
            Assertions.assertEquals("La unidad pertenece al enemigo",e.getMessage());
        }

    }

    @Test
    public void moverUnidadDistanciaIncorrecta() throws CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException,UnidadNulaException {
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
    public void moverCasilleroVacio() throws CasilleroOcupadoException, UnidadInvalidaException, MovimientoInvalidoException{
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        try {
            tablero.moverUnidad(1,1,2,2,jugador1);
        } catch (UnidadNulaException e) {
            Assertions.assertEquals("fiuba.algo3.algochess.unidades.Unidad invalida",e.getMessage());
        }

    }
    @Test
        //Prueba de ataque
    public void catapultaAtacaJineteADistancia() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);

        tablero.crearUnidad(jugador1,1,1,"catapulta");
        tablero.crearUnidad(jugador2,11,11,"soldado");
    }

    @Test
    public void unidadesCercanas() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException{
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1,jugador2);
        tablero.crearUnidad(jugador1,4,6,"soldado");
        tablero.crearUnidad(jugador2, 11, 11, "soldado");
        tablero.moverUnidad(11,11,10,10,jugador2);
        tablero.moverUnidad(10,10,9,9,jugador2);
        tablero.moverUnidad(9,9,8,8,jugador2);
        tablero.moverUnidad(8,8,7,7,jugador2);
        tablero.moverUnidad(7,7,6,6,jugador2);
        tablero.moverUnidad(6,6,5,5,jugador2);
        Soldado soldado = jugador1.getUnidadesDisponibles().get(1);
        tablero.unidadesCercanas(soldado);
    }
}
