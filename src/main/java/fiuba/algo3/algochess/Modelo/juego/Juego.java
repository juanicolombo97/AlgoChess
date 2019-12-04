package fiuba.algo3.algochess.Modelo.juego;

public class Juego {

    private Jugador jugadorAliado;
    private Jugador jugadorEnemigo;
    private Tablero tablero;

    public Juego(Jugador jugador, Jugador jugador2){
        this.jugadorAliado = jugador;
        this.jugadorEnemigo = jugador2;
    }

    public void comenzarJuego(){
        Tablero tablero = new Tablero(jugadorAliado,jugadorEnemigo);
        this.tablero = tablero;
    }
}
