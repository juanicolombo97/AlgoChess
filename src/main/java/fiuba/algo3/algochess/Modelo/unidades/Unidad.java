package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Direccion;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Interfaz que representa las unidades del juego.

public interface Unidad {

    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero);

    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero);

    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero);

    public void recibirDanio(double danioRecibido);

    public int cuantoCuesta();

    public void curarse(int vidaACurar);

    public List<Unidad> habilidadMoverse(Unidad unidadAMover,Map<Posicion, Casillero> tablero, List<Unidad> unidadesAliadas);

    public double getVidaUnidad();

    public Posicion getPosicion();

    public void modificarPosicion(Posicion posicion);

    public void recibirNotificacion();

    public void setDanioPorCasillero(double danioExtra);

    public void agregarSoldadoAListaDeSoldados(List<Unidad> listaDeSoldados);

    public void agregarUnidadCercana(List<Unidad> batallonUnidades, List<Unidad> listaUnidades);

    public void agregarUnidadADistancia(List<Unidad> unidadesADistanciaCercana);

    Posicion calcularPosicionCernana(Direccion direccionActual, int counter);
}
