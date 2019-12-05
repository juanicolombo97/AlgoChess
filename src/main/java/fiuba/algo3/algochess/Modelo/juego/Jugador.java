package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.unidades.Emisario;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Jugador {

    public void setJuego(Juego juego);

    public void setJugadorRival(Jugador jugador);

    public void cambiarTurno();

    public String getNombreJugador();

    public int getPuntosDisponibles();

    public void casillerosAliados(List casilleros);

    public Unidad crearUnidad(Casillero casillero, String nombreUnidad, Posicion posicion, Emisario emisario);

    public void guardarUnidad(Unidad unidadNueva);

    public void modificarPuntos(Unidad unidad);

    public void unidadPerteneceAJugador(Unidad unidad);

    public void unidadModificarPosicionCasillero(Unidad unidad, Casillero casilleroFin);

    public void atacar(Unidad atacante, Unidad atacado, Casillero casillero, HashMap tablero, Distancia distancia);

    public ArrayList<Unidad> getUnidadesDisponibles();

    public boolean unidadAliada(Unidad unidad);

    public void reconocerUnidadesAliadasCercanasA(Unidad unidad, ArrayList unidadesCercanas, ArrayList unidadesAliadasCercanasAUnidad);

    public void reconocerUnidadesEnemigasCercanasA(Unidad unidad, ArrayList unidadesCercanas, ArrayList unidadesEnemigasCercanasAUnidad);
}
