package fiuba.algo3.algochess.Modelo.juego;

public class Juego {

    private Jugador jugadorAliado;
    private Jugador jugadorEnemigo;
    private Jugador jugadorActual;
    private Tablero tablero;

    public Juego(Jugador jugador, Jugador jugador2){
        this.jugadorAliado = jugador;
        this.jugadorEnemigo = jugador2;
    }

    public Tablero comenzarJuego(){
        Tablero tablero = new Tablero(jugadorAliado,jugadorEnemigo);
        this.tablero = tablero;
        return tablero;
    }


}
