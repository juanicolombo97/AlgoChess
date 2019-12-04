package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.TurnoJugadorException;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {

    @Test
    public void comenzarJuego(){
        Jugador jugador1 = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
    }

    @Test
    public void elTurnoEsDelJugador1yNoDelJugador2(){
        Jugador jugador1 = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        try{
            Posicion posicion = new Posicion(10,11);
            juego.crearUnidad(jugador2, posicion, "soldado");
        } catch (TurnoJugadorException e){
            Assertions.assertEquals("Es el turno del otro jugador", e.getMessage());
        }
    }

    @Test
    public void crearUnidadesDeUnJugador(){
        Jugador jugador1 = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        Posicion posicionSoldado = new Posicion(9,1);
        Posicion posicionCurandero1 = new Posicion(7,2);
        Posicion posicionCurandero2 = new Posicion(7,1);
        Posicion posicionCatapulta = new Posicion(1,6);
        Posicion posicionCatapulta2 = new Posicion(4,6);
        Posicion posicionCatapulta3 = new Posicion(7,6);
        Posicion posicionSoldado2 = new Posicion(1,1);
        juego.crearUnidad(jugador1, posicionSoldado, "soldado");
        juego.crearUnidad(jugador1, posicionCurandero1, "curandero");
        juego.crearUnidad(jugador1, posicionCurandero2, "curandero");
        juego.crearUnidad(jugador1, posicionCatapulta, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta2, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta3, "catapulta");
        //Cuando se acaban los puntos de un jugador, pasa al turno del siguiente
        try {
            juego.crearUnidad(jugador1, posicionSoldado2, "soldado");
        } catch (TurnoJugadorException e){
            Assertions.assertEquals("Es el turno del otro jugador", e.getMessage());
        }
    }

    @Test
    public void crearUnidadesDeAmbosJugadores(){
        Jugador jugador1 = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        Posicion posicionSoldado = new Posicion(9,1);
        Posicion posicionCurandero1 = new Posicion(7,2);
        Posicion posicionCurandero2 = new Posicion(7,1);
        Posicion posicionCatapulta = new Posicion(1,6);
        Posicion posicionCatapulta2 = new Posicion(4,6);
        Posicion posicionCatapulta3 = new Posicion(7,6);
        juego.crearUnidad(jugador1, posicionSoldado, "soldado");
        juego.crearUnidad(jugador1, posicionCurandero1, "curandero");
        juego.crearUnidad(jugador1, posicionCurandero2, "curandero");
        juego.crearUnidad(jugador1, posicionCatapulta, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta2, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta3, "catapulta");
        Posicion posicionSoldadoEnemigo = new Posicion(11,1);
        Posicion posicionCuranderoEnemigo1 = new Posicion(13,2);
        Posicion posicionCuranderoEnemigo2 = new Posicion(13,1);
        Posicion posicionCatapultaEnemiga = new Posicion(20,6);
        Posicion posicionCatapultaEnemiga2 = new Posicion(20,6);
        Posicion posicionCatapultaEnemiga3 = new Posicion(20,6);
        Posicion posicionSoldadoEnemigo2 = new Posicion(20,20);
        juego.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo1, "curandero");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo2, "curandero");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga2, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga3, "catapulta");
        try {
            juego.crearUnidad(jugador2, posicionSoldadoEnemigo2, "soldado");
        } catch (TurnoJugadorException e){
            Assertions.assertEquals("Es el turno del otro jugador", e.getMessage());
        }
    }

}