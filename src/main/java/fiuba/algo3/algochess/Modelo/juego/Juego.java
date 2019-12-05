package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.TurnoJugadorException;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

public class Juego {

    private Jugador jugadorAliado;
    private Jugador jugadorEnemigo;
    private Tablero tablero;
    private Fase faseActual;

    public Juego(Jugador jugador, Jugador jugador2){
        this.jugadorAliado = jugador;
        this.jugadorEnemigo = jugador2;
        this.jugadorAliado.setJugadorRival(this.jugadorEnemigo);
        this.jugadorEnemigo.setJugadorRival(new JugadorNulo());
        this.jugadorAliado.setJuego(this);
        this.jugadorEnemigo.setJuego(this);
    }

    public void cambiarJugadorActual(Jugador jugador){
        faseActual.cambiarJugadorActual(jugador);
    }

    public Tablero comenzarJuego(){
        Tablero tablero = new Tablero(jugadorAliado,jugadorEnemigo);
        this.tablero = tablero;
        this.faseActual = new FaseCreacionUnidades(this.jugadorAliado, this.tablero, this);
        return tablero;
    }

    public void cambiarAFaseJuego(){
        // Esta linea sirve para el manejo de turnos diferente a la fase anterior
        this.jugadorEnemigo.setJugadorRival(jugadorAliado);
        this.faseActual = new FaseJuego(jugadorAliado, tablero, this);
    }

    public Unidad crearUnidad(Jugador jugador, Posicion posicion, String nombreUnidad){
        return faseActual.crearUnidad(jugador, posicion, nombreUnidad);
    }

    public void realizarMovimiento(Posicion posicionInicial, Posicion posicionFinal, Jugador jugador){
        faseActual.realizarMovimiento(posicionInicial, posicionFinal, jugador);
    }

    public void realizarAtaque(Posicion posicionAtacante, Posicion posicionAtacado, Jugador jugador){
        faseActual.realizarAtaque(posicionAtacante, posicionAtacado, jugador);
    }

    public void finalizarJuego(){
        // Algo como "Gano el jugador: str(jugadorActual)"
        System.out.print("Finalizó el juego");
    }
}
