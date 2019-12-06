package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.JugadorNuloException;
import fiuba.algo3.algochess.Modelo.unidades.Emisario;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JugadorNulo implements Jugador{

    @Override
    public void setJuego(Juego juego) {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public void setJugadorRival(Jugador jugador) {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public void cambiarTurno() {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public String getNombreJugador() {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public int getPuntosDisponibles() {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public void casillerosAliados(List casilleros) {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public Unidad crearUnidad(Casillero casillero, String nombreUnidad, Posicion posicion, Emisario emisario) {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public void guardarUnidad(Unidad unidadNueva) {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public void modificarPuntos(Unidad unidad) {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public void unidadPerteneceAJugador(Unidad unidad) {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public void unidadModificarPosicionCasillero(Unidad unidad, Casillero casilleroFin) {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public void atacar(Unidad atacante, Unidad atacado, Casillero casillero, Map<Posicion, Casillero> tablero, Distancia distancia) {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public ArrayList<Unidad> getUnidadesDisponibles() {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public boolean unidadAliada(Unidad unidad) {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public void reconocerUnidadesAliadasCercanasA(Unidad unidad, List<Unidad> unidadesCercanas, List<Unidad> unidadesAliadasCercanasAUnidad) {
        throw new JugadorNuloException("Este jugador no existe");
    }

    @Override
    public void reconocerUnidadesEnemigasCercanasA(Unidad unidad, List<Unidad> unidadesCercanas, List<Unidad> unidadesEnemigasCercanasAUnidad) {
        throw new JugadorNuloException("Este jugador no existe");
    }
}
