package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;
// Interfaz que representa las unidades del juego.

public interface Unidad {

    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, CurarException, UnidadNulaException, UnidadInvalidaException;

    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, CurarException, UnidadNulaException, UnidadInvalidaException;

    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, CurarException, UnidadNulaException, CasilleroVacioExcepcion, UnidadInvalidaException;

    public void recibirDanio(double danioRecibido) throws UnidadNulaException;

    public int cuantoCuesta();

    public void curarse(int vidaACurar) throws CurarException, UnidadNulaException;

    public ArrayList habilidadMoverse(Unidad unidadAMover,HashMap tablero,ArrayList unidadesAliadas) throws MovimientoInvalidoException, CasilleroVacioExcepcion;

    public double getVidaUnidad();

    public Posicion getPosicion();

    public void modificarPosicion(Posicion posicion) throws MovimientoInvalidoException, CasilleroVacioExcepcion;

    public void recibirNotificacion() throws CasilleroVacioExcepcion;

    public boolean esSoldado();

    public void enCasilleroEnemigo();

    public void enCasilleroAliado();
}
