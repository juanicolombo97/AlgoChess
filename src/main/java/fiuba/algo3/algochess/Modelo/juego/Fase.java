package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.unidades.Unidad;

public interface Fase {

    public Unidad crearUnidad(Jugador jugador, Posicion posicion, String nombreUnidad);

    public void realizarMovimiento(Posicion posicionInicial, Posicion posicionFinal, Jugador jugador);

    public void realizarAtaque(Posicion posicionAtacante, Posicion posicionAtacado, Jugador jugador);

    public void cambiarTurno();

    public void cambiarJugadorActual(Jugador jugador);
}
