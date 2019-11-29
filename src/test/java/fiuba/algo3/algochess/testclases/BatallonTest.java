package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.juego.Tablero;
import fiuba.algo3.algochess.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BatallonTest {

    @Test
    void pruebasBatallonCatapultaAtacaTodasUnidades() throws CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CurarException, UnidadNulaException, NoPuedeAtacarException, CasilleroVacioExcepcion {
        Jugador jugador1 = new Jugador("juan");
        Jugador jugador2 = new Jugador("pedro");
        // Establezco posiciones de los soldados aliados
        Posicion posicionSoldado1 = new Posicion(1, 1);
        Posicion posicionSoldado2 = new Posicion(2, 1);
        Posicion posicionSoldado3 = new Posicion(3, 1);
        Posicion posicionSoldado4 = new Posicion(4, 1);
        Posicion posicionSoldado5 = new Posicion(5, 1);
        Tablero tablero = new Tablero(jugador1, jugador2);
        // Creo los soldados aliados
        tablero.crearUnidad(jugador1, posicionSoldado1, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado2, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado3, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado4, "soldado");
        tablero.crearUnidad(jugador1, posicionSoldado5, "soldado");
        // Establezco posicion de catapulta enemiga y la creo
        Posicion posicionCatapulta = new Posicion(19, 19);
        tablero.crearUnidad(jugador2, posicionCatapulta, "catapulta");
        // Ataco a los soldados con la catapulta
        tablero.atacar(posicionCatapulta, posicionSoldado2, jugador2);
        // Verifico que se le saca vida a todas las unidades del batallon
        ArrayList listaUnidades = jugador1.getUnidadesDisponibles();

        for (Object unidadActual : listaUnidades) {
            Unidad unidad = (Unidad) unidadActual;
            Assertions.assertEquals(80, unidad.getVidaUnidad());
        }
    }
}