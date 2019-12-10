package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.JugadorPerdioException;
import fiuba.algo3.algochess.Modelo.excepciones.JugadorSeQuedoSinPuntosException;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

public class EstadoJuegoAliado implements EstadoJuego {

    private Jugador jugador;
    private Jugador jugadorEnemigo;
    public EstadoJuegoAliado(Jugador jugadorAliado, Jugador jugadorEnemigo) {
        jugador = jugadorAliado;
        this.jugadorEnemigo = jugadorEnemigo;
    }

    @Override
    public EstadoJuego crearUnidad(Tablero tablero, String nombreUnidad, Posicion posicion) {
        try {
            tablero.crearUnidad(jugador,posicion,nombreUnidad);
        }catch (JugadorSeQuedoSinPuntosException e){
            return new EstadoJuegoEnemigo(jugadorEnemigo,jugador);
        }
        return this;
    }

    @Override
    public EstadoJuego mover(Posicion posicionInicial, Posicion posicionFinal, Tablero tablero) {
        tablero.moverUnidad(posicionInicial,posicionFinal,jugador);
        return new EstadoJuegoEnemigo(jugadorEnemigo,jugador);
    }

    @Override
    public EstadoJuego atacar(Posicion posicionAtancate, Posicion posicionAtacado, Tablero tablero) {
        jugador.puedeSeguirJugando();
        Casillero casilleroUnidad = tablero.atacar(posicionAtancate,posicionAtacado,jugador);
        Unidad unidaAtacada = casilleroUnidad.obtenerUnidad();
        jugadorEnemigo.actualizarVidaUnidad(unidaAtacada,casilleroUnidad);
        return new EstadoJuegoEnemigo(jugadorEnemigo,jugador);
    }
}
