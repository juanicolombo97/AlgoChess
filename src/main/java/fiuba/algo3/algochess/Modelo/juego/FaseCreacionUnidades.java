package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.TurnoJugadorException;

public class FaseCreacionUnidades implements Fase{
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;
    private Tablero tablero;
    private Juego juego;

    public FaseCreacionUnidades(Jugador jugador1, Jugador jugador2, Tablero tablero, Juego juego){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorActual = jugador1;
        this.jugadorSiguiente = jugador2;
        this.tablero = tablero;
        this.juego = juego;
    }

    @Override
    public void cambiarTurno(){
        if (todasLasUnidadesFueronCreadas()){
            juego.cambiarAFaseJuego();
        } else {
            this.jugadorActual = jugadorSiguiente;
        }
    }

    @Override
    public void crearUnidad(Jugador jugador, Posicion posicion, String nombreUnidad){
        if (jugadorActual == jugador) {
            tablero.crearUnidad(jugador, posicion, nombreUnidad);
            if(jugadorActual.getPuntosDisponibles() == 0){
                this.cambiarTurno();
            }
        } else {
            throw new TurnoJugadorException("Es el turno del otro jugador");
        }
    }

    @Override
    public void realizarMovimiento(Posicion posicionInicial, Posicion posicionFinal, Jugador jugador){}

    @Override
    public void realizarAtaque(Posicion posicionAtacante, Posicion posicionAtacado, Jugador jugador){}

    private boolean todasLasUnidadesFueronCreadas(){
        return jugador1.getPuntosDisponibles() == 0 && jugador2.getPuntosDisponibles() == 0;
    }
}
