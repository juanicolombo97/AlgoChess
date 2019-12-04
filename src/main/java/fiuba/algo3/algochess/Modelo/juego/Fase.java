package fiuba.algo3.algochess.Modelo.juego;

public interface Fase {

    public void crearUnidad(Jugador jugador, Posicion posicion, String nombreUnidad);

    public void realizarMovimiento(Posicion posicionInicial, Posicion posicionFinal, Jugador jugador);

    public void realizarAtaque(Posicion posicionAtacante, Posicion posicionAtacado, Jugador jugador);
}
