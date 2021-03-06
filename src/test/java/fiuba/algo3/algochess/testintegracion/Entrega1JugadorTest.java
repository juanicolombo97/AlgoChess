package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Entrega1JugadorTest {

    @Test
    public void jugadorNoPuedeCrearMasUnidadesQuePuntosDisponibles() {
        Jugador jugador = new Jugador("Juani");
        Jugador jugador1 = new Jugador("Juani");
        Tablero tablero = new Tablero(jugador,jugador1);

        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(1,12);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(1,4);
        Posicion posicion4 = new Posicion(1,5);

        tablero.crearUnidad(jugador,posicion,"catapulta");
        tablero.crearUnidad(jugador,posicion1,"catapulta");
        tablero.crearUnidad(jugador,posicion2,"catapulta");
        try {
            tablero.crearUnidad(jugador,posicion3,"catapulta");
        }catch (JugadorSeQuedoSinPuntosException e){
            Assertions.assertEquals("Te haz quedado sin puntos",e.getMessage());
        }
    }

    @Test
    public void jugadorRecienCreadoAlNoTenerUnidadesSeLoConsideraPerdedor(){
        Jugador jugador = new Jugador("Juani");
        Assertions.assertEquals(0, jugador.getUnidadesDisponibles().size());
    }
}
