package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.FaseCreacionUnidadesFinalizoException;
import fiuba.algo3.algochess.Modelo.excepciones.JugadorPerdioException;
import fiuba.algo3.algochess.Modelo.excepciones.TurnoJugadorException;

public class FaseJuego implements Fase{
    private Jugador jugadorActual;
    private Tablero tablero;
    private Juego juego;

    public FaseJuego(Jugador jugador1, Tablero tablero, Juego juego){
        this.jugadorActual = jugador1;
        this.tablero = tablero;
        this.juego = juego;
    }

    @Override
    public void cambiarTurno(){
        try{
            this.jugadorActual = jugadorActual.cambiarTurnoJuego();
        } catch (JugadorPerdioException e){
            juego.finalizarJuego(); //Falta implementar como sabe el juego que jugador gana
        }
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
