package fiuba.algo3.algochess.Modelo.juego;


public class Juego {

    public Jugador jugadorAliado;
    public Jugador jugadorEnemigo;
    public Tablero tablero;
    private EstadoJuego estadoJuego;


    public Juego(String jugador1, String jugador2) {
        jugadorAliado = new Jugador(jugador1);
        jugadorEnemigo = new Jugador(jugador2);
        tablero = new Tablero(jugadorAliado, jugadorEnemigo);
        estadoJuego = new EstadoJuegoAliado(jugadorAliado,jugadorEnemigo);

    }

    public void crearUnidad(String nombreUnidad, Posicion posicion){
        estadoJuego = estadoJuego.crearUnidad(tablero,nombreUnidad,posicion);
    }

    public void mover(Posicion posicionInicial,Posicion posicionFinal) throws Exception{
        System.out.println("Antes error");
        estadoJuego = estadoJuego.mover(posicionInicial,posicionFinal,tablero);
        System.out.println("Despues error");
    }

    public void atacar(Posicion posicionAtancate,Posicion posicionAtacado){
        estadoJuego = estadoJuego.atacar(posicionAtancate,posicionAtacado,tablero);
    }

    public Jugador jugadorActual(){
        return estadoJuego.jugadorActual();
    }

    public void cambiarTurno(){
        estadoJuego = estadoJuego.cambiarTurno();
    }

}