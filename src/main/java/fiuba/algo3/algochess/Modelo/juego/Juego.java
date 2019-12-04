package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.TurnoJugadorException;

public class Juego {

    private Jugador jugadorAliado;
    private Jugador jugadorEnemigo;
    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;
    private Tablero tablero;
    private Fase faseActual;

    public Juego(Jugador jugador, Jugador jugador2){
        this.jugadorAliado = jugador;
        this.jugadorEnemigo = jugador2;
    }

    public Tablero comenzarJuego(){
        Tablero tablero = new Tablero(jugadorAliado,jugadorEnemigo);
        this.tablero = tablero;
        this.jugadorActual = jugadorAliado;
        this.jugadorSiguiente = jugadorEnemigo;
        FaseCreacionUnidades faseCreacionUnidades = new FaseCreacionUnidades(this.jugadorActual, this.jugadorSiguiente, this.tablero);
        this.faseActual = faseCreacionUnidades;
        return tablero;
    }

    public void cambiarTurno(){
        if (jugadorSiguiente.puedeSeguirJugando()){
            faseActual.cambiarTurno();
        } else {
            finalizarJuego();
        }
    }

    public void finalizarJuego(){
        // Algo como "Gano el jugador: str(jugadorActual)"
        System.out.print("Finalizó el juego");
    }
}
