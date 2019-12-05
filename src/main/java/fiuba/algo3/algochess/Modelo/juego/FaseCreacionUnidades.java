package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.FaseJuegoNoComienzaAunException;
import fiuba.algo3.algochess.Modelo.excepciones.TerminoCreacionException;
import fiuba.algo3.algochess.Modelo.excepciones.TurnoJugadorException;

public class FaseCreacionUnidades implements Fase{
    private Jugador jugadorActual;
    private Tablero tablero;
    private Juego juego;

    public FaseCreacionUnidades(Jugador jugador1, Jugador jugador2, Tablero tablero, Juego juego){
        this.jugadorActual = jugador1;
        this.tablero = tablero;
        this.juego = juego;
    }

    @Override
    public void cambiarTurno(){
        try{
            this.jugadorActual = jugadorActual.cambiarTurnoCreacion();
        } catch(TerminoCreacionException e){
            juego.cambiarAFaseJuego();
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
    public void realizarMovimiento(Posicion posicionInicial, Posicion posicionFinal, Jugador jugador){
        throw new FaseJuegoNoComienzaAunException("La fase de juego aun no ha comenzado");
    }

    @Override
    public void realizarAtaque(Posicion posicionAtacante, Posicion posicionAtacado, Jugador jugador){
        throw new FaseJuegoNoComienzaAunException("La fase de juego aun no ha comenzado");
    }

}
