package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.TurnoJugadorException;

public class FaseJuego implements Fase{
    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;
    private Tablero tablero;
    private Juego juego;

    public FaseJuego(Jugador jugador1, Jugador jugador2, Tablero tablero, Juego juego){
        this.jugadorActual = jugador1;
        this.jugadorSiguiente = jugador2;
        this.tablero = tablero;
        this.juego = juego;
    }

    @Override
    public void cambiarTurno(){
        Jugador auxiliar = jugadorActual;
        this.jugadorActual = jugadorSiguiente;
        this.jugadorSiguiente = auxiliar;
    }

    @Override
    public void crearUnidad(Jugador jugador, Posicion posicion, String nombreUnidad){}

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
