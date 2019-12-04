package fiuba.algo3.algochess.Modelo.juego;

public class Juego {

    private Jugador jugadorAliado;
    private Jugador jugadorEnemigo;
    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;
    private Tablero tablero;

    public Juego(Jugador jugador, Jugador jugador2){
        this.jugadorAliado = jugador;
        this.jugadorEnemigo = jugador2;
    }

    public Tablero comenzarJuego(){
        Tablero tablero = new Tablero(jugadorAliado,jugadorEnemigo);
        this.tablero = tablero;
        this.jugadorActual = jugadorAliado;
        this.jugadorSiguiente = jugadorEnemigo;
        return tablero;
    }

    public void cambiarTurno(){
        if (jugadorSiguiente.puedeSeguirJugando()){
            Jugador auxiliar = jugadorActual;
            this.jugadorActual = jugadorSiguiente;
            this.jugadorSiguiente = auxiliar;
        } else{
            finalizarJuego();
        }
    }

    public void realizarAtaque(Posicion posicionAtacante, Posicion posicionAtacado, Jugador jugador){
        if (jugadorActual == jugador){
            tablero.atacar(posicionAtacante, posicionAtacado, jugador);
        }
        this.cambiarTurno();
    }

    public void realizarMovimiento(Posicion posicionInicial, Posicion posicionFinal, Jugador jugador){
        if (jugadorActual == jugador){
            tablero.moverUnidad(posicionInicial, posicionFinal, jugador);
        }
        this.cambiarTurno();
    }

    public void finalizarJuego(){
        // Algo como "Gano el jugador: str(jugadorActual)"
    }
}
