package fiuba.algo3.algochess.Modelo.juego;

public interface EstadoJuego {

    public EstadoJuego crearUnidad(Tablero tablero, String nombreUnidad, Posicion posicion);

    EstadoJuego mover(Posicion posicionInicial, Posicion posicionFinal, Tablero tablero);

    EstadoJuego atacar(Posicion posicionAtancate, Posicion posicionAtacado, Tablero tablero);

    Jugador jugadorActual();
}
