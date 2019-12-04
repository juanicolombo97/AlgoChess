package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;
// Interfaz que representa las unidades del juego.

public interface Unidad {

    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, HashMap tablero);

    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero);

    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero);

    public void recibirDanio(double danioRecibido);

    public int cuantoCuesta();

    public void curarse(int vidaACurar);

    public ArrayList habilidadMoverse(Unidad unidadAMover,HashMap tablero,ArrayList unidadesAliadas);

    public double getVidaUnidad();

    public Posicion getPosicion();

    public void modificarPosicion(Posicion posicion);

    public void recibirNotificacion();

    public boolean esSoldado();

    public void enCasilleroEnemigo();

    public void enCasilleroAliado();

    public void agregarSoldadoAListaDeSoldados(ArrayList<Soldado> listaDeSoldados);

}
