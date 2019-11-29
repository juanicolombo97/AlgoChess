package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;
// Interfaz que representa las unidades del juego.

public interface Unidad {

    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, CurarException, UnidadNulaException, UnidadInvalidaException;

    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, CurarException, UnidadNulaException, UnidadInvalidaException;

    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, CurarException, UnidadNulaException, CasilleroVacioExcepcion;

    public void recibirDanio(double danioRecibido) throws UnidadNulaException;

    public int cuantoCuesta();

    public void curarse(int vidaACurar) throws CurarException, UnidadNulaException;

    public ArrayList habilidadMoverse(Unidad unidadAMover,HashMap tablero,ArrayList unidadesAliadas) throws MovimientoInvalidoException, CasilleroVacioExcepcion;

    public double getVidaUnidad();

    public Posicion getPosicion();

    public void modificarPosicion(Posicion posicion);

}
