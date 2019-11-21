package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Direccion;
import fiuba.algo3.algochess.juego.Posicion;
// Interfaz que representa las unidades del juego.

public interface Unidad {

    public void atacarDistanciaCerca(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException;

    public void atacarDistanciaMediana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException;

    public void atacarDistanciaLejana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException;

    public void recibirDanio(double danioRecibido) throws UnidadNulaException;

    public int cuantoCuesta();

    public void curarse(int vidaACurar) throws CurarException, UnidadNulaException;

    public void moverUnidad(Direccion direccion) throws UnidadNulaException, MovimientoInvalidoException ;

    public Posicion getPosicion();
}
