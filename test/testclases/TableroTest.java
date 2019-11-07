import Excepciones.CasilleroEnemigoException;
import Excepciones.CasilleroOcupadoExcenption;
import Excepciones.NoAlcanzanLosPuntosException;
import excepciones.UnidadInvalidaException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class TableroTest {

    @Test
    //Se crea tablero y ocloca pieza en sector aliado correctamente.
    public void creoTableroCorrectamentey() throws NoAlcanzanLosPuntosException, excepciones.UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoExcenption {
        Jugador jugador1 = new Jugador("juani");
        Jugador jugador2 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador1,jugador2);
        tablero.crearUnidad(jugador1,"soldado",1,1);
        Assertions.assertEquals("soldado", tablero.getUnidad(1,1).getNombre());
    }

    @Test
    // El secto del 1-10 pertenece al primer jugador.
    //Insertar pieza en 11-11 del jugador uno debe generar error.
    public void agregarUnidadASectorEnemigoLanzaError() throws CasilleroOcupadoExcenption, UnidadInvalidaException {
        Jugador jugador1 = new Jugador("juani");
        Jugador jugador2 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador1,jugador2);

        try {
            tablero.crearUnidad(jugador1,"soldado",11,11);
        } catch (NoAlcanzanLosPuntosException e) {
            e.printStackTrace();
        } catch (CasilleroEnemigoException e) {
           Assertions.assertEquals("Este casillero pertence al enemigo",e.getMessage());
        }
    }
    @Test
    public void seVerificaQuePiezaAliadaEnCasilleroOcupadoLanzaError() throws CasilleroOcupadoExcenption, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException {
        Jugador jugador1 = new Jugador("juani");
        Jugador jugador2 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador1,jugador2);
        tablero.crearUnidad(jugador1,"soldado",1,1);
        try{
            tablero.crearUnidad(jugador1,"soldado",1,1);
        }catch (CasilleroOcupadoExcenption e){
            Assertions.assertEquals("El casillero esta ocupado",e.getMessage());
        }
    }

    @Test
    //una unidad se puede mover en todas las dirrecciones
    public void moverUnidadTodasDirrecciones() throws CasilleroOcupadoExcenption, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException {
        Jugador jugador1 = new Jugador("juani");
        Jugador jugador2 = new Jugador("carlos");
        Tablero tablero = new Tablero(jugador1, jugador2);
        tablero.crearUnidad(jugador1, "soldado", 5, 5);

        //Mover la unidad no lanza error salvo que se mueva a un casillero ocupado.
        tablero.moverUnidad(5, 5, 4, 4);
        tablero.moverUnidad(4, 4, 3, 3);
        tablero.moverUnidad(3, 3, 2, 3);
        tablero.moverUnidad(2, 3, 1, 1);
        tablero.moverUnidad(1, 1, 5, 5);
        tablero.moverUnidad(5, 5, 4, 4);

        Assertions.assertEquals("soldado", tablero.getUnidad(4, 4).getNombre());
    }
}