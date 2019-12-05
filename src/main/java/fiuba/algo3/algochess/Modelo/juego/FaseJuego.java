package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.FaseCreacionUnidadesFinalizoException;
import fiuba.algo3.algochess.Modelo.excepciones.TurnoJugadorException;

public class FaseJuego implements Fase{
    private Jugador jugadorActual;
    private Tablero tablero;
    private Juego juego;

    public FaseJuego(Jugador jugador, Tablero tablero, Juego juego){
        this.jugadorActual = jugador;
        this.tablero = tablero;
        this.juego = juego;
    }

    @Override
    public void cambiarTurno(){
        this.jugadorActual.cambiarTurno();
    }

    @Override
    public void cambiarJugadorActual(Jugador jugador){
        this.jugadorActual = jugador;
    }

    @Override
    public void crearUnidad(Jugador jugador, Posicion posicion, String nombreUnidad){
        throw new FaseCreacionUnidadesFinalizoException("La fase de creación de unidades ya finalizó");
    }

    @Override
    public void realizarAtaque(Posicion posicionAtacante, Posicion posicionAtacado, Jugador jugador){
        if (jugadorActual == jugador){
            tablero.atacar(posicionAtacante, posicionAtacado, jugador);
        } else {
            throw new TurnoJugadorException("Es el turno del otro jugador");
        }
        this.cambiarTurno();
    }

    @Override
    public void realizarMovimiento(Posicion posicionInicial, Posicion posicionFinal, Jugador jugador){
        if (jugadorActual == jugador){
            tablero.moverUnidad(posicionInicial, posicionFinal, jugador);
        } else {
            throw new TurnoJugadorException("Es el turno del otro jugador");
        }
        this.cambiarTurno();
    }
}
