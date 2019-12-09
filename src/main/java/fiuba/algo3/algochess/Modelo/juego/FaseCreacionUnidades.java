package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.FaseJuegoNoComienzaAunException;
import fiuba.algo3.algochess.Modelo.excepciones.JugadorSeQuedoSinPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Modelo.unidades.UnidadNula;

public class FaseCreacionUnidades implements Fase{
    private Jugador jugadorActual;
    private Tablero tablero;
    private Juego juego;

    public FaseCreacionUnidades(Jugador jugador, Tablero tablero, Juego juego){
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
    public Unidad crearUnidad(Jugador jugador, Posicion posicion, String nombreUnidad){
        try {
            return tablero.crearUnidad(jugador, posicion, nombreUnidad);
        } catch (NoAlcanzanLosPuntosException e){
            return crearUnidad(jugador,posicion,nombreUnidad);
        }catch(JugadorSeQuedoSinPuntosException e){
            return new UnidadNula(posicion);
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
