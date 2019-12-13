package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.JugadorPerdioException;
import fiuba.algo3.algochess.Modelo.excepciones.JugadorSeQuedoSinPuntosException;

import java.util.concurrent.atomic.AtomicBoolean;

public class EstadoJuegoEnemigo implements EstadoJuego {

    private Jugador jugador;
    private Jugador jugadorEnemigo;

    public EstadoJuegoEnemigo(Jugador jugador, Jugador jugadorEnemigo) {
        this.jugador = jugador;
        this.jugadorEnemigo = jugadorEnemigo;

    }
    @Override
    public EstadoJuego crearUnidad(Tablero tablero, String nombreUnidad, Posicion posicion ) {
        try {
            tablero.crearUnidad(jugador,posicion,nombreUnidad);
            jugador.puedeSeguirColocandoFichas();
        }catch (JugadorSeQuedoSinPuntosException e){
            return new EstadoJuegoAliado(jugadorEnemigo,jugador);
        }

        return this;

    }

    @Override
    public EstadoJuego mover(Posicion posicionInicial, Posicion posicionFinal, Tablero tablero) {
        tablero.moverUnidad(posicionInicial,posicionFinal,jugador);
        return new EstadoJuegoAliado(jugadorEnemigo,jugador);
    }
    @Override
    public EstadoJuego atacar(Posicion posicionAtancate, Posicion posicionAtacado, Tablero tablero) {
        try {
            tablero.atacar(posicionAtancate,posicionAtacado,jugador);
            jugadorEnemigo.actualizarUnidadesDisponibles();
            jugadorEnemigo.verificarSiPuedeSeguirJugando();
            return new EstadoJuegoAliado(jugadorEnemigo,jugador);
        }catch (JugadorPerdioException e){
            throw new JugadorPerdioException("Felicitaciones " + jugadorActual().getNombreJugador() + " has ganado");
        }

    }

    @Override
    public Jugador jugadorActual() {
        return jugador;
    }

    @Override
    public EstadoJuego cambiarTurno() {
        return new EstadoJuegoAliado(jugadorEnemigo,jugador);
    }
}
